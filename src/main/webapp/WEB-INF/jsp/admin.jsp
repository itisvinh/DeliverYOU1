<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Administrator Management</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='<c:url value="/css/admin.css"/>'>
    <script defer src='<c:url value="/js/admin.js"/>'></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

<div id="main-container" class="d-flex flex-column w-100 vh-100">
    <div id="top-nav" class="w-100 bg-info d-flex px-2 align-items-center justify-content-center"
         style="height: 3rem">
        <img src="<c:url value="/img/brand_name.svg"/>" style="width: 7rem;">
        <i class="bi bi-dot fs-3"></i>
        <div class="fw-semibold">Administrator</div>
        <div class="dropdown position-absolute" style="right: 2rem; cursor: pointer;">
            <i class="bi bi-person-circle" style="right: 2rem" data-bs-toggle="dropdown" aria-expanded="false"></i>
            <ul class="dropdown-menu">
                <li class="w-100 text-center fw-bold">Andie Mills</li>
                <li><button class="dropdown-item" type="button">
                    <i class="bi bi-person-lines-fill me-2"></i>
                    Profile
                </button>
                </li>
                <li>
                    <button class="dropdown-item" type="button">
                        <i class="bi bi-box-arrow-right me-2"></i>
                        Logout
                    </button>
                </li>
            </ul>
        </div>
    </div>
    <div id="bottom-nav" class="fixed-bottom">
        <button class="nav-item active" data-tab-index="0">
            <i class="bi bi-house-fill"></i>
            <div>Home</div>
        </button>

        <button class="nav-item" data-tab-index="1">
            <i class="bi bi-person-circle"></i>
            <div>User</div>
        </button>

        <button class="nav-item" data-tab-index="2">
            <i class="bi bi-people-fill"></i>
            <div>Driver</div>
        </button>
    </div>
    <iframe id="tab-iframe" class="w-100 h-100" src="<c:url value="/admin/app/admin-driver-3249738HJVHSG87629GCUYC987"/>"></iframe>

    <div id="endpoint" class="d-none" data-endpoint="<c:url value="/admin"/>"></div>
</div>

</body>

</html>
