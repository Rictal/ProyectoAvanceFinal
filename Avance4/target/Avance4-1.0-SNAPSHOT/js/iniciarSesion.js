const iniciarSesion = async () => {
    let correo = document.getElementById("correo").value;
    let contrasenia = document.getElementById("contrasenia").value;
    let data = {
        correo: correo,
        password: contrasenia
    };
    if (correo !== '' && contrasenia !== '') {
        try {
            const response = await fetch("IniciarSesion", {
                method: 'POST',
                body: JSON.stringify(data), // data can be `string` or {object}!
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                }
            });
            const user = await response.json();
            if (user.valido === 1) {
                window.location.href = "postNormal.html";
            } else {
                alert("Usuario invalido");
            }
        } catch (error) {
            console.error(error);
        }
    }
};


const handleOnSubmit = (e) => {
    e.preventDefault();
}

window.onload = () => {
    let button = document.getElementById("iniciarSesionBtn");
    let formulario = document.getElementById("form");
    formulario.onsubmit = handleOnSubmit;
    button.onclick = iniciarSesion;
};
