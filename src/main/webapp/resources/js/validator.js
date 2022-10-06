
class Validator {
    constructor() {
        this.validators = []
    }

    #isNode(o) {
        return (
            typeof Node === "object" ? o instanceof Node :
                o && typeof o === "object" && typeof o.nodeType === "number" && typeof o.nodeName === "string"
        );
    }

    // Returns true if it is a DOM element
    #isElement(o) {
        return (
            typeof HTMLElement === "object" ? o instanceof HTMLElement : //DOM2
                o && typeof o === "object" && o !== null && o.nodeType === 1 && typeof o.nodeName === "string"
        );
    }

    add(element, principle, message, outlineCSSStyle, outlineRadiusCSSStyle) {
        if (this.#isNode(element) || this.#isElement(element)) {
            if (principle instanceof Function) {
                outlineCSSStyle = (outlineCSSStyle && outlineCSSStyle.replace(/\s+/gm, ' ').trim() !== '') ? outlineCSSStyle : undefined
                outlineRadiusCSSStyle = (outlineRadiusCSSStyle && outlineRadiusCSSStyle.replace(/\s+/gm, ' ').trim() !== '') ? outlineRadiusCSSStyle : undefined
                this.validators.push({ element, principle, message, prevStyle: element.style, outlineCSSStyle, outlineRadiusCSSStyle, messageIdList: [] })
                return this
            } else {
                throw "[principle] is expected to be a callback"
            }
        } else {
            throw "[element] is neither a DOM node nor DOM element"
        }
    }

    #removeOldMessage(validator) {
        const list = validator.messageIdList
        for (let i = 0; i < list.length; i++) {
            const emsg = document.querySelector('#' + list[i])
            if (emsg)
                emsg.remove()
        }
    }


    #doValidate(validator) {
        if (validator.principle() === false) {
            validator.element.style.outline = (validator.outlineCSSStyle) ? validator.outlineCSSStyle : "2px solid rgba(255, 16, 39, 0.5)"
            validator.element.style.borderRadius = (validator.outlineRadiusCSSStyle) ? validator.outlineRadiusCSSStyle : 0

            this.#removeOldMessage(validator)

            const msg = document.createElement('p')
            const msg_id = 'validator-msg-' + Math.ceil(Math.random() * 10000) + (new Date().getMilliseconds())
            validator.messageIdList.push(msg_id)
            msg.classList.add("validator-msg-class-E62324")
            msg.id = msg_id
            msg.style.color = 'red'
            msg.style.paddingLeft = '.8rem'
            msg.style.marginBottom = 0
            msg.innerHTML = validator.message
            validator.element.after(msg)
        } else {
            validator.element.style = validator.prevStyle
            this.#removeOldMessage(validator)
        }
    }

    validate() {
        for (let val of this.validators) {
            this.#doValidate(val)
        }
    }
}