window.onload = () => {
    peticionPublicaciones()
        .then(({usuario, listaPosts}) => {
            cargarPublicaciones(usuario, listaPosts);
            establerNombreUsuario(usuario);
        });
}

const peticionPublicaciones = async () => {
    const response = await fetch("CargarPublicacion");
    const user = await response.json();
    return user;
};


const establerNombreUsuario = (usuario) => {
    const usuarioNombre = document.getElementById("nombreSesion");
    usuarioNombre.innerHTML = usuario.nombre;
}

const cargarPublicaciones = (usuario, listaPosts) => {
    const posts = document.getElementById("posts");
    console.log(usuario);
    console.log(listaPosts);
    posts.innerHTML = '';
    posts.innerHTML = `
         <header>
            <h2>Posts</h2>
        </header>`;
    listaPosts.reverse()
        .forEach(post => {
            posts.innerHTML += `
                        <article class="post">
                            <p class="usuario">${post.titulo}</p>
                            <p class="fecha-post">
                                <time>${post.fechaHoraCreacion}</time>
                            </p>
                            <p> ${post.contenido}</p>
                            ${validaUsuario(usuario, post)}
                        </article> 
                        `
        });
}

const eliminarPost = async (id) => {
    const eliminar = window.confirm("¿Desea eliminar el post?");
    const data = {
        postId: id,
    }
    console.log(data);
    if (eliminar) {
        //elimina la publicación
        await fetch("EliminarPublicacion", {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        });
        //carga las publicaciones de nuevo
        peticionPublicaciones()
            .then(({usuario, listaPosts}) => {
                cargarPublicaciones(usuario, listaPosts);
                establerNombreUsuario(usuario);
            });
    }
}


const validaUsuario = (usuario, post) => {
    if (usuario.admin === true) {
        return `
                <input type="button" 
                       value="Eliminar"
                       class="editar" 
                       id=${post.id}
                       onclick="eliminarPost(this.id)"
                       />          
                `
    } else if (usuario.nombre === post.titulo) {
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
