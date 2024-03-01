<%@ page import="bean.ProductResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="java.security.Provider" %>
<%@ page import="bean.ShoppingCart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="View/styleWeb/styleHeader.css">
    <link rel="stylesheet" href="View/styleWeb/styleDetails.css">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <link rel="stylesheet" href="View/styleWeb/styleFooter.css">
    <link rel="stylesheet" href="View/styleWeb/styleButtonAdd.css">
    <script src="View/JSWeb/eventButtonAdd.js"></script>
    <link rel="stylesheet" href="Image/fontawesome/css/all.min.css">
    <link rel="icon" href="Image/logo/BHD-html.png" type="image/x-icon">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <script src="View/JSWeb/addPart.js"></script>
    <script type="text/javascript" src="View/JSWeb/jquery-3.7.1.js"></script>
    <script src="View/JSWeb/JSDetails.js"></script>
    <title>Chi tiết đơn hàng</title>
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
                    String roleID = (String) session.getAttribute("Role");
                    System.out.println(success);
                    System.out.println(roleID);
                    if (success != null && "R1".equals(roleID)) {
                %>
                <a href="indexAdmin.jsp" class="user"><i class="fa-solid fa-user"
                                                         style="margin-right: 5px"></i> <%= success %>
                </a>
                <%
                } else if (success != null) {
                %>
                <a href="indexPersonal.jsp" class="user"><i class="fa-solid fa-user"
                                                            style="margin-right: 5px"></i> <%= success %>
                </a>
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
<%
    ProductResponse p = (ProductResponse) request.getAttribute("productDetail");
    System.out.println(p);
    if (p != null) {
%>
<div class="container" id="product" product-id="<%=p.getId()%>">

    <div class="img-product">
        <div class="mini-img-product">
            <img src="Image/Product/<%= p.getImage()%>" alt="">

        </div>
        <div class="zoom-image-product">
            <img src="Image/Product/<%= p.getImage() %>" alt="">`
        </div>

    </div>

    <div class="text">
        <div class="information">
            <p class="name"><%=p.getName()%>
            </p>
            <div class="quantity">
<%--                <div class="sale">--%>
<%--                    <p class="sub-sale">Đã bán: 65</p>--%>
<%--                </div>--%>
<%--                <div class="inventory">--%>
<%--                    <p class="sub-inventory">Còn lại: 134</p>--%>
<%--                </div>--%>
            </div>
            <p class="price"><%=cart.totalPriceFormatted(p.getPrice())%>
            </p>
            <p class="color" style="font-weight: bold;">Màu sắc:</p>
            <div class="color-btn" style="margin-bottom: 10px;">
                <%
                    String colors = p.getColor();
                    String[] arrColor = colors.split(",");

                    for (int i = 0; i < arrColor.length; i++) {
                        String c = arrColor[i];
                %>
                <button class="btn button color" style="background-color: #<%=c.trim()%>;" value="#<%=c.trim()%>"></button>
                <%}%>
            </div>
            <p class="size" style="margin-bottom: 5px; font-weight: bold;">Kích thước:</p>
            <%
                String sizes = p.getSize();
                String[] arr = sizes.split(",");
                for (int i = 0; i < arr.length; i++) {
                    String s = arr[i];
            %>
            <button class="button size-btn size" value="<%=s.trim()%>"><%=s.trim()%></button>
            <%}%>
            <div class="add" style="margin-bottom: 10px;">
                <button class="add-pd add-cart"><i class="fa-solid fa-cart-shopping"
                                                   style="color: #fff; margin-left: 5px;"></i>Thêm vào giỏ hàng


                </button>
            </div>
        </div>
        <hr style="margin-bottom: 20px;">
        <div class="feature"></div>
        <p style="font-weight: bold; margin-bottom: 5px;">Mô tả sản phẩm:</p>
        <%
            String dts = p.getDetails();
            String[] lDetail = dts.split(",");
            for (String s : lDetail) {
        %>
        <ul class="describe">
            <li class="describe-p"><%=s.trim()%>
            </li>
        </ul>
        <%}%>
        <hr style="margin-bottom: 20px;">
        <p style="font-weight: bold; margin-bottom: 5px;">Hướng dẫn sử dụng:</p>
        <ul class="use">
            <li>Giặt máy ở chế độ nhẹ, nhiệt độ thường.</li>
            <li>Không sử dụng hoá chất tẩy có chứa Clo.</li>
            <li>Phơi trong bóng mát.</li>
            <li>Sấy thùng, chế độ nhẹ nhàng.</li>
            <li>Là ở nhiệt độ trung bình 150 độ C.</li>
            <li>Giặt với sản phẩm cùng màu</li>
            <li>Không là lên chi tiết trang trí</li>
        </ul>
    </div>
</div>
<%}%>

<script>
    document.body.innerHTML += addFooter();
</script>

</body>

</html>