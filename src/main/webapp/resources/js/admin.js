const BTM_NAV = document.querySelector('#bottom-nav')
const IFRAME = document.querySelector('#tab-iframe')
const TAB_DRIVER = 2
const TAB_USER = 1

function assignEventListeners() {
    const endpoint = document.querySelector('#endpoint').dataset.endpoint

    for (let i = 0; i < BTM_NAV.children.length; i++) {
        const child = BTM_NAV.children[i]
        child.onclick = () => {
            navItemClicked(child)
            tabClicked(child, endpoint)
        }
    }
}

assignEventListeners()

function navItemClicked(a) {
    if (!a.classList.contains('active'))
        a.classList.add('active')

    for (let i = 0; i < BTM_NAV.children.length; i++) {
        const child = BTM_NAV.children[i]
        if (child !== a)
            child.classList.remove('active')
    }
}

function tabClicked(div , endpoint) {
    const { tabIndex } = div.dataset
    if (tabIndex) {

        if (tabIndex == TAB_DRIVER) {
            IFRAME.src = endpoint + "/app/admin-driver-3249738HJVHSG87629GCUYC987"
        }

    } else
        throw "No tab index data specified"
}

