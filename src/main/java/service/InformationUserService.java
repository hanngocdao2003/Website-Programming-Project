package service;

import bean.InformationUser;
import dao.InformationUserDAO;

import java.sql.SQLException;
import java.util.List;

public class InformationUserService {
  public List<InformationUser> loadDataUser() throws SQLException {
      InformationUserDAO dao = new InformationUserDAO();
      List<InformationUser> result = dao.listInfUser();
      return  result;
  }
    public List<InformationUser> loadDataLockUser() throws SQLException {
        InformationUserDAO dao = new InformationUserDAO();
        List<InformationUser> result = dao.listLockUser();
        return  result;
    }
    public boolean blockUser(int id) throws SQLException {
      InformationUserDAO dao = new InformationUserDAO();
      return dao.blockUser(id);
    }
    public boolean unlockUser(int id) throws SQLException {
        InformationUserDAO dao = new InformationUserDAO();
        return dao.unlockUser(id);
    }
    private String print(List<InformationUser> list) {
        String result = "";
        for (InformationUser user : list) {
            result += user + "\n";
        }
        return result;
    }

    public static void main(String[] args) throws SQLException {
        InformationUserService service = new InformationUserService();
 //       System.out.println(service.print(service.loadDataLockUser()));
        System.out.println(service.unlockUser(3));
    }
}
