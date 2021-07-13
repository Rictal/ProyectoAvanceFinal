/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import dominio.Admor;
import dominio.Anclado;
import dominio.Comentario;
import dominio.Comun;
import dominio.Estado;
import dominio.Municipio;
import dominio.Normal;
import dominio.Post;
import dominio.Usuario;
import dominio.enums.Genero;
import dominio.enums.TiposUsuarios;
import dominio.fabricas.FabricaUsuario;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bryan
 */
public class FachadaTest {
    
public static void main(String[] args) {
        IFachada fachada = FabricaFachadaControl.getInstance();
//
//        Comun postComun = new Comun();
//        postComun.setContenido("Venta y compra");
//        postComun.setFechaHoraCreacion(new Date());
//        postComun.setFechaHoraEdicion(new Date());
//        postComun.setTitulo("MarketPlace");
//        postComun.setComentarios(null);
//        postComun.setUsuario(null);
//        fachada.guardarPost(postComun);
//        fachada.eliminarEstado(4);
//        fachada.eliminarEstado(3);
//        List<Municipio> listaMunicipios = new ArrayList<>();
//        Estado estado = new Estado();
//        estado.setNombre("Sonora");
//        Municipio municipio = new Municipio("Obregon", estado);
//        listaMunicipios.add(municipio);
//        Municipio municipio2 = new Municipio("Hermosillo", estado);
//        listaMunicipios.add(municipio2);
//        Municipio municipio3 = new Municipio("Guaymas", estado);
//        listaMunicipios.add(municipio3);
//        Municipio municipio4 = new Municipio("Nogales", estado);
//        listaMunicipios.add(municipio4);
//        Municipio municipio5 = new Municipio("Navojoa", estado);
//        listaMunicipios.add(municipio5);
//        estado.setMunicipios(listaMunicipios);
//        fachada.guardarEstado(estado);
//
        Usuario usuarioAdmin = FabricaUsuario.getUser(TiposUsuarios.ADMIN.toString());
        usuarioAdmin.setCiudad(fachada.buscarIDMunicipio(17));
        usuarioAdmin.setContrasenia("Password");
        usuarioAdmin.setAvatar(null);
        usuarioAdmin.setEmail("ponchito@potros.com");
        usuarioAdmin.setGenero(Genero.HOMBRE);
        usuarioAdmin.setNombreCompleto("Alfonso Sempai");
        usuarioAdmin.setTelefono("64466666");
        usuarioAdmin.setFechaNacimiento(new Date());
        fachada.guardarAdmor((Admor) usuarioAdmin);
//
//        List<Comentario> listaComentarios = new ArrayList<>();
//        
//        List<Comun> listaPostComun = new ArrayList<>();
//        Comun postcomun1 = new Comun();
//        postcomun1.setUsuario(usuarioAdmin);
//        postcomun1.setContenido("Hola amigos ya estamos en vivo");
//        postcomun1.setFechaHoraCreacion(new Date());
//        postcomun1.setFechaHoraEdicion(null);
//        postcomun1.setTitulo("1");
//        postcomun1.setComentarios(listaComentarios);
//        
//        Comun postcomun2 = new Comun();
//        postcomun2.setUsuario(usuarioAdmin);
//        postcomun2.setContenido("Se cancela hay covid");
//        postcomun2.setFechaHoraCreacion(new Date());
//        postcomun2.setFechaHoraEdicion(null);
//        postcomun2.setTitulo("2");
//        postcomun2.setComentarios(listaComentarios);
//        
//
//        listaPostComun.add(postcomun1);
//        listaPostComun.add(postcomun2);
//
//        usuarioAdmin.setComunes(listaPostComun);
//        usuarioAdmin.setFechaNacimiento(new Date());
//        
//        fachada.guardarAdmor((Admor) usuarioAdmin);

//        AdmorRepository admorDAO = new AdmorRepository();
//        
//        List<Anclado> listaAnclados = new ArrayList<>();
//        String nombreCompleto = "Pochito Arce";
//        String email = "pochito@gmail.com";
//        String contrasenia = "1234";
//        String telefono = "6441092567";
//        byte[] avatar = String.format("hola").getBytes();
//        Municipio ciudad = new Municipio("Obregon", new Estado("Sonora", null));
//        Date fechaNacimiento = new Date();
//        Genero genero = Genero.HOMBRE;
//        List<Comun> listaComunes = new ArrayList<>();
//        
//        Admor admin = new Admor(listaAnclados, nombreCompleto, email, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, listaComunes);
//        
//        admorDAO.guardar(admin);
    }
    
}
