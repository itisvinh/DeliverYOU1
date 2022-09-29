<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/16/2022
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset=utf-8>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/signUp_Form.css'/>">

</head>
<body>
    <div class="wrapper">
        <div class="form-left">
            <h2 class="text-uppercase">information</h2>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Et molestie ac feugiat sed. Diam volutpat commodo.
            </p>
            <p class="text">
                <span>Sub Head:</span>
                Vitae auctor eu augudsf ut. Malesuada nunc vel risus commodo viverra. Praesent elementum facilisis leo vel.
            </p>
            <div class="form-field">
                <input type="submit" class="account" value="Have an Account?">
            </div>
        </div>
        <c:url value="/register" var="action"/>
        <form:form class="form-right" enctype="multipart/form-data" method="post" action="${action}" modelAttribute="user">
            <h2 class="text-uppercase">Registration form</h2>
            <div class="row">
                <div class="col-sm-6 mb-3">
                    <label>First Name</label>
                    <form:input type="text" name="first_name" id="first_name" class="input-field" path="firstname"/>
                </div>
                <div class="col-sm-6 mb-3">
                    <label>Last Name</label>
                    <form:input type="text" name="last_name" id="last_name" class="input-field" path="lastname"/>
                </div>
            </div>
            <div class="mb-3">
                <label>Your Phone</label>
                <form:input type="text" class="input-field" name="phone" path="phoneNumber"/>
            </div>
            <div class="mb-3">
                <label>Your Email</label>
                <form:input type="email" class="input-field" name="email" path="email"/>
            </div>
            <div class="row">
                <div class="col-sm-6 mb-3">
                    <label>Password</label>
                    <form:input type="password" name="pwd" id="pwd" class="input-field" path="password"/>
                </div>
                <div class="col-sm-6 mb-3">
                    <label>Current Password</label>
                    <form:input type="password" name="cpwd" id="cpwd" class="input-field" path="confirmPassword"/>
                </div>
            </div>
            <div class="mb-3">
                <label>Avatar</label>
                <form:input type="file" class="input-field" name="avatar" path="file"/>
            </div>
            <div class="mb-3">
                <label class="option">I agree to the <a href="#">Terms and Conditions</a>
                    <input type="checkbox" checked>
                    <span class="checkmark"></span>
                </label>
            </div>
            <div class="form-field">
                <input type="submit" value="Register" class="register" name="register">
            </div>
        </form:form>
    </div>
</body>
</html>
