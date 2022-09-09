<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">            <!-- Favicons -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-transparent w-100 vh-100">

<main class="bg-white w-100 h-100 p-2 rounded-3 d-flex flex-column" style="align-items: center; justify-content: center;">
    <img class="img-thumbnail rounded-circle mx-auto mb-5 shadow" style="width: 10rem; height: 10rem;" src="data:image/jpeg;base64,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">
    <div class="input-group mb-3">
        <span class="input-group-text">First name</span>
        <input id="fname" type="text" class="form-control" placeholder="">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Last name</span>
        <input id="lname" type="text" class="form-control" placeholder="">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Email<span style="color: transparent;">dndn</span></span>
        <input id="mail" type="text" class="form-control" placeholder="">
    </div>
    <button class="btn btn-info text-white rounded-pill" onclick="updateProfile(this, '<c:url value="/user/api/update-user"/>')">Update profile</button>

</main>
<style>
    .input-group {
        max-width: 30rem;
    }
</style>
<script>
    function updateProfile(button, endpoint) {
        const main = button.parentNode
        const fname = main.querySelector('#fname')
        const lname = main.querySelector('#lname')
        const mail = main.querySelector('#mail')

        uploadChanges({ fname, lname, mail }, endpoint)
            .then(data => {
                if (data) {
                    alert('update successfully')
                }
            })
    }

    async function uploadChanges(info, endpoint) {
        return fetch(endpoint, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                'email' : info.email,
                'firstname': info.firstname,
                'lastname': info.lastname
            })
        })
            .then(res => res.json())
            .then(data => data)
            .catch(reason => {
                console.log('[FETCH ERROR]', reason)
                return undefined
            })
    }
</script>

</body>
</html>
