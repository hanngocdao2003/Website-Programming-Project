<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.CommentReponse" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleUploadComment.css">
    <link rel="stylesheet" href="View/styleWeb/color.css">

    <title>Phản hồi của người dùng</title>
</head>
<body>
<header class="logo">
    <img src="Image/BHD-nền%20trong%20suốt.svg" alt="">
    <h3 style="font-family: 'Brush Script MT', cursive">BHD Boutique</h3>
    <form action="LogOut" method="post" id="logOut">
        <button class="logOut">Đăng xuất</button>
    </form>
</header>
<div class="center" style="display: flex;">
    <div class="left_panel" style="width: 18%;">
        <nav class="menu_bar">
            <div class="bar">
                <div class="logo_admin">
                    <i class="fa-solid fa-lock" style="color: var(--border); font-size: 20px;"></i>
                    <h2 style="color: var(--font);">Admin</h2>
                </div>
                <div class="button_add_product" onclick="buttonClick('panel5')">
                    <i class="fa-solid fa-plus" style="color: var(--border);"></i>
                    Thêm sản phẩm
                </div>
                <div class="menu_nav">
                    <ul class="menu">
                        <a href="index.jsp" style="text-decoration: none">
                            <li class="item">
                                <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                                Trang chủ
                            </li>
                        </a>
                        <li class="item" onclick="handleClick(this, 'panel2')">
                            <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                            Thống kê số liệu
                        </li>
                        <li class="item" onclick="handleClick(this, 'panel3')">
                            <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                            Quản lý sản phẩm
                        </li>
                        <li class="item" onclick="handleClick(this, 'panel6')">
                            <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                            Quản lý đơn hàng
                        </li>
                        <a href="uploadInfUser" class="linkUpload">
                            <li class="item">
                                <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                                Quản lý người dùng
                            </li>
                        </a>
                        <a href="upload-cmt" class="linkUpload">
                            <li class="item">
                                <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                                Phản hồi người dùng
                            </li>
                        </a>
                        <li class="item" onclick="handleClick(this, 'panel_addSlide')">
                            <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                            Thêm trình chiếu
                        </li>
                        <a href="indexChangePass.jsp" style="text-decoration: none">
                            <li class="item">
                                <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                                Đổi mật khẩu
                            </li>
                        </a>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div id="info_panel" class="info_panel">
        <!-- Chức năng phản hồi người dùng -->
        <div class="reply" id="panel7">
            <div id="content">
                <form class="main_label" action="upload-cmt" method="get">
                    <table id="table3">
                        <thead>
                        <tr>
                            <th class="label">Số thứ tự</th>
                            <th class="label">Tên khách hàng</th>
                            <th class="label">Nội dung phản hồi</th>
                            <th class="label">Ngày bình luận</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<CommentReponse> comments;
                            comments = (List<CommentReponse>) session.getAttribute("Comments");
                            List<Integer> listID = new ArrayList<>();
                            System.out.println(comments);
                            if (comments != null && !comments.isEmpty()) {
                                for (int i = 0; i < comments.size(); i++) {
                                    listID.add(comments.get(i).getId());
                        %>
                        <tr>

                            <%--                            <% System.out.println(comments.get(i).getId());%>--%>
                            <td><%= i + 1 %>
                            </td>
                            <td><%= comments.get(i).getNameUser() %>
                            </td>
                            <td><%= comments.get(i).getFeedback() %>
                            </td>
                            <td><%= comments.get(i).getDate_cmt() %>
                            </td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="5">Không có dữ liệu để hiển thị</td>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                </form>
                <form action="readCmt" class="btn_read_cmt">
                    <% for (Integer id : listID) { %>
                    <input type="hidden" value="<%= id %>" name="IDcmt"/>
                    <% } %>
                    <input type="submit" class="button_read_all" value="Đã đọc tất cả">
                </form>
            </div>
        </div>

    </div>
</div>
</body>
</html>
