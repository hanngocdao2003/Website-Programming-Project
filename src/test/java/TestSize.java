import dao.SizeDAO;

import java.sql.SQLOutput;

public class TestSize {
    public static void main(String[] args) {
        SizeDAO sizeDAO = new SizeDAO();
        System.out.println(sizeDAO.findSize(1));
    }
}
