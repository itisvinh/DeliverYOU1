class Util {
    static randomInt(min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max + 1 - min) + min);
    }
}

class Fetch {
    static get METHOD_GET() { return 'GET' }
    static get METHOD_POST() { return 'POST' }
    static get #CT_PREFIX() { return 'application/' }
    static get CONTENT_TYPE_FORM_URLENCODED() { return this.#CT_PREFIX + 'x-www-form-urlencoded' }
    static get CONTENT_TYPE_JSON() { return this.#CT_PREFIX + 'json' }

    static #called_from_outside = true
    #content_type = Fetch.CONTENT_TYPE_JSON
    #body = {}
    #method = Fetch.METHOD_GET

    constructor() {
        if (Fetch.#called_from_outside)
            throw "Invalid constructor call: private constructor, use Fetch.build() instead"
    }

    static build(content_type) {
        this.#called_from_outside = false
        const instance =  new Fetch()
        this.#called_from_outside = true;
        instance.#content_type = (!content_type || content_type.trim() === '') ? this.CONTENT_TYPE_JSON : content_type
        return instance
    }

    body(body) {
        this.#body = this.#build_body(this.#content_type, body)
        return this
    }

    method(method) {
        this.#method = (!method && method.trim() === '') ? Fetch.METHOD_GET : method.toUpperCase()
        return this
    }

    #build_body(content_type, body) {
        switch (content_type) {
            case Fetch.CONTENT_TYPE_JSON:
                return JSON.stringify(body)

            case Fetch.CONTENT_TYPE_FORM_URLENCODED:
                const urlencoded = new URLSearchParams();
                Object.keys(body).forEach(function(key,index) {
                    urlencoded.append(key, body[key])
                });
                return urlencoded
        }
    }

    #request_options() {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", this.#content_type);

        const obj = {
            method: this.#method,
            headers: myHeaders,
            body : this.#body,
            redirect: 'manual'
        };

        return obj
    }

    fetch(endpoint) {
        return this.#method === Fetch.METHOD_GET ? fetch(endpoint) : fetch(endpoint, this.#request_options())
    }

    fetchBodySingleResult(endpoint, field_name) {
        if (!field_name || field_name.trim() === '')
            field_name = 0

        return this.fetch(endpoint)
            .then(response => response.json())
            .then(data => {
                if (field_name === 0)
                    return data[Object.keys(data)[0]]
                return data['' + field_name]
            })
    }
}
