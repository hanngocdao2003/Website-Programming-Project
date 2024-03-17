package interfaces;

import java.sql.SQLException;

public interface AbstractModel {
    public boolean insert();

    public boolean update(int id);

    public boolean delete(int id);
}
