function activateSearch(event) {
    const search_bar = document.querySelector('form.search-bar')
    if (!search_bar.classList.contains('active')) {
        search_bar.classList.add('active')
        event.preventDefault()
        document.querySelector('#search-bar-title').style.display = 'none'
    }
}

function deactivateSearch() {
    const search_bar = document.querySelector('form.search-bar')
    search_bar.classList.remove('active')
    document.querySelector('form .search-input').value = ''
    document.querySelector('#search-bar-title').style.display = 'block'
}


function classSelectorOf(element, includingTag = false) {
    let sel = includingTag ? element.tagName.toLowerCase() : ''
    element.classList.forEach((val, index, array) => sel += '.' + val)
    return sel
}

function idSelectorOf(element, includingTag = false) {
    return (includingTag ? element.tagName.toLowerCase() : '') + '#' + element.id
}

function showTrackingModal() {
    const input = document.querySelector('input#tracking-search-field')
    const id = input.value.trim()
    buildTrackingGlimpse(id)
    return false;
}

function displayTrackingModal() {
    const modal = document.querySelector('#tracking-modal')
    new bootstrap.Modal(modal, {}).show()
}

function buildTrackingGlimpse(id) {
    const endpoint = document.querySelector('#endpoint').dataset.endpoint
    const modal = document.querySelector('#tracking-modal')
    const content_gr_1 = modal.querySelector('.content-group-1')
    const content_gr_2 = modal.querySelector('.content-group-2')

    Fetch.build().method(Fetch.METHOD_POST).fetch(endpoint + `public/api/get-tracking/${id}`)
        .then(response => {
            if (response.status === 200)
                return response.json()

            if (content_gr_1.classList.contains("d-none"))
                content_gr_1.classList.remove('d-none')

            if (!content_gr_2.classList.contains("d-none"))
                content_gr_2.classList.add('d-none')

            return { 'error': 'error' }
        })
        .then(data => {
            console.log('data', data)
            if (data.error) {
                alert('Package is neither existent nor assigned to a driver')
                return
            } else {
                const pick_up_loc = modal.querySelector('#pu-loc')
                const fee = modal.querySelector('#d-fee')
                const status = modal.querySelector('#d-status')

                if (!content_gr_1.classList.contains("d-none"))
                    content_gr_1.classList.add('d-none')

                if (content_gr_2.classList.contains("d-none"))
                    content_gr_2.classList.remove('d-none')

                pick_up_loc.innerHTML = data.receiver_address.district + ', ' + data.receiver_address.province
                fee.innerHTML = data.fee
                switch (data.status.toUpperCase()) {
                    case 'ONGOING':
                        status.innerHTML = 'The package is being delivered'
                        break
                    case 'CANCELED':
                        status.innerHTML = 'The package was canceled'
                        break
                    case 'DELIVERED':
                        status.innerHTML = 'The package was delivered'
                        break
                }
                displayTrackingModal()
            }
        })
        .catch(error => {
            console.error(error)
            alert("Error has occurred")
        })
}


