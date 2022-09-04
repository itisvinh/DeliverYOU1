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

displayAddPostModal()