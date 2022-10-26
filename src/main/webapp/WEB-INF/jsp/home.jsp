<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="main">
    <section class="top-sect" style="background-image: url('<c:url value="/img/home_bg.jpg"/>');">
        <div class="w-100 text-center m-2" id="search-bar-title">Track your package</div>
        <div class="w-100">
            <form class="search-bar" action="" method="post">
                <div class="input-holder">
                    <input type="text" class="search-input" placeholder="Type to search" />
                    <button class="search-icon" onclick="activateSearch(event)" data-bs-toggle="modal" data-bs-target="#tracking-modal">
                        <span></span>
                    </button>
                </div>
                <span class="close" onclick="deactivateSearch()"></span>
            </form>
        </div>
    </section>

    <div style="height: 200vh;"></div>
</div>

<script async src="<c:url value="/js/homePage.js"/>"></script>