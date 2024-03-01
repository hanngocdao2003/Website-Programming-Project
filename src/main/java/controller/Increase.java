package controller;

import bean.ShoppingCart;
import bean.UserEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "increase", value = "/increase")
public class Increase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void IncreaseProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        UserEntity userEntity = (UserEntity) session.getAttribute("User_Login");
//        if (userEntity == null) {
//            response.sendRedirect("indexLogin.jsp");
//        } else {
            ShoppingCart shoppingCarts = (ShoppingCart) session.getAttribute("cart");
            if (shoppingCarts == null) {
                ShoppingCart shoppingCart = new ShoppingCart();
                session.setAttribute("cart", shoppingCart);
            }
            String color = request.getParameter("btnColor");
            String size = request.getParameter("btnSize");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int productId = Integer.parseInt(request.getParameter("productId"));
            //shoppingCarts.increasingQuantity(productId, );
//        }
    }
}