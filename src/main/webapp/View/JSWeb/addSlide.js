function readURL(input) {
    if (input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = function(e) {
        var uploadWrap = $(input).closest('.file-upload');
        var fileUploadImage = uploadWrap.find('.file-upload-image');
        var fileUploadContent = uploadWrap.find('.file-upload-content');
        var imageTitle = fileUploadContent.find('.image-title');
  
        // Thay đổi từ siblings sang find để đảm bảo tìm đúng phần tử
        uploadWrap.find('.image-upload-wrap').hide();
        fileUploadImage.attr('src', e.target.result);
        fileUploadContent.show();
        imageTitle.html(input.files[0].name);
      };
  
      reader.readAsDataURL(input.files[0]);
    } else {
      removeUpload(input);
    }
  }


function removeUpload(input, sendChangeEvent = true) {
  var uploadWrap = $(input).closest('.file-upload');
  var fileUploadContent = uploadWrap.find('.file-upload-content');
  var uploadWrapImage = uploadWrap.find('.image-upload-wrap');
  var fileInput = uploadWrap.find('.file-upload-input');

  // Ẩn phần hiển thị ảnh và reset giá trị của input
  fileUploadContent.hide();
  uploadWrapImage.show();

  // Reset giá trị của input và kiểm tra có cần gửi sự kiện change hay không
  var originalValue = fileInput.val();
  fileInput.val('');
  if (sendChangeEvent && originalValue !== '') {
    fileInput.trigger('change');  // Gửi sự kiện change để kích thích xử lý đọc URL
  }
}




$('.image-upload-wrap').on('dragover', function() {
    $(this).addClass('image-dropping');
  });

  $('.image-upload-wrap').on('dragleave', function() {
    $(this).removeClass('image-dropping');
  });
