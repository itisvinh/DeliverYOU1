let current_tab_index = 0

function autocomplete(inp, arr) {
    /*the autocomplete function takes two arguments,
    the text field element and an array of possible autocompleted values:*/
    var currentFocus;
    /*execute a function when someone writes in the text field:*/
    inp.addEventListener("input", function (e) {
        var a, b, i, val = this.value;
        /*close any already open lists of autocompleted values*/
        closeAllLists();
        if (!val) {
            return false;
        }
        currentFocus = -1;
        /*create a DIV element that will contain the items (values):*/
        a = document.createElement("DIV");
        a.setAttribute("id", this.id + "autocomplete-list");
        a.setAttribute("class", "autocomplete-items");
        /*append the DIV element as a child of the autocomplete container:*/
        this.parentNode.appendChild(a);
        /*for each item in the array...*/
        for (i = 0; i < arr.length; i++) {
            /*check if the item starts with the same letters as the text field value:*/
            if (arr[i].name.toUpperCase().includes(val.trim().toUpperCase())) {
                /*create a DIV element for each matching element:*/
                b = document.createElement("div");
                b.setAttribute('data-code', arr[i].code)
                b.innerHTML += arr[i].name
                /*insert a input field that will hold the current array item's value:*/
                b.innerHTML += `<input type='hidden' value='${arr[i].name}' data-code='${arr[i].code}'>`;
                /*execute a function when someone clicks on the item value (DIV element):*/

                b.addEventListener("click", function (e) {
                    /*insert the value for the autocomplete text field:*/
                    const inputEle = this.getElementsByTagName("input")[0]
                    inp.value = inputEle.value;
                    inp.setAttribute('data-code', inputEle.dataset.code)
                    // inp.setAttribute('data-code', arr[i].code)
                    /*close the list of autocompleted values,
                    (or any other open lists of autocompleted values:*/
                    closeAllLists();

                    const loc_selectors = inp.parentNode.parentNode
                    console.log('parent', loc_selectors)
                    if (inp === loc_selectors.querySelector('.province-sel')) {
                        loc_selectors.querySelector('.district-sel').removeAttribute('disabled')
                        loc_selectors.querySelector('.province-sel').setAttribute('disabled', '')
                        fetchDistricts(loc_selectors, inputEle.dataset.code)
                    } else if (inp === loc_selectors.querySelector('.district-sel')) {
                        loc_selectors.querySelector('.ward-sel').removeAttribute('disabled')
                        loc_selectors.querySelector('.district-sel').setAttribute('disabled', '')
                        fetchWards(loc_selectors, inputEle.dataset.code)
                    } else if (inp === loc_selectors.querySelector('.ward-sel')) {
                        loc_selectors.querySelector('.ward-sel').setAttribute('disabled', '')
                    }

                });
                a.appendChild(b);
            }
        }
    });
    /*execute a function presses a key on the keyboard:*/
    inp.addEventListener("keydown", function (e) {
        var x = document.getElementById(this.id + "autocomplete-list");
        if (x) x = x.getElementsByTagName("div");
        if (e.keyCode == 40) {
            /*If the arrow DOWN key is pressed,
            increase the currentFocus variable:*/
            currentFocus++;
            /*and and make the current item more visible:*/
            addActive(x);
        } else if (e.keyCode == 38) { //up
            /*If the arrow UP key is pressed,
            decrease the currentFocus variable:*/
            currentFocus--;
            /*and and make the current item more visible:*/
            addActive(x);
        } else if (e.keyCode == 13) {
            /*If the ENTER key is pressed, prevent the form from being submitted,*/
            e.preventDefault();
            if (currentFocus > -1) {
                /*and simulate a click on the "active" item:*/
                if (x) x[currentFocus].click();
            }
        }
    });

    function addActive(x) {
        /*a function to classify an item as "active":*/
        if (!x) return false;
        /*start by removing the "active" class on all items:*/
        removeActive(x);
        if (currentFocus >= x.length) currentFocus = 0;
        if (currentFocus < 0) currentFocus = (x.length - 1);
        /*add class "autocomplete-active":*/
        x[currentFocus].classList.add("autocomplete-active");
    }

    function removeActive(x) {
        /*a function to remove the "active" class from all autocomplete items:*/
        for (var i = 0; i < x.length; i++) {
            x[i].classList.remove("autocomplete-active");
        }
    }

    function closeAllLists(elmnt) {
        /*close all autocomplete lists in the document,
        except the one passed as an argument:*/
        var x = document.getElementsByClassName("autocomplete-items");
        for (var i = 0; i < x.length; i++) {
            if (elmnt != x[i] && elmnt != inp) {
                x[i].parentNode.removeChild(x[i]);
            }
        }

    }
    /*execute a function when someone clicks in the document:*/
    document.addEventListener("click", function (e) {
        closeAllLists(e.target);
    });
}

function resetCurrentTabIndex() {
    current_tab_index = 0
}

// --------------------------------------------

async function fetchProvinces() {
    fetch('https://provinces.open-api.vn/api/p/')
        .then(response => response.json())
        .then(provinces => {
            autocomplete(document.querySelector('#pickup-loc-sel .province-sel'), provinces)
            autocomplete(document.querySelector('#dropoff-loc-sel .province-sel'), provinces)
        })
}

const modal_content_observer = new MutationObserver(mutation => {
    fetchProvinces()
    handleImages()
})
modal_content_observer.observe(document.querySelector('#main-modal .modal-content .content'), {
    attributes: true,
    characterData: true,
    childList: true,
    subtree: true,
    attributeOldValue: true,
    characterDataOldValue: true
})

fetchProvinces()

// ----------------------------------------------

async function fetchDistricts(loc_selectors, provinceCode) {
    fetch(`https://provinces.open-api.vn/api/p/${provinceCode}/?depth=2`)
        .then(response => response.json())
        .then(provinceDepth2 => provinceDepth2.districts)
        .then(districts => {
            autocomplete(loc_selectors.querySelector('.district-sel'), districts)
        })
}

async function fetchWards(loc_selectors, districtCode) {
    fetch(`https://provinces.open-api.vn/api/d/${districtCode}/?depth=2`)
        .then(response => response.json())
        .then(districtDepth2 => districtDepth2.wards)
        .then(wards => {
            autocomplete(loc_selectors.querySelector('.ward-sel'), wards)
        })
}

function resetLoc(button) {
    const loc_selectors = button.parentNode
    const p = loc_selectors.querySelector('.province-sel')
    const d = loc_selectors.querySelector('.district-sel')
    const w = loc_selectors.querySelector('.ward-sel')
    const st = loc_selectors.querySelector('.street-inp')

    p.removeAttribute('disabled')
    d.setAttribute('disabled', '')
    w.setAttribute('disabled', '')

    p.value = ''
    d.value = ''
    w.value = ''
    st.value = ''
}

// ----------------------------
const ToastType = {
    ERROR: 0,
    WARNING: 1,
    INFO: 2
}

function showToast(content, toastType) {
    if (!content) content = ''
    let toast_bg = ''
    switch (toastType) {
        case ToastType.ERROR:
            toast_bg = 'danger'
            break
        case ToastType.WARNING:
            toast_bg = 'warning'
            break
        case ToastType.INFO:
            toast_bg = 'primary'
            break
    }
    const toast_container = document.querySelector('#toast-container')

    const toast_id = 'toast-' + new Date().getTime() + Math.floor(Math.random() * 100)
    const toast =
        `
    <div id="${toast_id}" class="toast align-items-center text-bg-${toast_bg} border-0" role="alert" aria-live="assertive" aria-atomic="true" data-bs-autohide="true" data-bs-delay="8000">
        <div class="d-flex">
            <div class="toast-body">
                ${content}
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
    `

    toast_container.innerHTML += toast
    const toast_ele = toast_container.querySelector(`#${toast_id}`)
    new bootstrap.Toast(toast_ele).show()

    // observe children img
    new ClassWatcher(toast_ele, 'show', () => { }, () => {
        toast_container.removeChild(toast_ele)
    })
}

async function getTotalPosts(endpoint) {
    return fetch(endpoint + "/get-total-posts")
        .then(res => res.json())
        .catch(reason => {
            console.log("[FETCH ERROR]", "cannot fetch the total number of posts")
            return undefined
        })
}

function postAddedSuccessfully(endpoint) {
    document.elementFromPoint(1,1).click()
    document.querySelector('.frame-container .frame').contentWindow.location.reload();

    getTotalPosts(endpoint).then(data => {
        if (data && data.count > -1) {
            document.querySelector('.profile-container .member-stats .m-posts .number').innerHTML = data.count
        }
    })

}

function validatePostInfo(p_loc, d_loc, recepient, files) {
    const { p_province, p_district, p_ward, p_street } = p_loc
    const { d_province, d_district, d_ward, d_street } = d_loc
    const { r_name, r_phone } = recepient

    if (p_province.value === '' || p_district.value === '' || p_ward.value === '' || p_street.value.trim() === '') {
        showToast('Invalid pick-up location!', ToastType.ERROR)
        return false
    } else if (d_province.value === '' || d_district.value === '' || d_ward.value === '' || d_street.value.trim() === '') {
        showToast('Invalid drop-off location!', ToastType.ERROR)
        return false
    } else if (r_name.value.trim() === '' || r_phone.value.trim() === '') {
        showToast("Recipient's name and phone cannot be empty!", ToastType.ERROR)
        return false
    } else if (files.length === 0) {
        showToast("PLease upload at least 1 image for your post!", ToastType.ERROR)
        return false
    }
    return true
}

function addPost(endpoint) {
    const p_province = document.querySelector('.modal-body .tab #pickup-loc-sel .province-sel')
    const p_district = document.querySelector('.modal-body .tab #pickup-loc-sel .district-sel')
    const p_ward = document.querySelector('.modal-body .tab #pickup-loc-sel .ward-sel')
    const p_street = document.querySelector('.modal-body .tab #pickup-loc-sel .street-inp')

    const d_province = document.querySelector('.modal-body .tab #dropoff-loc-sel .province-sel')
    const d_district = document.querySelector('.modal-body .tab #dropoff-loc-sel .district-sel')
    const d_ward = document.querySelector('.modal-body .tab #dropoff-loc-sel .ward-sel')
    const d_street = document.querySelector('.modal-body .tab #dropoff-loc-sel .street-inp')
    //-----------------
    const r_name = document.querySelector('.modal-body .tab #rep-name')
    const r_phone = document.querySelector('.modal-body .tab #rep-phone')
    //----------------
    const img_files = document.querySelector('.modal-body .tab #upload')
    const post_content = document.querySelector('.modal-body .tab #post_content span.textarea')
    const cat_name = document.querySelector('.modal-body .tab #category_name span.cat_name')

    const pickup_loc = { p_province, p_district, p_ward, p_street }
    const dropoff_loc = { d_province, d_district, d_ward, d_street }
    const recepient = { r_name, r_phone }
    const files = img_files.files ? img_files.files : []

    console.log('[STATE]', 'prepare to upload images')

    if (validatePostInfo(pickup_loc, dropoff_loc, recepient, files)) {

        uploadImages().then(urls => {
            if (urls.length > 0) {
                // const file_urls = urls.join('<split/>')
                const post = {
                    sender_address: {
                        province: p_province.value,
                        district: p_district.value,
                        ward: p_ward.value,
                        street: p_street.value
                    },
                    receiver_address: {
                        province: d_province.value,
                        district: d_district.value,
                        ward: d_ward.value,
                        street: d_street.value
                    },
                    receiver: {
                        name: r_name.value,
                        phone: r_phone.value
                    },
                    files: urls,
                    content: post_content.innerHTML,
                    category_name: cat_name.innerHTML
                }
                createNewPost(endpoint, post).then(data => {
                    if (data && data.code === 201) {
                        postAddedSuccessfully(endpoint)
                    } else {
                        showToast("Exception occurred at the server", ToastType.ERROR)
                    }
                })
            }
        })
    }
}

function createNewPost(endpoint, post) {
    return fetch(endpoint + "/add-post", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            senderProvince: post.sender_address.province,
            senderDistrict: post.sender_address.district,
            senderWard: post.sender_address.ward,
            senderStreet: post.sender_address.street,
            senderId: 0,
            receiverProvince: post.receiver_address.province,
            receiverDistrict: post.receiver_address.district,
            receiverWard: post.receiver_address.ward,
            receiverStreet: post.receiver_address.street,
            receiverName: post.receiver.name,
            receiverPhone: post.receiver.phone,
            postContent: post.content,
            categoryName: post.category_name,
            urlList: post.files
        })
    })
        .then(res => {
            console.log("RES", res)
            return res.json()
        })
        .then(data => {
            console.log("POST", data)
            showToast("Created successfully", ToastType.INFO)
            return data
        })
        .catch(error => {
            console.log('[FETCH ERROR]', error)
            return undefined
        });
}

function nextTab(button, endpoint) {
    const mode = button.dataset.mode

    if (mode === 'next') {
        const tabs = document.querySelectorAll('.modal-body .tab-container .tab')

        if (current_tab_index + 1 === tabs.length - 1) {
            button.innerHTML = 'Add'
            button.dataset.mode = 'add'
            button.setAttribute('type', 'submit')
        }
        if (current_tab_index + 1 > 0) {
            const pNode = button.parentNode
            const prevBtn = pNode.querySelector('button')
            prevBtn.classList.remove('d-none')
        }

        const prev_tab = tabs[current_tab_index++]
        const tab = tabs[current_tab_index]
        if (!prev_tab.classList.contains('d-none'))
            prev_tab.classList.add('d-none')
        tab.classList.remove('d-none')

        // header
        const progress_bar = document.querySelector('.modal-header .progress-bar')
        const progress_items = progress_bar.querySelectorAll('.progress-item')
        progress_items[current_tab_index].classList.add('active')

    } else if (mode === 'add') {
        addPost(endpoint)
    }
}

function previousTab(button) {
    const tabs = document.querySelectorAll('.modal-body .tab-container .tab')

    if (current_tab_index - 1 === 0) {
        if (!button.classList.contains('d-none'))
            button.classList.add('d-none')
    } else if (current_tab_index - 1 < tabs.length - 1) {
        const pNode = button.parentNode
        const nextBtn = pNode.querySelectorAll('button')[1]
        nextBtn.dataset.mode = 'next'
        nextBtn.innerHTML = 'Next'
        nextBtn.setAttribute('type', 'button')
    }

    // header
    const progress_bar = document.querySelector('.modal-header .progress-bar')
    const progress_items = progress_bar.querySelectorAll('.progress-item')
    progress_items[current_tab_index].classList.remove('active')


    // tabs
    const tab = tabs[current_tab_index--]
    const prev_tab = tabs[current_tab_index]
    if (!tab.classList.contains('d-none'))
        tab.classList.add('d-none')
    prev_tab.classList.remove('d-none')
}

// --------------------------------------------

class ClassWatcher {

    constructor(targetNode, classToWatch, classAddedCallback, classRemovedCallback) {
        this.targetNode = targetNode
        this.classToWatch = classToWatch
        this.classAddedCallback = classAddedCallback
        this.classRemovedCallback = classRemovedCallback
        this.observer = null
        this.lastClassState = targetNode.classList.contains(this.classToWatch)

        this.init()
    }

    init() {
        this.observer = new MutationObserver(this.mutationCallback)
        this.observe()
    }

    observe() {
        this.observer.observe(this.targetNode, { attributes: true })
    }

    disconnect() {
        this.observer.disconnect()
    }

    mutationCallback = mutationsList => {
        for (let mutation of mutationsList) {
            if (mutation.type === 'attributes' && mutation.attributeName === 'class') {
                let currentClassState = mutation.target.classList.contains(this.classToWatch)
                if (this.lastClassState !== currentClassState) {
                    this.lastClassState = currentClassState
                    if (currentClassState) {
                        this.classAddedCallback()
                    }
                    else {
                        this.classRemovedCallback()
                    }
                }
            }
        }
    }
}


// -------------- IMG UPLOADER -----------------

function readAsURL(file) {
    return new Promise((resolve) => {
        const file_reader = new FileReader()
        file_reader.onload = () => resolve(file_reader.result)
        file_reader.readAsDataURL(file)
    })
}

function readFiles(input) {
    const files = input.files
    const reader_promises = []

    for (let f of files) {
        reader_promises.push(readAsURL(f))
    }

    Promise.all(reader_promises).then(values => {
        const img_container = document.querySelector('.image-uploader.container .image-area')
        img_container.innerHTML = ''
        for (let value of values) {
            const img = `<img src="${value}">`
            img_container.innerHTML += img
        }
    })
}


function handleImages() {
    // document.querySelector('#upload').addEventListener('change', function () {
    //     readFiles(input);
    // });
    /*  ==========================================
        SHOW UPLOADED IMAGE NAME
    * ========================================== */
    const input = document.getElementById('upload');
    const infoArea = document.getElementById('upload-label');

    input.addEventListener('change', showFileName);
    function showFileName(event) {
        var input = event.srcElement;
        var fileName = input.files[0].name;
        infoArea.textContent = 'File name: ' + fileName;
    }
}

handleImages()

// -----------------------------

function categorySelected(li) {
    const button = li.parentNode.parentNode.querySelector('button')
    button.querySelector('.btn-label-content').innerHTML = li.innerHTML
    button.dataset.cat = li.dataset.cat
}

// ---------------------------
// ------------------------------

async function uploadImage(file) {
    const form_data = new FormData()
    form_data.append('upload_preset', 'whrdpezg')
    form_data.append('file', file)

    return fetch('https://api.cloudinary.com/v1_1/de26tcplz/image/upload', {
        method: 'POST',
        body : form_data
    }).then(res => res.json())
        .then(data => {
            let url =''
            if (data.error) {
                console.error('[ERROR]', data.error.message)
            } else {
                url = data.url
                console.log('[URL]', url)
            }
            return url
        })
}

async function uploadImages() {
    console.log('[STATE]', 'begin to upload')
    const input = document.querySelector('#upload')
    const files = input.files

    if (files.length === 0) {
        console.error('[ERROR]', 'no file to upload')
        return []
    }

    const promise_list = []

    for (let file of files) {
        const promise = uploadImage(file)
        promise_list.push(promise)
    }

    return Promise.all(promise_list).then(urls => {
        if (urls.length === 0) {
            console.error('[STATE]', 'failed to upload your images')
            return []
        } else if (urls.length < files.length) {
            console.error('[WARNING]', 'failed to upload SOME of the images')
        } else {
            console.log('[STATE]', 'finished uploading images')
        }
        return urls
    })

}
