document.addEventListener('DOMContentLoaded', function () {
    $(".SlideList").slick({
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2000,
      slidesToShow: 1,
      slidesToScroll: 1,
      speed: 2000,
      autoplay: true,
      arrows: true,
      prevArrow: $(".carosel-nav-left"),
      nextArrow: $(".carosel-nav-right")
    });
  });
  
  document.addEventListener('DOMContentLoaded', function () {
    $(".SlideListProduct").slick({
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2000,
      slidesToShow: 4,
      slidesToScroll: 1,
      speed: 2000,
      autoplay: true,
      arrows: true,
      prevArrow: $(".carosel-nav-left"),
      nextArrow: $(".carosel-nav-right")
    });
  });