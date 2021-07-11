const getDatos = () => {
    const nombre = document.getElementById("registro_nombre").value;
    const apellido = document.getElementById("registro_apellidos").value;
    const hombre = document.getElementsByClassName("genero")[0];
    const mujer = document.getElementsByClassName("genero")[1];
    const telefono = document.getElementById("telefono").value;
    const fechaNacimiento = document.getElementById("fechaNacimiento").value;
    const estado = document.getElementById("estado").value;
    const municipio = document.getElementById("registro_ciudad").value;
    const correoElectronico = document.getElementById("registro_correo").value;
    const contrasenia = document.getElementById("registro_contra").value;
    let genero = 'helicoptero apache';

    if (hombre.checked) {
        genero = hombre.value;
    } else if (mujer.checked) {
        genero = mujer.value;
    }

    const data = {
        nombre: nombre,
        apellido: apellido,
        genero: genero,
        telefono: telefono,
        fechaNacimiento: fechaNacimiento,
        estado: estado,
        municipio: municipio,
        correoElectronico: correoElectronico,
        contrasenia: contrasenia
    }

    return data;
};


const peticion = async (data) => {
    const response = await fetch("CrearCuenta", {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json; charset=UTF-8'
        }
    }).then(user => user.json())
        .then(user => {
            if (user.valido === 1) {
                window.location.href = "index.html";
            } else {
                alert("El correo ya se encuentra registrado");
            }
        });
};

const crearCuenta = () => {
    const data = getDatos();
    peticion(data);
    const correoElectronico = document.getElementById("registro_correo");
    correoElectronico.value="";
    const contrasenia = document.getElementById("registro_contra");
    contrasenia.value="";
};


const handleOnSubmit = (e) => {
    e.preventDefault();
}


window.onload = () => {
    const form = document.getElementById("formulario_registro");
    const bntRegistrar = document.getElementById("registrarse");
    bntRegistrar.onclick = crearCuenta;
    form.onsubmit = handleOnSubmit;
}