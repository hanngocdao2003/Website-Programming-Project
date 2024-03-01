package controller;

import bean.ProductResponse;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Product", value = "/Product")
public class FindProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameproduct");
        ProductService productService = new ProductService();
        Map<String, String> searchParams = new HashMap<>();
        searchParams.put("name", name);
        List<ProductResponse> productList = productService.findProduct(searchParams);
        System.out.println(productList);
        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("allProductofCategory.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}