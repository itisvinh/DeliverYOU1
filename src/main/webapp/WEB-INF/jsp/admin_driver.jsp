<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html class="h-100 w-100">

<head>
  <meta charset='utf-8'>
  <meta http-equiv='X-UA-Compatible' content='IE=edge'>
  <meta name='viewport' content='width=device-width, initial-scale=1'>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Latest compiled JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
  <script defer src="<c:url value="/js/admin_driver.js"/>"></script>
</head>

<body class="h-100 w-100">

<script>
  function inIframe() {
    try {
      return window.self !== window.top;
    } catch (e) {
      return true;
    }
  }

  if (!inIframe()) {
    console.log(34234324)
    window.stop()
    const body = document.querySelector('body')
    body.classList.add('m-auto', 'fw-bold', 'fs-2')
    body.innerHTML = `<div>This page can only be loaded inside an iframe</div>`
  }
</script>

<style>
  .card.card-extra {
    transition: all .2s ease-in-out;
    background: #a8dadc;
    color: black;
  }

  .card.top-node:after {
    content: "0";
    position: absolute;
    top: -.7rem;
    right: -.7rem;
    font-size: 1.2rem;
    font-weight: 700;
    background: #08abb0;
    width: 2rem;
    height: 2rem;
    color: white;
    text-align: center;
    border-radius: 1rem;
  }

  .card.card-extra:hover {
    background: #8dc8c9;
  }

  #driver-management-search-bar {
    width: 100%;
    height: 2.2rem;
    display: flex;
    position: relative;
    max-width: 30rem;
  }

  #driver-management-search-bar input {
    width: 100%;
    height: 100%;
    outline: none;
    border: none;
    background: #bed8d99a;
    margin: 0;
    border-radius: 1.075rem;
    padding-left: 1rem;
    padding-right: 2.2rem;
    transition: all .1s ease-in-out;
  }

  #driver-management-search-bar input:focus {
    background: #e4e4e4;
    outline: 1px solid #002f4965;
  }

  #driver-management-search-bar .search-btn {
    background: #003049;
    height: 100%;
    width: 2.15rem;
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
    border-radius: 1.075rem;
    position: absolute;
    right: 0rem;
    cursor: pointer;
    transition: all .1s ease-in-out;
  }

  #driver-management-search-bar .search-btn:hover {
    background: #002f49bf;
  }

  .editable-img {
    position: relative;
  }

  .editable-img .icon {
    color: white;
    background: #7b8787;
    padding: .22rem .38rem;
    border-radius: .5rem;
    position: absolute;
    right: 0;
    bottom: 0;
    transition: all .1s ease-in-out;
    cursor: pointer;
  }

  .editable-img .icon:hover {
    background: #8e9c9c;
  }

  .input-group .title {
    width: 100%;
    font-size: .9rem;
    color: #003049;
  }

  .input-group input {
    border: 1px solid rgba(178, 178, 178, 0.567);
    background: #ececec;
    border-radius: .4rem !important;
    width: 100%;
    padding-left: .5rem;
    padding-top: .3rem;
    padding-bottom: .3rem;
  }

  .input-group input:focus {
    border: 1px solid rgb(166, 166, 166);
    background: white;
  }
</style>

<div class="container-fluid w-100 h-100 p-4 d-flex justify-content-center align-items-center"
     style="gap: 2rem; flex-wrap: wrap;">

  <button class="card card-extra top-node d-flex flex-column align-items-center py-3"
          style="max-width: 10rem; height: 8rem;" data-bs-toggle="offcanvas" href="#driver-reg-pending-offcanvas">
    <i class="bi bi-person-plus-fill fs-1"></i>
    <div class="text-center fw-semibold">Driver Registration <br> Pending Requests</div>
  </button>
  <button class="card card-extra d-flex flex-column align-items-center py-3"
          style="max-width: 10rem; height: 8rem;" data-bs-toggle="offcanvas" href="#driver-management-offcanvas">
    <i class="bi bi-person-lines-fill fs-1"></i>
    <div class="text-center fw-semibold">Driver Management</div>
  </button>

</div>

<!-- ------------------------------------------------------------ -->

<div class="offcanvas offcanvas-start vw-100" tabindex="-1" id="driver-reg-pending-offcanvas"
     aria-labelledby="offcanvasExampleLabel">
  <div class="offcanvas-header">
    <i class="px-1"></i>
    <div class="text-white px-2 py-1 rounded-pill" style="background: #003049;">
      <i class="text-center rounded-pill bi bi-person-plus-fill m-0"
         style="padding: .2rem .4rem; background: #d62828;"></i>
      <h5 class="offcanvas-title d-inline-block ms-1" id="offcanvasExampleLabel1">Pending Registrations</h5>
    </div>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>

  <div class="offcanvas-body">
    <div class="w-100 h-100 p-1 d-flex flex-column align-items-center" style="overflow-y: auto;">

      <div class="card p-2 w-100 shadow" style="max-width: 50rem; min-width: 20rem;">
        <div class="d-flex flex-row align-items-center">
          <img class="img-thumbnail rounded-circle shadow" style="width: 8rem; height: 8rem"
               src="https://expertphotography.b-cdn.net/wp-content/uploads/2020/08/social-media-profile-photos.jpg">
          <div class="ms-3 me-1">
            <h5>Andee Munn</h5>
            <p class="m-0 p-0" style="font-size: .9rem;">
              <span class="birth-date">Jun 12, 2000</span>
              (<span class="age">22</span> years)
            <p>
            <div class="m-0 p-0">
              <span class="fw-semibold">Citizen ID:</span>
              <span>123456789012</span>
            </div>
          </div>
          <div style="flex-grow: 1;">
            <button class="btn btn-info rounded-pill fw-semibold float-end" data-bs-toggle="collapse"
                    href="#collapseExample" role="button" aria-expanded="false"
                    aria-controls="collapseExample">Details</button>
          </div>
        </div>

        <div class="collapse mt-2" id="collapseExample">
          <div class="card card-body">
            <div class="m-0 p-0">
              <span class="fw-semibold">Phone number:</span>
              <span>0123445666</span>
            </div>
            <div class="m-0 p-0">
              <span class="fw-semibold">Applied date:</span>
              <span>JUN 12, 2022</span>
            </div>
            <div class="m-0 p-0">
              <span class="fw-semibold">Address:</span>
              <span>123456789012</span>
            </div>
            <div class="m-0 p-0 text-wrap">
              <span class="fw-semibold">Message:</span>
              <span>sakjdbksbfksjdbf</span>
            </div>
            <button class="mt-3 btn btn-info fw-semibold rounded-pill">Confirm This
              Registration</button>
            <div class="text-danger text-center" style="font-size: 0.9rem;">*Password will be
              automatically generated and will be
              sent to driver</div>
          </div>
        </div>
      </div>

    </div>
  </div>
</div>

<!-- ----------------------------------   -->
<div class="offcanvas offcanvas-start vw-100 show" tabindex="-1" id="driver-management-offcanvas"
     aria-labelledby="offcanvasExampleLabel">
  <div class="offcanvas-header">
    <i class="px-1"></i>
    <div class="text-white px-2 py-1 rounded-pill" style="background: #003049;">
      <i class="text-center rounded-pill bi bi-person-plus-fill m-0"
         style="padding: .2rem .4rem; background: #d62828;"></i>
      <h5 class="offcanvas-title d-inline-block ms-1" id="offcanvasExampleLabel">Driver Management</h5>
    </div>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>

  <div class="offcanvas-body">
    <div class="w-100 h-100 p-1 d-flex flex-column align-items-center" style="overflow-y: auto;">

      <div id="driver-management-search-bar">
        <input>
        <i class="search-btn bi bi-search"></i>
      </div>

      <div class="mt-4" style="overflow-x: auto;">
        <table class="table">
          <thead>
          <tr style="cursor: pointer;">
            <th onclick="sortTable(this, 0)">ID</th>
            <th onclick="sortTable(this, 1)">First name</th>
            <th onclick="sortTable(this, 2)">Last name</th>
            <th onclick="sortTable(this, 3)">Phone number</th>
            <th onclick="sortTable(this, 4)">Citizen ID</th>
            <th></th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>1</td>
            <td>Maria Anders</td>
            <td>Germany</td>
            <td>0123456545</td>
            <td>fdojgndkfg</td>
            <td>
              <button class="btn btn-danger" data-bs-toggle="modal"
                      data-bs-target="#driver-management-modal">More</button>
            </td>
          </tr>
          <tr>
            <td>2</td>
            <td>Francisco Chang</td>
            <td>Mexico</td>
            <td>0372738473</td>
            <td>fdojgndkfg</td>
            <td>
              <button class="btn btn-danger">More</button>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div>
        <button class="btn btn-info rounded-pill fw-semibold mt-2">Load More</button>
      </div>

    </div>


  </div>
</div>

<!-- ------------------------------------- -->
<!-- ----------------------------------=- -->
<!-- Modal -->
<div class="modal fade" id="driver-management-modal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">

      <div class="modal-body d-flex justify-content-center flex-column">

        <div class="d-flex justify-content-center">
          <div class="editable-img">
            <i class="icon bi bi-pencil-fill"
               onclick="document.querySelector('#driver-avatar-uploader').click()"></i>
            <img class="img-thumbnail shadow rounded-circle" style="width: 5rem; height: 5rem"
                 src="https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8cHJvZmlsZXxlbnwwfHwwfHw%3D&w=1000&q=80">
            <input id="driver-avatar-uploader" type="file" class="d-none">
          </div>
        </div>

        <div class="input-group w-100">
          <div class="title">First name</div>
          <input type="text" value="7474" />
        </div>

        <div class="input-group w-100 mt-2">
          <div class="title">Last name</div>
          <input type="text" value="7474" />
        </div>

        <div class="input-group w-100 mt-2">
          <div class="title">Citizen ID</div>
          <input type="text" value="7474" />
        </div>

        <div class="input-group w-100 mt-2">
          <div class="title">Date of birth</div>
          <input type="datetime" value="7474" />
        </div>

        <div class="input-group w-100 mt-2">
          <div class="title">Phone number</div>
          <input type="text" value="7474" />
        </div>

      </div>

      <div class="modal-footer p-1">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Remove</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>

    </div>
  </div>
</div>

<!-- ------------------------------------- -->
</body>

</html>
