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

function tab_clicked(button) {
    const tab_index = button.dataset.tabIndex
    const tab_body = button.parentNode.parentNode.querySelector('.modal-tab-body')
    const tabs = tab_body.querySelectorAll('.modal-tab-content')

    tabs[tab_index].classList.remove('d-none')

    for(let tab of tabs)
        if(tab !== tabs[tab_index] && !tab.classList.contains('d-none'))
            tab.classList.add('d-none')
}

function displayDetailsModal(button, endpoint) {
    const modal = document.querySelector('#mainPostDetailsModal')
    const postId = button.dataset.postId
    endpoint += postId

    const img_container = document.querySelector('#mainPostDetailsModal #modal-img-container')
    const created_date = document.querySelector('#mainPostDetailsModal #modal-post-created')
    const p_loc = document.querySelector('#mainPostDetailsModal #modal-pickup-loc')
    const d_loc = document.querySelector('#mainPostDetailsModal #modal-dropoff-loc')
    const r_name = document.querySelector('#mainPostDetailsModal #modal-rep-name')
    const r_phone = document.querySelector('#mainPostDetailsModal #modal-rep-phone')
    const content = document.querySelector('#mainPostDetailsModal #modal-post-content')

    img_container.innerHTML = "";
    created_date.innerHTML = "";
    p_loc.innerHTML = "";
    d_loc.innerHTML = "";
    r_name.innerHTML = "";
    r_phone.innerHTML = "";
    content.innerHTML = "";


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
}