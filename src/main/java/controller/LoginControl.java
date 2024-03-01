package controller;

import bean.UserEntity;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginControl", value = "/home")
public class LoginControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String ERROR = "indexLogin.jsp";
        final String SUCCESS = "index.jsp";
        final String ADSUCCESS = "indexAdmin.jsp";
        response.setContentType("text/html; charset=UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UserEntity userEntity = UserService.checkLogin(userName, password);
        boolean checkBlockAcc = UserService.getBlockAccount(userName);

        HttpSession session = request.getSession(true);
        String url = ERROR;

        if (checkBlockAcc) {
            request.setAttribute("block", "Tài khoản đã bị khóa");
        } else if (userEntity == null) {
            request.setAttribute("Error", "Tên đăng nhập hoặc mật khẩu không đúng");
        } else {
            session.setAttribute("Role", userEntity.getRoleId());
            session.setAttribute("User", userEntity);
            session.setAttribute("Id", userEntity.getId());
            session.setAttribute("fullName", userEntity.getFullName());
            session.setAttribute("numberPhone", userEntity.getPhone());
            session.setAttribute("email", userEntity.getEmail());
            session.setAttribute("province", userEntity.getProvince());
            session.setAttribute("district", userEntity.getDistrict());
            session.setAttribute("ward", userEntity.getWard());
            session.setAttribute("numHouse", userEntity.getNumHouse());

            if (userEntity.getRoleId().equals("R1")) {
                url = ADSUCCESS;
                session.setAttribute("Success", userEntity.getFullName());
            } else {

                url = SUCCESS;
                session.setAttribute("Success", userEntity.getFullName());
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}

