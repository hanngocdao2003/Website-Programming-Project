package controller;

import bean.UserEntity;
import service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "insertComment", value = "/insertComment")
public class ReceiveComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String feedback = req.getParameter("feedback");
        System.out.println(feedback);
        HttpSession session = req.getSession();
        UserEntity userId = (UserEntity) session.getAttribute("User");
        System.out.println(userId);
        Date date_cmt = new Date(System.currentTimeMillis());
        System.out.println(date_cmt);
        if (userId == null) {
            // Người dùng chưa đăng nhập, chuyển hướng về trang đăng nhập
            resp.sendRedirect("indexLogin.jsp");
        }else{
            CommentService commentService = new CommentService();
            boolean success = commentService.uploadComment(userId.getId(), feedback, date_cmt);
            System.out.println(success);
            if (success) {
                resp.sendRedirect("CommentOK.jsp"); // Chuyển hướng đến trang thành công
            } else {
                resp.sendRedirect("comment.jsp"); // Chuyển hướng đến trang lỗi
            }
        }
    }
}
