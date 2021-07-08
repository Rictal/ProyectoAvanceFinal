/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alfon
 */
@Entity
@Table(name = "municipios")
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmunicipio")
    private Long idmunicipio;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(optional = false, targetEntity = Estado.class)
    @JoinColumn(name = "idestado", nullable = true)
    private Estado estado;
    
    @OneToMany(mappedBy = "ciudad",cascade = CascadeType.ALL)
    private List<Usuario> usuarios;
    
    public Municipio() {
    }

    public Municipio(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Long idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipio != null ? idmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idmunicipio == null && other.idmunicipio != null) || (this.idmunicipio != null && !this.idmunicipio.equals(other.idmunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Municipio{" + "idmunicipio=" + idmunicipio + ", nombre=" + nombre + ", estado=" + estado + ", usuarios=" + usuarios + '}';
    }

}
