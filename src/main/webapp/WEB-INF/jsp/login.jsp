<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/css/login.css"/>" />
    <!-- CSS boostrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <!-- font-awesome -->
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <!-- JavaScript Bundle with Popper -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <script async src="<c:url value="/js/login.js"/>"></script>
</head>
<body>
<form action="">
    <div class="container-blurry-glass m-3 rounded">
        <div class="avatar-container">
            <img class="avatar-img img-thumbnail rounded-circle" src="https://mdbootstrap.com/img/Photos/Avatars/img%20(30).jpg"/>
        </div>
        <div class="login-header">Welcome</div>

        <div class="input-group">
            <input class="input-content" type="text" name="phone_number" onkeyup="autoValidatePhoneNumber(this.value)" required/>
            <label class="input-label">Phone number</label>
            <i class="input-icon fa-solid fa-phone-flip"></i>
        </div>

        <div class="input-group">
            <input class="input-content" type="password" name="password" required/>
            <label class="input-label">Password</label>
            <i class="input-icon clickable fa-solid fa-arrow-right-long"></i>
        </div>

        <div style="display: none" class="alert alert-danger alert-dismissible fade show" role="alert" >
            <i class="fa-solid fa-circle-info"></i>
            <span class="alert-msg">message</span>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <div class="checkbox-group">
            <input class="input-checkbox form-check-input" type="checkbox" id="check1" name="remember_me" value="remember" checked>
            <span>Remember me</span>
        </div>

        <a href="#" class="reset-passwd-lbl">Forgot password?</a>
    </div>

    <div class="container-blurry-glass no-children m-3 rounded text-center">
        <span>Don't have an account? <a href="#" class="text-info text-decoration-none">Sign up</a></span>
    </div>
</form>

</body>
</html>


