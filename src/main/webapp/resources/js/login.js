function autoValidatePhoneNumber(phoneNumber) {
    const alert_box = document.querySelector(".alert")

    if (phoneNumber.trim() === '') {
        alert_box.style.display = 'none'
        return
    }

    const validateRes = validatePhoneNumber(phoneNumber)
    if (!validateRes) {
        const alert_msg = document.querySelector(".alert-msg")
        alert_msg.innerHTML = '<strong>Invalid</strong> phone number format'
        alert_box.style.display = 'block'
    } else {
        alert_box.style.display = 'none'
    }
}

function validatePhoneNumber(phoneNumber) {
    return /^(\+84|0)(3|5|7|8|9|1[2|6|8|9])(\d{8})\b/.test(phoneNumber)
}

function validatePassword(password) {
    return /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/.test(password)
}

