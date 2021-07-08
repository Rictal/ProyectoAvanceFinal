package com.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import controles.FabricaFachadaControl;
import controles.IFachada;
import dominio.Admor;
import dominio.Estado;
import dominio.Municipio;
import dominio.Normal;
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
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        Estado estado = new Estado("Guadalajara", null);
        List<Normal> listaNormal = fachada.buscarTodasNormal();
        //out.print(jason);
        System.out.println(gson.toJson(estado));
        response.setContentType("application/json");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String correo = request.getParameter("txtcorreo");
        String pass = request.getParameter("txtpassword");
        boolean redireccion = true;

        List<Normal> listaNormal = fachada.buscarTodasNormal();
        List<Admor> listaAdmon = fachada.buscarTodasAdmor();

        for (Admor admor : listaAdmon) {
            if (admor.getEmail().equals(correo) && admor.getContrasenia().equals(pass)) {
                session.setAttribute("admin", admor);
                response.setContentType("application/json");
                gson.toJson(admor, out);
                redireccion = false;
                response.sendRedirect("postAdmin.html");
            }
        }

        for (Normal normal : listaNormal) {
            if (normal.getEmail().equals(correo) && normal.getContrasenia().equals(pass)) {
                session.setAttribute("normal", normal);
                response.setContentType("application/json");
                gson.toJson(normal, out);
                redireccion = false;
                response.sendRedirect("postNormal.html");
            }
        }

        if (redireccion) {
            response.sendRedirect("index.html");
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
