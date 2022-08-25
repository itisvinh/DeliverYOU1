let previous_active_nav_item = document.querySelector('.side-bar .nav .default-active > a')

function performToggle(element) {
    element.classList.toggle('open')

    const sidebar = document.querySelector('#main-side-nav')
    if (sidebar.classList.contains('collapsed'))
        sidebar.classList.remove('collapsed')
    else
        sidebar.classList.add('collapsed')
}

function selectNavItem(item) {
    previous_active_nav_item.classList.remove('active')
    previous_active_nav_item = item.querySelector('a')
    previous_active_nav_item.classList.add('active')
}

// recently added
function closeModal(event) {
    if (event.target !== document.querySelector('#main-modal')) {
        return false
    }

    const modal = document.querySelector('#main-modal')
    modal.style.display = 'none'
    modal.classList.toggle('show')
}