package dao;

import bean.CommentForWeb;
import bean.CommentReponse;
import database.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommentForWebDAO {
    private static final String INSERT_COMMENT_SQL = "INSERT INTO comment_for_web(id_user, feedback, date_cmt, reader) VALUES (?, ?, ?, ?)";

    public boolean insertComment(int id_user, String feedback, Date date_cmt) {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENT_SQL)) {
            preparedStatement.setInt(1, id_user);
            preparedStatement.setString(2, feedback);
            preparedStatement.setDate(3, date_cmt);
            preparedStatement.setInt(4, 0);

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<CommentReponse> commentsForWeb() throws SQLException {
        List<CommentReponse> comments = new ArrayList<>();
        String sql = "SELECT comment_for_web.id, users.fullName, comment_for_web.feedback, comment_for_web.date_cmt FROM comment_for_web inner join users on users.id = comment_for_web.id_user where reader = 0;";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CommentReponse comment = new CommentReponse();
                comment.setId(resultSet.getInt(1));
                comment.setNameUser(resultSet.getString(2));
                comment.setFeedback(resultSet.getString(3));
                comment.setDate_cmt(resultSet.getDate(4));
                comments.add(comment);
            }
        }
        return comments;
    }

    public String checkCmtForAdmin(int id) throws SQLException {
        String result = "";
        String sql = "update comment_for_web set reader = 1 where id = ?";
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        result = print(commentsForWeb());
        return result;
    }

    private String print(List<CommentReponse> list) {
        String result = "";
        for (CommentReponse c : list) {
            result += c + "\n";
        }
        return result;
    }

    public static void main(String[] args) throws SQLException {
        CommentForWebDAO dao = new CommentForWebDAO();
//        dao.insertComment(2, "Tôi là Thanh Bình", Date.valueOf(LocalDate.now()));
        //       System.out.println(dao.print(dao.commentsForWeb()));
        System.out.println(dao.checkCmtForAdmin(3));
    }

}
