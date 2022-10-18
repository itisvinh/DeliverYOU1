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
    <link rel="stylesheet" href="<c:url value="/css/user_posts.css"/>">
    <style>
        @import url('<c:url value="/css/user_posts_add_post.css"/>');
    </style>
    <script async src='<c:url value="/js/shipper.js"/>'></script>
</head>
<body class="bg-transparent w-100 vh-100 d-inline-block">

<div class="tabs" style="height: auto; min-height: 100%;">
    <input type="radio" id="tab1" name="tab-control" checked>
    <input type="radio" id="tab2" name="tab-control">
    <input type="radio" id="tab3" name="tab-control">
    <input type="radio" id="tab4" name="tab-control">
    <ul>
        <li title="Shipping">
            <label for="tab1" role="button">
                <svg viewBox="0 0 24 24">
                    <path
                            d="M3,4A2,2 0 0,0 1,6V17H3A3,3 0 0,0 6,20A3,3 0 0,0 9,17H15A3,3 0 0,0 18,20A3,3 0 0,0 21,17H23V12L20,8H17V4M10,6L14,10L10,14V11H4V9H10M17,9.5H19.5L21.47,12H17M6,15.5A1.5,1.5 0 0,1 7.5,17A1.5,1.5 0 0,1 6,18.5A1.5,1.5 0 0,1 4.5,17A1.5,1.5 0 0,1 6,15.5M18,15.5A1.5,1.5 0 0,1 19.5,17A1.5,1.5 0 0,1 18,18.5A1.5,1.5 0 0,1 16.5,17A1.5,1.5 0 0,1 18,15.5Z" />
                </svg>
                <br>
                <span>Feeds</span>
            </label>
        </li>
        <li title="Delivery Contents">
            <label for="tab2" role="button">
                <svg viewBox="0 0 24 24">
                    <path
                            d="M2,10.96C1.5,10.68 1.35,10.07 1.63,9.59L3.13,7C3.24,6.8 3.41,6.66 3.6,6.58L11.43,2.18C11.59,2.06 11.79,2 12,2C12.21,2 12.41,2.06 12.57,2.18L20.47,6.62C20.66,6.72 20.82,6.88 20.91,7.08L22.36,9.6C22.64,10.08 22.47,10.69 22,10.96L21,11.54V16.5C21,16.88 20.79,17.21 20.47,17.38L12.57,21.82C12.41,21.94 12.21,22 12,22C11.79,22 11.59,21.94 11.43,21.82L3.53,17.38C3.21,17.21 3,16.88 3,16.5V10.96C2.7,11.13 2.32,11.14 2,10.96M12,4.15V4.15L12,10.85V10.85L17.96,7.5L12,4.15M5,15.91L11,19.29V12.58L5,9.21V15.91M19,15.91V12.69L14,15.59C13.67,15.77 13.3,15.76 13,15.6V19.29L19,15.91M13.85,13.36L20.13,9.73L19.55,8.72L13.27,12.35L13.85,13.36Z" />
                </svg>
                <br>
                <span>Pending</span>
            </label>
        </li>
        <li title="Features">
            <label for="tab3" role="button">
                <svg viewBox="0 0 24 24">
                    <path
                            d="M14,2A8,8 0 0,0 6,10A8,8 0 0,0 14,18A8,8 0 0,0 22,10H20C20,13.32 17.32,16 14,16A6,6 0 0,1 8,10A6,6 0 0,1 14,4C14.43,4 14.86,4.05 15.27,4.14L16.88,2.54C15.96,2.18 15,2 14,2M20.59,3.58L14,10.17L11.62,7.79L10.21,9.21L14,13L22,5M4.93,5.82C3.08,7.34 2,9.61 2,12A8,8 0 0,0 10,20C10.64,20 11.27,19.92 11.88,19.77C10.12,19.38 8.5,18.5 7.17,17.29C5.22,16.25 4,14.21 4,12C4,11.7 4.03,11.41 4.07,11.11C4.03,10.74 4,10.37 4,10C4,8.56 4.32,7.13 4.93,5.82Z" />
                </svg>
                <br>
                <span>History</span>
            </label>
        </li>
    </ul>

    <div class="slider">
        <div class="indicator"></div>
    </div>
    <div class="content">
        <%---------------------------------------------------------------------%>
        <section>
            <h2>Feeds</h2>
            <div class="container-fluid">

                <div class="row">

                    <c:if test="${pending_posts.size() > 0}">
                        <c:forEach items="${pending_posts}" var="pending_post">
                            <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
                                <div class="card shadow" style="width: 14rem;">
                                    <img src="${pending_post.postImages.get(0).image}" class="card-img-top img-thumbnail m-auto">
                                    <div class="card-body">
                                        <div class="card-title d-flex flex-wrap" style="position: relative;">
                                            <span>Date:</span>
                                            <h6 class="text-end" style="flex-grow: 1;">${pending_post.orderDate.toGMTString()}</h6>
                                        </div>
                                        <div class="card-title d-flex flex-wrap" style="position: relative;">
                                            <span>Time:</span>
                                            <h6 class="text-end" style="flex-grow: 1;">${pending_post.orderDate.toString()}</h6>
                                        </div>
                                        <div>Content:</div>
                                        <p class="card-text mt-2" style="color: rgb(137, 137, 137); font-size: .9rem; width: 100%; height: 3rem; word-wrap: break-word; overflow-y: hidden;">
                                                ${pending_post.content}
                                        </p>
                                        <button class="btn btn-primary w-100" onclick="displayDetailsModal(this, '<c:url value="/common/api/get-post/"/>', 'feed')" data-post-id=${pending_post.id}>More</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                </div>

            </div>
        </section>
        <%---------------------------------------------------------------------%>

        <section>
            <h2>Pending</h2>
            <div class="container-fluid">

                <div class="row">

                    <c:if test="${await_acceptance_posts.size() > 0}">
                        <c:forEach items="${await_acceptance_posts}" var="aa_post">
                            <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
                                <div class="card shadow" style="width: 14rem;">
                                    <img src="${aa_post.postImages.get(0).image}" class="card-img-top img-thumbnail m-auto">
                                    <div class="card-body">
                                        <div class="card-title d-flex flex-wrap" style="position: relative;">
                                            <span>Date:</span>
                                            <h6 class="text-end" style="flex-grow: 1;">${aa_post.orderDate.toGMTString()}</h6>
                                        </div>
                                        <div class="card-title d-flex flex-wrap" style="position: relative;">
                                            <span>Time:</span>
                                            <h6 class="text-end" style="flex-grow: 1;">${aa_post.orderDate.toString()}</h6>
                                        </div>
                                        <div>Content:</div>
                                        <p class="card-text mt-2" style="color: rgb(137, 137, 137); font-size: .9rem; width: 100%; height: 3rem; word-wrap: break-word; overflow-y: hidden;">
                                                ${aa_post.content}
                                        </p>
                                        <button class="btn btn-primary w-100" onclick="displayDetailsModal(this, '<c:url value="/common/api/get-post/"/>', 'pending')" data-post-id=${aa_post.id}>More</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                </div>

            </div>
        </section>

        <%---------------------------------------------------------------------%>

        <section>
            <h2>History</h2>
            <div class="container-fluid">

                <div class="row">

                    <c:if test="${accepted_posts.size() > 0}">
                        <c:forEach items="${accepted_posts}" var="accepted_post">
                            <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
                                <div class="card shadow" style="width: 14rem;">
                                    <img src="${accepted_post.postImages.get(0).image}" class="card-img-top img-thumbnail m-auto">
                                    <div class="card-body">
                                        <div class="card-title d-flex flex-wrap" style="position: relative;">
                                            <span>Date:</span>
                                            <h6 class="text-end" style="flex-grow: 1;">${accepted_post.orderDate.toGMTString()}</h6>
                                        </div>
                                        <div class="card-title d-flex flex-wrap" style="position: relative;">
                                            <span>Time:</span>
                                            <h6 class="text-end" style="flex-grow: 1;">${accepted_post.orderDate.toString()}</h6>
                                        </div>
                                        <div>Content:</div>
                                        <p class="card-text mt-2" style="color: rgb(137, 137, 137); font-size: .9rem; width: 100%; height: 3rem; word-wrap: break-word; overflow-y: hidden;">
                                                ${accepted_post.content}
                                        </p>
                                        <button class="btn btn-primary w-100" onclick="displayDetailsModal(this, '<c:url value="/common/api/get-post/"/>', 'history')" data-post-id=${accepted_post.id}>More</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                </div>

            </div>
        </section>
    </div>

    <div id="mainPostModal" class="modal fade" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header" style="height: 2rem;">
                    <button type="button" class="btn-close" aria-label="Close" onclick="closeModal()"></button>
                </div>
                <div class="modal-body h-auto" style="overflow-y: auto; max-height: 15rem;">
                    <div id="img-container" class="d-flex flex-wrap" style="border: 2px dashed rgb(210, 210, 210); gap: .2rem">
                        <img class="img-thumbnail" style="width: 6rem; height: 6rem;" src=""/>
                    </div>
                    <div class="d-flex flex-wrap">
                        <div class="fw-bold me-2">Sender:</div>
                        <div id="sender-name" class="text-end" style="flex-grow: 1;">Anne</div>
                    </div>
                    <div class="d-flex flex-wrap">
                        <div class="mx-2">Phone:</div>
                        <div id="sender-phone" class="text-end" style="flex-grow: 1;">Anne</div>
                    </div>
                    <div class="d-flex flex-wrap">
                        <div class="mx-2">Address:</div>
                        <div id="sender-address" class="text-end" style="flex-grow: 1;">Anne</div>
                    </div>
                    <div class="d-flex flex-wrap mt-2">
                        <div class="fw-bold me-2">Recipent:</div>
                        <div id="receiver-name" class="text-end" style="flex-grow: 1;">Anne</div>
                    </div>
                    <div class="d-flex flex-wrap">
                        <div class="mx-2">Phone:</div>
                        <div id="receiver-phone"  class="text-end" style="flex-grow: 1;">Anne</div>
                    </div>
                    <div class="d-flex flex-wrap">
                        <div class="mx-2">Address:</div>
                        <div id="receiver-address"  class="text-end" style="flex-grow: 1;">Anne</div>
                    </div>
                    <div class="d-flex flex-wrap mt-2">
                        <div class="fw-bold me-2">Category:</div>
                        <div id="cat-name" class="text-end" style="flex-grow: 1;">Other</div>
                    </div>
                </div>
                <div class="modal-footer h-auto p-0">

                    <div id="group-set-fee">
                        <div id="shipper-delivery-fee" class="input-group">
                            <span class="input-group-text">Delivery fee?</span>
                            <input id="shipper-delivery-fee-input" type="text" class="form-control" placeholder="10 000 (VND)">
                        </div>
                        <button type="button" class="w-100 btn btn-primary" onclick="addPostAuction('<c:url value="/user/api"/>'); validateFee()">Deliver this</button>
                    </div>

                    <div id="group-confirm-finish" class="d-none">
                        <button type="button" class="w-100 btn btn-warning" onclick="confirmFinishDelivering('<c:url value="/user/api"/>')">Deliver this</button>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
<div style="display: none;" id="current_user_phone_number" data-currentUserPhone="${u_phone}"></div>

<script src="js/validator.js"></script>
<script>
    const validator = new Validator()

    const fee_container = document.querySelector('#shipper-delivery-fee')
    const fee_input = fee_container.querySelector('#shipper-delivery-fee-input')
    let value = ''

    validator.add(fee_container, () => {
        value = fee_input.value.match(/\d+/gm)

        if (value) {
            value = value.join("")
            return value < 1000 ? false : true
        } else {
            return false
        }

    }, "Invalid value", "", ".3rem")

    function validateFee() {
        validator.validate()

        let dval = [];
        for (let i = value.length - 1; i >= 0; i--) {
            dval.push(value[i])
            if (i > 0 && (value.length - i) % 3 === 0)
                dval.push(' ')
        }
        dval = dval.reverse().join('')
        fee_input.value = dval + ' (VND)'
    }


</script>

</body>
</html>
