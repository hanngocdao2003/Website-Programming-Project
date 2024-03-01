package service;

import dao.StatisticsDAO;

public class StatisticsService {
    public static int getTotalBills() {
        return new StatisticsDAO().getTotalBills();
    }

    public static double getProceed() {
        return new StatisticsDAO().getProceed();
    }

    public static int getSoldProducts() {
        return new StatisticsDAO().getSoldProducts();
    }

    public static int getUsers() {
        return new StatisticsDAO().getUsers();
    }

}
