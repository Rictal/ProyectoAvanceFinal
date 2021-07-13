const getDatos = () => {
    const contenido = document.getElementById("txtPublicacion").value;
    const datos = {
        contenido: contenido,
    }
    return datos;
}

const peticion = async () => {
    const data = getDatos();
    console.log(data);
    const response = await fetch("crearPublicacion", {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json; charset=UTF-8'
        }
    });
    window.location.href = "postNormal.html";
};


window.onload = () => {
    const btnPublicar = document.getElementById("publicar-btn");
    btnPublicar.onclick = peticion;


}

