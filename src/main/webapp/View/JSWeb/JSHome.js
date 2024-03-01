document.addEventListener("DOMContentLoaded", function(){
    document.getElementById("Contact").addEventListener("click", function(event){
        event.preventDefault();
        window.scrollTo(0, document.getElementById("footer").offsetTop)
    });
})