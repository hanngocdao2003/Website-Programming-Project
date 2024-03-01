package dao;

import database.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO {
    public void update(int id, String fullName, String province, String district, String ward, String numHouse) throws SQLException {
        String sql = "update users \n" +
                "set fullName = ?, province = ?, district = ?, ward = ?, numHouse = ?\n" +
                "where id = ?";
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, fullName);
        statement.setString(2, province);
        statement.setString(3, district);
        statement.setString(4, ward);
        statement.setString(5, numHouse);
        statement.setInt(6, id);
        statement.executeUpdate();
    }

}
