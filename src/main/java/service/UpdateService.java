package service;

import dao.UpdateDAO;

import java.sql.SQLException;

public class UpdateService {
    public void updateUser(int id, String fullName, String province, String district, String ward, String numHouse) throws SQLException {
        UpdateDAO updateDAO = new UpdateDAO();
        updateDAO.update(id, fullName, province, district, ward, numHouse);
    }

}
