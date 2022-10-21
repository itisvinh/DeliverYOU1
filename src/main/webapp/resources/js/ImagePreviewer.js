class ImagePreviewer {
    static previewEvent(input, img) {
        try {
            if (input.tagName === 'INPUT' && img.tagName === 'IMG') {

                input.onchange = (event) => {
                    if(event.target.files.length > 0){
                        img.src = URL.createObjectURL(event.target.files[0]);
                    }
                }

            } else {
                throw new TypeError("<input> and <img> are required")
            }
        } catch (error) {
            throw error
        }
    }
}