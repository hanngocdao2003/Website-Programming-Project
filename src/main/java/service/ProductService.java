package service;

import bean.*;
import dao.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    public static List<ProductResponse> findProduct(Map<String, String> search) {
        // khởi tạo list để lấy các đối tượng lấy được từ lớp productDAO
        List<ProductEntity> productEntities = ProductDAO.findProduct(search);
        System.out.println(productEntities.size());
        List<ProductResponse> result = new ArrayList<>();
        ImageDAO imageDAO = new ImageDAO();
        ColorDAO colorDAO = new ColorDAO();
        SizeDAO sizeDAO = new SizeDAO();
        for (ProductEntity item : productEntities) {
            Integer productId = item.getId();
            List<ImageEntity> imageEntities = imageDAO.findImage(productId);
            List<ColorEntity> colorEntities = colorDAO.findColor(productId);
            List<SizeEntity> sizeEntities = sizeDAO.findSize(productId);

            //dùng feature java 8 để lấy list màu, size
            String color = colorEntities.stream().map(colors -> colors.getCode()).collect(Collectors.joining(", "));
            String size = sizeEntities.stream().map(sizes -> sizes.getSize()).collect(Collectors.joining(", "));
            String image = imageEntities.stream().map(img -> img.getLink()).collect(Collectors.joining(", "));
            // Tạo một đối tượng ProductResponse để gán dữ liệu
            ProductResponse productResponse = new ProductResponse();

            productResponse.setId(productId);
            productResponse.setName(item.getName());
            productResponse.setPrice(item.getPrice());
            productResponse.setDetails(item.getDetails());
            //productResponse.setImage(imageEntities.getFirst().getLink());
            productResponse.setImage(image);
            productResponse.setColor(color);
            productResponse.setSize(size);

            result.add(productResponse);
        }
        return result;
    }

    public static ProductResponse getDetails(Integer productId) {
        ProductEntity productEntity = ProductDAO.getDetails(productId);
        ProductResponse productResponse = new ProductResponse();

        ImageDAO imageDAO = new ImageDAO();
        ColorDAO colorDAO = new ColorDAO();
        SizeDAO sizeDAO = new SizeDAO();

        List<ImageEntity> imageEntities = imageDAO.findImage(productId);
        List<ColorEntity> colorEntities = colorDAO.findColor(productId);
        List<SizeEntity> sizeEntities = sizeDAO.findSize(productId);

        String color = colorEntities.stream().map(colors -> colors.getCode()).collect(Collectors.joining(", "));
        String size = sizeEntities.stream().map(sizes -> sizes.getSize()).collect(Collectors.joining(", "));
        String image = imageEntities.stream().map(img -> img.getLink()).collect(Collectors.joining(", "));

        productResponse.setId(productEntity.getId());
        productResponse.setName(productEntity.getName());
        productResponse.setPrice(productEntity.getPrice());
        productResponse.setDetails(productEntity.getDetails());
        productResponse.setColor(color);
        productResponse.setSize(size);
        productResponse.setImage(image);

        return productResponse;
    }

    public static ProductResponse findProductByImage(String image) {
        ProductEntity productEntity = ProductDAO.findProductByImage(image);
        ProductResponse productResponse = new ProductResponse();

        ImageDAO imageDAO = new ImageDAO();
        ColorDAO colorDAO = new ColorDAO();
        SizeDAO sizeDAO = new SizeDAO();

        List<ImageEntity> imageEntities = imageDAO.findImage(productEntity.getId());
        List<ColorEntity> colorEntities = colorDAO.findColor(productEntity.getId());
        List<SizeEntity> sizeEntities = sizeDAO.findSize(productEntity.getId());

        String color = colorEntities.stream().map(colors -> colors.getCode()).collect(Collectors.joining(", "));
        String size = sizeEntities.stream().map(sizes -> sizes.getSize()).collect(Collectors.joining(", "));
        String images = imageEntities.stream().map(img -> img.getLink()).collect(Collectors.joining(", "));

        productResponse.setId(productEntity.getId());
        productResponse.setName(productEntity.getName());
        productResponse.setPrice(productEntity.getPrice());
        productResponse.setDetails(productEntity.getDetails());
        productResponse.setColor(color);
        productResponse.setSize(size);
        productResponse.setImage(images);

        return productResponse;
    }


    public static List<ProductResponse> getImageSlide() {
        List<ProductResponse> list = new ArrayList<>();
        List<ProductEntity> entityList = new ProductDAO().getNewImage();
        ImageDAO imageDAO = new ImageDAO();
        for (ProductEntity e : entityList) {
           List<ImageEntity> images = imageDAO.findImage(e.getId());
            String image = images.stream().map(img -> img.getLink()).collect(Collectors.joining(", "));
            ProductResponse response = new ProductResponse();
            response.setImage(image);
            list.add(response);
        }
        return list;
    }
    public static List<ProductResponse> getImageSlideProduc(String type) throws SQLException {
        List<ProductResponse> list = new ArrayList<>();
        List<ProductEntity> entityList = new ProductDAO().getNewImageShirt(type);
        ImageDAO imageDAO = new ImageDAO();
        for (ProductEntity e : entityList) {
            List<ImageEntity> images = imageDAO.findImage(e.getId());
            String image = images.stream().map(img -> img.getLink()).collect(Collectors.joining(", "));
            ProductResponse response = new ProductResponse();
            response.setImage(image);
            list.add(response);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getImageSlide().get(1));
    }
}