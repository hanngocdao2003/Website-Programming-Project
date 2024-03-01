package dao;

import bean.UserEntity;

import database.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SignUpDAO {
    public boolean checkAccount(String numberPhone, String email) {
        List<UserEntity>  userEntityList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select users.id, users.fullName, users.phone, users.email, users.password, users.status, users.roleId FROM shopquanao.users\n" +
                "where users.phone =" + numberPhone +  "and users.email =" + email);
        try {

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       return true;
    }

    public List<UserEntity> createAccount(String numberPhone) {
        List<UserEntity> userEntityList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select users.phone, users.password from users where users.phone ='" + numberPhone + "'" +
                "and users.status = 1");


        try {
            Connection conn = ConnectionUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setPhone(rs.getString("phone"));
                userEntity.setPassword(rs.getString("password"));
                userEntityList.add(userEntity);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  userEntityList;
    }

    public static void main(String[] args) {
        SignUpDAO signUpDAO = new SignUpDAO();

    }
}


