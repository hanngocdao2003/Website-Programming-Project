package service;

import bean.CommentForWeb;
import bean.CommentReponse;
import bean.UserEntity;
import dao.CommentForWebDAO;
import dao.UserDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentService {


    public boolean uploadComment(int id_user, String feedback, Date date_cmt) {
        CommentForWebDAO commentForWebDAO = new CommentForWebDAO();
        commentForWebDAO.insertComment(id_user, feedback, date_cmt);
        return true;
    }
    public List<CommentReponse> listCommentOfUser() throws SQLException {
        CommentForWebDAO comment = new CommentForWebDAO();
        List<CommentReponse> list = comment.commentsForWeb();
        return  list;
    }
    public boolean checkCmt(int id) throws SQLException {
        CommentForWebDAO dao = new CommentForWebDAO();
        String result = dao.checkCmtForAdmin(id);
        if(result.isEmpty()){
            return true;
        }
        return false;
    }
    private String print(List<CommentReponse> list){
        String result = "";
        for(CommentReponse c : list){
            result += c + "\n";
        }
        return result;
    }
    public static void main(String[] args) throws SQLException {
       CommentService cmt = new CommentService();
        //System.out.println(cmt.print(cmt.listCommentOfUser()));
    }

}
