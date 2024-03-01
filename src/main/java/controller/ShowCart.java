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

@WebServlet(name = "showcart", value = "/showcart")
public class ShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        ProductService productService = new ProductService();
        if (productId != null && !productId.isEmpty()) {
            System.out.println(productId);
            ProductResponse productDetail = ProductService.getDetails(Integer.parseInt(productId));
            request.setAttribute("productDetail", productDetail);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/indexOrder.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private ProductResponse getProductDetail(String productId) {
        Map<String, String> search = new HashMap<>();
        search.put("productId", productId);
        List<ProductResponse> productDetails = ProductService.findProduct(search);
        return productDetails.isEmpty() ? null : productDetails.get(0);
    }
}