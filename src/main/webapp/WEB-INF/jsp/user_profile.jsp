<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <!-- Favicons -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="<c:url value="/css/login.css"/>">
</head>
<body class="bg-transparent w-100 vh-100 d-flex" style="align-items: center; justify-content: center">

<div class="container-blurry-glass pb-4 rounded m-auto">

    <div class="w-100 tab-container" style="min-height: 14rem !important;">
        <div class="tab">

            <div class="avatar-container">
                <img id="main-avatar-img" class="avatar-img img-thumbnail rounded-circle"
                     src="${user.avatar}" data-previous-value="${user.avatar}"/>
                <i class="bi bi-pencil-fill rounded-circle d-flex"
                   onclick="document.querySelector('#avatar-selector').click()" style="width: 2rem; height: 2rem; background-color: rgb(137, 137, 137);
                          justify-content: center; align-items: center; position: absolute;
                          transform: translate(2rem, 2rem); border: 1px solid rgba(96, 96, 96, 0.862);
                          cursor: pointer;">
                </i>
                <input id="avatar-selector" class="d-none" type="file" onchange="avatarSelectorChanged()">

            </div>

            <div id="first-name" class="input-group mt-3">
                <input class="input-content" type="text" name="phone_number" value="${user.firstname}" required data-previous-value="${user.firstname}"/>
                <label class="input-label">First name</label>
                <i class="input-icon bi bi-person-circle"></i>
            </div>

            <div id="last-name" class="input-group mt-2">
                <input class="input-content" type="text" name="phone_number" value="${user.lastname}" required data-previous-value="${user.lastname}"/>
                <label class="input-label">Last name</label>
                <i class="input-icon bi bi-person-circle"></i>
            </div>

            <div id="email" class="input-group mt-2">
                <input class="input-content" type="text" name="phone_number" value="${user.email}" required data-previous-value="${user.email}"/>
                <label class="input-label">Email</label>
                <i class="input-icon bi bi-envelope-fill"></i>
            </div>

        </div>

        <div class="tab d-block">
            <div id="phone-number" class="input-group mt-2">
                <input class="input-content" type="password" name="password" value="${user.phoneNumber}" required data-previous-value="${user.phoneNumber}"/>
                <label class="input-label">Phone number</label>
                <i class="input-icon bi bi-telephone-fill"></i>
            </div>

            <div id="password" class="d-none input-group mt-2">
                <input class="input-content" type="password" name="password" required />
                <label class="input-label">Password</label>
                <i class="input-icon bi bi-key-fill"></i>
            </div>

            <div id="confirm-password" class="d-none input-group mt-2">
                <input class="input-content" type="password" name="password" required />
                <label class="input-label">Confirm password</label>
                <i class="input-icon bi bi-check-circle-fill"></i>
            </div>

        </div>

    </div>

    <button class="btn btn-primary rounded-pill mt-3" onclick="updateProfile()">Update information</button>

</div>
<div id="current-phone-number" data-phone-number="${current_phone_number}"></div>
<div id="endpoint" data-endpoint="<c:url value="/"/>"></div>

<script src='<c:url value="/js/util.js"/>'></script>
<script src='<c:url value="/js/toast.js"/>'></script>
<script>
    let CURRENT_PHONE_NUMBER;
    let ENDPOINT;
    let AVATAR;
    let FIRST_NAME;
    let LAST_NAME;
    let EMAIL;
    let PHONE;
    let PASSWORD;
    let CONFIRM_PASSWORD;

    function reloadSelectedElement() {
        CURRENT_PHONE_NUMBER = document.querySelector('#current-phone-number').dataset.phoneNumber
        ENDPOINT = document.querySelector('#endpoint').dataset.endpoint
        AVATAR = document.querySelector('#main-avatar-img')
        FIRST_NAME = document.querySelector('#first-name')
        LAST_NAME = document.querySelector('#last-name')
        EMAIL = document.querySelector('#email')
        PHONE = document.querySelector('#phone-number')
        PASSWORD = document.querySelector('#password')
        CONFIRM_PASSWORD = document.querySelector('#confirm-password')
    }

    function changeDetected(element) {
        const val = element.value.replace(/\s+/gm, ' ').trim()
        if (element.dataset.previousValue.replace(/\s+/gm, ' ').trim() !== val) {
            return val
        }
        return undefined
    }

    function buildUploadObject() {
        const body = {}

        // const avatar
        const fn = changeDetected(FIRST_NAME.querySelector('input'))
        const ln = changeDetected(LAST_NAME.querySelector('input'))
        const em = changeDetected(EMAIL.querySelector('input'))
        const phone = changeDetected(PHONE.querySelector('input'))

        if (fn) body.firstname = fn
        if (ln) body.lastname = ln
        if (em) body.email = em
        if (phone) body.phoneNumber = phone

        return (Object.keys(body).length > 0) ? body : undefined
    }

    function persistChanges(body) {

        if (body.firstname) FIRST_NAME.querySelector('input').dataset.previousValue = body.firstname
        if (body.lastname) LAST_NAME.querySelector('input').dataset.previousValue = body.lastname
        if (body.email) EMAIL.querySelector('input').dataset.previousValue = body.email
        if (body.phoneNumber) PHONE.querySelector('input').dataset.previousValue = body.phoneNumber
    }

    function updateProfile() {
        reloadSelectedElement()
        const body = buildUploadObject()

        if (body) {
            Fetch.build().method(Fetch.METHOD_POST).body(body).fetch(ENDPOINT + 'common/api/update-user')
                .then(response => {
                    if (response.status === 200) {
                        BSToast.show(document, "Your profile has been updated", BSToast.BACKGROUND_BLUE)
                        persistChanges(body)
                    }
                    else
                        BSToast.show(document, "Failed to update profile", BSToast.BACKGROUND_RED)
                })
                .catch(error => {
                    console.error(error)
                    BSToast.show(document, "Error has occurred", BSToast.BACKGROUND_RED)
                })
        } else {
            BSToast.show(document, "No changes are detected", BSToast.BACKGROUND_YELLOW)
        }
    }

    // function loadProfile() {
    //     Fetch.build().method(Fetch.METHOD_POST)
    //         .fetchBodySingleResult(ENDPOINT + 'public/api/get-user-info/' + CURRENT_PHONE_NUMBER)
    //         .then(user => {
    //             console.log(user)
    //             AVATAR.src = user.avatar
    //             FIRST_NAME.querySelector('input').value = user.firstname
    //             LAST_NAME.querySelector('input').value = user.lastname
    //             EMAIL.querySelector('input').value = user.email
    //             PHONE.querySelector('input').value = user.phoneNumber
    //             BSToast.show(document, "Showing your profile")
    //         })
    //         .catch(error => {
    //             console.error(error)
    //             BSToast.show(document, "Error occurred when loading user's profile")
    //         })
    // }



</script>

</body>
</html>
