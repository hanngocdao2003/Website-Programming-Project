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

@WebServlet(name = "detailsProduct", value = "/detailsProduct")
public class DetailsProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        ProductService productService = new ProductService();
        if (productId != null && !productId.isEmpty()) {
            ProductResponse productDetail = ProductService.getDetails(Integer.parseInt(productId));
            request.setAttribute("productDetail", productDetail);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/details.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.jsp"); // Thay bằng trang lỗi mong muốn
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
    private ProductResponse getProductDetail(String productId) {
        Map<String, String> search = new HashMap<>();
        search.put("productId", productId);
        List<ProductResponse> productDetails = ProductService.findProduct(search);
        return productDetails.isEmpty() ? null : productDetails.get(0);
    }
}