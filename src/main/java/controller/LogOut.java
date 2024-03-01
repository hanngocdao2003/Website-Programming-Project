package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogOut", value = "/LogOut")
public class LogOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
//            session.invalidate(); // Xóa session

            session.removeAttribute("User");
            session.removeAttribute("fullName");
            session.removeAttribute("numberPhone");
            session.removeAttribute("email");
            session.removeAttribute("province");
            session.removeAttribute("district");
            session.removeAttribute("ward");
            session.removeAttribute("numHouse");
            session.removeAttribute("Success");
            session.removeAttribute("Success");
            session.removeAttribute("cart");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        // Chuyển hướng về trang chính
    }
}
