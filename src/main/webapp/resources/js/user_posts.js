function displayAddPostModal(event) {
    const modal = window.parent.document.getElementById('main-modal')
    modal.style.display = 'block'
    modal.classList.toggle('show')
    const modal_content = modal.querySelector('.modal-content')
    modal_content.innerHTML = document.querySelector('.add-post-modal-content').innerHTML

}