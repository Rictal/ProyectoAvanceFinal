package com.utils;

import dominio.Usuario;
import java.util.Base64;

public class CargarImagen {

    public static String cargarImagen(Usuario usuario) {
        if (usuario.getAvatar() != null) {
            byte[] photo = usuario.getAvatar();
            String bphoto = Base64.getEncoder().encodeToString(photo);
            return "<img src=\"data:image/png;base64," 
                                + bphoto 
                                + "\" width=\"75\"  height=\"75\" id=\"userImg\" alt=\"ImgUsuario\" />";
        }
        
        return "<img src=\"https://upload.wikimedia.org/wikipedia/commons/d/d3/User_Circle.png\" width=\"75\"  height=\"75\" alt=\"usuario\" id=\"userImg\" />";
        
    }
}
