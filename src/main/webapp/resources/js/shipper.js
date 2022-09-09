function closeModal() {
    const modal = document.querySelector('#mainPostModal')
    modal.classList.remove('d-block', 'show')
}

function openModal() {
    const modal = document.querySelector('#mainPostModal')
    if (!modal.classList.contains('d-block'))
        modal.classList.add('d-block')
    if (!modal.classList.contains('show'))
        modal.classList.add('show')
}