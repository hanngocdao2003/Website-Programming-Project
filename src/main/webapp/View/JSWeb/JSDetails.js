document.addEventListener("DOMContentLoaded", function () {
    $(".color").click(function () {
        $(".color").removeClass("active");
        $(".color").css({"border": ""});
        $(this).css({"border": "5px solid var( --but)"});
        $(this).addClass("active");
    });

    $(".size").click(function () {
        $(".size").removeClass("active");
        $(".size").css({"border": ""});
        $(this).css({"border": "5px solid var( --but)"});
        $(this).addClass("active");
    });
    addCart();
});

function addCart() {
    $(".add-cart").click(() => {
        //bắt sự kiện người dùng chọn mẫu nào, màu gì, và san pham la j, số lương
        //ajax truyen 3 tham so tren vào body của request đẻ gui len server.
        var id = $("#product").attr("product-id");
        console.log(id);
        $(".container").attr("id")
        var color = $(".color.active").attr("value");
        console.log(color);
        var size = $(".size.active").attr("value");
        console.log(size);

        var data = {
            'id': id,
            'color': color,
            'size': size,
        };
        $.ajax({
            url: '/maven_war_exploded/addtocart',
            type: 'POST',
            data: data,
            success: function (data) {
                console.log(data.totalItems);
                document.getElementById("totalitem").innerText = data.totalItems;
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
            }
        });
    });
}
