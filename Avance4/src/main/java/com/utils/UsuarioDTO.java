package com.utils;


public class UsuarioDTO {

    private String nombre;
    private String correo;
    private String telefono;
    private int id;
    private String municipio;
    private String estado;
    private boolean admin;
    private String genero;
    private String fechaNacimiento;

    public UsuarioDTO(String nombre, int id, boolean admin) {
        this.nombre = nombre;
        this.id = id;
        this.admin = admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", id=" + id +
                ", municipio='" + municipio + '\'' +
                ", estado='" + estado + '\'' +
                ", admin=" + admin +
                ", genero='" + genero + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
    
}
