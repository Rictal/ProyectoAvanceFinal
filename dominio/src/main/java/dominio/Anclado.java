/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alfon
 */
 @Entity
@Table(name = "anclados")
@DiscriminatorValue(value = "anclado")
public class Anclado extends Post implements Serializable {
    
    @ManyToOne(targetEntity = Admor.class, optional = false)
    @JoinColumn(name = "idusuario",nullable = false)
    private Admor admin;
    
    public Anclado() {
    }

    public Anclado(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }

    public Admor getAdmin() {
        return admin;
    }

    public void setAdmin(Admor admin) {
        this.admin = admin;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anclado)) {
            return false;
        }
        Anclado other = (Anclado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Anclado{" + "id=" + id + '}';
    }

}