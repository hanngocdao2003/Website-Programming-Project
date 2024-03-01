package dao;
import bean.ColorEntity;
import bean.SizeEntity;
import database.ConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SizeDAO {
    public static List<SizeEntity> findSize(int productId) {
        List<SizeEntity> sizeEntities = new ArrayList<>();
        String sql = "SELECT id, size, productId FROM shopquanao.sizes WHERE productId = '" + productId + "'";
        try (Connection conn = ConnectionUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {
            while (rs.next()) {
                SizeEntity sizeEntity = new SizeEntity();
                sizeEntity.setId(rs.getInt("id"));
                sizeEntity.setSize(rs.getString("size"));
                sizeEntity.setProductId(rs.getInt("productId"));
                sizeEntities.add(sizeEntity);
            }
        } catch (Exception ex) {
            System.out.println("error sizes " + ex.getMessage());
        }
        return sizeEntities;
    }
}

