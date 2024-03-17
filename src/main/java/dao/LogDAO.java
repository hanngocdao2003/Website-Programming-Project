package dao;

import bean.LogEntity;
import database.ConnectionUtils;
import interfaces.AbstractModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDAO implements AbstractModel {
    @Override
    public boolean insert() {
        Connection con = ConnectionUtils.getConnection();
        LogEntity logEntity = new LogEntity();
        String sql = "insert into log(ip, nationality, level, address, preValue, value) values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, logEntity.getIp());
            preparedStatement.setString(2, logEntity.getNationality());
            preparedStatement.setString(3, logEntity.getLevel());
            preparedStatement.setString(4, logEntity.getAddress());
            preparedStatement.setString(5, logEntity.getPreValue());
            preparedStatement.setString(6, logEntity.getValue());

            int row = preparedStatement.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
