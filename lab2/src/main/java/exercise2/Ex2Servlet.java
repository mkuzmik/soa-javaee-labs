package exercise2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("ex2")
public class Ex2Servlet extends HttpServlet {
    
    Random random = new Random();

    String view = "" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Ex2</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "{}" +
            "</body>\n" +
            "</html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fig = req.getParameter("graj");

        random.nextInt(3);
        
        switch (random.nextInt(3)) {
            case 0:
        }
        
    }
}
