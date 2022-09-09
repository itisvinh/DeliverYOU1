<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" language="java" pageEncoding="utf-8" %>

<nav class="local-navbar navbar navbar-expand-sm navbar-light sticky-top mask-custom shadow-0">
    <div class="container">
        <a class="navbar-brand" href="#!">
            <!-- <span style="color: #5e9693;">Psycho</span>
            <span style="color: #fff;">logist</span> -->
            <img class="brand-logo" src='<c:url value="/img/brand_logo.png"/>' alt="logo" />
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#!">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#!">Team</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#!">Contact</a>
                </li>
            </ul>
            <ul class="navbar-nav d-flex flex-row">
                <li class="nav-item me-3 me-lg-0">
                    <a class="nav-link" href="#!">
                        <i class="fas fa-shopping-cart"></i>
                    </a>
                </li>
                <li class="nav-item me-3 me-lg-0">
                    <button class="btn btn-dark rounded-pill" data-bs-toggle="modal" data-bs-target="#modalCenter">Log In</button>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Navbar -->

<%--modal placeholder--%>
<div class="modal fade" id="modalCenter" tabindex="-1" aria-labelledby="exampleModalCenterTitle" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content d-flex justify-content-center align-items-center" style="background-color: transparent; border: none">
            <%--------------------------------login form-----------------------------------%>
            <form action="javascript:void(0)" method="post" id="mainLoginForm" onsubmit="return ajaxSubmitForm(this, { urlPrefix:'<c:url value="/"/>'})">
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
                        <button id="submit-btn" type="submit" class="input-icon clickable fa-solid fa-arrow-right-long"></button>
                    </div>

                    <div style="display: none; width: 100%;" class="alert alert-danger" role="alert" >
                        <i class="fa-solid fa-circle-info"></i>
                        <span class="alert-msg">message</span>
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
            <%--------------------------------end of login form-----------------------------------%>
        </div>
    </div>
</div>
<%--end of modal placeholder--%>

<script async src="<c:url value="/js/login.js"/>"></script>
<script async src="<c:url value="/js/topNavbar.js"/>"></script>
