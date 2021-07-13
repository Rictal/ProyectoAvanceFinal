package com.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.utils.ListaPublicaciones;
import com.utils.UsuarioDTO;
import dominio.Admor;
import dominio.Post;
import dominio.Usuario;
import dominio.Normal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CargarPublicacion extends HttpServlet {

    private ListaPublicaciones publicaciones = new ListaPublicaciones();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        JsonObject usuarioJson = new JsonObject();
        List<Post> listaPublicacion = (List<Post>) request.getSession().getAttribute("listaPublicaciones");
        System.out.println(listaPublicacion);
        if(listaPublicacion==null){
            listaPublicacion = publicaciones.getListaPublicacion();
        }
        //usuario de la sesion
        Usuario usuario=null;
        if (this.verificarUsuarioAdmin(request.getSession().getAttribute("admin"))) {
            usuario = (Admor) request.getSession().getAttribute("admin");
        } else {
            usuario = (Normal) request.getSession().getAttribute("normal");
        }

        usuarioJson.add("usuario", gson.toJsonTree(this.conversionUsuario(usuario)));
        //lista de posts
        usuarioJson.add("listaPosts", gson.toJsonTree(listaPublicacion));
        session.setAttribute("listaPublicaciones", listaPublicacion);
        //envio de datos
        out.println(usuarioJson.toString());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    private UsuarioDTO conversionUsuario(Usuario usuario) {
        boolean admin = true;
        if (usuario instanceof Normal) {
            admin = false;
        }
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombreCompleto(), usuario.getIdusuario().intValue(), admin);
        return usuarioDTO;
    }

    private boolean verificarUsuarioAdmin(Object usuario) {
        boolean admin = false;
        if (usuario instanceof Admor) {
            admin = true;
        }
        return admin;
    }

}
