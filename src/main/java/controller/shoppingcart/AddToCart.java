package controller.shoppingcart;

import bean.ShoppingCart;
import bean.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import org.json.JSONObject;

@WebServlet(name = "addtocart", value = "/addtocart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idUser = (int) session.getAttribute("Id");
        ShoppingCart shoppingCarts = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCarts == null) {
            shoppingCarts = new ShoppingCart();
        }
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        int quantity;
        try {
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException e) {
            quantity = 1;
        }
        int productId = Integer.parseInt(request.getParameter("id"));
        try {
            shoppingCarts.addProduct(idUser, color, size, productId, quantity);
        } catch (Exception e) {
        }
        session.setAttribute("cart", shoppingCarts);
        int totalItems = shoppingCarts.getTotalItem(idUser);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalItems", totalItems);
        response.setContentType("application/json");
        response.getWriter().println(jsonObject);
//    }
    }
}