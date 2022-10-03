<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/30/2022
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>

<div class="row">
  <c:forEach items="${shippers}" var="p">
    <div class="col-md-4 col-xs-12" style="padding: 10px;">
      <div class="card">
        <a href="<c:url value="/shipperTest/${p.id}"/>">
          <c:choose>
            <c:when test="${p.avatar != null && p.avatar.startsWith('https') == true}">
              <img class="card-img-top img-fluid" src="${p.avatar}" alt="${p.firstname} ${p.lastname}" />
            </c:when>
            <c:when test="${p.avatar.startsWith('https') == false}">
              <img class="card-img-top img-fluid" src="<c:url value="/img/default.jpg"/>" alt="${p.firstname} ${p.lastname}" />
            </c:when>
          </c:choose>
        </a>
        <div class="card-body">
          <h4 class="card-title">${p.firstname} ${p.lastname} </h4>
          <p class="card-text">
              ${p.phoneNumber}
          </p>
          <a href="<c:url value="/shipperTest/${p.id}" />" class="btn btn-primary">Xem chi tiet</a>
        </div>
      </div>
    </div>
  </c:forEach>
</div>
