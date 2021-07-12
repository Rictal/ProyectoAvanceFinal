package com.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.utils.UsuarioDTO;
import dominio.Post;
import dominio.Usuario;
import dominio.Normal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CargarPublicacion extends HttpServlet {

    private List<Post> listaPublicacion = new ArrayList<>();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        JsonObject usuarioJson = new JsonObject();
        //usuario de la sesion
        Usuario usuario = (Normal) session.getAttribute("normal");
        usuarioJson.add("usuario", gson.toJsonTree(this.conversionUsuario(usuario)));
        //lista de posts
        this.cargarLista();
        usuarioJson.add("listaPosts", gson.toJsonTree(listaPublicacion));
        System.out.println(usuarioJson);
        //envio de datos
        out.println(usuarioJson.toString());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void cargarLista() {
        this.listaPublicacion.removeAll(this.listaPublicacion);
        this.listaPublicacion.add(new Post(1L, new Date(), "Pochito 'el travieso' Arce", "Hola muy buenas a todos guapisímos, aquí vegueta 777 en directo en minecraft, desde mundo vegueta😊😊😊😊"));
        this.listaPublicacion.add(new Post(2L, new Date(), "Justin B", "buenas tardes mi nombre es Justin biber y me comunico con el fin de evaluar el servicio que usted recibe"));
        this.listaPublicacion.add(new Post(3L, new Date(), "McGregor", "me lastime la pierna en mi ultima pelea"));
        this.listaPublicacion.add(new Post(4L, new Date(), "Gabe Newell", "half life 4"));
        this.listaPublicacion.add(new Post(4L, new Date(), "Romana Garcia", "pokemon go"));
    }

    private UsuarioDTO conversionUsuario(Usuario usuario) {
        boolean admin = true;
        if (usuario instanceof Normal) {
            admin = false;
        }
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombreCompleto(), usuario.getIdusuario().intValue(), admin);
        return usuarioDTO;
    }

}
