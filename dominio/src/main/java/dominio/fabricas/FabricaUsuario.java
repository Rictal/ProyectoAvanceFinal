package dominio.fabricas;

import dominio.enums.TiposUsuarios;
import dominio.Admor;
import dominio.Normal;
import dominio.Usuario;

public class FabricaUsuario {

    public static Usuario getUser(String tipoUsuario) {
        if (tipoUsuario == null && tipoUsuario.equals("")) {
            return null;
        }
        if (tipoUsuario.equalsIgnoreCase(TiposUsuarios.NORMAL.toString())) {
            return new Normal();
        } else if (tipoUsuario.equalsIgnoreCase(TiposUsuarios.ADMIN.toString())) {
            return new Admor();
        }
        return null;
    }
}
