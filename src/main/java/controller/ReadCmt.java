package controller;

import service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "readCmt", value = "/readCmt")
public class ReadCmt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] idValues = req.getParameterValues("IDcmt");
        CommentService service = new CommentService();
        List<Integer> idList = new ArrayList<>();
        for (String idValue : idValues) {
            idList.add(Integer.parseInt(idValue));
        }
        try {
            for(int i : idList){
                boolean check = service.checkCmt(i);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("UploadCommentAdmin.jsp").forward(req, resp);
    }
}
