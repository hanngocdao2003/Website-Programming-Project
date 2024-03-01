package controller;

import bean.BillEntity;
import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        final String LOGIN = "indexLogin.jsp";
        final String CURRENT = "indexOrder.jsp";
        final String SUCCESS = "order-successfully.jsp";

        String url = CURRENT;

        HttpSession session = request.getSession(true);
        session.getAttribute("User");

        String phoneSession = (String) session.getAttribute("numberPhone");

        if (phoneSession == null) {
            url = LOGIN;
        } else {
            String fullName = request.getParameter("fullName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String note = request.getParameter("note");

            if (fullName == null || phone == null || email == null || address == null) {
                url = CURRENT;
                request.setAttribute("null1", "Vui lòng nhập thông tin");
            }

            String radio = request.getParameter("choose");
            String value = "";
            if (radio.equals("cod")) {
                value = "COD";
            } else if (radio.equals("momo")) {
                value = "Momo";
            } else if (radio.equals("zalo")) {
                value = "ZaloPay";
            } else if (radio.equals("card")) {
                value = "Card";
            } else {
                url = CURRENT;
                request.setAttribute("null", "Vui lòng chọn hình thức thanh toán");
            }

            Date created = new Date(System.currentTimeMillis());
            BillEntity bill = new BillEntity();
            bill.setUserName(fullName);
            bill.setUserPhone(phone);
            bill.setUserAddress(address);
            bill.setNote(note);
            bill.setUserId(OrderService.getIdUser(phoneSession));
            bill.setDateCreated(created);
            bill.setPaymentMethod(value);

            OrderService.addBill(bill);
            url = SUCCESS;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}