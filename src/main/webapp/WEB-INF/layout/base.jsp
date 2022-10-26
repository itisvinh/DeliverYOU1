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
        <div class="modal fade" id="tracking-modal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-body d-flex flex-column" style="gap: .5rem;">
                        <div>
                            <i class="bi bi-pin-map-fill"></i>
                            <span class="ms-2 fw-semibold">Pickup location:</span>
                            <span>Long Thành, Đồng Nai</span>
                        </div>
                        <div>
                            <i class="bi bi-geo-alt-fill"></i>
                            <span class="ms-2 fw-semibold">Deliver to:</span>
                            <span class="text-danger">sign in to view this information</span>
                        </div>
                        <div>
                            <i class="bi bi-cash"></i>
                            <span class="ms-2 fw-semibold">Fee:</span>
                            <span>57.000 (VND)</span>
                        </div>
                        <div>
                            <i class="bi bi-truck-front-fill"></i>
                            <span class="ms-2 fw-semibold">Status:</span>
                            <span class="text-primary">Package is being delivered</span>
                        </div>
                    </div>
                    <div class="modal-footer p-1 position-relative">
                        <div class="text-primary position-absolute pt-3" style="font-size: .9rem; left: 1rem;">
                            <p>*For more information, go to Post tab</p>
                        </div>
                        <button type="button" class="btn btn-primary rounded-pill" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
