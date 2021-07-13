package com.servlets;

import com.google.gson.JsonObject;
import com.utils.OperacionesJson;
import controles.FabricaFachadaControl;
import controles.IFachada;
import dominio.Admor;
import dominio.Municipio;
import dominio.Normal;
import dominio.Usuario;
import dominio.enums.Genero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@MultipartConfig
public class CrearCuenta extends HttpServlet {

    private final IFachada fachada = FabricaFachadaControl.getInstance();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        BufferedReader br = request.getReader();

        String json = OperacionesJson.obtenerJson(br);
        JsonObject usuarioJson = OperacionesJson.stringToJson(json);
        PrintWriter out = response.getWriter();


        String nombre = usuarioJson.get("nombre").getAsString() + " " + usuarioJson.get("apellido").getAsString();
        String genero = usuarioJson.get("genero").getAsString();
        String telefono = usuarioJson.get("telefono").getAsString();
        String fechaNacimiento = usuarioJson.get("fechaNacimiento").getAsString();
        String municipio = usuarioJson.get("municipio").getAsString();
        String correo = usuarioJson.get("correoElectronico").getAsString();
        String contrasenia = usuarioJson.get("contrasenia").getAsString();

        Genero generoEnum = getGeneroEnum(genero);
        Date fechaConvertida = FechaConvertida(fechaNacimiento);
        Municipio municipioConvertido = getMunicipio(municipio);

        boolean existenciaCorreo = verificarCorreo(correo);

        if (existenciaCorreo) {
            usuarioJson.addProperty("valido", 0);
        } else {
            Usuario nuevoUsuario = new Normal(nombre,
                    correo,
                    contrasenia,
                    telefono,
                    municipioConvertido,
                    fechaConvertida,
                    generoEnum);
            fachada.guardarNormal((Normal) nuevoUsuario);
            usuarioJson.addProperty("valido", 1);
        }

        out.println(usuarioJson.toString());
        out.flush();

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

    private Genero getGeneroEnum(String genero) {
        return genero.equals(Genero.HOMBRE.toString()) ? Genero.HOMBRE : Genero.MUJER;
    }

    private Municipio getMunicipio(String municipio) {
        List<Municipio> municipioLista = fachada.buscarComoMunicipio(municipio);
        Municipio municipioConvertido = municipioLista.get(0);
        return municipioConvertido;
    }

    private Date FechaConvertida(String fechaNacimiento) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimientoConvertida = null;
        try {
            fechaNacimientoConvertida = formatoFecha.parse(fechaNacimiento);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaNacimientoConvertida;
    }

    private byte[] imagenConvertida(Part avatar) {
//      String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        try {
            InputStream fileContent = avatar.getInputStream();
            byte[] avatarConvertido = IOUtils.toByteArray(fileContent);
            return avatarConvertido;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

    private boolean verificarCorreo(String correo) {
        List<Normal> listaNormal = fachada.buscarTodasNormal();
        List<Admor> listaAdmon = fachada.buscarTodasAdmor();
        for (Admor admor : listaAdmon) {
            if (admor.getEmail().equals(correo)) {
                return true;
            }
        }

        for (Normal normal : listaNormal) {
            if (normal.getEmail().equals(correo)) {
                return true;
            }
        }
        return false;
    }
}
