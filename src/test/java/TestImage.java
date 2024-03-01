import dao.ImageDAO;

public class TestImage {
    public static void main(String[] args) {
        ImageDAO imageDAO = new ImageDAO();
        System.out.println(imageDAO.findImage(1));
    }
}
