/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alfon
 */
@Entity
@DiscriminatorValue(value = "comun")
@Table(name = "comunes")
public class Comun extends Post implements Serializable {

    @OneToMany(mappedBy = "comun", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;
    
    @ManyToOne(targetEntity = Usuario.class,optional = false)
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;
    
    public Comun() {
    }

    public Comun(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public Comun(Long id, List<Comentario> comentarios) {
        this.id = id;
        this.comentarios = comentarios;
    }
        
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Comun)) {
            return false;
        }
        Comun other = (Comun) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comun{" + "id=" + id + ", comentarios=" + comentarios + '}';
    }
    
}
