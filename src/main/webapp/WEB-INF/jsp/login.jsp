<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



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




