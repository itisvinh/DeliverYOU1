<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html" language="java" pageEncoding="utf-8" %>


<nav class="navbar navbar-expand-sm navbar-dark bg-dark sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">SaleApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Category 1</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Category 2</a>
                </li>
            </ul>
            <form class="d-flex" action="">
                <input name="string" class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
