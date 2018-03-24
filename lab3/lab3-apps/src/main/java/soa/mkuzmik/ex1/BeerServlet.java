package soa.mkuzmik.ex1;

import soa.mkuzmik.ex1.model.BeerChooser;
import soa.mkuzmik.ex1.model.BeerColor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("beer")
public class BeerServlet extends HttpServlet {

    BeerChooser beerChooser = new BeerChooser();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c = req.getParameter("color");
        Set<String> brands = beerChooser.getBrands(beerColorOf(c));
        req.setAttribute("brands", brands);
        RequestDispatcher view = req.getRequestDispatcher("ex1/wynik.jsp");
        view.forward(req, resp);
    }

    private BeerColor beerColorOf(String color) {
        switch (color) {
            case "jasny": return BeerColor.PALE;
            case "bursztyn": return BeerColor.AMBER;
            case "brąz": return BeerColor.BROWN;
            default: return BeerColor.DARK;
        }
    }
}
