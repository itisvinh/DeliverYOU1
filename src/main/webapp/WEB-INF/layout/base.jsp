<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title><tiles:insertAttribute name="title"/></title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel='stylesheet' type='text/css' media='screen' href='<c:url value="/css/home.css"/>'>
        <link rel='stylesheet' type='text/css' media='screen' href='<c:url value="/css/login.css"/>'>
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
        <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%--        <script async src="<c:url value="/js/login.js"/>"></script>--%>

    </head>
    <body>
        <tiles:insertAttribute name="topNavBar" />

        <div id="b-body">
            <tiles:insertAttribute name="body" />
        </div>

        <div id="b-footer">
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>
