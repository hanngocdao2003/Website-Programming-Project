package dao;

import bean.ImageEntity;
import bean.ProductEntity;
import database.ConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {
    public List<ImageEntity> findImage(int productId) {
        List<ImageEntity> imageEntities = new ArrayList<>();
        String sql = "SELECT i.id, i.link, i.productId FROM shopquanao.images AS i"
                + " WHERE 1 = 1 ";
        if (productId != 0) {
            sql += " AND productId = " + productId;
        }
        try (Connection conn = ConnectionUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {
            while (rs.next()) {
                ImageEntity imageEntity = new ImageEntity();
                imageEntity.setId(rs.getString("id"));
                imageEntity.setLink(rs.getString("link"));
                imageEntity.setProductId(rs.getInt("productId"));
                imageEntities.add(imageEntity);
            }
        } catch (Exception ex) {
            System.out.println("error images " +ex.getMessage());
        }
        return imageEntities;
    }
}
