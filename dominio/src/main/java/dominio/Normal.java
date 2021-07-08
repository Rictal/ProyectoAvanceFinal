/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.enums.Genero;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Alfon
 */
@Entity
@DiscriminatorValue(value = "normal")
public class Normal extends Usuario implements Serializable {

    @OneToMany(mappedBy = "normal", cascade = CascadeType.ALL)
    List<Comentario> comentarios;

    public Normal() {
    }

    public Normal(String nombreCompleto, String email, String contrasenia
            , String telefono, Municipio ciudad, Date fechaNacimiento, Genero genero) {   
        super(nombreCompleto, email, contrasenia, telefono, ciudad, fechaNacimiento, genero);
    }

     

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Normal)) {
            return false;
        }
        Normal other = (Normal) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Normal{" + super.toString() + "comentarios=" + comentarios + '}';
    }

}
