package controller;

import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResetPasswordServlet", value = "/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String RESET = "reset-password.jsp";
        final String LOGIN = "indexLogin.jsp";
        final String FAIL = "verification-fail.jsp";

        String url = RESET;

        String code = request.getParameter("code");
        String newPass1 = request.getParameter("newPass1");
        String newPass2 = request.getParameter("newPass2");

        response.setContentType("text/html; charset=UTF-8");
        boolean verify = false;
        String email = UserService.getEmail(code);
        if (newPass1.equals(newPass2)) {
            verify = UserService.updatePassByCode(code, newPass1);
            if (verify) {
                url = LOGIN;
                UserService.deleteCode(email);
            } else {
                url = FAIL;
            }
        } else {
            request.setAttribute("NotEqual", "Mật khẩu không trùng nhau");
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}