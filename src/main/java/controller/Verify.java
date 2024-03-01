package controller;

import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "verify", value = "/verify")
public class Verify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String token = request.getParameter("token");
        System.out.println(email + ": " + token);

        boolean checkVerify = false;
        try {
            checkVerify = UserService.verifyUser(email, token);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            response.sendRedirect("error.jsp?message=InvalidParameters");
            return;
        }
        if (checkVerify) response.sendRedirect("verification-success.jsp");
        else response.sendRedirect("verification-fail.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}