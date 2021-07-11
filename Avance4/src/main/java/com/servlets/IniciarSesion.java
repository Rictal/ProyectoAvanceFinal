package com.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.utils.OperacionesJson;
import controles.FabricaFachadaControl;
import controles.IFachada;
import dominio.Admor;
import dominio.Normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IniciarSesion extends HttpServlet {

    private final IFachada fachada = FabricaFachadaControl.getInstance();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        BufferedReader br = request.getReader();
        PrintWriter out = response.getWriter();

        String json = OperacionesJson.obtenerJson(br);
        JsonObject usuarioJson = OperacionesJson.stringToJson(json);

        //datos de correo y contraseña para validar
        String correo = usuarioJson.get("correo").getAsString();
        String contrasenia = usuarioJson.get("password").getAsString();

        HttpSession session = request.getSession();
        boolean redireccion = false;

        List<Normal> listaNormal = fachada.buscarTodasNormal();
        List<Admor> listaAdmon = fachada.buscarTodasAdmor();

        for (Admor admor : listaAdmon) {
            if (admor.getEmail().equals(correo)
                    && admor.getContrasenia().equals(contrasenia)) {
                session.setAttribute("admin", admor);
                redireccion = true;
                usuarioJson.addProperty("valido", 1);
            }
        }

        for (Normal normal : listaNormal) {
            if (normal.getEmail().equals(correo) &&
                    normal.getContrasenia().equals(contrasenia)) {
                session.setAttribute("normal", normal);
                redireccion = true;
                usuarioJson.addProperty("valido", 1);
            }
        }

        if (redireccion) {
            out.println(usuarioJson.toString());
            out.flush();
        } else {
            usuarioJson.addProperty("valido",0);
            out.println(usuarioJson.toString());
            out.flush();
        }

    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
