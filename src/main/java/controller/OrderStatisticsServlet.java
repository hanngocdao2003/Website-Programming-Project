package controller;

import service.StatisticsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderStatisticsServlet", value = "/OrderStatisticsServlet")
public class OrderStatisticsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String ADMIN = "indexAdmin.jsp";
        String url = ADMIN;

        int totalOrder = StatisticsService.getTotalBills();
        System.out.println("Total Order Count: " + totalOrder);
        request.setAttribute("totalOrder", totalOrder);

        double proceed = StatisticsService.getProceed();
        request.setAttribute("proceed", proceed);

        int soldProduct = StatisticsService.getSoldProducts();
        request.setAttribute("soldProduct", soldProduct);

        int users = StatisticsService.getUsers();
        request.setAttribute("users", users);

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}