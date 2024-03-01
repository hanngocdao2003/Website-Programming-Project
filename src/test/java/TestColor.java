import dao.ColorDAO;

public class TestColor {
    public static void main(String[] args) {
        ColorDAO colorDAO = new ColorDAO();
        System.out.println(colorDAO.findColor(1));
    }
}
