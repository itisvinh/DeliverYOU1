<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://www.gstatic.com/charts/loader.js"></script>
    <script src='<c:url value="/js/util.js"/>'></script>
    <script src='<c:url value="/js/toast.js"/>'></script>
    <script defer src='<c:url value="/js/user_reports.js"/>'></script>
    <script defer src='<c:url value="/js/common_reports.js"/>'></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>

<body class="p-lg-4 p-md-3 p-sm-2">
<style>
    .card {
        width: 100%;
        height: auto;
        box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px;
        border-color: rgba(214, 214, 214, 0.8);
        overflow: hidden;
    }

    bi.bi-caret-down-fill,
    bi.bi-caret-up-fill {
        transition: all .5s ease-in-out;
        color: #1d3557;
    }

    .text-title {
        color: #1d3557;
        font-weight: bold;
    }

    .bg-clr-1 {
        background-color: #7c8698;
    }
</style>


<div class="card p-2 pb-3 mb-2">

    <div onclick="return; toggleCollapsibleIcon(this)" class="fw-semibold" data-bs-toggle="collapse-d"
         data-bs-target="#general-reports">
            <span>
                <i class="bi bi-caret-up-fill d-none"></i>
            </span>
        <span class="text-title">
                General Report:
            </span>
    </div>

    <div id="general-reports" class="collapse show">
        <div class="dropdown">
            <button class="btn btn-secondary rounded-pill dropdown-toggle ms-2 float-end"
                    style="background: #219ebc; border:none;" type="button" data-bs-toggle="dropdown"
                    aria-expanded="false">
                <i class="bi bi-funnel-fill"></i>
                <span id="dd-filter-value" data-month="0">All time</span>
            </button>
            <ul class="dropdown-menu">
                <li onclick="filterSelected(this)" class="dropdown-item" data-month="0">All time</li>
                <li onclick="filterSelected(this)" class="dropdown-item" data-month="10">October</li>
                <li onclick="filterSelected(this)" class="dropdown-item" data-month="9">September</li>
            </ul>
        </div>
        <hr />

        <div class="container-fluid">

            <div class="d-flex align-items-center">
                <div
                        class="text-white px-3 py-1 rounded-pill bg-clr-1 d-flex align-items-center justify-content-center">
                    <i class="bi bi-file-earmark-post-fill me-2"></i>
                    <span class="text-center">Total post</span>
                </div>
                <div class="fw-semibold text-white px-2 py-1 text-end ms-2 text-wrap rounded-pill bg-dark">12</div>
            </div>

            <div class="d-flex align-items-center mt-2">
                <div
                        class="text-white px-3 py-1 rounded-pill bg-clr-1 d-flex align-items-center justify-content-center">
                    <i class="text-center bi bi-currency-dollar bg-white rounded-circle me-2"
                       style="color: #7c8698; font-size: .68rem; padding-left: .2rem; padding-right: .2rem;"></i>
                    <span class="text-center">Total spending</span>
                </div>
                <div class="fw-semibold text-white px-2 py-1 text-end ms-2 text-wrap rounded-pill bg-dark">
                    <span class="currency-symbol">$</span>
                    <span>0.0</span>
                </div>
            </div>

            <div class="d-flex align-items-center mt-2">
                <div
                        class="text-white px-3 py-1 rounded-pill bg-clr-1 d-flex align-items-center justify-content-center">
                    <i class="text-center bi bi-currency-dollar bg-white rounded-circle me-2"
                       style="color: #7c8698; font-size: .68rem; padding-left: .2rem; padding-right: .2rem;"></i>
                    <span class="text-center">Total earning</span>
                </div>
                <div class="fw-semibold text-white px-2 py-1 text-end ms-2 text-wrap rounded-pill bg-dark">
                    <span class="currency-symbol">$</span>
                    <span>0.0</span>
                </div>
            </div>

            <div class="d-flex align-items-center mt-2">
                <div
                        class="text-white px-3 py-1 rounded-pill bg-clr-1 d-flex align-items-center justify-content-center">
                    <i class="bi bi-person-circle me-2"></i>
                    <span class="text-center">Rated shippers</span>
                </div>
                <div class="fw-semibold text-white px-2 py-1 text-end ms-2 text-wrap rounded-pill bg-dark">10</div>
            </div>

            <div class="d-flex align-items-center mt-2">
                <div
                        class="text-white px-3 py-1 rounded-pill bg-clr-1 d-flex align-items-center justify-content-center">
                    <i class="bi bi-person-circle me-2"></i>
                    <span class="text-center">Delivered</span>
                </div>
                <div class="fw-semibold text-white px-2 py-1 text-end ms-2 text-wrap rounded-pill bg-dark">10</div>
            </div>

        </div>
    </div>
</div>
<!-- ----------------------------------------------------- -->
<sec:authorize access="hasRole('ROLE_USER')">

    <div class="card p-2 mb-2">
        <div onclick="toggleCollapsibleIcon(this)" class="fw-semibold" data-bs-toggle="collapse"
             data-bs-target="#posts-per-cat-reports">
                <span>
                    <i class="bi bi-caret-up-fill"></i>
                </span>
            <span class="text-title">
                    Post per Category:
                </span>
        </div>

        <div id="posts-per-cat-reports" class="collapse show">
            <div class="chart" style="width: 100%; max-width: 40rem; height: 80vw; max-height: 20rem; margin: auto;">
            </div>
        </div>
    </div>

    <!-- ---------------------------------------------------------- -->
    <div class="card p-2 mb-2">
        <div onclick="toggleCollapsibleIcon(this)" class="fw-semibold" data-bs-toggle="collapse"
             data-bs-target="#monthly-spending-reports">
                <span>
                    <i class="bi bi-caret-up-fill"></i>
                </span>
            <span class="text-title">
                    Monthly Spending:
                </span>
        </div>

        <div id="monthly-spending-reports" class="collapse show">
            <div class="chart" style="width: 100%; max-width: 40rem; height: auto; margin: auto;"></div>
        </div>
    </div>

</sec:authorize>

<div id="endpoint" data-endpoint="<c:url value="/"/>"></div>

<!-- ----------------------------------------------------- -->

</body>

</html>
