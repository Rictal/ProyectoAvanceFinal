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
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alfon
 */
@Entity
@Table(name = "usuarios")
@DiscriminatorColumn(name = "tipousuario", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    protected Long idusuario;
    
    @Column(name="nombreCompleto",nullable = false)
    protected String nombreCompleto;
    
    @Column(name="email",nullable = false, unique = true)
    protected String email;
    
    @Column(name="contrasenia",nullable = false)
    protected String contrasenia;
    
    @Column(name="telefono",nullable = false)
    protected String telefono;
    
    @Column(name = "avatar",nullable = true)
    protected byte[] avatar;
    
    @ManyToOne(optional = false, targetEntity = Municipio.class)
    @JoinColumn(name = "idmunicipio",nullable = false)
    protected Municipio ciudad;
    
    @Column(name = "fechaNacimiento",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaNacimiento;
    
    @Column(name = "genero",nullable = false)
    @Enumerated(EnumType.STRING)
    protected Genero genero;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    protected List<Comun> comunes;

    public Usuario() {
    }

    public Usuario(String nombreCompleto, String email, String contrasenia, String telefono, Municipio ciudad, Date fechaNacimiento, Genero genero) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Usuario(String nombreCompleto, String contrasenia, String telefono, byte[] avatar, Municipio ciudad, Date fechaNacimiento, Genero genero) {
        this.nombreCompleto = nombreCompleto;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }
    
    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public List<Comun> getComunes() {
        return comunes;
    }

    public void setComunes(List<Comun> comunes) {
        this.comunes = comunes;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Municipio getCiudad() {
        return ciudad;
    }

    public void setCiudad(Municipio ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", nombreCompleto=" + nombreCompleto + ", email=" + email + ", contrasenia=" + contrasenia + ", telefono=" + telefono + ", avatar=" + avatar + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + '}';
    }

    
    
}