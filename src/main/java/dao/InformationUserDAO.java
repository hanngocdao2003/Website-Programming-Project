package dao;

import bean.InformationUser;
import database.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationUserDAO {
    public List<InformationUser> listInfUser() throws SQLException {
        List<InformationUser> result = new ArrayList<>();
        String sql = "select users.id ,users.fullName, users.phone, users.email, roles.roleName, users.status \n" +
                "from users inner join roles on roles.id = users.roleId where  users.roleID = ? and users.status = ?";
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "R2");
        statement.setInt(2, 1);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            InformationUser user = new InformationUser();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setNumberphone(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setRole(rs.getString(5));
            user.setStatus(rs.getInt(6));
            result.add(user);
        }
        return  result;
    }
    public List<InformationUser> listLockUser() throws SQLException {
        List<InformationUser> result = new ArrayList<>();
        String sql = "select users.id , users.fullName, users.phone, users.email, roles.roleName, users.status \n" +
                "from users inner join roles on roles.id = users.roleId where  users.roleID = ? and users.status = ?";
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "R2");
        statement.setInt(2, 0);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            InformationUser user = new InformationUser();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setNumberphone(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setRole(rs.getString(5));
            user.setStatus(rs.getInt(6));
            result.add(user);
        }
        return  result;
    }
    public boolean blockUser(int id) throws SQLException {
        String sql = "update users set status = 0 where id = ?;";
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int update = statement.executeUpdate();
        if(update != 0){
            return  true;
        }else{
            return false;
        }
    }
    public boolean unlockUser(int id) throws SQLException {
        String sql = "update users set status = 1 where id = ?;";
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int update = statement.executeUpdate();
        if(update != 0){
            return  true;
        }else{
            return false;
        }
    }
    private String print(List<InformationUser> list) {
        String result = "";
        for (InformationUser user : list) {
            result += user + "\n";
        }
        return result;
    }
    public static void main(String[] args) throws SQLException {
        InformationUserDAO dao = new InformationUserDAO();
//        System.out.println(dao.print(dao.listInfUser()));
        System.out.println(dao.unlockUser(6));
    }
}
