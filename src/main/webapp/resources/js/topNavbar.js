window.onscroll = function(e) {
    var navbar = document.querySelector('.navbar.sticky-top')
    if (window.scrollY > 0) {
        // navbar.classList.remove('navbar-dark')
        navbar.classList.add('bg-blurry')
    } else {
        navbar.classList.remove('bg-blurry')
    }
}

function displayLoginForm(urlPrefix) {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.querySelector('.modal-content').innerHTML = this.responseText;
    }
    xhttp.open("GET", urlPrefix + "/login.jsp");
    xhttp.send();
}