<%@ page import="bean.ProductResponse" %>
<%@ page import="bean.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="Image/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="View/styleWeb/styleHeader.css">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <link rel="stylesheet" href="View/styleWeb/styleProduct.css">
    <link rel="stylesheet" href="View/styleWeb/stylePagination.css">
    <link rel="stylesheet" href="View/styleWeb/styleFooter.css">
    <link rel="stylesheet" href="View/styleWeb/styleOutline.css">
    <link rel="icon" href="Image/logo/BHD-html.png" type="image/x-icon">
    <script src="View/JSWeb/code.jquery.com_jquery-3.7.1.min.js"></script>
    <script src="View/JSWeb/slick.min.js"></script>
    <script src="View/JSWeb/addPart.js"></script>
    <script src="View/JSWeb/JSHome.js"></script>
    <script src="View/JSWeb/slideShow.js"></script>
    <title>Bộ sưu tập</title>
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
<div class="SliderShow_Store">
    <div class="SlideList">
        <img src="Image/SlideStore/slide3.png" alt="">
        <img src="Image/SlideStore/slide2.png" alt="">
        <img src="Image/SlideStore/slide4.png" alt="">
        <img src="Image/SlideStore/slide1.png" alt="">
    </div>
</div>
<div class="page1 page">
    <ul class="listItemProduct" id="allOfCategory">
        <%
            List<ProductResponse> productResponses = (List<ProductResponse>) request.getAttribute("products");
            if (productResponses != null) {
                for (ProductResponse p : productResponses
                ) {
        %>
        <li class="itemProduct">
            <a href="detailsProduct?productId=<%=p.getId()%>"><img src="Image/Product/<%=p.getImage()%>" alt=""
                                                                   class="imageProduct"></a>
            <a href="detailsProduct?productId=<%=p.getId()%>" class="linkProduct"><%=p.getName()%>
            </a>
            <div class="evalute"><span>Đánh giá: <ul class="fiveStar">
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
            </ul></span></div>

            <p class="priceProduct"><%=p.getPrice()%>
            </p>

        </li>
        <%
                }
            }
        %>
    </ul>
</div>

<script>
    document.body.innerHTML += addFooter();

    function validateForm() {
        var productInput = document.getElementById('productInput').value;
        if (productInput.trim() === null) {
            alert("Vui lòng nhập sản phẩm cần tìm");
            return false;
        }
        return true;
    }
</script>
</body>
</html>