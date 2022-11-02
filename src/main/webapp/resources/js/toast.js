// DEPENDENCY: Boostrap 5.2 (CSS + JS)
class BSToast {
    static get BACKGROUND_BLUE() { return 'text-bg-primary' }
    static get BACKGROUND_RED() { return 'text-bg-danger' }
    static get BACKGROUND_YELLOW() { return 'text-bg-warning' }
    static get TOAST_ID() { return 'toast-bs-29486324986GJ' }
    static get TOAST_MESSAGE_ID() { return 'toast-bs-29486324986GJ-message' }
    static #TOAST =
        `    
            <div class="toast-container position-fixed bottom-0 end-0 p-3">
                <div id="${this.TOAST_ID}" class="toast align-items-center text-bg-primary border-0" role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="d-flex">
                        <div id="${this.TOAST_MESSAGE_ID}" class="toast-body">
                            Hello, world! This is a toast message.
                        </div>
                        <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                    </div>
                </div>
            </div>
        `

    static #checkIfExists(container) {
        if (container.id !== this.TOAST_ID) {
            const child_lookup = container.querySelector(`#${this.TOAST_ID}`)
            return !!child_lookup
        } else
            return true
    }

    static #addHTML(container) {
        let doc_container = container.querySelector('body')
        if (!doc_container)
            container.innerHTML += this.#TOAST
        else
            doc_container.innerHTML += this.#TOAST
    }

    static #setBackgroundColor(toast, bg_clr) {
        const list = toast.classList
        for (let i = 0; i < list.length; i++) {
            if (/^text-bg-.*$/.test(list[i]))
                list.remove(list[i])
        }
        list.add(bg_clr)
    }

    static show(context, message, background_color) {
        try {
            if (context) {
                if (!this.#checkIfExists(context))
                    this.#addHTML(context)

                let toast;

                if (context.querySelector('body'))
                    toast = context.querySelector(`#${this.TOAST_ID}`)
                else
                    toast = context.ownerDocument.querySelector(`#${this.TOAST_ID}`)

                let bg_clr = this.BACKGROUND_BLUE
                if (background_color)
                    bg_clr = background_color

                this.#setBackgroundColor(toast, bg_clr)

                toast.querySelector(`#${this.TOAST_MESSAGE_ID}`).innerHTML = message
                new bootstrap.Toast(toast).show()

            } else {
                console.error("Cannot show toast, context is undefined")
            }
        } catch (error) {
            console.error("Cannot show toast, error has occurred: ", error)
        }
    }
}