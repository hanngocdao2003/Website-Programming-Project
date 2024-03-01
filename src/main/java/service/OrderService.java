package service;

import bean.BillEntity;
import bean.OrderManagement;
import dao.OrderDAO;

import java.util.List;

public class OrderService {
    public static boolean addBill(BillEntity billEntity) {
        return new OrderDAO().addBill(billEntity);
    }

    public static int getIdUser(String phone) {
        return new OrderDAO().getIdUser(phone);
    }

    public static List<OrderManagement> getListOrder(String statusPayment, String statusOrder) {
        return new OrderDAO().getListOrder(statusPayment, statusOrder);
    }
}
