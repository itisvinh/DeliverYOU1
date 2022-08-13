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
