package com.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import controles.FabricaFachadaControl;
import controles.IFachada;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IniciarSesion extends HttpServlet {

    private final IFachada fachada = FabricaFachadaControl.getInstance();
    private final Gson gson = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("txtcorreo");
        String pass = request.getParameter("txtpassword");

        String IdCorreo = request.getParameter("correo");
        String IdPass = request.getParameter("password");

        System.out.println(correo);
        System.out.println(pass);
        System.out.println("---");
        System.out.println(IdCorreo);
        System.out.println(IdPass);
//        PrintWriter out = response.getWriter();
//        Gson gson = new Gson();
//        Estado estado = new Estado("Guadalajara", null);
//        List<Normal> listaNormal = fachada.buscarTodasNormal();
//        //out.print(jason);
//        System.out.println(gson.toJson(estado));
//        response.setContentType("application/json");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }

        String json = sb.toString();
        JsonObject usuarioJson = this.stringToJson(json);

        System.out.println(usuarioJson.get("correo").toString().replace("\"", ""));

        PrintWriter out = response.getWriter();
        out.println(usuarioJson.toString());
        out.flush();
        

        /**
         * Gson gson = new Gson(); PrintWriter out = response.getWriter();
         * HttpSession session = request.getSession();
         *
         * String correo = request.getParameter("txtcorreo"); String pass =
         * request.getParameter("txtpassword"); boolean redireccion = true;
         *
         * List<Normal> listaNormal = fachada.buscarTodasNormal(); List<Admor>
         * listaAdmon = fachada.buscarTodasAdmor();
         *
         * for (Admor admor : listaAdmon) { if (admor.getEmail().equals(correo)
         * && admor.getContrasenia().equals(pass)) {
         * session.setAttribute("admin", admor);
         * response.setContentType("application/json"); gson.toJson(admor, out);
         * redireccion = false; response.sendRedirect("postAdmin.html"); } }
         *
         * for (Normal normal : listaNormal) { if
         * (normal.getEmail().equals(correo) &&
         * normal.getContrasenia().equals(pass)) {
         * session.setAttribute("normal", normal);
         * response.setContentType("application/json"); gson.toJson(normal,
         * out); redireccion = false; response.sendRedirect("postNormal.html");
         * } }
         *
         * if (redireccion) { response.sendRedirect("index.html"); }
         */
    }

    private JsonObject stringToJson(String json) {
        JsonObject JUsuario = gson.fromJson(json, JsonObject.class);
        return JUsuario;
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
