<%@ page import="bean.UserEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.ShoppingCart" %>
<%@ page import="bean.Slide" %>
<%@ page import="controller.ImageSliderServlet" %>
<%@ page import="service.Add_Image_Service" %>
<%@ page import="service.ProductService" %>
<%@ page import="bean.ProductResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Image/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="View/styleWeb/styleMenu.css">
    <link rel="stylesheet" href="View/styleWeb/styleHeader.css">
    <%--    <link rel="stylesheet" href="View/styleWeb/styleOrder.css">--%>
    <link rel="stylesheet" href="View/styleWeb/styleFooter.css">
    <link rel="stylesheet" href="View/styleWeb/color.css">
    <link rel="icon" href="Image/logo/BHD-html.png" type="image/x-icon">
    <script src="View/JSWeb/code.jquery.com_jquery-3.7.1.min.js"></script>
    <script src="View/JSWeb/slick.min.js"></script>
    <script src="View/JSWeb/addPart.js"></script>
    <script src="View/JSWeb/JSHome.js"></script>
    <script src="View/JSWeb/slideShow.js"></script>
    <title>Trang chủ</title>
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
        <%
            List<String> imagePaths = Add_Image_Service.loadSlider();
            for (String imagePath : imagePaths) {
        %>
        <img src="<%= imagePath %>" alt="">
        <% } %>
    </div>
</div>
<div class="CategoryCard">
    <a href="">
        <form class="Search" action="Product" method="get">
            <div class="CategoryItem T-Shirt">
                <input type="text" name="nameproduct" value="Áo" hidden="hidden">
                <button class="TitleCategory" name="keyword" type="submit"><span>Áo</span></button>
            </div>
        </form>
    </a>
    <a href="">
        <form class="Search" action="Product" method="get">
            <div class="CategoryItem Jacket">
                <input type="text" name="nameproduct" value="Áo Khoác" hidden="hidden">
                <button class="TitleCategory" type="submit"><span>Áo khoác</span></button>
            </div>
        </form>
    </a>
    <a href="">
        <form class="Search" action="Product" method="get">
            <div class="CategoryItem Trouser">
                <input type="text" name="nameproduct" value="Quần" hidden="hidden">
                <button class="TitleCategory" type="submit"><span>Quần</span></button>
            </div>
        </form>
    </a>

    <a href="">
        <form class="Search" action="Product" method="get">
            <div class="CategoryItem Dress">
                <input type="text" name="nameproduct" value="Đầm" hidden="hidden">
                <button class="TitleCategory" type="submit"><span>Đầm</span></button>
            </div>
        </form>
    </a>
    <a href="">
        <form class="Search" action="Product" method="get">
            <div class="CategoryItem Skirt">
                <input type="text" name="nameproduct" value="Váy" hidden="hidden">
                <button class="TitleCategory" type="submit"><span>Váy</span></button>
            </div>
        </form>
    </a>
</div>
<div class="Top10 NewProductOfStore">
    <div class="Filter_ProductSilde">
        <span>Sản phẩm mới</span>
        <div class="SliderShow_Product">
            <div class="SlideListProduct">
                <%
                    List<ProductResponse> images = ProductService.getImageSlide();
                    for (ProductResponse imagePath : images) {
                %>
                <a href=""><img src="Image/Product/<%= imagePath.getImage() %>" alt=""></a>
                <% } %>
            </div>
        </div>
    </div>
</div>

<div class="Top10 OfCategory">
    <span>Sản phẩm bán chạy</span>
    <div class="Top10 T-ShirtOfStore">
        <div class="Filter_ProductSilde">
            <span>Áo</span>
            <div class="SliderShow_Product">
                <div class="SlideListProduct">
                    <%
                        List<ProductResponse> imageShirt = ProductService.getImageSlideProduc("Áo");
                        for (ProductResponse imagePath : imageShirt) {
                    %>
                    <a href=""><img src="Image/Product/<%= imagePath.getImage() %>" alt=""></a>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
    <div class="Top10 TrouserOfStore">
        <div class="Filter_ProductSilde">
            <span>Quần</span>
            <div class="SliderShow_Product">
                <div class="SlideListProduct">
                    <%
                        List<ProductResponse> imageTrouser = ProductService.getImageSlideProduc("Quần");
                        for (ProductResponse imagePath : imageTrouser) {
                    %>
                    <a href=""><img src="Image/Product/<%= imagePath.getImage() %>" alt=""></a>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
    <div class="Top10 JacketOfStore">
        <div class="Filter_ProductSilde">
            <span>Áo khoác</span>
            <div class="SliderShow_Product">
                <div class="SlideListProduct">
                    <%
                        List<ProductResponse> imageJacket = ProductService.getImageSlideProduc("Áo khoác");
                        for (ProductResponse imagePath : imageJacket) {
                    %>
                    <a href=""><img src="Image/Product/<%= imagePath.getImage() %>" alt=""></a>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
    <div class="Top10 DressOfStore">
        <div class="Filter_ProductSilde">
            <span>Đầm</span>
            <div class="SliderShow_Product">
                <div class="SlideListProduct">
                    <%
                        List<ProductResponse> imageDress = ProductService.getImageSlideProduc("Đầm");
                        for (ProductResponse imagePath : imageDress) {
                    %>
                    <a href=""><img src="Image/Product/<%= imagePath.getImage() %>" alt=""></a>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
    <div class="Top10 DressOfStore">
        <div class="Filter_ProductSilde">
            <span>Váy</span>
            <div class="SliderShow_Product">
                <div class="SlideListProduct">
                    <%
                        List<ProductResponse> imageSkirt = ProductService.getImageSlideProduc("Váy");
                        for (ProductResponse imagePath : imageSkirt) {
                    %>
                    <a href=""><img src="Image/Product/<%= imagePath.getImage() %>" alt=""></a>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    document.body.innerHTML += addFooter();

    function findProducts(category) {
        document.getElementById("categoryInput").value = category;
        document.getElementById("productSearchForm").submit();
    }

    $(document).ready(function () {
        $(".SlideListProduct img").on("click", function () {
            var imageName = $(this).data("image-name");

            $.ajax({
                type: "GET", // Hoặc "GET" tùy thuộc vào phương thức của bạn
                url: "/productImage",
                data: {imageName: imageName},
                dataType: "json",
                success: function (response) {
                    // Xử lý dữ liệu trả về từ server
                    console.log(response);
                },
                error: function (error) {
                    console.error("Error during AJAX request:", error);
                }
            });
        });
    });
    function submitForm() {
        document.getElementById('productForm').submit();
    }
</script>
</body>
</html>