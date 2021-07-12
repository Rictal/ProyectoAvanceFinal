const peticion = async () => {
    const response = await fetch("CargarPublicacion");
    const user = await response.json();
    return user;
};

window.onload = () => {

    peticion()
        .then(({usuario, listaPosts}) => {
            cargarPublicaciones(usuario, listaPosts);
            establerNombreUsuario(usuario);
        });


}

const establerNombreUsuario=(usuario)=>{
    const usuarioNombre= document.getElementById("nombreSesion");
    usuarioNombre.innerHTML=usuario.nombre;
}

const cargarPublicaciones = (usuario, listaPosts) => {
    const posts = document.getElementById("posts");
    for (const post of listaPosts) {
        posts.innerHTML += `
                        <article class="post">
                            <p class="usuario">${post.titulo}</p>
                            <p class="fecha-post">
                                Fecha:
                                <time>${post.fechaHoraCreacion}</time>
                            </p>
                            <p> ${post.contenido}</p>
                            ${validaUsuario(usuario,post)}
                        </article> 
                        `
    }
}

const validaUsuario = (usuario, post) => {
    if (usuario.nombre === post.titulo) {
        return `
            <a href="publicar.html">
                <input type="button" 
                       value="Editar"
                       class="editar" />
            </a>
        `
    }
    return '';
}
