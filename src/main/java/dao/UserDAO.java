package dao;

import bean.UserEntity;
import database.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<UserEntity> getAccount(String numberPhone) {
        List<UserEntity> userEntityList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, fullName, phone, email, password, status, roleId, province, district, ward, numHouse " + "from users where phone = '" + numberPhone + "' and status = 1");

        try {
            Connection conn = ConnectionUtils.getConnection();
            PreparedStatement stmt;
            if (conn != null) {
                stmt = conn.prepareStatement(sql.toString());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    UserEntity userEntity = new UserEntity();
                    userEntity.setId(rs.getInt("id"));
                    userEntity.setFullName(rs.getString("fullName"));
                    userEntity.setPhone(rs.getString("phone"));
                    userEntity.setEmail(rs.getString("email"));
                    userEntity.setPassword(rs.getString("password"));
                    userEntity.setStatus(rs.getShort("status"));
                    userEntity.setRoleId(rs.getString("roleId"));
                    userEntity.setProvince(rs.getString("province"));
                    userEntity.setDistrict(rs.getString("district"));
                    userEntity.setWard(rs.getString("ward"));
                    userEntity.setNumHouse(rs.getString("numHouse"));
                    userEntityList.add(userEntity);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return userEntityList;
    }

    public UserEntity getUser(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, fullName, phone, email, password, status, roleId, province, district, ward, numHouse " + "from users where id=" + id);

        try {
            Connection conn = ConnectionUtils.getConnection();
            PreparedStatement stmt;
            if (conn != null) {
                stmt = conn.prepareStatement(sql.toString());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    UserEntity userEntity = new UserEntity();
                    userEntity.setId(rs.getInt("id"));
                    userEntity.setFullName(rs.getString("fullName"));
                    userEntity.setPhone(rs.getString("phone"));
                    userEntity.setEmail(rs.getString("email"));
                    userEntity.setPassword(rs.getString("password"));
                    userEntity.setStatus(rs.getShort("status"));
                    userEntity.setRoleId(rs.getString("roleId"));
                    userEntity.setProvince(rs.getString("province"));
                    userEntity.setDistrict(rs.getString("district"));
                    userEntity.setWard(rs.getString("ward"));
                    userEntity.setNumHouse(rs.getString("numHouse"));
                    return userEntity;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean getBlockAccount(String phone) {
        UserEntity user = new UserEntity();
        String sql = "select status from users where phone = ?";
        Connection con = ConnectionUtils.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, phone);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user.setStatus(rs.getShort("status"));
                Short st = user.getStatus();
                if (st == 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static String toString(List<UserEntity> userEntityList) {
        String resutl = "";
        for (UserEntity userEntity : userEntityList) {
            resutl += userEntity;
        }
        return resutl;
    }


    public boolean addUser(UserEntity user, String token) {
        String query = "insert into shopquanao.users (fullName, phone, email, password, token) values (?,?,?,?, ?)";
        try (Connection con = ConnectionUtils.getConnection()) {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getPhone());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            pst.setString(5, token);

            int row = pst.executeUpdate();

            return row > 0;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public static boolean verifyUser(String phone) {
        String query = "update shopquanao.users set status = 1, roleId = 'R2', birthday = null, province = null, district= null, ward= null, numHouse=null where phone = " + phone;
        try (Connection con = ConnectionUtils.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            // pst.setString(1, phone);

            int row = pst.executeUpdate();

            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePass(String phone, String pass) {
        String query = "update users set password = ? where phone = ? and status = 1";
        try {
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, pass);
            preparedStatement.setString(2, phone);

            int row = preparedStatement.executeUpdate();

            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassByCode(String code, String pass) {
        String query = "update users set password = ? where token = ? and status = 1";
        try {
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, pass);
            preparedStatement.setString(2, code);

            int row = preparedStatement.executeUpdate();

            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getPass(String phone) {
        UserEntity user = new UserEntity();
        String query = "select password from users where phone = " + phone;

        try {
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user.getPassword();
    }

    public boolean verifyUser(String email, String token) throws SQLException {
        String sql = "SELECT email, token FROM users WHERE email = ? AND token = ?";
        Connection con = ConnectionUtils.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, token);
        ResultSet resultSet = statement.executeQuery();
        boolean checkVerify = resultSet.next();
        resultSet.close();
        statement.close();
        if (checkVerify) {
            String sqlUpdate = "UPDATE users SET token = NULL WHERE email = ?";
            statement = con.prepareStatement(sqlUpdate);
            statement.setString(1, email);
            statement.executeUpdate();
            statement.close();
        }

        return checkVerify;
    }

    public boolean checkEmail(String email) {
        UserEntity user = new UserEntity();
        String query = "select email from users where email = ? and status = 1";

        try {
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveCode(String email, String token) {
        String sql = "UPDATE users SET token = ? WHERE email = ? AND status = 1";
        Connection con = ConnectionUtils.getConnection();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, token);
            statement.setString(2, email);

            int row = statement.executeUpdate();

            return row > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCode(String email) {
        String sql = "UPDATE users SET token = NULL WHERE email = ? AND status = 1";
        Connection con = ConnectionUtils.getConnection();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, email);

            int row = statement.executeUpdate();

            return row > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmail(String token) {
        UserEntity user = new UserEntity();
        String query = "select email from users where token = ? and status = 1";

        try {
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, token);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setEmail(rs.getString("email"));
            }
            return user.getEmail();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
    }
}
