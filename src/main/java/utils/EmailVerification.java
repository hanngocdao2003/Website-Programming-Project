package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

public class EmailVerification {
    static final String username = "cromeecs@gmail.com";
    static final String password = "vqincsbglaaaemyp";

    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public static boolean sendVerificationEmail(String toMail, String token) {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
            message.setSubject("Xác thực tài khoản");
            message.setText("Xin chào,\n\nBạn đã đăng ký tài khoản thành công. Hãy click vào đường link sau để xác nhận tài khoản:\n"
                    + "http://localhost:8080/maven_war_exploded/verify?email=" + toMail + "&token=" + token);

            Transport.send(message);

            System.out.println("Email sent successfully.");
            return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateConfirmationCode() {
        // Tạo mã xác nhận ngẫu nhiên, ví dụ sử dụng số và chữ cái
        int length = 6;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < length; i++) {
            code.append(characters.charAt(random.nextInt(characters.length())));
        }

        return code.toString();
    }

    public static boolean sendConfirmationEmail(String email, String confirmationCode) {

        // Cấu hình properties cho JavaMail
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Tạo đối tượng Session
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            Message message = new MimeMessage(session);

            // Thiết lập thông tin người gửi và người nhận
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            // Thiết lập tiêu đề và nội dung email
            message.setSubject("Xác Nhận Quên Mật Khẩu");
            message.setText("Mã xác nhận của bạn là: " + confirmationCode);

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");
            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println( sendConfirmationEmail("hanngocdao2003@gmail.com", generateConfirmationCode()));

    }

}
