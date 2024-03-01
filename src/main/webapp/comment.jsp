<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.ShoppingCart" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="View/styleWeb/styleComment.css">
    <link rel="stylesheet" href="View/styleWeb/styleFooter.css">
    <link rel="stylesheet" href="Image/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="icon" href="Image/BHD-html.png" type="image/x-icon">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <script src="View/JSWeb/addPart.js"></script>
    <title>Đóng góp ý kiến</title>
</head>

<body>
<div class="image">
    <a href="index.jsp" class="home"><img src="Image/BHD-nền%20trong%20suốt.svg" alt=""></a>
</div>
<form class="wrapper" action="insertComment">
    <h2>Bạn có gì muốn nhắn gửi cho BHD Store ạ ? *</h2>
    <textarea name="feedback" placeholder="Bạn nhập nội dung ở đây..." required></textarea>
    <button type="submit" class="buttonComment">Ok, Xong rồi!</button>
</form>
<script>
    document.body.innerHTML += addFooter();

    const textarea = document.querySelector("textarea");
    textarea.addEventListener("input", (e) => {
        textarea.style.height = "63px";
        let scHeight = e.target.scrollHeight;
        textarea.style.height = scHeight + "px";
    });
</script>
</body>

</html>