package controller;


import bean.UserEntity;
import dao.UserDAO;
import service.UserService;
import utils.EmailVerification;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignUp", value = "/SignUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String VERIFY = "verifying.jsp";
        final String SIGNUP = "indexLogin.jsp";

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String url = SIGNUP;
        try {
            // Lấy thông tin từ form
            String fullName = request.getParameter("inputName");
            String email = request.getParameter("inputEmail");
            String phoneNumber = request.getParameter("inputNumPhoneRect");
            String password = request.getParameter("inputPassRect");
            String repassword = request.getParameter("ReinputPass");

            // Kiểm tra tham số từ form
            if (fullName == null || email == null || phoneNumber == null || password == null || repassword == null
                    || fullName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                // Thông báo lỗi về tham số
                response.sendRedirect("error.jsp?message=InvalidParameters");
                return;
            }
            if (!password.equals(repassword)) {
                request.setAttribute("password", "Mật khẩu không trùng nhau!");
            } else {
                // Tạo user
                UserEntity user = new UserEntity();
                user.setFullName(fullName);
                user.setEmail(email);
                user.setPhone(phoneNumber);
                user.setPassword(password);

                boolean verificationSuccess = UserService.registerUser(user);
                if (verificationSuccess == false) {
                    request.setAttribute("fail", "Tài khoản đã tồn tại!");
                } else {
                    UserDAO.verifyUser(phoneNumber);
                    url = VERIFY;
                    //response.sendRedirect("verifying.jsp");
//                new Verify();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi, ví dụ: hiển thị thông báo lỗi hoặc chuyển hướng đến trang lỗi
            response.sendRedirect("error.jsp?message=" + e.getMessage());
        }
        request.getRequestDispatcher(url).forward(request, response);
    }


}