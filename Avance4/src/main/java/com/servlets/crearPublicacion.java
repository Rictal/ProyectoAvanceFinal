package com.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.utils.ListaPublicaciones;
import com.utils.OperacionesJson;
import com.utils.UsuarioDTO;
import dominio.Admor;
import dominio.Normal;
import dominio.Post;
import dominio.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Bryan
 */
public class crearPublicacion extends HttpServlet {

    private ListaPublicaciones publicaciones = new ListaPublicaciones();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BufferedReader br = request.getReader();
        HttpSession session = request.getSession();
        List<Post> listaPublicacion = (List<Post>) session.getAttribute("listaPublicaciones");
        String json = OperacionesJson.obtenerJson(br);
        JsonObject postJson = OperacionesJson.stringToJson(json);

        Usuario usuario=null;
        if (this.verificarUsuarioAdmin(request.getSession().getAttribute("admin"))) {
            usuario = (Admor) request.getSession().getAttribute("admin");
        } else {
            usuario = (Normal) request.getSession().getAttribute("normal");
        }
        String titulo = usuario.getNombreCompleto();
        String contenido = postJson.get("contenido").getAsString();
        long id = 1;
        if (!listaPublicacion.isEmpty()) {
            id = listaPublicacion.get(listaPublicacion.size() - 1).getId() + 1;
        }
        Post nuevoPost = new Post(id, new Date(), titulo, contenido);
        listaPublicacion.add(nuevoPost);
        session.setAttribute("listaPublicaciones", listaPublicacion);
    }

    private boolean verificarUsuarioAdmin(Object usuario) {
        boolean admin = false;
        if (usuario instanceof Admor) {
            admin = true;
        }
        return admin;
    }

}
