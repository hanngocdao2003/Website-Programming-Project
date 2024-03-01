<%@ page import="bean.UserEntity" %>
<%@ page import="bean.ShoppingCart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Debug: In ra thông tin Session --%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Image/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="View/styleWeb/styleFooter.css">
    <link rel="stylesheet" href="View/styleWeb/styleHeader.css">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <link rel="stylesheet" href="View/styleWeb/stylePersonal.css">
    <link rel="icon" href="Image/logo/BHD-html.png" type="image/x-icon">
    <script src="View/JSWeb/code.jquery.com_jquery-3.7.1.min.js"></script>
    <script src="View/JSWeb/slick.min.js"></script>
    <script src="View/JSWeb/addPart.js"></script>
    <script src="View/JSWeb/JSHome.js"></script>
    <script src="View/JSWeb/slideShow.js"></script>
    <title>Thông tin cá nhân</title>
</head>

<body>
<header>
    <%
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
        }
    %>
    <div class="firstArea">
        <div class="logo_search_cart">
            <a href="index.jsp" class="logo">
                <img src="Image/logo/BHD-nền%20trong%20suốt.svg" alt="404">
                <h1>BHD Boutique</h1>
            </a>
            <div class="search_Category">
                <form class="Search" action="Product" method="get">
                    <input name="keyword" type="text" class="input_search" placeholder="Nhập sản phẩm cần tìm">
                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
            </div>

            <div class="rightIcon">
                <a href="indexOrder.jsp" class="cartHeader"><i class="fa-solid fa-cart-shopping"></i><span
                        id="totalitem"
                        style="color: var(--but)">
                             <%
                                 Object idUser = request.getSession().getAttribute("Id");
                                 if (idUser != null) {
                                     int id = (Integer) idUser;
                             %>
                            <%= cart.getTotalItem(id) %>
                                <%}%>
                        </span></a>
                <%
                    String success = (String) session.getAttribute("Success");
                    if (success != null) {
                %>
                <form action="LogOut" method="post">
                    <button class="logOut">Đăng xuất</button>
                </form>
                <%
                } else {
                %>
                <a href="indexLogin.jsp" class="user"><i class="fa-solid fa-user"></i></a>
                <%
                    }
                %>
            </div>

        </div>
    </div>
    <div class="menu_container">
        <div class="task_menu">
            <button class="btn_Category_search" id="btn_Category_search">
                    <span>
                        Danh mục
                    </span>
                <i class="fa-solid fa-angle-down"></i>
                <ul class="menu_Category" id="menu_Category">
                    <li class="menu_Category_Item">
                        <form class="Searchs" action="Product" method="get">
                            <div class="">
                                <input type="text" name="nameproduct" value="" hidden="hidden">
                                <input class="TitleCategory" type="submit" value="Tất cả sản phẩm">
                            </div>
                        </form>
                    </li>
                    <li class="menu_Category_Item">
                        <form class="Searchs" action="Product" method="get">
                            <div class="">
                                <input type="text" name="nameproduct" value="Áo" hidden="hidden">
                                <input class="TitleCategory" type="submit" value="Áo">
                            </div>
                        </form>
                    </li>
                    <li class="menu_Category_Item">
                        <form class="Searchs" action="Product" method="get">
                            <div class="">
                                <input type="text" name="nameproduct" value="Áo Khoác" hidden="hidden">
                                <input class="TitleCategory" type="submit" value="Áo Khoác">
                            </div>
                        </form>
                    </li>
                    <li class="menu_Category_Item">
                        <form class="Searchs" action="Product" method="get">
                            <div class="">
                                <input type="text" name="nameproduct" value="Quần" hidden="hidden">
                                <input class="TitleCategory" type="submit" value="Quần">
                            </div>
                        </form>
                    </li>
                    <li class="menu_Category_Item">
                        <form class="Searchs" action="Product" method="get">
                            <div class="">
                                <input type="text" name="nameproduct" value="Đầm" hidden="hidden">
                                <input class="TitleCategory" type="submit" value="Đầm">
                            </div>
                        </form>
                    </li>
                    <li class="menu_Category_Item">
                        <form class="Searchs" action="Product" method="get">
                            <div class="">
                                <input type="text" name="nameproduct" value="Váy" hidden="hidden">
                                <input class="TitleCategory" type="submit" value="Váy">
                            </div>
                        </form>
                    </li>
                </ul>
            </button>
            <ul class="Menupage">
                <a href="index.jsp" class="linkpage Home">
                    <li class="Item_menuPage">Trang chủ</li>
                </a>
                <form class="linkpage Shop" action="Product" method="get" id="productForm">
                    <input type="text" name="nameproduct" value="" style="display: none;">
                    <li class="Item_menuPage" onclick="submitForm()">Cửa hàng</li>
                </form>
                <a href="#" class="linkpage Contact" id="Contact">
                    <li class="Item_menuPage">Liên hệ</li>
                </a>
                <a href="AboutUs.jsp" class="linkpage Fashion">
                    <li class="Item_menuPage">Giới thiệu</li>
                </a>
                <a href="comment.jsp" class="linkpage Comment">
                    <li class="Item_menuPage">Đóng góp ý kiến</li>
                </a>
            </ul>
        </div>
    </div>
</header>
<div class="infor-user">
    <div class="label">
        <p style="color: brown;">Tài khoản của bạn</p>
        <div class="crossbar"></div>
    </div>
    <hr>
    <div class="information-acc">
        <form class="inf_acc" action="home" method="post">
            <label for="fullName">Họ và tên:</label>
            <input type="text" id="fullName" readonly
                   value="<%= (String) session.getAttribute("fullName") != null ? (String) session.getAttribute("fullName") : "" %>"
                   name="fullName">

            <label for="numberPhone">Số điện thoại:</label>
            <input type="text" id="numberPhone" readonly
                   value="<%= (String) session.getAttribute("numberPhone") != null ? (String) session.getAttribute("numberPhone") : "" %>"
                   name="numberPhone">
            <label for="email">Email:</label>
            <input type="email" id="email" readonly
                   value="<%= (String) session.getAttribute("email") != null ? (String) session.getAttribute("email") : "" %>"
                   name="email">
            <label for="address">Địa chỉ:</label>
            <div id="address" class="address label_information">
                <input type="text" placeholder="Tỉnh-Thành phố" readonly
                       value="<%= (String) session.getAttribute("province") != null ? (String) session.getAttribute("province") : "" %>"
                       name="province" id="province">
                <input type="text" placeholder="Quận-Huyện" readonly
                       value="<%= (String) session.getAttribute("district") != null ? (String) session.getAttribute("district") : "" %>"
                       name="district" id="district">
                <input type="text" placeholder="Xã-Phường-Thị trấn" readonly
                       value="<%= (String) session.getAttribute("ward") != null ? (String) session.getAttribute("ward") : "" %>"
                       name="ward" id="ward">
                <input type="text" placeholder="Số nhà-Đường" readonly
                       value="<%= (String) session.getAttribute("numHouse") != null ? (String) session.getAttribute("numHouse") : "" %>"
                       name="numHouse" id="numHouse">
            </div>
            <div></div>

        </form>

        <div class="buttonOfpage">
            <a href="UpdatePersonal.jsp">
                <button type="submit" class="update" id="update0">Cập nhật thông tin</button>
            </a>
            <a href="indexChangePass.jsp">
                <button type="submit" class="update" id="update1">Đổi mật khẩu</button>
            </a>
        </div>


    </div>

</div>
<script>
    document.body.innerHTML += addFooter();

</script>

<script>

</script>
</body>

</html>