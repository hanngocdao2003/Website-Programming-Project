function addFooter() {
  return `<footer id = "footer">
    <div class="contain">
      <div class="content">
        <div class="store">
          <img src="Image/logo/BHD-nền%20trong%20suốt.svg" alt="">
          <h1>BHD BOUTIQUE</h1>
        </div>
        <p class="text">Chúng tôi luôn trân trọng và mong đợi
          nhận được mọi ý kiến đóng góp từ khách
          hàng để có thể nâng cấp trải nghiệm dịch
          vụ và sản phẩm tốt hơn nữa. </p>
<!--        <a href="comment.html"><button class="idea-btn">Đóng góp ý kiến</button></a>-->
      </div>
      <div class="list-policy">
        <p class="policy-lb">Chính sách</p>
        <ul>
          <li><a href="policy-7days.html">Chính sách đổi trả 7 ngày</a></li>
          <li><a href="policy-sale.html">Chính sách khuyến mãi</a></li>
          <li><a href="policy-ship.html">Chính sách giao hàng</a></li>
        </ul>
        <div class="media">
          <a href="https://www.facebook.com/Binh.PHHT/" target="_blank"><img src="Image/link_Image/fb.png"
              alt="fb-icon"></a>
          <a href="https://www.instagram.com/peace_bi.ht/" target="_blank"><img src="Image/link_Image/instagram.png"
              alt="instagram-icon"></a>
        </div>
      </div>
      
      <div class="support">
        <div class="hotline">
          <h5><i class="fa-sharp fa-solid fa-phone-volume"
              style="color: #000000; max-width: 10px; margin-right: 10px;"></i>Hotline</h5>
          <p>0908586584 - 0896435451
            <br>(8:30 - 22:00)
          </p>
        </div>
        <div class="address">
          <h5><i class="fas fa-map-marker-alt" style="color: #000000; max-width: 10px; margin-right: 7px;"></i>Địa chỉ
          </h5>
          <p>Khu phố 6, phường Linh Trung
            <br>Thành phố Thủ Đức, Thành phố Hồ Chí Minh
          </p>
        </div>
        <div class="mail">
          <h5><i class="fas fa-envelope" style="color: #000000; max-width: 10px; margin-right: 11px;"></i>Email</h5>
          <p>bhdstore2023@gmail.com</p>
        </div>
      </div>
      <div class="image">
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.2145945643592!2d106.7917617!3d10.8712764!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBOw7RuZyBMw6JtIFRQLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1700918573471!5m2!1svi!2s" width="300" height="200" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
      </div>
    </div>
  </footer>`
}
document.addEventListener('DOMContentLoaded', function () {
  var btn_Category_searchList = document.getElementsByClassName("btn_Category_search");
  var menu_CategoryList = document.getElementsByClassName("menu_Category");

  for (var i = 0; i < btn_Category_searchList.length; i++) {
    (function (index) {
      btn_Category_searchList[index].addEventListener("click", function () {
        // Kiểm tra trạng thái hiện tại của menu_Category
        if (menu_CategoryList[index].style.display === "none" || menu_CategoryList[index].style.display === "") {
          // Nếu đang ẩn, hiển thị
          menu_CategoryList[index].style.display = "block";
        } else {
          // Nếu đang hiển thị, ẩn
          menu_CategoryList[index].style.display = "none";
        }
      });
    })(i);
  }
});








