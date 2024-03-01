package dao;

import database.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsDAO {
    //bills
    public int getTotalBills() {
        int re = 0;
        String sql = "select count(id) from bills where statusOrder like '%Giao hàng thành công%' and statusPayment like '%Đã thanh toán%'";
        Connection con = ConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                re = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }

    //proceeds
    public double getProceed() {
        double re = 0;
        String sql = "select sum(bill_details.quantity*products.price) as total from bill_details join products on bill_details.productId = products.id join bills on bills.id = bill_details.billId where statusOrder like '%Giao hàng thành công%' and statusPayment like '%Đã thanh toán%'";
        Connection con = ConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                re = rs.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }

    //products
    public int getSoldProducts() {
        int re = 0;
        String sql = "select sum(quantity) from bill_details join bills on bills.id = bill_details.billId where statusOrder like '%Giao hàng thành công%' and statusPayment like '%Đã thanh toán%'";
        Connection con = ConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                re = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }

    // users
    public int getUsers(){
        int re = 0;
        String sql = "select count(*) from users where status = 1";
        Connection con = ConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                re = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    public static void main(String[] args) {

    }
}
