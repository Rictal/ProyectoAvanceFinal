package controles;

import dominio.*;
import java.util.List;

class Fachada implements IFachada {

    private Fachada() {
    }

    private static class SingletonInstance{
        private final static Fachada facade = new Fachada();
    }
    
    static Fachada getInstance(){
        return SingletonInstance.facade;
    }
    
    private final ControlAdmor controlAdmor = ControlAdmor.getInstance();
    private final ControlAnclado controlAnclado = ControlAnclado.getInstance();
    private final ControlComentario controlComentario = ControlComentario.getInstance();
    private final ControlComun controlComun = ControlComun.getInstance();
    private final ControlEstado controlEstado = ControlEstado.getInstance();
    private final ControlMunicipio controlMunicipio = ControlMunicipio.getInstance();
    private final ControlNormal controlNormal = ControlNormal.getInstance();
    private final ControlUsuario controlUsuario = ControlUsuario.getInstance();
    private final ControlPost controlPost = ControlPost.getInstance();

    @Override
    public boolean guardarAdmor(Admor entidad) {
        return this.controlAdmor.guardar(entidad);
    }

    @Override
    public boolean actualizarAdmor(Admor entidad) {
        return this.controlAdmor.actualizar(entidad);
    }

    @Override
    public Admor buscarporIDAdmor(long id) {
        return this.controlAdmor.buscarporID(id);
    }

    @Override
    public List<Admor> buscarTodasAdmor() {
        return this.controlAdmor.buscarTodas();
    }

    @Override
    public boolean eliminarAdmor(long id) {
        return this.controlAdmor.eliminar(id);
    }

    @Override
    public List<Admor> buscarComoAdmor(String busqueda) {
        return this.controlAdmor.buscarComo(busqueda);
    }

    @Override
    public boolean guardarAnclado(Anclado entidad) {
        return this.controlAnclado.guardar(entidad);
    }

    @Override
    public boolean actualizarAnclado(Anclado entidad) {
        return this.controlAnclado.actualizar(entidad);
    }

    @Override
    public Anclado buscarporIDAAnclado(long id) {
        return this.controlAnclado.buscarporID(id);
    }

    @Override
    public List<Anclado> buscarTodasAnclado() {
        return this.controlAnclado.buscarTodas();
    }

    @Override
    public boolean eliminarAnclado(long id) {
        return this.controlAnclado.eliminar(id);
    }

    @Override
    public List<Anclado> buscarComoAnclado(String busqueda) {
        return this.controlAnclado.buscarComo(busqueda);
    }

    @Override
    public boolean guardarComentario(Comentario entidad) {
        return this.controlComentario.guardar(entidad);
    }

    @Override
    public boolean actualizarComentario(Comentario entidad) {
        return this.controlComentario.actualizar(entidad);
    }

    @Override
    public Comentario buscarIDComentario(long id) {
        return this.controlComentario.buscarporID(id);
    }

    @Override
    public List<Comentario> buscarTodasComentario() {
        return this.controlComentario.buscarTodas();
    }

    @Override
    public boolean eliminarComentario(long id) {
        return this.controlComentario.eliminar(id);
    }

    @Override
    public List<Comentario> buscarComoComentario(String busqueda) {
        return this.controlComentario.buscarComo(busqueda);
    }

    @Override
    public boolean guardarComun(Comun entidad) {
        return this.controlComun.guardar(entidad);
    }

    @Override
    public boolean actualizarComun(Comun entidad) {
        return this.controlComun.actualizar(entidad);
    }

    @Override
    public Comun buscarIDComun(long id) {
        return this.controlComun.buscarporID(id);
    }

    @Override
    public List<Comun> buscarTodasComun() {
        return this.controlComun.buscarTodas();
    }

    @Override
    public boolean eliminarComun(long id) {
        return this.controlComun.eliminar(id);
    }

    @Override
    public List<Comun> buscarComoComun(String busqueda) {
        return this.controlComun.buscarComo(busqueda);
    }

    @Override
    public boolean guardarEstado(Estado entidad) {
        return this.controlEstado.guardar(entidad);
    }

    @Override
    public boolean actualizarEstado(Estado entidad) {
        return this.controlEstado.actualizar(entidad);
    }

    @Override
    public Estado buscarIDEstado(long id) {
        return this.controlEstado.buscarporID(id);
    }

    @Override
    public List<Estado> buscarTodasEstado() {
        return this.controlEstado.buscarTodas();
    }

    @Override
    public boolean eliminarEstado(long id) {
        return this.controlEstado.eliminar(id);
    }

    @Override
    public List<Estado> buscarComoEstado(String busqueda) {
        return this.controlEstado.buscarComo(busqueda);
    }

    @Override
    public boolean guardarMunicipio(Municipio entidad) {
        return this.controlMunicipio.guardar(entidad);
    }

    @Override
    public boolean actualizarMunicipio(Municipio entidad) {
        return this.controlMunicipio.actualizar(entidad);
    }

    @Override
    public Municipio buscarIDMunicipio(long id) {
        return this.controlMunicipio.buscarporID(id);
    }

    @Override
    public List<Municipio> buscarTodasMunicipio() {
        return this.controlMunicipio.buscarTodas();
    }

    @Override
    public boolean eliminarMunicipio(long id) {
        return this.controlMunicipio.eliminar(id);
    }

    @Override
    public List<Municipio> buscarComoMunicipio(String busqueda) {
        return this.controlMunicipio.buscarComo(busqueda);
    }

    @Override
    public boolean guardarNormal(Normal entidad) {
        return this.controlNormal.guardar(entidad);
    }

    @Override
    public boolean actualizarNormal(Normal entidad) {
        return this.controlNormal.actualizar(entidad);
    }

    @Override
    public Normal buscarIDNormal(long id) {
        return this.controlNormal.buscarporID(id);
    }

    @Override
    public List<Normal> buscarTodasNormal() {
        return this.controlNormal.buscarTodas();
    }

    @Override
    public boolean eliminarNormal(long id) {
        return this.controlNormal.eliminar(id);
    }

    @Override
    public List<Normal> buscarComoNormal(String busqueda) {
        return this.controlNormal.buscarComo(busqueda);
    }

    @Override
    public boolean guardarPost(Post entidad) {
        return this.controlPost.guardar(entidad);
    }

    @Override
    public boolean actualizarPost(Post entidad) {
        return this.controlPost.actualizar(entidad);
    }

    @Override
    public Post buscarIDPost(long id) {
        return this.controlPost.buscarporID(id);
    }

    @Override
    public List<Post> buscarTodasPost() {
        return this.controlPost.buscarTodas();
    }

    @Override
    public boolean eliminarPost(long id) {
        return this.controlPost.eliminar(id);
    }

    @Override
    public List<Post> buscarComoPost(String busqueda) {
        return this.controlPost.buscarComo(busqueda);
    }

    @Override
    public boolean guardarUsuario(Usuario entidad) {
        return this.controlUsuario.guardar(entidad);
    }

    @Override
    public boolean actualizarUsuario(Usuario entidad) {
        return this.controlUsuario.actualizar(entidad);
    }

    @Override
    public Usuario buscarIDUsuario(long id) {
        return this.controlUsuario.buscarporID(id);
    }

    @Override
    public List<Usuario> buscarTodasUsuario() {
        return this.controlUsuario.buscarTodas();
    }

    @Override
    public boolean eliminarUsuario(long id) {
        return this.controlUsuario.eliminar(id);
    }

    @Override
    public List<Usuario> buscarComoUsuario(String busqueda) {
        return this.controlUsuario.buscarComo(busqueda);
    }
}
