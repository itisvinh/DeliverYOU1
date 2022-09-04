<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset=utf-8>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/css/user_posts.css'/>">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script defer src="<c:url value='/js/user_posts.js'/>"></script>
</head>
<body>

<form class="search-bar" action="">
    <div class="inner-content">
        <div class="input-group">
            <input class="input-field" type="text" name="">
        </div>
        <button class="search-btn" type="button">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
            </svg>
        </button>
    </div>
</form>

<main class="main-area">

    <div class="tabs">
        <input type="radio" id="tab1" name="tab-control" checked>
        <input type="radio" id="tab2" name="tab-control">
        <input type="radio" id="tab3" name="tab-control">
        <input type="radio" id="tab4" name="tab-control">
        <ul>
            <li title="Shipping">
                <label for="tab1" role="button">
                    <svg viewBox="0 0 24 24">
                        <path d="M3,4A2,2 0 0,0 1,6V17H3A3,3 0 0,0 6,20A3,3 0 0,0 9,17H15A3,3 0 0,0 18,20A3,3 0 0,0 21,17H23V12L20,8H17V4M10,6L14,10L10,14V11H4V9H10M17,9.5H19.5L21.47,12H17M6,15.5A1.5,1.5 0 0,1 7.5,17A1.5,1.5 0 0,1 6,18.5A1.5,1.5 0 0,1 4.5,17A1.5,1.5 0 0,1 6,15.5M18,15.5A1.5,1.5 0 0,1 19.5,17A1.5,1.5 0 0,1 18,18.5A1.5,1.5 0 0,1 16.5,17A1.5,1.5 0 0,1 18,15.5Z" />
                    </svg>
                    <br>
                    <span>Ongoing</span>
                </label>
            </li>
            <li title="Delivery Contents">
                <label for="tab2" role="button">
                    <svg viewBox="0 0 24 24">
                        <path d="M2,10.96C1.5,10.68 1.35,10.07 1.63,9.59L3.13,7C3.24,6.8 3.41,6.66 3.6,6.58L11.43,2.18C11.59,2.06 11.79,2 12,2C12.21,2 12.41,2.06 12.57,2.18L20.47,6.62C20.66,6.72 20.82,6.88 20.91,7.08L22.36,9.6C22.64,10.08 22.47,10.69 22,10.96L21,11.54V16.5C21,16.88 20.79,17.21 20.47,17.38L12.57,21.82C12.41,21.94 12.21,22 12,22C11.79,22 11.59,21.94 11.43,21.82L3.53,17.38C3.21,17.21 3,16.88 3,16.5V10.96C2.7,11.13 2.32,11.14 2,10.96M12,4.15V4.15L12,10.85V10.85L17.96,7.5L12,4.15M5,15.91L11,19.29V12.58L5,9.21V15.91M19,15.91V12.69L14,15.59C13.67,15.77 13.3,15.76 13,15.6V19.29L19,15.91M13.85,13.36L20.13,9.73L19.55,8.72L13.27,12.35L13.85,13.36Z" />
                    </svg>
                    <br>
                    <span>Pending</span>
                </label>
            </li>
            <li title="Features">
                <label for="tab3" role="button">
                    <svg viewBox="0 0 24 24">
                        <path d="M14,2A8,8 0 0,0 6,10A8,8 0 0,0 14,18A8,8 0 0,0 22,10H20C20,13.32 17.32,16 14,16A6,6 0 0,1 8,10A6,6 0 0,1 14,4C14.43,4 14.86,4.05 15.27,4.14L16.88,2.54C15.96,2.18 15,2 14,2M20.59,3.58L14,10.17L11.62,7.79L10.21,9.21L14,13L22,5M4.93,5.82C3.08,7.34 2,9.61 2,12A8,8 0 0,0 10,20C10.64,20 11.27,19.92 11.88,19.77C10.12,19.38 8.5,18.5 7.17,17.29C5.22,16.25 4,14.21 4,12C4,11.7 4.03,11.41 4.07,11.11C4.03,10.74 4,10.37 4,10C4,8.56 4.32,7.13 4.93,5.82Z"/>
                    </svg>
                    <br>
                    <span>Delivered</span>
                </label>
            </li>
            <li title="Returns">
                <label for="tab4" role="button">
                    <svg viewBox="0 0 24 24">
                        <path d="M11,9H13V7H11M12,20C7.59,20 4,16.41 4,12C4,7.59 7.59,4 12,4C16.41,4 20,7.59 20,12C20,16.41 16.41,20 12,20M12,2A10,10 0 0,0 2,12A10,10 0 0,0 12,22A10,10 0 0,0 22,12A10,10 0 0,0 12,2M11,17H13V11H11V17Z" />
                    </svg>
                    <br>
                    <span>Canceled</span>
                </label>
            </li>
        </ul>

        <div class="slider"><div class="indicator"></div></div>
        <div class="content">
            <section>
                <h2>Ongoing</h2>
                <div>
                    <div class="card" style="width: 18rem;">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <button class="btn btn-primary" data-toggle="modal" data-target=".main-area #exampleModalCenter">Go somewhere</button>
                        </div>
                    </div>
                </div>
            </section>

            <section>
                <h2>Pending</h2>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa dicta vero rerum? Eaque repudiandae architecto libero reprehenderit aliquam magnam ratione quidem? Nobis doloribus molestiae enim deserunt necessitatibus eaque quidem incidunt.
            </section>

            <section>
                <h2>Delivered</h2>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem quas adipisci a accusantium eius ut voluptatibus ad impedit nulla, ipsa qui. Quasi temporibus eos commodi aliquid impedit amet, similique nulla.
            </section>

            <section>
                <h2>Canceled</h2>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam nemo ducimus eius, magnam error quisquam sunt voluptate labore, excepturi numquam! Alias libero optio sed harum debitis! Veniam, quia in eum.
            </section>
        </div>

        <div class="add-post-modal-content d-none">
            <div class="modal-header">
                <div class="progress-bar">
                    <div class="progress-item active">Locations</div>
                    <div class="progress-item">Recipient</div>
                    <div class="progress-item">Products</div>
                </div>
            </div>

            <div class="modal-body">
                    <button type="button" id="reset-tab-index-btn" class="d-none" onclick="resetCurrentTabIndex()"></button>
                    <div class="tab-container">
                        <!-- ----------------------- -->
                        <div class="tab">
                            <button class="btn d-block" data-bs-toggle="collapse" data-bs-target="#pickup-loc-sel">Choose pick-up location:</button>
                            <div id="pickup-loc-sel" class="loc-selectors collapse show">
                                <div class="autocomplete">
                                    <input class="province-sel" type="text" name="sender_province" placeholder="Select province"/>
                                </div>
                                <div class="autocomplete">
                                    <input disabled class="district-sel" type="text" name="sender_district" placeholder="Select district"/>
                                </div>
                                <div class="autocomplete">
                                    <input disabled class="ward-sel" type="text" name="sender_ward" placeholder="Select ward"/>
                                </div>
                                <input class='street-inp textfield' type="text" placeholder="Street" name="sender_street"/>
                                <button onclick="resetLoc(this)" class="btn btn-danger rounded-pill">Clear</button>
                            </div>

                            <button class="btn d-block" data-bs-toggle="collapse" data-bs-target="#dropoff-loc-sel">Choose a drop-off location</button>
                            <div id="dropoff-loc-sel" class="loc-selectors collapse show">
                                <div class="autocomplete">
                                    <input class="province-sel" type="text" name="receiver_province" placeholder="Select province"/>
                                </div>
                                <div class="autocomplete">
                                    <input disabled="true" class="district-sel" type="text" name="receiver_district" placeholder="Select district"/>
                                </div>
                                <div class="autocomplete">
                                    <input disabled class="ward-sel" type="text" name="receiver_ward" placeholder="Select ward"/>
                                </div>
                                <input class='street-inp textfield' type="text" placeholder="Street" name="receiver_street"/>
                                <button onclick="resetLoc(this)" class="btn btn-danger rounded-pill">Clear</button>
                            </div>
                        </div>
                        <!-- ----------------------- -->
                        <div class="tab d-none">
                            <div class="recepient-selectors">
                                <div class="tf-title">Recipient's name:</div>
                                <input id="rep-name" class='textfield' type="text" placeholder="Name" name="rep-name"/>
                                <div class="tf-title">Recipient's phone number:</div>
                                <input id="rep-phone" class='textfield' type="text" placeholder="Phone number" name="rep-phone"/>
                            </div>
                        </div>
                        <!-- ----------------------- -->
                        <div class="tab d-none">
                            <div class="image-uploader container">
                                <div class="row">
                                    <div>
                                        <!-- Upload image input-->
                                        <div class="input-group mb-3 px-2 py-2 rounded-pill bg-dark shadow-md">
                                            <input id="upload" type="file" onchange="readFiles(this);" class="form-control border-0" multiple>
                                            <label id="upload-label" for="upload" class="font-weight-light text-muted">Choose file</label>
                                            <div class="input-group-append">
                                                <label for="upload" class="btn btn-light m-0 rounded-pill px-4"> <i class="fa fa-cloud-upload mr-2 text-muted"></i><small class="text-uppercase font-weight-bold text-muted">Choose file</small></label>
                                            </div>
                                        </div>
                                        <!-- Uploaded image area-->
                                        <div class="image-area mt-2">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="container mt-3">
                                <p id="post_content">
                                    <strong>Post content:</strong>
                                    <span class="textarea" role="textbox" contenteditable></span>>
                                </p>

                                <button id="category_name" data-cat="other" class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <span>Category: </span>
                                    <span class="cat_name btn-label-content fw-light">Other</span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li onclick="categorySelected(this)" class="dropdown-item" data-cat="food">Food</li>
                                    <li onclick="categorySelected(this)" class="dropdown-item" data-cat="clothing">Clothing</li>
                                    <li onclick="categorySelected(this)" class="dropdown-item" data-cat="electronics">Electronics</li>
                                    <li onclick="categorySelected(this)" class="dropdown-item" data-cat="fragile">Fragile</li>
                                    <li onclick="categorySelected(this)" class="dropdown-item" data-cat="other">Other</li>
                                </ul>
                            </div>
                            </div>
                        </div>
                        <!-- ----------------------- -->
                    </div>

            <div class="modal-footer p-1">
                <button type="button" class="btn btn-secondary d-none" data-bs-dismiss="modal" onclick="previousTab(this)">Previous</button>

                <button type="button" class="btn btn-primary" onclick="nextTab(this, '<c:url value="/user/api/add-post"></c:url>')" data-mode="next">Next</button>
            </div>

            <style>
                @import url('<c:url value="/css/user_posts_add_post.css"/>');
            </style>
        </div>

        </div>


        <button onclick="displayAddPostModal(event)" class="float-btn">
            <div>
                <span>+</span>
                <span class="hover-text">Create new post</span>
            </div>
        </button>


    </div>


</main>


</body>
</html>