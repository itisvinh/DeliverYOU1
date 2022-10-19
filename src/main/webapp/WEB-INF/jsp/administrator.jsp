<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>DELIVERYOU - Administrator</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>

<body class="bg-dark">
<style>
    :root {
        --clr-text-primary: white;
        --clr-text-secondary: rgba(255, 255, 255, 0.695);
        --clr-box-shadow: rgba(0, 0, 0, 0.2);
        --clr-background: rgba(255, 255, 255, 0.3);
        --clr-input-label: rgb(171, 171, 171);
        --input-focus-clr: rgb(218, 20, 218);
        --clr-input-icon: rgb(117, 117, 117);
        --font-size-normal: clamp(0.8rem, 5vw, 1rem);
        --font-size-floating: clamp(0.7rem, 3vw, 0.8rem);
    }

    body.modal-open> :is(#b-body, #b-footer, .local-navbar) {
        -webkit-filter: blur(1rem);
        -moz-filter: blur(1rem);
        -o-filter: blur(1rem);
        -ms-filter: blur(1rem);
        filter: blur(1rem);
        /*filter: url("https://gist.githubusercontent.com/amitabhaghosh197/b7865b409e835b5a43b5/raw/1a255b551091924971e7dee8935fd38a7fdf7311/blur".svg#blur);*/
        filter: progid:DXImageTransform.Microsoft.Blur(PixelRadius='16');
    }

    .container-blurry-glass {
        background: var(--clr-background) !important;
        backdrop-filter: blur(3rem);
        box-shadow: 0rem 0rem 0.6rem 0rem var(--clr-box-shadow);
        padding: clamp(1rem, 8vw, 3rem);
        display: flex;
        flex-direction: column;
        gap: 0.5rem;
        max-width: 27rem;
        outline: 1px solid rgba(204, 204, 204, 0.741);
        color: var(--clr-text-primary);
        word-wrap: break-word;
    }

    .container-blurry-glass.no-children {
        padding: 1rem clamp(1rem, 8vw, 3rem);
    }

    .input-group {
        position: relative;
        display: inline-block;
    }

    .input-group .input-content {
        width: 100%;
        border-radius: 0.5rem !important;
        padding: 1.2rem 0.8rem 0.4rem 0.8rem;
        outline: 1px solid var(--clr-box-shadow);
        border: none;
        border-collapse: separate;
    }

    .input-group .input-label {
        position: absolute;
        color: var(--clr-input-label);
        font-size: var(--font-size-normal);
        pointer-events: none;
        left: 0.8rem;
        top: 50%;
        transform: translate(0, -50%);
        transition: 0.2s ease all;
    }

    .checkbox-group {
        display: flex;
        justify-content: center;
        gap: 0.5rem;
        margin-top: 0.5rem;
    }

    .checkbox-group .input-checkbox {
        background-color: var(--input-focus-clr) !important;
    }

    .checkbox-group .input-checkbox:not(:checked) {
        background-color: var(--clr-text-primary) !important;
    }

    .input-group .input-icon {
        width: 1.8rem;
        height: 1.8rem;
        position: absolute;
        color: var(--clr-input-icon);
        top: 50%;
        transform: translate(0, -50%);
        right: 5%;
        border: 1px solid var(--clr-input-icon);
        border-radius: 50% !important;
        padding: 3px;
        pointer-events: none;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .input-icon.clickable {
        pointer-events: all;
        cursor: pointer;
    }

    .input-icon.unclickable {
        pointer-events: none;
    }

    .input-icon.clickable:hover {
        color: white;
        border-color: var(--input-focus-clr);
        background-color: var(--input-focus-clr);
        box-shadow: 0rem 0rem 1rem 0.1rem rgba(255, 16, 39, 0.5);
    }

    .input-content:focus {
        outline: 2px solid var(--input-focus-clr);
    }

    .input-content:focus~.input-label,
    .input-content:not(:focus):valid~.input-label {
        top: 0.9rem;
        bottom: 10px;
        left: 0.8rem;
        font-size: var(--font-size-floating);
        opacity: 1;
    }

    .avatar-container {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .avatar-container .avatar-img {
        width: clamp(3rem, 30vw, 6rem);
        height: clamp(3rem, 30vw, 6rem);
        box-shadow: 0rem 0rem 1rem 0.1rem var(--clr-box-shadow);
    }

    .login-header {
        font-weight: bold;
        font-size: clamp(1.2rem, 5vw, 1.5rem);
        text-align: center;
    }

    .reset-passwd-lbl {
        text-align: center;
        font-size: 0.85rem;
        pointer-events: all;
        color: var(--clr-text-secondary);
        cursor: pointer;
    }

    .reset-passwd-lbl:hover {
        color: var(--clr-text-primary);
    }

    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    /* Firefox */
    input[type="number"] {
        -moz-appearance: textfield;
    }

    .step-nav-container {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        gap: 1rem;
    }

    .step-nav-container .step-nav {
        background-color: white;
        color: black;
        border: 1px solid var(--clr-input-label);
        width: 2rem;
        height: 2rem;
        font-size: 1.2rem;
        border-radius: 1rem;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
    }

    .step-nav-container .step-nav:hover {
        background-color: var(--input-focus-clr);
        color: white;
        border: 1px solid var(--input-focus-clr);
    }

    .tab-container {
        display: flex;
        flex-direction: column;
        gap: 1rem;
    }

    .tab-container .tab {
        transition: all 0.8s ease;
    }
</style>

<div class="w-100 p-2 d-flex justify-content-center bg-secondary">
    <img src="/img/brand_name.svg" style="width: 8rem;">
</div>

<div class="modal fade show d-block" id="modalCenter" tabindex="-1" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content d-flex justify-content-center align-items-center"
             style="background-color: transparent; border: none">
            <form action="javascript:void(0)" method="post" id="mainLoginForm" onsubmit="return ajaxSubmitForm(this, { urlPrefix:'<c:url value="/admin"/>'})">
                <div class="container-blurry-glass m-3 rounded">
                    <div class="avatar-container">
                        <img class="avatar-img img-thumbnail rounded-circle"
                             src="https://mdbootstrap.com/img/Photos/Avatars/img%20(30).jpg" />
                    </div>
                    <div class="login-header">Welcome Administrator</div>

                    <div class="input-group">
                        <input class="input-content" type="text" name="phone_number" required />
                        <label class="input-label">Phone number</label>
                        <i class="input-icon fa-solid fa-phone-flip"></i>
                    </div>

                    <div class="input-group">
                        <input class="input-content" type="password" name="password" required />
                        <label class="input-label">Password</label>
                        <button id="submit-btn" type="submit"
                                class="input-icon clickable fa-solid fa-arrow-right-long"></button>
                    </div>

                    <div style="display: none; width: 100%;" class="alert alert-danger" role="alert">
                        <i class="fa-solid fa-circle-info"></i>
                        <span class="alert-msg">message</span>
                    </div>

                    <a href="#" class="reset-passwd-lbl">Forgot password?</a>
                </div>

            </form>
        </div>
    </div>
</div>

<script defer src="<c:url value="/js/admin_login.js"/>"></script>

</body>

</html>
