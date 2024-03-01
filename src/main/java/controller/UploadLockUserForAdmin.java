package controller;

import bean.InformationUser;
import service.InformationUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "uploadLockUser", value = "/uploadLockUser")
public class UploadLockUserForAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            InformationUserService service = new InformationUserService();
            List<InformationUser> list;
            list = service.loadDataLockUser();
            System.out.println(print(list));
            session.setAttribute("listLockUser", list);
            for (InformationUser user : list) {
                session.setAttribute("idLockUser", user.getId());
                session.setAttribute("nameLockUSer", user.getName());
                session.setAttribute("emailLockUser", user.getEmail());
                session.setAttribute("phoneLockUser", user.getNumberphone());
                session.setAttribute("roleLockUser", user.getRole());
                session.setAttribute("statusLockUser", user.getStatus());
            }
            req.getRequestDispatcher("ManagerLockUser.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String print(List<InformationUser> list) {
        String result = "";
        for (InformationUser c : list) {
            result += c + "\n";
        }
        return result;
    }
}
