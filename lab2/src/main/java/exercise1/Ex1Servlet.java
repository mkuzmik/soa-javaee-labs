package exercise1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("ex1")
public class Ex1Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean kobieta = false;
        boolean pelnoletni = false;

        if (req.getParameter("name").matches(".*a^")) {
            kobieta = true;
        }

        if (Integer.valueOf(req.getParameter("age")) >= 18) {
            pelnoletni = true;
        }

        PrintWriter writer = resp.getWriter();

        writer.write("pelnoletni " + String.valueOf(pelnoletni) + " kobieta " + String.valueOf(kobieta));
    }
}