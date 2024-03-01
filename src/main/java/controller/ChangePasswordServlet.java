package controller;

import bean.UserEntity;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/changePass")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.getAttribute("User");

        String phone = (String) session.getAttribute("numberPhone");
        String pass = UserService.getPass(phone);
        String oldPass = req.getParameter("oldPass");
        String newPass1 = req.getParameter("newPass1");
        String newPass2 = req.getParameter("newPass2");

        if (!pass.equals(oldPass)) {
            req.setAttribute("Fail1", "Sai mật khẩu");
            if (!newPass1.equals(newPass2)) {
                req.setAttribute("Fail2", "Mật khẩu không trùng nhau");
            }
        } else {
            if (newPass1.equals(newPass2)) {
                UserService.updatePass(phone, newPass1);
                //session.setAttribute("password", newPass1);
                req.getRequestDispatcher("indexLogin.jsp").forward(req, resp);
            }
        }
    }
}
