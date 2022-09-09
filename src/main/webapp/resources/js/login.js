const alert_msg_content_success_login = '<strong>Logged in successfully</strong>'
const alert_msg_content_err_login = '<strong>User not found</strong>'
const alert_msg_content_err_validate_phone = '<strong>Invalid</strong> phone number format'
const alert_msg_content_err_validate_pass = '<strong>Minimum</strong> password length is <strong>8</strong>'


function autoValidate() {
    const form = document.querySelector('#mainLoginForm')
    const phoneNumber = form.phone_number.value
    const password = form.password.value

    autoValidatePhoneNumber(phoneNumber)
    autoValidatePassword(password)
}

function autoValidatePhoneNumber(phoneNumber) {
    const alert_box = document.querySelector(".alert")

    if (phoneNumber.trim() === '') {
        alert_box.style.display = 'none'
        return
    }

    const validateRes = validatePhoneNumber(phoneNumber)
    if (!validateRes) {
        const alert_msg = document.querySelector(".alert-msg")
        replaceClassToken(alert_box, "alert-success", "alert-danger")
        alert_msg.innerHTML = alert_msg_content_err_validate_phone
        alert_box.style.display = 'block'
    } else {
        alert_box.style.display = 'none'
    }
}

function validatePhoneNumber(phoneNumber) {
    return /^(\+84|0)(3|5|7|8|9|1[2|6|8|9])(\d{8})\b/.test(phoneNumber)
}

function autoValidatePassword(password) {
    const alert_box = document.querySelector(".alert")

    if (validatePassword(password)) {
        alert_box.style.display = 'none'
        return
    }

    replaceClassToken(alert_box, "alert-success", "alert-danger")
    const alert_msg = document.querySelector(".alert-msg")
    alert_msg.innerHTML = alert_msg_content_err_validate_pass
    alert_box.style.display = 'block'
}

function validatePassword(password) {
    return /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/.test(password)
}

/**
 * @param form: the form to be submitted
 * @param args: an object contains extra arguments
 * @returns {boolean} to stop onsubmit form redirecting
 */
function ajaxSubmitForm(form, args) {
    const http = new XMLHttpRequest();
    http.withCredentials = true;
    const params = 'phone_number=' + form.phone_number.value + '&password=' + form.password.value;
    http.open('POST', args.urlPrefix + "login", true);

    //Send the proper header information along with the request
    http.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    http.onreadystatechange = function() {//Call a function when the state changes.
        const alert_msg = document.querySelector('div.alert .alert-msg')
        const alert_box = document.querySelector('div.alert')

        if(http.readyState === 4 && http.status === 200) {
            //alert(http.responseText);
            replaceClassToken(alert_box, "alert-danger", "alert-success")
            alert_msg.innerHTML = alert_msg_content_success_login
            alert_box.style.display = 'block'
            // window.location.href = http.responseURL
            console.log(http.responseURL)
        } else {
            replaceClassToken(alert_box, "alert-success", "alert-danger")
            alert_msg.innerHTML = alert_msg_content_err_login
            alert_box.style.display = 'block'
        }
    }
    http.send(params);
    return false
}


/** Replacing an element's class list
 * @param element: DOM element
 * @param oldToken: class token to be replaced
 * @param newToken: new class token to replace with
 *
 * newToken will be added to the class list even if oldToken does not exist
 * if oldToken exists, it will be removed from the class list
 */
function replaceClassToken(element, oldToken, newToken) {
    element.classList.remove(oldToken)

    if (!element.classList.contains(newToken))
        element.classList.add(newToken)
}

