<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html" language="java" pageEncoding="utf-8" %>

<nav class="local-navbar navbar navbar-expand-sm navbar-light sticky-top mask-custom shadow-0">
    <div class="container">
        <a class="navbar-brand" href="#!">
            <!-- <span style="color: #5e9693;">Psycho</span>
            <span style="color: #fff;">logist</span> -->
            <img class="brand-logo" src='<c:url value="/img/brand_name.svg"/>' alt="logo"/>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#!">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#!">Our Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#!">Contact</a>
                </li>
            </ul>
            <ul class="navbar-nav d-flex flex-row">
<%--                <li class="nav-item me-3 me-lg-0">--%>
<%--                    <a class="nav-link" href="#!">--%>
<%--                        <i class="fas fa-shopping-cart"></i>--%>
<%--                    </a>--%>
<%--                </li>--%>
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item me-3 me-lg-0">
                        <button class="btn btn-dark rounded-pill" data-bs-toggle="modal" data-bs-target="#modalCenter">Log
                            In
                        </button>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated() && (hasRole('ROLE_USER') || hasRole('ROLE_SHIPPER'))">
                    <li class="nav-item me-3 me-lg-0">
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <a class="btn btn-dark rounded-pill" href="<c:url value="/user/app"/>">Continue</a>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_SHIPPER')">
                            <a class="btn btn-dark rounded-pill" href="<c:url value="/shipper/app"/>">Continue</a>
                        </sec:authorize>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>

<!-- ********************************* -->
<style>
    @import url('https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css');
</style>

<div class="modal fade" id="modalCenter" tabindex="-1" aria-labelledby="exampleModalCenterTitle"
     style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content d-flex justify-content-center align-items-center"
             style="background-color: transparent; border: none">
            <form action="javascript:void(0)" method="post" id="mainLoginForm"
                  onsubmit="return ajaxSubmitForm(this, { urlPrefix:'<c:url value="/"/>'})">
                <div class="container-blurry-glass m-3 rounded">
                    <div class="avatar-container">
                        <img class="avatar-img img-thumbnail rounded-circle"
                             src="https://mdbootstrap.com/img/Photos/Avatars/img%20(30).jpg"/>
                    </div>
                    <div class="login-header">Welcome</div>

                    <div class="input-group">
                        <input class="input-content" type="text" name="phone_number" required/>
                        <label class="input-label">Phone number</label>
                        <i class="input-icon fa-solid fa-phone-flip"></i>
                    </div>

                    <div class="input-group">
                        <input class="input-content" type="password" name="password" required/>
                        <label class="input-label">Password</label>
                        <button id="submit-btn" type="submit"
                                class="input-icon clickable fa-solid fa-arrow-right-long"></button>
                    </div>

                    <div style="display: none; width: 100%;" class="alert alert-danger" role="alert">
                        <i class="fa-solid fa-circle-info"></i>
                        <span class="alert-msg">message</span>
                    </div>

                    <div class="checkbox-group">
                        <input class="input-checkbox form-check-input" type="checkbox" id="check1" name="remember_me"
                               value="remember" checked>
                        <span>Remember me</span>
                    </div>

                    <a href="#" class="reset-passwd-lbl">Forgot password?</a>
                </div>

                <div class="container-blurry-glass no-children m-3 rounded text-center">
                    <span>Don't have an account?
                        <button type="button" data-bs-target="#signUpModal" data-bs-toggle="modal"
                                class="fw-semibold text-info btn">
                            Sign Up
                        </button>
                    </span>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- ********************************* -->

<div class="modal fade" id="signUpModal" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content" style="background-color: transparent; border: none">

            <div class="container-blurry-glass m-3 pb-4 rounded">
                <form>
                    <div class="w-100 tab-container" style="min-height: 14rem !important;">
                        <div class="tab">

                            <div class="avatar-container">
                                <img id="main-avatar-img" class="avatar-img img-thumbnail rounded-circle"
                                     src="https://mdbootstrap.com/img/Photos/Avatars/img%20(30).jpg"/>
                                <i class="bi bi-pencil-fill rounded-circle d-flex"
                                   onclick="document.querySelector('#avatar-selector').click()" style="width: 2rem; height: 2rem; background-color: rgb(137, 137, 137);
                          justify-content: center; align-items: center; position: absolute;
                          transform: translate(2rem, 2rem); border: 1px solid rgba(96, 96, 96, 0.862);
                          cursor: pointer;">
                                </i>
                                <input id="avatar-selector" class="d-none" type="file"
                                       onchange="avatarSelectorChanged()">

                            </div>

                            <div id="first-name" class="input-group mt-3">
                                <input class="input-content" type="text" name="phone_number" required/>
                                <label class="input-label">First name</label>
                                <i class="input-icon bi bi-person-circle"></i>
                            </div>

                            <div id="last-name" class="input-group mt-2">
                                <input class="input-content" type="text" name="phone_number" required/>
                                <label class="input-label">Last name</label>
                                <i class="input-icon bi bi-person-circle"></i>
                            </div>

                            <div id="email" class="input-group mt-2">
                                <input class="input-content" type="text" name="phone_number" required/>
                                <label class="input-label">Email</label>
                                <i class="input-icon bi bi-envelope-fill"></i>
                            </div>

                        </div>

                        <div class="tab d-none">
                            <div id="phone-number" class="input-group mt-2">
                                <input class="input-content" type="password" name="password" required/>
                                <label class="input-label">Phone number</label>
                                <i class="input-icon bi bi-telephone-fill"></i>
                            </div>

                            <div id="password" class="input-group mt-2">
                                <input class="input-content" type="password" name="password" required/>
                                <label class="input-label">Password</label>
                                <i class="input-icon bi bi-key-fill"></i>
                            </div>

                            <div id="confirm-password" class="input-group mt-2">
                                <input class="input-content" type="password" name="password" required/>
                                <label class="input-label">Confirm password</label>
                                <i class="input-icon bi bi-check-circle-fill"></i>
                            </div>

                        </div>

                    </div>

                    <div class="step-nav-container mt-2">
                        <i id="previous-tab" onclick="prevTab()" class="step-nav bi bi-caret-left d-none"></i>
                        <i id="next-tab" onclick="nextTab()" class="step-nav bi-caret-right"></i>
                        <button type="button" id="sign-up" onclick="signUp()" class="step-nav px-3 fw-semibold d-none"
                                style="width: auto; font-size: .95rem;">SIGN UP
                        </button>
                    </div>
                </form>
            </div>

            <div class="container-blurry-glass no-children mx-3 rounded text-center">
          <span>Already have an account? <button type="button" data-bs-target="#modalCenter" data-bs-toggle="modal"
                                                 class="fw-semibold text-info btn">Sign In</button></span>
            </div>

        </div>
    </div>
</div>

<div id="endpoint" data-endpoint="<c:url value="/"/>"></div>


<!-- ********************************* -->
<script src="<c:url value="/js/validator.js"/>"></script>
<script defer>
    const ENDPOINT = document.querySelector('#endpoint').dataset.endpoint
    const prev_tab = document.querySelector('#previous-tab')
    const next_tab = document.querySelector('#next-tab')
    const sign_up = document.querySelector('#sign-up')
    const tab_container = document.querySelector('.tab-container')
    const container_size = tab_container.children.length
    let current_tab = 0

    //23434234324
    const fname = document.querySelector('#first-name')
    const lname = document.querySelector('#last-name')
    const email = document.querySelector('#email')
    const phone = document.querySelector('#phone-number')
    const password = document.querySelector('#password')
    const cpassword = document.querySelector('#confirm-password')

    const validator = new Validator();

    validator
        .add(fname, () => {
            const input = fname.querySelector('input')
            const val = input.value.replace(/\s+/gm, ' ').trim()
            const result = val.match(/^[a-zA-Z|\s]+$/)
            return (result) ? true : false
        }, 'Invalid field', '', '.7rem')
        .add(lname, () => {
            const input = lname.querySelector('input')
            const val = input.value.replace(/\s+/gm, ' ').trim()
            const result = val.match(/^[a-zA-Z|\s]+$/)
            return (result) ? true : false
        }, 'Invalid field', '', '.7rem')
        .add(email, () => {
            const input = email.querySelector('input')
            const val = input.value.replace(/\s+/gm, ' ').trim()
            const mail_reg = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            const result = val.match(mail_reg)
            return (result) ? true : false
        }, 'Invalid email address', '', '.7rem')
        .add(phone, () => {
            const input = phone.querySelector('input')
            const val = input.value.replace(/\s+/gm, ' ').trim()
            const phone_reg = /([\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})\b/
            const result = val.match(phone_reg)
            return (result) ? true : false
        }, 'Only support Vietnamese number', '', '.7rem')
        .add(password, () => {
            const input = password.querySelector('input')
            // const val = input.value.replace(/\s+/gm, ' ').trim()
            const pass_reg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/
            const result = input.value.match(pass_reg)
            return (result) ? true : false
        }, 'Password length must be at least 8,\n contains lowercases & uppercases & digits', '', '.7rem')
        .add(cpassword, () => {
            const cp_input = cpassword.querySelector('input')
            const p_input = password.querySelector('input')
            // const val = input.value.replace(/\s+/gm, ' ').trim()
            return cp_input.value === p_input.value
        }, 'Unmatched password', '', '.7rem')

    function validate() {
        validator.validate()
    }

    //32423423432

    function avatarSelectorChanged() {
        const file = document.querySelector('#avatar-selector').files[0]
        const reader = new FileReader()
        reader.readAsDataURL(file)
        reader.onload = evt => {
            document.querySelector('#main-avatar-img').src = evt.target.result
        }
    }

    function nextTab() {
        if (current_tab + 1 === container_size - 1) {
            sign_up.classList.toggle('d-none')
            next_tab.classList.toggle('d-none')
        }

        if (prev_tab.classList.contains('d-none')) {
            prev_tab.classList.remove('d-none')
        }

        tab_container.children[current_tab++].classList.toggle('d-none')
        tab_container.children[current_tab].classList.toggle('d-none')
    }

    function prevTab() {
        if (current_tab - 1 === 0) {
            prev_tab.classList.toggle('d-none')
        }

        if (!sign_up.classList.contains('d-none')) {
            sign_up.classList.add('d-none')
        }

        if (next_tab.classList.contains('d-none')) {
            next_tab.classList.remove('d-none')
        }

        tab_container.children[current_tab--].classList.toggle('d-none')
        tab_container.children[current_tab].classList.toggle('d-none')
    }

    function signUp() {
        const files = document.querySelector('#avatar-selector').files
        let file = null // ****

        if (files && files.length > 0) {
            const reader = new FileReader()
            reader.onloadend = () => {
                file = reader.result.replace('data:', '').replace(/^.+,/, ''); // return a base64 string of the file

                const firstname = fname.querySelector('input').value.replace(/\s+/gm, ' ').trim() // ****
                const lastname = lname.querySelector('input').value.replace(/\s+/gm, ' ').trim() // ****
                const i_email = email.querySelector('input').value.replace(/\s+/gm, ' ').trim() // ****
                const phoneNumber = phone.querySelector('input').value.replace(/\s+/gm, ' ').trim() // ****
                const i_password = password.querySelector('input').value // ****
                const confirm_password = cpassword.querySelector('input').value // ****

                const upload_obj = {
                    firstname,
                    lastname,
                    email: i_email,
                    phoneNumber,
                    password: i_password,
                    avatar: file
                }

                callSignUpAPI(upload_obj)
                    .then(status => {
                        if (status) {
                            performLogin(phoneNumber, i_password)
                        } else {
                            alert("Failed to sign up")
                        }
                    })
                    .catch(error => console.error(error))
            }
            reader.readAsDataURL(files[0])
        } else {
            alert("Profile picture is required")
            console.error("[ERROR] No avatar found")
            prevTab()
            return
        }
    }

    async function callSignUpAPI(upload_obj) {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        const raw = JSON.stringify(upload_obj)

        const requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'manual'
        };

        return fetch(ENDPOINT + "public/api/sign-up", requestOptions)
            .then(response => {
                if (response.status === 200)
                    return true
                return false
            })
    }

    function performLogin(phone, password) {
        // WARNING: For POST requests, body is set to null by browsers.
        const data = "phone_number=" + phone + "&password=" + password;

        const xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this)
                if (this.status === 200) {
                    alert("Login successfully")
                    window.location.href = this.responseURL
                } else {
                    alert("Signed up successfully but failed to sign in")
                }
            }
        });

        xhr.open("POST", ENDPOINT + "login");
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xhr.send(data);
    }
</script>

<%--end of sign up modal--%>
<script async src="<c:url value="/js/login.js"/>"></script>
<script async src="<c:url value="/js/topNavbar.js"/>"></script>
