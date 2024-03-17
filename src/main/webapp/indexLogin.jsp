<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="View/styleWeb/styleLogin.css">
    <link rel="stylesheet" href="Image/fontawesome/css/all.min.css">
    <link rel="icon" href="Image/logo/BHD-html.png" type="image/x-icon">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <script src="View/JSWeb/jquery-3.7.1.js"></script>
    <script src="View/JSWeb/LoginEvent.JS"></script>
    <title>Đăng Nhập</title>

</head>

<body>
<div class="content">
    <div class="SignIn_Area">
        <a href="index.jsp"><img src="Image/BHD-nền%20trong%20suốt.svg" alt="" class="logo"></a>
        <form action="home" class="formSignIn" method="post">
            <h1 class="titleSignIn">Đăng nhập</h1>
            <%
                String error = (String) request.getAttribute("Error");
                if (error != null) {
            %>
            <span><%= error%></span>
            <%}%>
            <%
                String error1 = (String) request.getAttribute("block");
                if (error1 != null) {
            %>
            <span><%= error1%></span>
            <%}%>
            <div class="NameAcc">
                <label for="inputNumPhone" class="label">Số điện thoại:</label>
                <input type="text" id="inputNumPhone" placeholder="Nhập số điện thoại" name="userName">
            </div>
            <div class="passAcc">
                <label for="inputPass" class="label">Mật khẩu:</label>
                <div class="passplace">
                    <input type="password" id="inputPass" placeholder="Nhập mật khẩu" autocomplete="current-password"
                           name="password">
                    <div class="hidden-appear" id="hidden-appear-SinIn-pass">
                        <i class="fa-regular fa-eye" id="eye"></i>
                    </div>
                </div>
                <div class="remember">
                    <input type="checkbox" id="check">
                    <label for="check">Ghi nhớ mật khẩu</label>
                </div>
                <a href="indexForgetPass.jsp" class="forgotPass">Quên mật khẩu?</a>
            </div>

            <div class="buttonSubmit">
                <input type="submit" class="button" value="Đăng nhập" name="btnLogin">
            </div>
            <div class="create">
                <a href="" class="createAcc" id="createAcc">Tạo tài khoản mới</a>
            </div>
        </form>
    </div>
    <div class="SignUp_Area">
        <form action="SignUp" method="post" class="formSignUp">
            <div class="first">
                <h1 class="titleSignUp">Đăng ký</h1>
                <a href="" class="undo" id="undo">
                    <i class="fa-solid fa-share"></i>
                    Trở lại đăng nhập
                </a>

            </div>
            <div class="NameUser">
                <label for="inputName" class="label">Họ và tên:</label>

                <input type="text" id="inputName" placeholder="Nhập họ và tên" required name="inputName">
            </div>
            <div class="EmailUser">
                <label for="inputEmail" class="label">Email</label>
                <input type="text" id="inputEmail" placeholder="Nhập email của bạn" required name="inputEmail">
            </div>
            <div class="NameAcc">
                <label for="inputNumPhoneRect" class="label">Số điện thoại:</label>
                <input type="text" id="inputNumPhoneRect" placeholder="Nhập số điện thoại" required
                       name="inputNumPhoneRect">

            </div>
            <div class="password_Area">
                <div class="passAcc">
                    <label for="inputPassRect" class="label">Mật khẩu:</label>
                    <div class="passplace">

                        <input type="password" id="inputPassRect" placeholder="Nhập mật khẩu" required
                               name="inputPassRect">

                        <div class="hidden-appear" id="hidden-appear-SingUp-pass">
                            <i class="fa-regular fa-eye" id="eye"></i>
                        </div>
                    </div>
                </div>
                <div class="passAcc">
                    <label for="ReinputPass" class="label">Nhập lại mật khẩu:</label>
                    <div class="passplace">
                        <input type="password" id="ReinputPass" placeholder="Nhập mật khẩu" required name="ReinputPass">

                        <button type="button" class="hidden-appear" id="hidden-appear-SingUp-Repass">
                            <i class="fa-regular fa-eye" id="eye"></i>
                        </button>
                    </div>
                </div>
            </div>
            <%
                String fail = (String) request.getAttribute("fail");
                if (fail != null) {
            %>
            <span><%= fail%></span>
            <%}%>

            <%
                String password = (String) request.getAttribute("password");
                if (password != null) {
            %>
            <span><%= password%></span>
            <%}%>
            <div class="buttonSubmit Register">
                <input type="submit" class="button" value="Tạo tài khoản">
            </div>
            <div id="other">
                <span>hoặc đăng ký bằng</span>
                <div>
                    <i class="fa-brands fa-google"></i>
                    <i class="fa-brands fa-facebook"></i>
                </div>
            </div>
        </form>
    </div>
    <div class="intro" id="intro" style="right: <%=request.getAttribute("fail") != null ? "50%" : "0%"%>">
        <div class="hello">
            <h3 class="welcome">BHD Boutique
                <br>
                Xin Chào!
            </h3>
            <span class="letterWelcome">Chào mừng bạn đến với BHD Boutique. Hãy đăng nhập để đến với trang chủ của
                    chúng tôi!</span>
        </div>
        <div class="back-Area">
            <a href="index.jsp" class="back">
                <i class="fa-solid fa-house"></i>
                Về trang chủ
            </a>
        </div>
    </div>
</div>
</body>
</html>