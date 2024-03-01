<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="View/styleWeb/styleChangePass.css">
    <link rel="stylesheet" href="Image/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="View/styleWeb/styleFooter.css">
    <link rel="icon" href="Image/BHD-html.png" type="image/x-icon">
    <title>Thiết lập lại mật khẩu</title>
</head>
<body>
<div id="container">
    <div class="header">
        <p>Thiết lập lại mật khẩu</p>
        <!--        <span>-->
        <!--    <i class="fa-regular fa-circle-xmark" style="color: #ff8080;"></i>-->
        <!--        </span>-->
    </div>
    <form action="ResetPasswordServlet" class="form" method="post">
        <div class="center">
            <input type="text" placeholder="Mã xác nhận" name="code" required>
            <input type="password" placeholder="Mật khẩu mới" name="newPass1" required>
            <input type="password" placeholder="Nhập lại mật khẩu mới" name="newPass2" required>
        </div>
        <%
            String error = (String) request.getAttribute("NotEqual");
            if (error != null) {
        %>
        <span style="padding: 20px"><%= error%></span>
        <%}%>
        <div class="button">
            <input type="submit" value="Thiết lập lại mật khẩu">
        </div>
    </form>
</div>
<footer>
    <div class="contain">
        <div class="content">
            <div class="store">
                <img src="Image/BHD-nền%20trong%20suốt.svg" alt="">
                <h1>BHD BOUTIQUE</h1>
            </div>
            <p class="text">Chúng tôi luôn trân trọng và mong đợi
                nhận được mọi ý kiến đóng góp từ khách
                hàng để có thể nâng cấp trải nghiệm dịch
                vụ và sản phẩm tốt hơn nữa. </p>
            <a href="comment.jsp">
                <button class="idea-btn">Đóng góp ý kiến</button>
            </a>
        </div>
        <div class="list-policy">
            <p class="policy-lb">Chính sách</p>
            <ul>
                <li><a href="policy-7days.jsp">Chính sách đổi trả 7 ngày</a></li>
                <li><a href="">Chính sách khuyến mãi</a></li>
                <li><a href="">Chính sách bảo mật</a></li>
                <li><a href="">Chính sách giao hàng</a></li>
            </ul>
            <div class="media">
                <a href="https://www.facebook.com/Binh.PHHT/" target="_blank"><img src="Image/fb.png" alt="fb-icon"></a>
                <a href="https://www.instagram.com/peace_bi.ht/" target="_blank"><img src="Image/instagram.png"
                                                                                      alt="instagram-icon"></a>
            </div>
        </div>
        <div class="support">
            <div class="hotline">
                <h5><i class="fa-sharp fa-solid fa-phone-volume"
                       style="color: #000000; max-width: 10px; margin-right: 10px;"></i>Hotline</h5>
                <p>0908586584 - 0896435451
                    <br>(8:30 - 22:00)
                </p>
            </div>
            <div class="address">
                <h5><i class="fas fa-map-marker-alt" style="color: #000000; max-width: 10px; margin-right: 7px;"></i>Địa
                    chỉ
                </h5>
                <p>Khu phố 6, phường Linh Trung
                    <br>Thành phố Thủ Đức, Thành phố Hồ Chí Minh
                </p>
            </div>
            <div class="mail">
                <h5><i class="fas fa-envelope" style="color: #000000; max-width: 10px; margin-right: 11px;"></i>Email
                </h5>
                <p>bhdstore2023@gmail.com</p>
            </div>
        </div>
        <div class="image">
            <a href="https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+N%C3%B4ng+L%C3%A2m+TP.+H%E1%BB%93+Ch%C3%AD+Minh/@10.8712817,106.7891868,17z/data=!3m1!4b1!4m6!3m5!1s0x3175276398969f7b:0x9672b7efd0893fc4!8m2!3d10.8712764!4d106.7917617!16s%2Fm%2F02q4yqq?hl=vi-VN&entry=ttu"
               target="_blank"><img src="Image/z4793086544750_3d5a24d390a654d6b14383f5afd1f044.jpg" alt=""></a>
        </div>
    </div>
</footer>
</body>
</html>