<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/30/2022
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>

<h1 class="text-center text-danger">CHI TIET SHIPPER</h1>

<div class="row">
    <div class="col-md-4">
        <c:choose>
            <c:when test="${shipper.avatar != null && shipper.avatar.startsWith('https:') == true}">
                <img class=" img-fluid rounded-circle" src="${shipper.avatar}" alt="${shipper.firstname} ${shipper.lastname}" />
            </c:when>
            <c:when test="${shipper.avatar.startsWith('https:') == false}">
                <img class=" img-fluid rounded-circle" src="<c:url value="/img/default.jpg"/>" alt="${shipper.firstname} ${shipper.lastname}"/>
            </c:when>
        </c:choose>
    </div>
    <div class="col-md-6">
        <h1>${shipper.firstname} ${shipper.lastname}</h1>
        <h3 class="text-danger">${shipper.phoneNumber}</h3>
        <h3>${shipper.email}</h3>
    </div>
</div>
<c:url value="/api/products/${shipper.id}/comments" var="endpoint" />

<sec:authorize access="!isAuthenticated()">
    <strong>Vui long <a href="<c:url value="/login" />">dang nhap</a> de binh luan!!!</strong>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div class="form-group">
        <textarea class="form-control" placeholder="Nhap noi dung binh luan" id="contentId"></textarea>
    </div>
    <button class="btn btn-danger" onclick="addComment('${endpoint}', ${shipper.id})">Them binh luan</button>
</sec:authorize>
<c:forEach items="${rating}" var="comment">
    <div class="row">
        <div class="col-md-2">
            <img class="rounded-circle img-fluid" src="/images/default.jpg">
        </div>
        <div class="col-md-10">
            <p>Đây là nội dung của bình luận</p>
            <i>Đây là thời gian</i>
        </div>
    </div>
</c:forEach>


<ul id="comments" class="list-group">

</ul>


<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>