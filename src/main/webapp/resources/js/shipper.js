function closeModal() {
    const modal = document.querySelector('#mainPostModal')
    modal.classList.remove('d-block', 'show')
}

// function openModal() {
//     const modal = document.querySelector('#mainPostModal')
//     if (!modal.classList.contains('d-block'))
//         modal.classList.add('d-block')
//     if (!modal.classList.contains('show'))
//         modal.classList.add('show')
// }

function displayDetailsModal(button, endpoint, type) {
    const modal = document.querySelector('#mainPostModal')
    const postId = button.dataset.postId
    endpoint += postId

    const img_container = document.querySelector('#mainPostModal #img-container')
    // const created_date = document.querySelector('#mainPostModal #modal-post-created')
    const s_name = document.querySelector('#mainPostModal #sender-name')
    const s_phone = document.querySelector('#mainPostModal #sender-phone')
    const p_loc = document.querySelector('#mainPostModal #sender-address')

    const r_name = document.querySelector('#mainPostModal #receiver-name')
    const r_phone = document.querySelector('#mainPostModal #receiver-phone')
    const d_loc = document.querySelector('#mainPostModal #receiver-address')

    const category = document.querySelector('#mainPostModal #cat-name')

    img_container.innerHTML = "";
    // created_date.innerHTML = "";
    p_loc.innerHTML = "";
    d_loc.innerHTML = "";
    r_name.innerHTML = "";
    r_phone.innerHTML = "";
    category.innerHTML = "";
    s_name.innerHTML = ""
    s_phone.innerHTML = ""


    fetchPost(endpoint)
        .then(data => {
            if (data) {
                for (let url of data.img_list) {
                    img_container.innerHTML += `<img src="${url}" class="rounded-2" style="width: 4rem; height: 4rem;"/>`
                }
                s_name.innerHTML = data.sname
                s_phone.innerHTML = data.sphone
                p_loc.innerHTML = data.pickup_loc

                r_name.innerHTML = data.rname
                r_phone.innerHTML = data.rphone
                d_loc.innerHTML = data.dropoff_loc

                category.innerHTML = data.cat_name
                modal.setAttribute("data-postId", postId)

                doDisplayDetailsModal(modal, type)
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

function doDisplayDetailsModal(modal, type) {
    if (!modal.classList.contains('d-block'))
        modal.classList.add('d-block')
    if (!modal.classList.contains('show'))
        modal.classList.add('show')

    const group_set_fee = modal.querySelector('#group-set-fee')
    const group_confirm_delivering = modal.querySelector('#group-confirm-finish')

    group_set_fee.classList.remove('d-none')
    if (!group_confirm_delivering.classList.contains('d-none'))
        group_confirm_delivering.classList.add('d-none')

    if (type == 'pending') {
        group_set_fee.setAttribute('disabled', '')
    } else if (type == 'history') {
        if (!group_set_fee.classList.contains('d-none'))
            group_set_fee.classList.add('d-none')
        group_confirm_delivering.classList.remove('d-none')
    }
}

// function closeDetailsModal() {
//     const modal = document.querySelector('#mainPostDetailsModal')
//     modal.classList.remove('show')
//     modal.style.display = 'none'
// }

function addPostAuction(endpoint) {
    const modal = document.querySelector('#mainPostModal')
    const modal_footer = modal.querySelector('.modal-footer')
    const user_phone = document.querySelector("#current_user_phone_number").dataset.currentUserPhone

    const postId = modal.dataset.postId
    const fee = modal_footer.querySelector('.input-group .form-control').value

    const upload_obj = {
        shipper_phone: user_phone,
        post_id: postId,
        fee
    }

    // call api
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify(upload_obj);

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    fetch(endpoint + "/add-post-auction", requestOptions)
        .then(response => response.json())
        .then(data => {
            if (data.successful) {
                //2343534583459863459693568359935395683598695685935693
            } else {

            }
        })
        .catch(error => {
            console.error(error)
        })

}

function confirmFinishDelivering(endpoint) {
    const modal = document.querySelector('#mainPostModal')
    const postId = modal.dataset.postId

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "post-id" : postId
    });

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    fetch(endpoint + "/confirm-finish-delivering", requestOptions)
        .then(res => {
            if (res.status == 200) {

            } else {

            }
        })
        .catch(err => {
            console.error(err)
        })
}