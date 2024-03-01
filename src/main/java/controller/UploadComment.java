package controller;

import bean.CommentReponse;
import service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "uploadCmt", value = "/upload-cmt")
public class UploadComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            CommentService commentService = new CommentService();
            List<CommentReponse> comments;
            comments = commentService.listCommentOfUser();
            System.out.println(print(comments));
            session.setAttribute("Comments", comments);
            System.out.println(print(comments));
            // Đưa danh sách CommentReponse vào request attribute để sử dụng trong JSP
           for(CommentReponse c : comments){
               session.setAttribute("comment_id", c.getId());
               System.out.println(req.getAttribute("comment_id"));
               session.setAttribute("comment_name", c.getNameUser());
               session.setAttribute("comment", c.getFeedback());
               session.setAttribute("comment_date", c.getDate_cmt());
           }
             //Chuyển hướng (forward) tới trang jsp để hiển thị dữ liệu
            req.getRequestDispatcher("UploadCommentAdmin.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần
        }
    }
    public String print(List<CommentReponse> list){
        String result = "";
        for(CommentReponse c : list){
            result += c + "\n";
        }
        return result;
    }
}
