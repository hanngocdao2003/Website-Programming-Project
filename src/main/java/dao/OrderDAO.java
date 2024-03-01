package dao;

import bean.BillEntity;
import bean.OrderManagement;
import bean.UserEntity;
import database.ConnectionUtils;
import utils.FormatUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public int getIdUser(String phone) {
        UserEntity user = new UserEntity();
        String sql = "select id from users where phone = ?";
        Connection con = ConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, phone);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user.getId();
    }

    public boolean addBill(BillEntity billEntity) {
        String sql = "insert into bills(id,userName,userPhone,userAddress,dateCreated,note,userId,statusPayment,statusOrder,paymentMethod) values (?,?,?,?,?,?,?,?,?,?)";
        String id = FormatUtils.generateOrderId();
        Connection con = ConnectionUtils.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, billEntity.getUserName());
            statement.setString(3, billEntity.getUserPhone());
            statement.setString(4, billEntity.getUserAddress());
            statement.setDate(5, billEntity.getDateCreated());
            statement.setString(6, billEntity.getNote());
            statement.setInt(7, billEntity.getUserId());
            statement.setString(8, "Chưa thanh toán");
            statement.setString(9, "Đang xác nhận");
            statement.setString(10, billEntity.getPaymentMethod());

            int row = statement.executeUpdate();
            return row > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<OrderManagement> getListOrder(String statusPayment, String statusOrder) {
        List<OrderManagement> list = new ArrayList<>();
        OrderManagement orderManagement = new OrderManagement();
        String query = "select bills.id, bills.userName, bill_details.quantity, (bill_details.quantity*products.price), bills.statusPayment, bills.statusOrder from bills join bill_details on bills.id = bill_details.billId join products on products.id = bill_details.productId where bills.statusPayment = ? and bills.statusOrder = ?";
        Connection con = ConnectionUtils.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, statusPayment);
            statement.setString(2, statusOrder);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String userName = rs.getString(2);
                int quantity = rs.getInt(3);
                float total = rs.getFloat(4);
                String status = rs.getString(5);
                boolean inspection = rs.getBoolean(6);
                orderManagement.setId(id);
                orderManagement.setUserName(userName);
                orderManagement.setQuantity(quantity);
                orderManagement.setTotal(total);
                orderManagement.setStatus(status);
                orderManagement.setInspection(inspection);
                list.add(orderManagement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
