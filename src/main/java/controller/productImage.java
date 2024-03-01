package controller;

import bean.ProductResponse;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "productImage", value = "/productImage")
public class productImage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String image = request.getParameter("image");
        ProductService productService = new ProductService();
        if (!image.isEmpty()) {
            ProductResponse productDetail = ProductService.findProductByImage(image);
            request.setAttribute("productDetail", productDetail);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/details.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}