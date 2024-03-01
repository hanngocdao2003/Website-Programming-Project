//import dao.ProductDAO;
//import bean.ProductResponse;
//import service.ProductService;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class TestProduct {
//    public static void main(String[] args) {
//        // Create a search map with parameters
//        Map<String, String> searchParams = new HashMap<>();
//        searchParams.put("name", "Áo");
//        //searchParams.put("category", "yourCategoryName");
//        ProductDAO productDAO = new ProductDAO();
//        ProductService productService = new ProductService();
//
//        //List<ProductEntity> products = productDAO.findAll(searchParams);
//        List<ProductResponse> products = productService.findProduct(searchParams);
//
//        // Display the results
//        if (!products.isEmpty()) {
//            System.out.println("Products found:");
//            for (ProductResponse product : products) {
//                System.out.println("Name: " + product.getName());
//                System.out.println("Price: " + product.getPrice());
//                System.out.println("Details: " + product.getDetails());
//                System.out.println("Image: " + product.getImage());
//                System.out.println("Color(s): " + product.getColor());
//                System.out.println("Size(s): " + product.getSize());
//                System.out.println("-----------------------");
//            }
//        } else {
//            System.out.println("No products found with the specified criteria.");
//        }
//    }
//}
