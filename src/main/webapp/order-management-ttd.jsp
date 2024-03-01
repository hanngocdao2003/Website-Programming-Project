<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleAdmin.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleUserManagement.css">
    <link rel="stylesheet" href="Image/fontawesome/css/all.min.css">
    <title>Quản lý đơn hàng</title>
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
                <div class="button_add_product">
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
                        <li class="item" style="color: white; border: 2px solid var(--font);
    border-radius: 20px;
    background-color: var(--font);">
                            <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                            Quản lý người dùng
                        </li>
                        <li class="item">
                            <a href="UploadCommentAdmin.jsp"><i
                                    class="fa-solid fa-circle"
                                    style="color: var(--border);"></i>
                                Phản hồi người dùng</a>
                        </li>
                        <li class="item">
                            <a href="indexAdmin.jsp"><i class="fa-solid fa-circle"
                                                        style="color: var(--border);"></i>
                                Thêm trình chiếu</a>
                        </li>
                        <a href="indexForgetPass.jsp" style="text-decoration: none">
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
        <!-- Chức năng quản lý đơn hàng -->
        <div class="order-management" id="panel6">
            <div class="search_order">
                <form action="" id="form_search">
                    <div class="search">
                        <input type="text" class="input" placeholder="Tìm kiếm theo tên">
                        <button class="btn_search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </div>
                </form>
            </div>
            <div class="filter">
                <div class="status">
                    <p>Trạng thái</p>
                    <form action="OrderManagement">
                        <div><input name="choose1" type="radio" value="dtt">
                            <span>Đã thanh toán</span>
                        </div>
                        <div><input name="choose1" type="radio" value="ctt">
                            <span>Chưa thanh toán</span>
                        </div>
                    </form>
                </div>
                <div class="status inspect">
                    <p>Duyệt</p>
                    <form action="OrderManagement">
                        <div><input name="choose2" type="radio" value="d">
                            <span>Đã duyệt</span>
                        </div>
                        <div><input name="choose2" type="radio" value="cd">
                            <span>Chưa duyệt</span>
                        </div>
                    </form>
                </div>
            </div>
            <div id="info_order">
                <div class="main_label">
                    <table id="table2">
                        <thead>
                        <tr>
                            <th class="label">Mã đơn hàng</th>
                            <th class="label">Tên khách hàng</th>
                            <th class="label">Số lượng sản phẩm</th>
                            <th class="label">Tổng tiền</th>
                            <th class="label">Trạng thái</th>
                            <!-- <th class="label">Mã phân quyền</th> -->
                            <th class="label">Duyệt đơn hàng</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>

