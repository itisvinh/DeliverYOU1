<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html class="w-100 h-100">

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <style>

        body .card {
            height: auto;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            border: none;
        }

        .card>img {
            object-fit: cover;
            width: 6rem;
            height: 6rem;
        }

        .stars-container {
            width: 100%;
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            gap: 1rem;
        }

        .stars-container .star {
            font-size: 1.5rem;
        }

        .card textarea {
            margin-top: 1rem;
            width: 100%;
            max-width: 30rem;
            border-radius: .3rem;
            padding: .3rem;
            border: none;
            background-color: rgba(213, 213, 213, 0.75);
            height: 5rem;
            min-height: 2.2rem;
            max-height: 10rem;
        }

        .card textarea:focus {
            outline: 2px solid rgba(35, 122, 198, 0.64);
            background-color: white;
        }

        .card button {
            max-width: 30rem;
        }

        ::-webkit-scrollbar {
            width: .5rem;
        }

        /* Track */
        ::-webkit-scrollbar-track {
            background: rgba(213, 213, 213, 0.75);
        }

        /* Handle */
        ::-webkit-scrollbar-thumb {
            background: rgba(136, 136, 136, 0.714);
            border-radius: .5rem;
        }

        /* Handle on hover */
        ::-webkit-scrollbar-thumb:hover {
            background: rgba(85, 85, 85, 0.727);
        }
    </style>
</head>

<body>
<main>
    <div class="card p-2">
        <img class="img-thumbnail shadow rounded-circle"
             src="https://media.istockphoto.com/photos/headshot-portrait-of-smiling-male-employee-in-office-picture-id1309328823?b=1&k=20&m=1309328823&s=170667a&w=0&h=a-f8vR5TDFnkMY5poQXfQhDSnK1iImIfgVTVpFZi_KU=">
        <p class="fw-semibold fs-5 mb-2">
            Keith Miller
        </p>
        <div class="stars-container">
            <i class="star bi bi-star"></i>
            <i class="star bi bi-star"></i>
            <i class="star bi bi-star"></i>
            <i class="star bi bi-star"></i>
            <i class="star bi bi-star"></i>
        </div>
        <textarea id="comment" placeholder="Share your thought?"></textarea>
        <button class="btn w-100 btn-primary mt-2 text-white fw-semibold" onclick="performRate()">RATE</button>
    </div>
</main>

<script defer>
    let RATED_STAR = 0
    const container = document.querySelector('.stars-container')
    for (let item of container.children) {
        item.addEventListener('mouseenter', () => starEnter(item))
        item.addEventListener('mouseleave', starLeave)
        item.addEventListener('click', () => starClick(item))
    }

    function starEnter(star) {
        const children = container.children

        for (let i = 0; i < children.length; i++) {
            if (children[i].classList.contains('bi-star')) {
                children[i].classList.replace('bi-star', 'bi-star-fill')
                children[i].style.color = 'rgb(227, 171, 74)'
            }
            if (children[i] === star)
                return i
        }
        return -1
    }

    function resetStar(item) {
        if (item.classList.contains('bi-star-fill')) {
            item.classList.replace('bi-star-fill', 'bi-star')
            item.style.color = 'black'
        }
    }

    function starLeave() {
        for (let item of container.children)
            resetStar(item)
    }

    function starClick(star) {
        const index = starEnter(star)
        RATED_STAR = index + 1
        const children = container.children

        for (let item of container.children)
            item.removeEventListener('mouseleave', starLeave)

        for (let i = index + 1; i < children.length; i++) {
            resetStar(children[i])
            children[i].addEventListener('mouseleave', starLeave)
        }
    }

    function performRate() {
        if (RATED_STAR <= 0) {
            console.error("rate your shipper")
        } else {
            const comment = document.querySelector('#comment').value.replace(/\s+/gm, ' ')
            console.log('rated: ', RATED_STAR)
            console.log('comment: ', comment)
        }
    }
</script>
</body>

</html>