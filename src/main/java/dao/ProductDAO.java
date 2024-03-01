package dao;

import bean.ProductEntity;
import database.ConnectionUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//
public class ProductDAO {

    public static String searchWithoutJoin(Map<String, String> search) {
        StringBuilder sql = new StringBuilder();
        if (search.containsKey("name")) {
            String name = search.get("name");
            if (name != null && !name.isEmpty()) {
                sql.append("AND p.name LIKE '%" + name + "%' ");
            }
        }
        return sql.toString();
    }

    public static String searchWithJoin(Map<String, String> search) {
        StringBuilder sql = new StringBuilder();
        if (search.containsKey("category")) {
            String category = search.get("category");
            if (category != null && !category.isEmpty()) {
                sql.append("AND c.categoryName LIKE '%" + category + "%' ");
            }
        }
        if (search.containsKey("images")) {
            String image = search.get("images");
            if (image != null && !image.isEmpty()) {
                sql.append("AND images.link = '" + image + "' ");
            }
        }
        return sql.toString();
    }

    public static ProductEntity getDetails(Integer productId) {
        List<ProductEntity> productEntities = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.id, p.name, p.price, p.details FROM shopquanao.products p ");
        sql.append("INNER JOIN shopquanao.category_details cd ON p.categoryId = cd.id\n"
                + "INNER JOIN shopquanao.categories c ON cd.categoryId = c.id\n");
        sql.append("WHERE 1 = 1 AND p.id = " + productId);
        try (Connection conn = ConnectionUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {

            while (rs.next()) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setId(productId);
                productEntity.setName(rs.getString("name"));
                productEntity.setPrice(rs.getInt("price"));
                productEntity.setDetails(rs.getString("details"));
                productEntities.add(productEntity);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return productEntities.getFirst();
    }

    public static List<ProductEntity> findProduct(Map<String, String> search) {
        List<ProductEntity> productEntities = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.id, p.name, p.price, p.details FROM shopquanao.products AS p ");
        sql.append("INNER JOIN shopquanao.category_details cd ON p.categoryId = cd.id\n"
                + "INNER JOIN shopquanao.categories c ON cd.categoryId = c.id\n");
        sql.append("WHERE 1 = 1 "); // bắt buộc có WHERE 1 = 1
        sql.append(searchWithJoin(search));
        sql.append(searchWithoutJoin(search));
        sql.append("GROUP BY p.id");


        try (Connection conn = ConnectionUtils.getConnection(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {

            while (rs.next()) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setId(rs.getInt("id"));
                productEntity.setName(rs.getString("name"));
                productEntity.setPrice(rs.getInt("price"));
                productEntity.setDetails(rs.getString("details"));
                productEntities.add(productEntity);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return productEntities;
    }

    public static ProductEntity findProductByImage(String img) {
        ProductEntity productEntity = new ProductEntity();
        String sql = "SELECT products.*\n" +
                "FROM products\n" +
                "INNER JOIN images ON products.id = images.productId\n" +
                "WHERE images.link = '" + img + "'";
        try (Connection conn = ConnectionUtils.getConnection(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {

            if (rs.next()) {
                productEntity.setId(rs.getInt("id"));
                productEntity.setName(rs.getString("name"));
                productEntity.setPrice(rs.getInt("price"));
                productEntity.setDetails(rs.getString("details"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return productEntity;
    }

    public List<ProductEntity> getNewImage() {
        String sql = "SELECT id FROM products \n" +
                "order by importDate desc\n" +
                "limit 10;";
        List<ProductEntity> list = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
        ) {
            while (rs.next()) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setId(rs.getInt(1));
                list.add(productEntity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<ProductEntity> getNewImageShirt(String type) throws SQLException {
        String sql = "SELECT * FROM products inner join category_details on products.categoryId = category_details.id inner join categories on category_details.categoryId = categories.id where categoryName = ? order by importDate desc limit 10;";
        List<ProductEntity> list = new ArrayList<>();
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, type);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setId(rs.getInt(1));
            list.add(productEntity);
        }
        return list;
    }
}