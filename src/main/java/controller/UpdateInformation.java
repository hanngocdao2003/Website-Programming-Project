package controller;

import service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "uploadInformation", value = "/uploadInformation")
public class UpdateInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UpdateService updateService = new UpdateService();
        HttpSession session = req.getSession(false);
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            int id = (int) session.getAttribute("Id");
            String fullName = req.getParameter("fullName");
            String province = req.getParameter("province");
            String district = req.getParameter("district");
            String ward = req.getParameter("ward");
            String numHouse = req.getParameter("numHouse");
            updateService.updateUser(id, fullName, province, district, ward, numHouse);
            session.setAttribute("fullName", fullName);
            session.setAttribute("province", province);
            session.setAttribute("district", district);
            session.setAttribute("ward", ward);
            session.setAttribute("numHouse", numHouse);
            req.getRequestDispatcher("UpdateOK.jsp").forward(req, resp);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
