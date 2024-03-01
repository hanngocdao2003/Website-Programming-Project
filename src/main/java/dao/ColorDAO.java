package dao;

import bean.ColorEntity;
import database.ConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColorDAO {
    public static List<ColorEntity> findColor(int productId) {
        List<ColorEntity> colorEntities = new ArrayList<>();
        String sql = "SELECT id, color, code, productId FROM shopquanao.colors WHERE productId = '" + productId + "'";

        try (Connection conn = ConnectionUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {
            while (rs.next()) {
                ColorEntity colorEntity = new ColorEntity();
                colorEntity.setId(rs.getInt("id"));
                colorEntity.setColor(rs.getString("color"));
                colorEntity.setCode(rs.getString("code"));
                colorEntity.setProductId(rs.getInt("productId"));
                colorEntities.add(colorEntity);
            }
        } catch (Exception ex) {
            System.out.println("error colors " + ex.getMessage());
        }
        return colorEntities;
    }
}

