package controles;

import dominio.*;

import java.util.List;

public interface IFachada {
    //Admor
    public abstract boolean guardarAdmor(Admor entidad);
    public abstract boolean actualizarAdmor(Admor entidad);
    public abstract Admor buscarporIDAdmor(long id);
    public abstract List<Admor> buscarTodasAdmor();
    public abstract boolean eliminarAdmor(long id);
    public abstract List<Admor> buscarComoAdmor(String busqueda);
    //Anclado
    public abstract boolean guardarAnclado(Anclado entidad);
    public abstract boolean actualizarAnclado(Anclado entidad);
    public abstract Anclado buscarporIDAAnclado(long id);
    public abstract List<Anclado> buscarTodasAnclado();
    public abstract boolean eliminarAnclado(long id);
    public abstract List<Anclado> buscarComoAnclado(String busqueda);
    //Comentario
    public abstract boolean guardarComentario(Comentario entidad);
    public abstract boolean actualizarComentario(Comentario entidad);
    public abstract Comentario buscarIDComentario(long id);
    public abstract List<Comentario> buscarTodasComentario();
    public abstract boolean eliminarComentario(long id);
    public abstract List<Comentario> buscarComoComentario(String busqueda);
    //Comun
    public abstract boolean guardarComun(Comun entidad);
    public abstract boolean actualizarComun(Comun entidad);
    public abstract Comun buscarIDComun(long id);
    public abstract List<Comun> buscarTodasComun();
    public abstract boolean eliminarComun(long id);
    public abstract List<Comun> buscarComoComun(String busqueda);
    //Estado
    public abstract boolean guardarEstado(Estado entidad);
    public abstract boolean actualizarEstado(Estado entidad);
    public abstract Estado buscarIDEstado(long id);
    public abstract List<Estado> buscarTodasEstado();
    public abstract boolean eliminarEstado(long id);
    public abstract List<Estado> buscarComoEstado(String busqueda);
    //Municipio
    public abstract boolean guardarMunicipio(Municipio entidad);
    public abstract boolean actualizarMunicipio(Municipio entidad);
    public abstract Municipio buscarIDMunicipio(long id);
    public abstract List<Municipio> buscarTodasMunicipio();
    public abstract boolean eliminarMunicipio(long id);
    public abstract List<Municipio> buscarComoMunicipio(String busqueda);
    //Normal
    public abstract boolean guardarNormal(Normal entidad);
    public abstract boolean actualizarNormal(Normal entidad);
    public abstract Normal buscarIDNormal(long id);
    public abstract List<Normal> buscarTodasNormal();
    public abstract boolean eliminarNormal(long id);
    public abstract List<Normal> buscarComoNormal(String busqueda);
    //Post
    public abstract boolean guardarPost(Post entidad);
    public abstract boolean actualizarPost(Post entidad);
    public abstract Post buscarIDPost(long id);
    public abstract List<Post> buscarTodasPost();
    public abstract boolean eliminarPost(long id);
    public abstract List<Post> buscarComoPost(String busqueda);
    //Usuario
    public abstract boolean guardarUsuario(Usuario entidad);
    public abstract boolean actualizarUsuario(Usuario entidad);
    public abstract Usuario buscarIDUsuario(long id);
    public abstract List<Usuario> buscarTodasUsuario();
    public abstract boolean eliminarUsuario(long id);
    public abstract List<Usuario> buscarComoUsuario(String busqueda);
}
