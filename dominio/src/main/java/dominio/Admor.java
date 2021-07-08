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
@DiscriminatorValue(value="admin")
public class Admor extends Usuario implements Serializable {

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Anclado> anclados;
    
    public Admor() {
    }

    public Admor(List<Anclado> anclados, String nombreCompleto, String email, String contrasenia, String telefono, Municipio ciudad, Date fechaNacimiento, Genero genero) {
        super(nombreCompleto, email, contrasenia, telefono, ciudad, fechaNacimiento, genero);
        this.anclados = anclados;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    public List<Anclado> getAnclados() {
        return anclados;
    }

    public void setAnclados(List<Anclado> anclados) {
        this.anclados = anclados;
    }
    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admor)) {
            return false;
        }
        Admor other = (Admor) object;
        if ((this.idusuario == null && idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }
}
