document.addEventListener('DOMContentLoaded', function () {
    // Chọn nút "Cập nhập thông tin"
    var updateButton = document.getElementById("update");

    // Thêm sự kiện click cho nút "Cập nhập thông tin"
    updateButton.addEventListener('click', function (event) {
        // Ngăn chặn hành vi mặc định của form
        event.preventDefault();
        // Đảo ngược trạng thái
        // Chọn tất cả các thẻ input trong form có thuộc tính readonly
        var inputFullName = document.getElementById("fullName")
        var inputProvince = document.getElementById("province")
        var inputDistrict = document.getElementById("district")
        var inputWard = document.getElementById("ward")
        var inputNumHouse = document.getElementById("numHouse")
        var listUpdate = [inputFullName, inputProvince, inputDistrict, inputWard, inputNumHouse]
        if (updateButton.innerHTML === "Cập nhật thông tin") {
            updateButton.innerHTML = "Cập nhật";
            listUpdate.forEach(function (input) {
                input.readOnly = false;
            });
        } else {
            updateButton.innerHTML = "Cập nhật thông tin";
            listUpdate.forEach(function (input) {
                input.readOnly = true;
            });
        }
        // Vòng lặp qua từng thẻ input và chuyển đổi readonly thành false

    });

});