class Base64Converter {
    static async toBase64(file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
        });
    }

    static async convert(file) {
        try {
            return await this.toBase64(file);
        } catch(error) {
            console.error(error);
            return undefined;
        }
    }
}