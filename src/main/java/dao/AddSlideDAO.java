package dao;

import bean.Slide;
import database.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddSlideDAO {

    private static final String INSERT_SLIDE_SQL = "INSERT INTO image_slideshow(name, data) VALUES (?, ?)";


    public boolean insertSlide(String name, byte[] data) {
        insertData(INSERT_SLIDE_SQL, name, data);
        return true;
    }

    private boolean insertData(String sql, String name, byte[] data) {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.setBytes(2, data);

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Slide> loadSlider() {
        List<Slide> slideList = new ArrayList<>();
        String sql = "select id,name,data from shopquanao.image_slideshow";
        try {
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Slide slide = new Slide();
                slide.setId(rs.getInt("id"));
                slide.setLink(rs.getString("name"));
                slide.setData(rs.getBytes("data"));
                slideList.add(slide);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slideList;
    }

}
