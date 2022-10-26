let BTM_NAV = null

function getBottomNav() {
    const nav = parent.document.querySelector('#bottom-nav')

    if (nav) {
        BTM_NAV = nav
        return nav
    } else
        throw 'Failed to get bottom nav'
}

getBottomNav()

function assignBottomPaddingNav() {
    if (BTM_NAV) {
        let b = document.querySelectorAll('.offcanvas .offcanvas-body')

        for (let i of b) {
            i.style.paddingBottom = BTM_NAV.offsetHeight / 16 + 'rem'
            console.log(i, i.style.paddingBottom)
        }
    } else
        throw 'Bottom nav is null: cannot get height'
}

assignBottomPaddingNav()

// -------------------------

function sortTable(th, n) {
    let table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;

    table = th
    while (table.tagName != 'TABLE')
        table = table.parentNode

    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount++;
        } else {
            /* If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again. */
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function showToast(msg, isDanger) {
    if (!LIVE_TOAST.classList.contains('text-bg-primary'))
        LIVE_TOAST.classList.add('text-bg-primary')
    LIVE_TOAST.classList.remove('text-bg-danger')

    if (isDanger) {
        LIVE_TOAST.classList.remove('text-bg-primary')
        LIVE_TOAST.classList.add('text-bg-danger')
    }

    LIVE_TOAST.querySelector('.toast-body').innerHTML = msg
    new bootstrap.Toast(LIVE_TOAST).show()
}

let START_INDEX_DRIVER = 0
const MAX_RESULT_DRIVER = 2
const DRIVER_LIST_OFFCANVAS = document.querySelector('#driver-management-offcanvas')
const DRIVER_DETAIL_MODAL = document.querySelector("#driver-management-modal")
const LIVE_TOAST = document.querySelector('#live-toast')
const ENDPOINT = document.querySelector('#endpoint').dataset.endpoint

function iniDriverLoad() {
    DRIVER_LIST_OFFCANVAS.querySelector('.offcanvas-body .table tbody').innerHTML = ''
    getDrivers()
}

iniDriverLoad()

function getDrivers() {
    const endpoint = document.querySelector('#endpoint').dataset.endpoint + '/api/get-drivers'
    const tbody = DRIVER_LIST_OFFCANVAS.querySelector('.offcanvas-body .table tbody')


    fetchDrivers(endpoint)
        .then(array => {
            if (array) {
                for (let i = 0; i < array.length; i++) {
                    const list = array[i]
                    tbody.innerHTML +=
                        `
                        <tr class="d_row" data-avatar="${list.avatar}" data-email="${list.email} data-address="${list.address}" data-deleted=${list.deleted} >
                            <td>${list.id}</td>
                            <td>${list.firstname}</td>
                            <td>${list.lastname}</td>
                            <td>${list.phoneNumber}</td>
                            <td>${list.citizenId}</td>
                            <td>
                                <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#driver-management-modal">More</button>
                            </td>
                        </tr>
                        `;
                    tbody.children[tbody.children.length - 1].querySelector('button[data-bs-toggle="modal"]').onmousedown = () => populateDriverDetailsModal(list)
                }
                START_INDEX_DRIVER += array.length
            }
        })
}

function populateDriverDetailsModal(list) {
    const fname = DRIVER_DETAIL_MODAL.querySelector('#driver-fname')
    const lname = DRIVER_DETAIL_MODAL.querySelector('#driver-lname')
    const avatar = DRIVER_DETAIL_MODAL.querySelector('#driver-avatar')
    const citizen_id = DRIVER_DETAIL_MODAL.querySelector('#driver-citizen-id')
    const email = DRIVER_DETAIL_MODAL.querySelector('#driver-email')
    const phone = DRIVER_DETAIL_MODAL.querySelector('#driver-phone')
    const driver_id = DRIVER_DETAIL_MODAL.querySelector('#modal-driver-id')

    fname.value = fname.dataset.content = list.firstname
    lname.value = lname.dataset.content = list.lastname
    citizen_id.value = citizen_id.dataset.content = list.citizenId
    email.value = email.dataset.content = list.email
    phone.value = phone.dataset.content = list.phoneNumber
    avatar.src = avatar.dataset.content = list.avatar
    driver_id.dataset.id = list.id
}

async function fetchDrivers(endpoint) {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "start_index": START_INDEX_DRIVER,
        "max_results": MAX_RESULT_DRIVER
    });

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    return fetch(endpoint, requestOptions)
        .then(response => response.json())
        .then(result => {
            console.log('result', result)
            return result.list.length > 0 ? result.list : undefined
        })
        .catch(error => {
            console.log('error', error)
            return undefined
        });
}

async function saveChanges() {
    const fname = DRIVER_DETAIL_MODAL.querySelector('#driver-fname')
    const lname = DRIVER_DETAIL_MODAL.querySelector('#driver-lname')
    const avatar = DRIVER_DETAIL_MODAL.querySelector('#driver-avatar')
    const avatar_uploader = DRIVER_DETAIL_MODAL.querySelector('#driver-avatar-uploader')
    const citizen_id = DRIVER_DETAIL_MODAL.querySelector('#driver-citizen-id')
    const email = DRIVER_DETAIL_MODAL.querySelector('#driver-email')
    const phone = DRIVER_DETAIL_MODAL.querySelector('#driver-phone')
    const driver_id = DRIVER_DETAIL_MODAL.querySelector('#modal-driver-id').dataset.id
    const changes = {id: driver_id}
    const elements_w_changes = []

    if (detectChange(avatar, true)) {
        const file = avatar_uploader.files[0]
        if (file) {
            try {
                changes.avatar = await Base64Converter.toBase64(file)
                elements_w_changes.push(avatar)
            } catch (error) {
                console.error(error)
                showToast("Error occurred when encoding profile picture", true)
            }
        }
    }

    if (detectChange(fname)) {
        changes.firstname = fname.value
        elements_w_changes.push(fname)
    }
    if (detectChange(lname)) {
        changes.lastname = lname.value
        elements_w_changes.push(lname)
    }
    if (detectChange(citizen_id)) {
        changes.citizenId = citizen_id.value
        elements_w_changes.push(citizen_id)
    }
    if (detectChange(email)) {
        changes.email = email.value
        elements_w_changes.push(email)
    }
    if (detectChange(phone)) {
        changes.phoneNumber = phone.value
        elements_w_changes.push(phone)
    }

    if (Object.keys(changes).length > 1) {
        updateDriver(changes)
            .then(status => {
                if (status === 200) {
                    showToast("Changes detected and saved")

                    for (let i of elements_w_changes) {
                        if (i.tagName === "IMG")
                            persistChange(i, true)
                        else
                            persistChange(i)
                    }
                } else
                    showToast("Failed to update driver's information")
            })
            .catch(error => {
                console.error(error)
                showToast("Exception occurred", true)
            })
    } else
        showToast('No changes are made')

}

async function updateDriver(changes) {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify(changes);

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    return fetch(ENDPOINT + '/api/update-user/driver', requestOptions)
        .then(res => res.status)
}

function detectChange(element, isIMG) {
    if (element) {
        if (isIMG)
            return element.dataset.content !== element.src
        else {
            element.value = element.value.replace(/\s+/gm, ' ').trim()
            return element.dataset.content.replace(/\s+/gm, ' ').trim() !== element.value
        }
    }
    throw "Null element"
}

function persistChange(element, isIMG) {
    if (element) {
        if (isIMG)
            element.dataset.content = element.src
        else {
            element.dataset.content = element.value = element.value.replace(/\s+/gm, ' ').trim()
        }
    } else
        throw "Null element"
}

function assignListeners() {
    const avatar = DRIVER_DETAIL_MODAL.querySelector('#driver-avatar')
    const avatar_uploader = DRIVER_DETAIL_MODAL.querySelector('#driver-avatar-uploader')
    ImagePreviewer.previewEvent(avatar_uploader, avatar)
}

assignListeners()

function deleteUser() {
    const driver_id = DRIVER_DETAIL_MODAL.querySelector('#modal-driver-id').dataset.id

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "id": driver_id
    });

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    fetchDrivers(ENDPOINT + "/api/delete-user/driver", requestOptions)
        .then(res => {
            if (res.status === 200) {
                showToast(" Driver has been deleted")
            } else
                showToast("Failed to delete driver", true)
        })
}

//------------------------------------------------------
const DRIVER_REGISTRATION_OFFCANVAS = document.querySelector('#driver-reg-pending-offcanvas')
const DRIVER_REGISTRATIONS_CONTAINER = DRIVER_REGISTRATION_OFFCANVAS.querySelector('#regs-container')
const REGS_ALL = 2
const REGS_IS_PROCESSED = 0
const REGS_IS_NOT_PROCESSED = 1
const MONTHS_NAME = ['Jan', 'Feb', 'Mar', 'April', "May", "Jun", "July", 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
let set_year = new Date().getFullYear()

function loadRegistrations(regs) {
    const driver_id = DRIVER_DETAIL_MODAL.querySelector('#modal-driver-id').dataset.id

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify( regs ? regs : REGS_IS_NOT_PROCESSED);

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'manual'
    };

    fetch(ENDPOINT + '/api/get-driver-registrations', requestOptions)
        .then(res => {
            if (res.status === 200) {
                return res.json()
            } else {
                showToast("Failed to fetch driver registration", true)
                return undefined
            }
        })
        .then(data => {
            if (data && data.list) {
                for (let i of data.list) {

                    DRIVER_REGISTRATIONS_CONTAINER.innerHTML +=
                        `
                        <div data-reg-id="${i.id}" class="card p-2 w-100 shadow" style="max-width: 50rem; min-width: 20rem;">
                            <div class="d-flex flex-row align-items-center">
                                <img class="img-thumbnail rounded-circle shadow" style="width: 8rem; height: 8rem"
                                     src="${i.avatar}">
                                <div class="ms-3 me-1">
                                    <h5>${i.firstname + ' ' + i.lastname}</h5>
                                    <p class="m-0 p-0" style="font-size: .9rem;">
                                        <span class="birth-date">${MONTHS_NAME[Util.randomInt(0, 11)]} ${Util.randomInt(1, 28)}, ${set_year = Util.randomInt(1980, 2000)}</span>
                                        (<span class="age">${new Date().getFullYear() - set_year}</span> years)
                                    <p>
                                    <div class="m-0 p-0">
                                        <span class="fw-semibold">Citizen ID:</span>
                                        <span>${i.citizenId}</span>
                                    </div>
                                </div>
                                <div style="flex-grow: 1;">
                                    <button class="btn btn-info rounded-pill fw-semibold float-end" data-bs-toggle="collapse"
                                            href="#collapseExample" role="button" aria-expanded="false"
                                            aria-controls="collapseExample">Details
                                    </button>
                                </div>
                            </div>

                            <div class="collapse mt-2" id="collapseExample">
                                <div class="card card-body">
                                    <div class="m-0 p-0">
                                        <span class="fw-semibold">Phone number:</span>
                                        <span>${i.phoneNumber}</span>
                                    </div>
                                    <div class="m-0 p-0">
                                        <span class="fw-semibold">Applied date:</span>
                                        <span>${formatDate(i.appliedDate)}</span>
                                    </div>
                                    <div class="m-0 p-0 d-none">
                                        <span class="fw-semibold">Address:</span>
                                        <span>123456789012</span>
                                    </div>
                                    <div class="m-0 p-0 text-wrap">
                                        <span class="fw-semibold">Message:</span>
                                        <span>${i.message}</span>
                                    </div>
                                    <button onclick="confirmRegistration(${i.id})" class="mt-3 btn btn-info fw-semibold rounded-pill">Confirm This
                                        Registration
                                    </button>
                                    <div class="text-danger text-center" style="font-size: 0.9rem;">*Password will be
                                        automatically generated and will be
                                        sent to driver
                                    </div>
                                </div>
                            </div>
                        </div>
                        `

                }
            } else
                showToast("No registration to show",)
        })
        .catch(error => {
            console.error(error)
        })

}

function formatDate(milliseconds) {
    const options = {weekday: 'long', year: 'numeric', month: 'long', day: 'numeric'};
    return new Date(milliseconds).toLocaleDateString("en-US", options)
}

function confirmRegistration(id) {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify({}),
        redirect: 'manual'
    };

    fetch(ENDPOINT + `/api/process-registration/${id}`, requestOptions)
        .then(res => {
            if (res.status === 200) {
                showToast('Registration has been confirmed')
                document.querySelector(`.card[data-reg-id="${id}"]`).remove()
            } else
                showToast('Failed to confirm the registration', true)
        })
        .catch(error => {
            console.error(error)
            showToast('Error has occurred', true)
        })
}

function reloadRegistrations() {
    DRIVER_REGISTRATIONS_CONTAINER.innerHTML = ""
    loadRegistrations()
    showToast("The list has been reloaded")
}

reloadRegistrations()



