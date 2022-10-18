function displayAddPostModal(event) {
    const modal = window.parent.document.getElementById('main-modal')
    modal.style.display = 'block'
    modal.classList.toggle('show')
    const modal_content = modal.querySelector('.modal-content')
    const script = modal_content.querySelector('.script')
    const content = modal_content.querySelector('.content')
    // load js dynamically, and run script only once
    // if (script.children.length === 0) {
    //     let scriptEle = document.createElement("script")
    //     scriptEle.setAttribute("type", "text/javascript")
    //     scriptEle.setAttribute("src", jsURL)
    //     scriptEle.defer = true
    //     script.appendChild(scriptEle)
    // }

    content.innerHTML = ''

    const add_post_modal_content = document.querySelector('.add-post-modal-content')
    content.innerHTML += add_post_modal_content.innerHTML
}

// -------------------------------------
let loadPostAuctionInterval = null
let totalPostAuctions = -1

function tab_clicked(button, endpoint) {
    const modal = document.querySelector("#mainPostDetailsModal")
    const postId = modal.dataset.currentPostId
    const tab_index = button.dataset.tabIndex

    if (loadPostAuctionInterval) {
        clearInterval(loadPostAuctionInterval)
        console.log("interval is cleared[1]")
    }
    if (tab_index == 1) {
        displayPostAuctions(endpoint)
        console.log("interval is set")
        loadPostAuctionInterval = setInterval( () => {
            loadPostAuctionIntervalFunction(endpoint, postId)
            console.log("interval is fired")
        }, 4000)
    }

    // make sel tab title BOLD
    button.classList.toggle("fw-bold")
    const other_button = button.parentNode.querySelectorAll(`button:not([data-tab-index="${tab_index}"])`)
    for (let ob of other_button) {
        ob.classList.toggle("fw-bold")
    }

    const tab_body = button.parentNode.parentNode.querySelector('.modal-tab-body')
    const tabs = tab_body.querySelectorAll('.modal-tab-content')

    tabs[tab_index].classList.remove('d-none')

    for(let tab of tabs)
        if(tab !== tabs[tab_index] && !tab.classList.contains('d-none'))
            tab.classList.add('d-none')
}

function loadPostAuctionIntervalFunction(endpoint, postId) {
    fetchTotalNumberOfPostAuctions(endpoint, postId)
        .then(data => {
            if (data) {
                if (totalPostAuctions !== data.total) {
                    totalPostAuctions = data.total
                    displayPostAuctions(endpoint)
                }
            }
        })
}

async function fetchTotalNumberOfPostAuctions(endpoint, postId) {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "post-id": postId
    });

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    return fetch(endpoint + "/get-total-post-auctions-of", requestOptions)
        .then(response => response.json())
        .then(result => result)
        .catch(error => {
            console.error('error', error)
            return undefined
        });
}

async function performChoosingDriver(data, endpoint) {
    const myHeaders = new Headers();

    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "shipper-id": data.shipperId,
        "post-id": data.postId
    });

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    return fetch(endpoint + '/accept-post-auction', requestOptions)
        .then(res => {
            return (res.status == 200)
        })
        .catch(err => {
            console.error(err)
            return false
        })
}

function chooseDriver(button, endpoint) {
    let parent = button.parentNode

    while (!parent.classList.contains('card-post-auction')) {
        parent = parent.parentNode
    }

    const { shipperId, postId } = parent.dataset
    performChoosingDriver({ shipperId, postId }, endpoint)
        .then(result => {
            if (result) {

            } else {

            }
        })
}

function displayPostAuction(container, postAuction, endpoint) {
    let cardId = 'card-post-auction-' + Math.ceil(Math.random() * 10000) + new Date().getTime()
    container.innerHTML +=
        `
        <div id="${cardId}" class="card-post-auction card rounded-3 p-2 d-flex flex-row" style="align-items: center; box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;">
            <img src="..."
                 class="shipper-avatar rounded-circle img-thumbnail me-3 shadow" style="width: 4rem; height: 4rem;"/>
            <div class="d-flex flex-column w-100" style="gap: .2rem;">
                <h6 class="shipper-name m-0 ms-1"></h6>
                <div class="shipper-delivery-fee ms-1"></div>
                <button type="button" onclick="chooseDriver(this, ${endpoint})" class="w-100 btn btn-info rounded-pill text-white p-0">Choose this driver</button>
            </div>
         </div>
        `

    const card = container.querySelector('#' + cardId)

    const avatar = card.querySelector('.shipper-avatar')
    const name = card.querySelector('.shipper-name')
    const fee = card.querySelector('.shipper-delivery-fee')

    const {postId, shipperId, shippingFee, requestedTime, shipperAvatar, shipperName} = postAuction

    avatar.src = shipperAvatar
    name.innerHTML = shipperName
    fee.innerHTML = shippingFee

    card.dataset.shipperId = shipperId
    card.dataset.postId = postId
    card.dataset.requestedTime = requestedTime
}

function displayPostAuctions(endpoint) {
    const postId = document.querySelector('#mainPostDetailsModal').dataset.currentPostId
    const postAuctionsContent = document.querySelector('#modal-tab-auctions .modal-tab-auctions-content')

    fetchPostAuctions(endpoint, postId)
        .then(data => {
            if (data) {
                postAuctionsContent.innerHTML = ''
                console.log("[DATA]:: " + data)
                for (let p of data) {
                    displayPostAuction(postAuctionsContent, p, endpoint)
                }
            } else {
                console.error("[FETCH ERROR] Post Auctions")
            }
        })
}

async function fetchPostAuctions(endpoint, postId) {
    const myHeaders = new Headers();

    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "post-id": postId
    });

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    return fetch(endpoint + "/get-post-auctions", requestOptions)
        .then(response => response.json())
        .then(list => list)
        .catch(error => {
            console.error('error', error)
            return undefined
        });
}

function displayDetailsModal(button, endpoint) {
    const modal = document.querySelector('#mainPostDetailsModal')
    const postId = button.dataset.postId
    endpoint += postId
    modal.dataset.currentPostId = postId

    const img_container = document.querySelector('#mainPostDetailsModal #modal-img-container')
    const created_date = document.querySelector('#mainPostDetailsModal #modal-post-created')
    const p_loc = document.querySelector('#mainPostDetailsModal #modal-pickup-loc')
    const d_loc = document.querySelector('#mainPostDetailsModal #modal-dropoff-loc')
    const r_name = document.querySelector('#mainPostDetailsModal #modal-rep-name')
    const r_phone = document.querySelector('#mainPostDetailsModal #modal-rep-phone')
    const content = document.querySelector('#mainPostDetailsModal #modal-post-content')
    const auctions_tab = document.querySelector('#modal-tab-auctions .modal-tab-auctions-content')

    img_container.innerHTML = "";
    created_date.innerHTML = "";
    p_loc.innerHTML = "";
    d_loc.innerHTML = "";
    r_name.innerHTML = "";
    r_phone.innerHTML = "";
    content.innerHTML = "";
    auctions_tab.innerHTML = ''


    fetchPost(endpoint)
        .then(data => {
            if (data) {
                for (let url of data.img_list) {
                    img_container.innerHTML += `<img src="${url}" class="rounded-2" style="width: 4rem; height: 4rem;"/>`
                }
                created_date.innerHTML = data.post_created
                p_loc.innerHTML = data.pickup_loc
                d_loc.innerHTML = data.dropoff_loc
                r_name.innerHTML = data.rname
                r_phone.innerHTML = data.rphone
                content.innerHTML = data.content.trim().length > 0 ? data.content : '[No Content]'
                doDisplayDetailsModal(modal)
            }
        })
}

async function fetchPost(endpoint) {
    return fetch(endpoint)
        .then(res => res.json())
        .then(data => data)
        .catch(reason => {
            console.error(reason)
            return undefined
        })
}

function doDisplayDetailsModal(modal) {
    if (!modal.classList.contains('show'))
        modal.classList.add('show')
    modal.style.display = 'block'
}

function closeDetailsModal() {
    const modal = document.querySelector('#mainPostDetailsModal')
    modal.classList.remove('show')
    modal.style.display = 'none'
    if (loadPostAuctionInterval) {
        clearInterval(loadPostAuctionInterval)
        totalPostAuctions = -1
        console.log("interval is cleared")
    }
}