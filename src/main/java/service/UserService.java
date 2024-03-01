package service;

import bean.UserEntity;
import dao.UserDAO;
import utils.EmailVerification;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public static UserEntity checkLogin(String numberPhone, String password) {
        UserDAO userDAO = new UserDAO();
        List<UserEntity> userEntityList = userDAO.getAccount(numberPhone);
        if (!userEntityList.isEmpty()) {
            UserEntity user = userEntityList.get(0);
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static UserEntity checkRegister(String numberPhone, String email) {
        UserDAO userDAO = new UserDAO();
        List<UserEntity> userEntityList = userDAO.getAccount(numberPhone);
        if (!userEntityList.isEmpty()) {
            UserEntity user = userEntityList.get(0);
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public static boolean registerUser(UserEntity user) {
        UserDAO userDAO = new UserDAO();

        // Kiểm tra xem người dùng đã tồn tại hay chưa
        UserEntity existingUser = checkRegister(user.getPhone(), user.getEmail());
        if (existingUser != null) {
            // Người dùng đã tồn tại, không thể đăng ký
            return false;
        } else {
            String token = EmailVerification.generateToken();
            boolean registrationSuccess = userDAO.addUser(user, token);
            if (registrationSuccess)
                // Nếu đăng ký thành công, tạo token và gửi email xác nhận
                EmailVerification.sendVerificationEmail(user.getEmail(), token);
            return registrationSuccess;
        }
    }

    public static boolean updatePass(String phone, String pass) {
        return new UserDAO().updatePass(phone, pass);
    }

    public static boolean updatePassByCode(String code, String pass) {
        return new UserDAO().updatePassByCode(code, pass);
    }

    public static String getPass(String phone) {
        return new UserDAO().getPass(phone);
    }

    public static boolean verifyUser(String email, String token) throws SQLException {
        return new UserDAO().verifyUser(email, token);
    }

    public static boolean checkEmail(String email) {
        return new UserDAO().checkEmail(email);
    }

    public static boolean saveCode(String email, String code) {
        return new UserDAO().saveCode(email, code);
    }

    public static boolean deleteCode(String email) {
        return new UserDAO().deleteCode(email);
    }

    public static String getEmail(String code) {
        return new UserDAO().getEmail(code);
    }

    public static boolean getBlockAccount(String phone) {
        return new UserDAO().getBlockAccount(phone);
    }

    public static void main(String[] args) {
    }
}

