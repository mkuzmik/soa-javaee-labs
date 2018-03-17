package exercise5;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/ex5")
public class VisitorBookServlet extends HttpServlet {

    Set<User> users = new HashSet<>();
    List<Comment> comments = new LinkedList<>();

    @Override
    public void init() throws ServletException {
        super.init();

        users.add(new User("jan", "jan", "Jan"));
        users.add(new User("adam", "adam", "Adam"));
    }

    // POST - login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Optional<User> maybeUser = users.stream().filter(user -> user.getLogin().equals(login)).findFirst();

        if (maybeUser.isPresent() && maybeUser.get().getPassword().equals(password)) {
            String newSessionId = UUID.randomUUID().toString();
            maybeUser.get().setSessionId(newSessionId);
            resp.addCookie(new Cookie("sessionId", newSessionId));

            resp.sendRedirect("visitorbook.html");
        } else {
            resp.sendRedirect("login.html");
        }
    }

    // GET - add comment
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = getSessionIdFrom(req);

        Optional<User> maybeUser = users.stream()
                .filter(user1 -> user1.getSessionId().equals(sessionId)).findFirst();

        if (!maybeUser.isPresent()) {
            resp.sendRedirect("login.html");
        } else {
            String comment = req.getParameter("comment");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            comments.add(new Comment(maybeUser.get(), name, email, comment));
            resp.sendRedirect("visitorbook.html");
        }
    }

    // PUT - get comments
    // only for authenticated users
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = getSessionIdFrom(req);

        Optional<User> maybeUser = users.stream()
                .filter(user1 -> user1.getSessionId().equals(sessionId)).findAny();

        if (!maybeUser.isPresent()) {
            resp.sendError(403);
        } else {
            PrintWriter writer = resp.getWriter();
            String html = comments.stream().map(Comment::toHTML).reduce("", String::concat);
            writer.write(html);
            writer.close();
        }
    }

    private String getSessionIdFrom(HttpServletRequest req) {
        return Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals("sessionId"))
                .findAny()
                .orElse(new Cookie("sessionId", ""))
                .getValue();
    }
}
