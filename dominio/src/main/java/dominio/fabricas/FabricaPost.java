package dominio.fabricas;

import dominio.Post;
import dominio.enums.TiposPosts;
import dominio.Anclado;
import dominio.Comun;

public class FabricaPost {

    public static Post getPost(String tipoPost) {
        if (tipoPost == null && tipoPost.equals("")) {
            return null;
        }
        if (tipoPost.equalsIgnoreCase(TiposPosts.ANCLADO.toString())) {
            return new Anclado();
        } else if (tipoPost.equalsIgnoreCase(TiposPosts.COMUN.toString())) {
            return new Comun();
        }
        return null;
    }

}
