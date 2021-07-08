async function reportesMaterials() {
    try {
        let res = await fetch("IniciarSesion")
                .then(response => response.json())
                .then(data => console.log(data));
    } catch (error) {
        console.log(error);
    }
}
reportesMaterials();