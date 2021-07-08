/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alfon
 */
@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Comentario instance;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomentario")
    private Long id;

    @Column(name = "fechaHora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @ManyToOne(optional = false, targetEntity = Comun.class)
    @JoinColumn(name = "idcomun", nullable = false)
    private Comun comun;

    @ManyToOne(targetEntity = Normal.class, optional = false)
    @JoinColumn(name = "idusuario", nullable = false)
    private Normal normal;

    private Comentario() {
    }

    private Comentario(Date fechaHora, String contenido, Comun comun, Normal normal) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.comun = comun;
        this.normal = normal;
    }

    private Comentario(Long id, Date fechaHora, String contenido, Comun comun, Normal normal) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.comun = comun;
        this.normal = normal;
    }

    public static Comentario getInstance() {
        if (instance == null) {
            instance = new Comentario();
        }
        return instance;
    }
    
    public static Comentario getInstance(Date fechaHora, String contenido, Comun comun, Normal normal) {
        if (instance == null) {
            instance = new Comentario(fechaHora, contenido, comun, normal);
        }
        return instance;
    }
    
    public static Comentario getInstance(Long id, Date fechaHora, String contenido, Comun comun, Normal normal) {
        if (instance == null) {
            instance = new Comentario(id, fechaHora, contenido, comun, normal);
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Comun getComun() {
        return comun;
    }

    public void setComun(Comun comun) {
        this.comun = comun;
    }

    public Normal getNormal() {
        return normal;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
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
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", comun=" + comun + ", comentarios=" + '}';
    }

}
