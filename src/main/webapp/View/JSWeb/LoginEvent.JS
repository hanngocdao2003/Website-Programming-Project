document.addEventListener("DOMContentLoaded", function(){
    document.getElementById("createAcc").addEventListener("click", function(event) {
        event.preventDefault(); // Ngăn chuyển sổ kiến mạc định của trình duyệt

        const intro = document.querySelector(".intro");

        // Kiểm tra xem right hiện tại lẽ 0% hay 100%
        if (intro.style.right === "100%") {
            intro.style.right = "0"; // Di chuyển từ phải sang trái
        }
        else {
            intro.style.right = "50%"; // Di chuyển từ trái sang phải
        }
    });

    document.querySelector(".undo").addEventListener("click", function(event) {
        event.preventDefault();
        console.log("run");

        const intro = document.querySelector(".intro");

        if (intro.style.right !== "0%") {
            intro.style.right = "0%";
        }
    });
    var innerhiddenSignIn = document.querySelector('#hidden-appear-SinIn-pass');
    var innerhiddenSignUpPass = document.querySelector('#hidden-appear-SingUp-pass');
    var innerhiddenSignUpRePass = document.querySelector('#hidden-appear-SingUp-Repass');
    const appear = '<i class="fa-regular fa-eye" id="eye"></i>'
    const hide = '<i class="fa-solid fa-eye-slash" id="hide"></i>';
    var isOpen = true
    var inputPass = document.querySelector('#inputPass');
    var inputRectPass = document.querySelector('#inputPassRect');
    var reinputPass = document.querySelector('#ReinputPass');
    var Password = [inputPass, inputRectPass, reinputPass]
    function onPass(){
        for (var i = 0; i < Password.length; i++) {
            if( Password[i].type === 'password'){
                Password[i].type = 'text';
            }
        }
    }


    function offPass() {
        for (var i = 0; i < Password.length; i++) {
            if( Password[i].type === 'text'){
                Password[i].type = 'password';
            }
        }
    }
    innerhiddenSignIn.addEventListener("click", function(){
        if(isOpen == true){
            innerhiddenSignIn.innerHTML = hide
            isOpen = false;
            onPass()
        }else{
            innerhiddenSignIn.innerHTML = appear
            isOpen = true;
            offPass()
        }
    })
    innerhiddenSignUpPass.addEventListener("click", function(){
        if(isOpen == true){
            innerhiddenSignUpPass.innerHTML = hide
            isOpen = false;
            onPass()
        }else{
            innerhiddenSignUpPass.innerHTML = appear
            isOpen = true;
            offPass()
        }
    })
    innerhiddenSignUpRePass.addEventListener("click", function(){
        if(isOpen == true){
            innerhiddenSignUpRePass.innerHTML = hide
            isOpen = false;
            onPass()
        }else{
            innerhiddenSignUpRePass.innerHTML = appear
            isOpen = true;
            offPass()
        }
    });

    console.log("first")
});
