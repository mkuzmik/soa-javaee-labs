package soa.mkuzmik.ex4;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shop")
public class ShoppingServlet extends HttpServlet {

    @Inject
    private ShoppingCart shoppingCart;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("id");
        int amount = Integer.valueOf(req.getParameter("amount"));
        String source = req.getParameter("source");
        String redirect = source.equals("cart") ? "ex4/cart.jsp" : "/ex4/shop.jsp";
        if (source.equals("shop")) {
            shoppingCart.addProduct(itemId, amount);
        } else {
            shoppingCart.setAmount(itemId, amount);
        }
        req.setAttribute("cart", shoppingCart.getIdPiecesMap());
        RequestDispatcher view = req.getRequestDispatcher(redirect);
        view.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cart", shoppingCart.getIdPiecesMap());
        RequestDispatcher view = req.getRequestDispatcher("ex4/cart.jsp");
        view.forward(req, resp);
    }
}
