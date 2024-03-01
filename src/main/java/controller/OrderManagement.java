package controller;

import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "OrderManagement", value = "/OrderManagement")
public class OrderManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<bean.OrderManagement> orderManagements1 = OrderService.getListOrder("Đã thanh toán", "Đang chuẩn bị hàng");
        session.setAttribute("ttd", orderManagements1);
        List<bean.OrderManagement> orderManagements2 = OrderService.getListOrder("Đã thanh toán", "Chưa duyệt");
        session.setAttribute("ttcd", orderManagements2);
        List<bean.OrderManagement> orderManagements3 = OrderService.getListOrder("Chưa thanh toán", "Đang chuẩn bị hàng");
        session.setAttribute("cttd", orderManagements3);
        List<bean.OrderManagement> orderManagements4 = OrderService.getListOrder("Chưa thanh toán", "Chưa duyệt");
        session.setAttribute("cttcd", orderManagements4);

        String choose1 = request.getParameter("choose1"); //dtt ctt
        String choose2 = request.getParameter("choose2"); //d cd
        if (choose1.equals("dtt") && choose2.equals("d")) {

        } else if (choose1.equals("dtt") && choose2.equals("cd")) {

        } else if (choose1.equals("ctt") && choose2.equals("d")) {

        } else {

        }

        for (bean.OrderManagement orderManagement : orderManagements1) {
            session.setAttribute("id", orderManagement.getId());
            session.setAttribute("uN", orderManagement.getUserName());
            session.setAttribute("qu", orderManagement.getQuantity());
            session.setAttribute("tt", orderManagement.getTotal());
            session.setAttribute("stt", orderManagement.getStatus());
            session.setAttribute("ins", orderManagement.isInspection());
        }
        for (bean.OrderManagement orderManagement : orderManagements2) {
            session.setAttribute("id", orderManagement.getId());
            session.setAttribute("uN", orderManagement.getUserName());
            session.setAttribute("qu", orderManagement.getQuantity());
            session.setAttribute("tt", orderManagement.getTotal());
            session.setAttribute("stt", orderManagement.getStatus());
            session.setAttribute("ins", orderManagement.isInspection());
        }
        for (bean.OrderManagement orderManagement : orderManagements3) {
            session.setAttribute("id", orderManagement.getId());
            session.setAttribute("uN", orderManagement.getUserName());
            session.setAttribute("qu", orderManagement.getQuantity());
            session.setAttribute("tt", orderManagement.getTotal());
            session.setAttribute("stt", orderManagement.getStatus());
            session.setAttribute("ins", orderManagement.isInspection());
        }
        for (bean.OrderManagement orderManagement : orderManagements4) {
            session.setAttribute("id", orderManagement.getId());
            session.setAttribute("uN", orderManagement.getUserName());
            session.setAttribute("qu", orderManagement.getQuantity());
            session.setAttribute("tt", orderManagement.getTotal());
            session.setAttribute("stt", orderManagement.getStatus());
            session.setAttribute("ins", orderManagement.isInspection());
        }

    }
}