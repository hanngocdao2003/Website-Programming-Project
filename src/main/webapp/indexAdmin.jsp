<%@ page import="bean.CommentReponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collections" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleAddProduct.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleAdmin.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleFeedback.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleOrderManagement.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleProductManagement.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleStatistical.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleUserManagement.css">
    <link rel="stylesheet" href="Image/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="View/styleWeb/styleAdmin/styleAddSlide.css">
    <link rel="icon" href="Image/logo/BHD-html.png" type="image/x-icon">
    <link rel="stylesheet" href="fonts/stylesheet.css">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <script src="View/JSWeb/code.jquery.com_jquery-3.7.1.min.js"></script>
    <title>Admin</title>
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
                        <a href="OrderManagement" class="linkUpload">
                            <li class="item" onclick="handleClick(this, 'panel3')">
                                <i class="fa-solid fa-circle" style="color: var(--border);"></i>
                                Quản lý sản phẩm
                            </li>
                        </a>
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
        <div id="panel1" class="intro_panel">
            <h2 style="color: var(--font)">Chào mừng bạn đã trở lại!</h2>
        </div>
        <!-- Chức năng thống kê dữ liệu -->
        <div id="panel2" class="thongke_panel" style="width: 100%;">
            <div class="thongke_main">
                <div class="thongke doanhthu">
                    <i class="fa-solid fa-money-bills" style="color: var(--border);"></i>
                    <h2 style="color: var(--font)">
                        <%= request.getAttribute("proceed")%>
                    </h2>
                    <span class="temp"></span>
                    <h3 style="color: var(--font)">VND</h3>
                </div>
                <div class="thongke">
                    <i class="fa-solid fa-cart-shopping" style="color: var(--border);"></i>
                    <h2 style="color: var(--font);">
                        <%= request.getAttribute("soldProduct")%>
                    </h2>
                    <span class="temp"></span>
                    <h3 style="color: var(--font);">Sản phẩm đã bán</h3>
                </div>
                <div class="thongke">
                    <i class="fa-solid fa-file-invoice-dollar" style="color: var(--border);"></i>
                    <h2 style="color: var(--font);">
                        <%= request.getAttribute("totalOrder")%>
                    </h2>
                    <span class="temp"></span>
                    <h3 style="color: var(--font);">Đơn hàng</h3>
                </div>
                <div class="thongke">
                    <i class="fa-solid fa-eye" style="color: var(--border);"></i>
                    <h2 style="color: var(--font);">
                        <%= request.getAttribute("users")%>
                    </h2>
                    <span class="temp"></span>
                    <h3 style="color: var(--font);">Người dùng</h3>
                </div>
            </div>
            <div id="chart">
                <canvas id="canvas">
                </canvas>
            </div>
        </div>
        <!-- Chức năng quản lý sản phẩm -->
        <div id="panel3" class="product-management">
            <div class="select_product">
                <div class="label_category">
                    <h2 style="color: var(--font);">Danh mục</h2>
                </div>
                <ul class="category">
                    <li>Áo
                        <ul class="submenu">
                            <li>Áo thun</li>
                            <li>Áo kiểu</li>
                            <li>Áo sơ mi</li>
                            <li>Áo croptop</li>
                        </ul>
                    </li>
                    <li>Áo khoác
                        <ul class="submenu">
                            <li>Áo khoác gió</li>
                            <li>Áo khoác len</li>
                            <li>Blazer</li>
                            <li>Áo khoác Jean/Kaki</li>
                        </ul>
                    </li>
                    <li>Quần
                        <ul class="submenu">
                            <li>Quần dài</li>
                            <li>Quần ngắn</li>
                        </ul>
                    </li>
                    <li>Đầm
                        <ul class="submenu">
                            <li>Đầm kiểu</li>
                            <li>Yếm đầm</li>
                            <li>Nguyên bộ</li>
                        </ul>
                    </li>
                    <li>Váy
                        <ul class="submenu">
                            <li>Váy dài</li>
                            <li>Váy ngắn</li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="search_product">
                <form action="" id="form_search">
                    <div class="search">
                        <input type="text" class="input" placeholder="Tìm kiếm theo tên">
                        <button class="btn_search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </div>
                    <div class="filter">
                        <select name="filter-select" id="filter-select">
                            <option value="alphabet">Sắp xếp theo tên sản phẩm</option>
                            <option value="alphabet">Sắp xếp theo số lượng đã bán</option>
                            <option value="alphabet">Sắp xếp theo số lượng tồn</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="main_label">
                <table id="table1">
                    <thead>
                    <tr>
                        <th class="label">Mã sản phẩm</th>
                        <th class="label">Tên sản phẩm</th>
                        <th class="label">Giá</th>
                        <th class="label">Màu</th>
                        <th class="label">Số lượng đã bán</th>
                        <th class="label">Số lượng tồn</th>
                        <th class="label">Chức năng</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
        <%--        <!-- Chức năng quản lý người dùng -->--%>
        <%--        <div class="customer-management" id="panel4">--%>
        <%--            <div class="seach_customer">--%>
        <%--                <form action="" id="form_search">--%>
        <%--                    <div class="search">--%>
        <%--                        <input type="text" class="input" placeholder="Tìm kiếm theo tên">--%>
        <%--                        <button class="btn_search">--%>
        <%--                            <i class="fa-solid fa-magnifying-glass"></i>--%>
        <%--                        </button>--%>
        <%--                    </div>--%>
        <%--                    <div class="filter">--%>
        <%--                        <select name="filter-select" id="filter-select">--%>
        <%--                            <option value="alphabet">Sắp xếp theo tên người dùng</option>--%>
        <%--                            <option value="alphabet">Sắp xếp theo tài khoản bị khóa</option>--%>
        <%--                        </select>--%>
        <%--                    </div>--%>
        <%--                </form>--%>
        <%--            </div>--%>
        <%--            <div id="info_customer">--%>
        <%--                <div class="main_label">--%>
        <%--                    <table id="table">--%>
        <%--                        <thead>--%>
        <%--                        <tr>--%>
        <%--                            <th class="label">Tên người dùng</th>--%>
        <%--                            <th class="label">Số điện thoại</th>--%>
        <%--                            <th class="label">Email</th>--%>
        <%--                            <th class="label">Quyền</th>--%>
        <%--                            <th class="label">Khóa</th>--%>
        <%--                            <th class="label">Chức năng</th>--%>
        <%--                        </tr>--%>
        <%--                        </thead>--%>
        <%--                        <tbody>--%>
        <%--                        </tbody>--%>
        <%--                    </table>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <!-- Chức năng thêm sản phẩm -->
        <div class="container-add-product" id="panel5">
            <form action="">
                <div class="label">
                    <p style="color: #eeeeee">Thêm sản phẩm</p>
                </div>
                <div class="add-product-here">
                    <div class="file-upload">
                        <label for="imageName">Image Name:</label>
                        <input type="text" id="imageName" name="imageName" required>
                        <div class="image-upload-wrap">
                            <input multiple="multiple" name="imageFile" class="file-upload-input" type='file'
                                   onchange="readURL(this);" accept="image/*"/>
                            <div class="drag-text">
                                <h3>Kéo và thả file hoặc chọn thêm ảnh</h3>
                            </div>
                        </div>
                        <div class="file-upload-content">
                            <img class="file-upload-image" src="#" alt="Ảnh của bạn"/>
                            <div class="image-title-wrap">
                                <button type="button" onclick="removeUpload(this)" class="remove-image">Xóa ảnh trên
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="file-upload">
                        <label for="imageName">Image Name:</label>
                        <input type="text" id="imageName" name="imageName" required>
                        <div class="image-upload-wrap">
                            <input multiple="multiple" name="imageFile" class="file-upload-input" type='file'
                                   onchange="readURL(this);" accept="image/*"/>
                            <div class="drag-text">
                                <h3>Kéo và thả file hoặc chọn thêm ảnh</h3>
                            </div>
                        </div>
                        <div class="file-upload-content">
                            <img class="file-upload-image" src="#" alt="Ảnh của bạn"/>
                            <div class="image-title-wrap">
                                <button type="button" onclick="removeUpload(this)" class="remove-image">Xóa ảnh trên
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="file-upload">
                        <label for="imageName">Image Name:</label>
                        <input type="text" id="imageName" name="imageName" required>
                        <div class="image-upload-wrap">
                            <input multiple="multiple" name="imageFile" class="file-upload-input" type='file'
                                   onchange="readURL(this);" accept="image/*"/>
                            <div class="drag-text">
                                <h3>Kéo và thả file hoặc chọn thêm ảnh</h3>
                            </div>
                        </div>
                        <div class="file-upload-content">
                            <img class="file-upload-image" src="#" alt="Ảnh của bạn"/>
                            <div class="image-title-wrap">
                                <button type="button" onclick="removeUpload(this)" class="remove-image">Xóa ảnh trên
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="file-upload">
                        <label for="imageName">Image Name:</label>
                        <input type="text" id="imageName" name="imageName" required>
                        <div class="image-upload-wrap">
                            <input multiple="multiple" name="imageFile" class="file-upload-input" type='file'
                                   onchange="readURL(this);" accept="image/*"/>
                            <div class="drag-text">
                                <h3>Kéo và thả file hoặc chọn thêm ảnh</h3>
                            </div>
                        </div>
                        <div class="file-upload-content">
                            <img class="file-upload-image" src="#" alt="Ảnh của bạn"/>
                            <div class="image-title-wrap">
                                <button type="button" onclick="removeUpload(this)" class="remove-image">Xóa ảnh trên
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="info-of-product">
                    <div class="name-product">
                        <input type="text" name="name-pro" placeholder="Thêm tên sản phẩm">
                    </div>
                    <div class="price-product">
                        <input type="text" name="price-pro" placeholder="Thêm giá sản phẩm">
                    </div>
                    <div class="type-product">
                        <input type="text" name="name-pro" placeholder="Thêm loại sản phẩm">
                    </div>
                    <div class="discount-product">
                        <input type="text" name="name-pro" placeholder="Mã giảm giá (nếu có)">
                    </div>
                    <div class="suplipper-product">
                        <input type="text" name="name-pro" placeholder="Thêm mã nhà cung cấp">
                    </div>
                    <div class="quantity-product">
                        <input type="text" name="name-pro" placeholder="Số lượng nhập vào kho">
                    </div>
                </div>
                <div class="describe">
                    <textarea placeholder="Mô tả sản phẩm..." required></textarea>
                </div>
                <div class="footer-container">
                    <button>Thêm sản phẩm</button>
                </div>
            </form>
        </div>
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
                    <form action="">
                        <div><input name="choose1" type="radio">
                            <span>Đã thanh toán</span>
                        </div>
                        <div><input name="choose1" type="radio">
                            <span>Chưa thanh toán</span>
                        </div>
                    </form>
                </div>
                <div class="status inspect">
                    <p>Duyệt</p>
                    <form action="">
                        <div><input name="choose2" type="radio">
                            <span>Đã duyệt</span>
                        </div>
                        <div><input name="choose2" type="radio">
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
        <!-- Chức năng phản hồi người dùng -->
        <%--        <div class="reply" id="panel7">--%>
        <%--            &lt;%&ndash;            <div class="search-reply">&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                <form action="" id="form_search">&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                    <div class="search">&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                        <input type="text" class="input" placeholder="Tìm kiếm theo tên">&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                        <button class="btn_search">&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                            <i class="fa-solid fa-magnifying-glass"></i>&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                        </button>&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                    </div>&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                    <div class="filter">&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                        <select name="filter-select" id="filter-select">&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                            <option value="alphabet">Sắp xếp theo chưa đọc</option>&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                            <option value="alphabet">Sắp xếp theo chưa phản hồi</option>&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                        </select>&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                    </div>&ndash;%&gt;--%>
        <%--            &lt;%&ndash;                </form>&ndash;%&gt;--%>
        <%--            &lt;%&ndash;            </div>&ndash;%&gt;--%>
        <%--            <div id="content">--%>
        <%--                <form class="main_label" action="uploadCmt" method="post">--%>
        <%--                    <table id="table3">--%>
        <%--                        <thead>--%>
        <%--                        <tr>--%>
        <%--                            <th class="label">Số thứ tự</th>--%>
        <%--                            <th class="label">Tên khách hàng</th>--%>
        <%--                            <th class="label">Nội dung phản hồi</th>--%>
        <%--                            <th class="label">Ngày bình luận</th>--%>
        <%--                            <th class="label">Đánh dấu đã đọc</th>--%>
        <%--                        </tr>--%>
        <%--                        </thead>--%>
        <%--                    </table>--%>
        <%--                    <div class="btn_upload">--%>
        <%--                        <button  class="btn_show">Tải dữ liệu</button>--%>
        <%--                    </div>--%>
        <%--                </form>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <!-- Chức năng thêm slide cho trang chủ -->
        <div id="panel_addSlide">
            <form method="post" action="addSlide" enctype="multipart/form-data">
                <div class="label">
                    <p>Thêm chương trình</p>
                </div>
                <div class="add-slide-here">
                    <div class="file-upload">
                        <label for="imageName">Image Name:</label>
                        <input type="text" id="imageName" name="imageName" required>
                        <div class="image-upload-wrap">
                            <input multiple="multiple" name="imageFile" class="file-upload-input" type='file'
                                   onchange="readURL(this);" accept="image/*"/>
                            <div class="drag-text">
                                <h3>Kéo và thả file hoặc chọn thêm ảnh</h3>
                            </div>
                        </div>
                        <div class="file-upload-content">
                            <img class="file-upload-image" src="#" alt="Ảnh của bạn"/>
                            <div class="image-title-wrap">
                                <button type="button" onclick="removeUpload(this)" class="remove-image">Xóa ảnh trên
                                </button>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="footer-container">
                    <input type="submit" value="Submit" class="button">
                </div>
            </form>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="View/JSWeb/data.js"></script>
<script src="View/JSWeb/eventAdmin.js"></script>
<script src="View/JSWeb/eventAddProduct.js"></script>
<script src="View/JSWeb/addSlide.js"></script>
</body>


</html>

