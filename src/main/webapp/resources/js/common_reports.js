function toggleCollapsibleIcon(div) {
    const icon = div.querySelector('span i.bi')
    let changed = false

    if (icon.classList.contains('bi-caret-down-fill')) {
        icon.classList.replace('bi-caret-down-fill', 'bi-caret-up-fill')
        changed = true
    } else if (icon.classList.contains('bi-caret-up-fill')) {
        icon.classList.replace('bi-caret-up-fill', 'bi-caret-down-fill')
        changed = true
    }

    if (changed) {
        div.style.pointerEvents = 'none'
        setTimeout(() => {
            div.style.pointerEvents = 'all'
        }, 400)
    }
}

let prev_filter = "0"

function filterSelected(li, afterSelected) {
    const li_month = li.dataset.month
    if (li_month !== prev_filter) {
        const dropdown = li.parentNode.parentNode
        const filter_value = dropdown.querySelector('#dd-filter-value')
        filter_value.innerHTML = li.innerHTML
        filter_value.dataset.month = li_month
        prev_filter = li_month
        afterSelected(li.innerHTML, li_month) //sodbhiewveewugwieuviduvfsidvfidsfvsdifvisdfvsidvfsdf
        console.log("[STAT]", "Filter has been changed to " + li.innerHTML)
    } else
        console.log("[STAT]", "Filter remains the same")
}