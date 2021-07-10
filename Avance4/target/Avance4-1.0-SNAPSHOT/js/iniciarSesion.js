const iniciarSesion = async () => {
    let correo = document.getElementById("correo").value;
    let contrasenia = document.getElementById("contrasenia").value;
    let data = {
        correo: correo,
        password: contrasenia
    };

    console.log(JSON.stringify(data));

    if (correo !== '' && contrasenia !== '') {
        try {
            let response = await fetch("IniciarSesion", {
                method: 'POST',
                body: JSON.stringify(data), // data can be `string` or {object}!
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                }
            });
        } catch (error) {
            console.error(error);
        }
    }

    // window.location.href = "postNormal.html";
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
/*
 async function iniciarSesion(name, password) {
 try {
 let data = {name: name,
 password: password};
 console
 let res = await fetch("http://localhost:8888/usuario/validar", {
 method: 'POST',
 body: JSON.stringify(data), // data can be `string` or {object}!
 headers: {
 'Content-Type': 'application/json; charset=UTF-8'
 }
 })
 
 .then((res) => res.json()).then(json => {
 tkn = JSON.stringify(json);
 console.log(tkn)
 });
 ;
 
 } catch (error) {
 console.log(error);
 }
 }
 reportesMaterials();
 */