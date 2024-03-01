<%@ page import="bean.InformationUser" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleUserManagement.css">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleAdmin.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleLockUser.css">
    <link rel="stylesheet" href="Image/fontawesome/css/all.min.css">
    <title>Quản lý người dùng</title>
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
        <div class="firstPanel">
            <a href="uploadInfUser"><i class="fa-solid fa-caret-left"></i> Quản lý tài khoản</a>
        </div>
        <!-- Chức năng quản lý người dùng -->
        <div class="customer-management" id="panel4">
            <div id="info_customer">

                <form class="main_label running" action="uploadLockUser" method="get">
                    <span>Thông tin các tài khoản</span>
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="label">Tên người dùng</th>
                            <th class="label">Số điện thoại</th>
                            <th class="label">Email</th>
                            <th class="label">Quyền</th>
                            <th class="label">Trạng thái</th>
                            <th class="label">Khóa tài khoản</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<InformationUser> infUser;
                            infUser = (List<InformationUser>) session.getAttribute("listLockUser");
                            System.out.println(infUser);
                            String running = "Đang hoạt động";
                            String lockUser = "Đã khóa";
                            if (infUser != null && !infUser.isEmpty()) {
                                for (int i = 0; i < infUser.size(); i++) {

                        %>
                        <tr>
                            <td><%= infUser.get(i).getName() %>
                            </td>
                            <td><%= infUser.get(i).getNumberphone() %>
                            </td>
                            <td><%= infUser.get(i).getEmail() %>
                            </td>
                            <td><%= infUser.get(i).getRole() %>
                            </td>
                            <%if (infUser.get(i).getStatus() == 1) {%>
                            <td><%=running %>
                            </td>
                            <%} else {%>
                            <td><%=lockUser %>
                            </td>
                            <%}%>
                            <td>
                                <a href="#"> <a href="unlockUser?idUl=<%=infUser.get(i).getId()%>" class="btn_lock">Mở
                                    khóa tài khoản</a>
                                </a>
                            </td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="6">Không có dữ liệu để hiển thị</td>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </div>
</div>

</body>
</html>
