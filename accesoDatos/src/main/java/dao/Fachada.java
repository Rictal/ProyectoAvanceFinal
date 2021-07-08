package dao;

import dominio.*;

import java.util.List;

/**
 * @author Alfon
 */
class Fachada implements IFachada {

    private Fachada() {
    }

    private static class SingletonInstance {

        private final static Fachada facade = new Fachada();
    }

    static Fachada getInstance() {
        return SingletonInstance.facade;
    }

    private final AdmorRepository admorRepository = AdmorRepository.getInstance();
    private final AncladoRepository ancladoRepository = AncladoRepository.getInstance();
    private final ComentarioRepository comentarioRepository = ComentarioRepository.getInstance();
    private final ComunRepository comunRepository = ComunRepository.getInstance();
    private final EstadoRepository estadoRepository = EstadoRepository.getInstance();
    private final MunicipioRepository municipioRepository = MunicipioRepository.getInstance();
    private final NormalRepository normalRepository = NormalRepository.getInstance();
    private final PostRepository postRepository = PostRepository.getInstance();
    private final UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    @Override
    public boolean guardarAdmor(Admor entidad) {
        return this.admorRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarAdmor(Admor entidad) {
        return this.admorRepository.actualizar(entidad);
    }

    @Override
    public Admor buscarporIDAdmor(long id) {
        return this.admorRepository.buscarporID(id);
    }

    @Override
    public List<Admor> buscarTodasAdmor() {
        return this.admorRepository.buscarTodas();
    }

    @Override
    public boolean eliminarAdmor(long id) {
        return this.admorRepository.eliminar(id);
    }

    @Override
    public List<Admor> buscarComoAdmor(String busqueda) {
        return this.admorRepository.buscarComo(busqueda);
    }

    @Override
    public boolean guardarAnclado(Anclado entidad) {
        return this.ancladoRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarAnclado(Anclado entidad) {
        return this.ancladoRepository.actualizar(entidad);
    }

    @Override
    public Anclado buscarporIDAAnclado(long id) {
        return this.ancladoRepository.buscarporID(id);
    }

    @Override
    public List<Anclado> buscarTodasAnclado() {
        return this.ancladoRepository.buscarTodas();
    }

    @Override
    public boolean eliminarAnclado(long id) {
        return this.ancladoRepository.eliminar(id);
    }

    @Override
    public List<Anclado> buscarComoAnclado(String busqueda) {
        return this.ancladoRepository.buscarComo(busqueda);
    }

    @Override
    public boolean guardarComentario(Comentario entidad) {
        return this.comentarioRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarComentario(Comentario entidad) {
        return this.comentarioRepository.actualizar(entidad);
    }

    @Override
    public Comentario buscarIDComentario(long id) {
        return this.comentarioRepository.buscarporID(id);
    }

    @Override
    public List<Comentario> buscarTodasComentario() {
        return this.comentarioRepository.buscarTodas();
    }

    @Override
    public boolean eliminarComentario(long id) {
        return this.comentarioRepository.eliminar(id);
    }

    @Override
    public List<Comentario> buscarComoComentario(String busqueda) {
        return this.comentarioRepository.buscarComo(busqueda);
    }

    @Override
    public boolean guardarComun(Comun entidad) {
        return this.comunRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarComun(Comun entidad) {
        return this.comunRepository.actualizar(entidad);
    }

    @Override
    public Comun buscarIDComun(long id) {
        return this.comunRepository.buscarporID(id);
    }

    @Override
    public List<Comun> buscarTodasComun() {
        return this.comunRepository.buscarTodas();
    }

    @Override
    public boolean eliminarComun(long id) {
        return this.comunRepository.eliminar(id);
    }

    @Override
    public List<Comun> buscarComoComun(String busqueda) {
        return this.comunRepository.buscarComo(busqueda);
    }

    @Override
    public boolean guardarEstado(Estado entidad) {
        return this.estadoRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarEstado(Estado entidad) {
        return this.estadoRepository.actualizar(entidad);
    }

    @Override
    public Estado buscarIDEstado(long id) {
        return this.estadoRepository.buscarporID(id);
    }

    @Override
    public List<Estado> buscarTodasEstado() {
        return this.estadoRepository.buscarTodas();
    }

    @Override
    public boolean eliminarEstado(long id) {
        return this.estadoRepository.eliminar(id);
    }

    @Override
    public List<Estado> buscarComoEstado(String busqueda) {
        return this.estadoRepository.buscarComo(busqueda);
    }

    @Override
    public boolean guardarMunicipio(Municipio entidad) {
        return this.municipioRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarMunicipio(Municipio entidad) {
        return this.municipioRepository.actualizar(entidad);
    }

    @Override
    public Municipio buscarIDMunicipio(long id) {
        return this.municipioRepository.buscarporID(id);
    }

    @Override
    public List<Municipio> buscarTodasMunicipio() {
        return this.municipioRepository.buscarTodas();
    }

    @Override
    public boolean eliminarMunicipio(long id) {
        return this.municipioRepository.eliminar(id);
    }

    @Override
    public List<Municipio> buscarComoMunicipio(String busqueda) {
        return this.municipioRepository.buscarComo(busqueda);
    }

    @Override
    public boolean guardarNormal(Normal entidad) {
        return this.normalRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarNormal(Normal entidad) {
        return this.normalRepository.actualizar(entidad);
    }

    @Override
    public Normal buscarIDNormal(long id) {
        return this.normalRepository.buscarporID(id);
    }

    @Override
    public List<Normal> buscarTodasNormal() {
        return this.normalRepository.buscarTodas();
    }

    @Override
    public boolean eliminarNormal(long id) {
        return this.normalRepository.eliminar(id);
    }

    @Override
    public List<Normal> buscarComoNormal(String busqueda) {
        return this.normalRepository.buscarComo(busqueda);
    }

    @Override
    public boolean guardarPost(Post entidad) {
        return this.postRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarPost(Post entidad) {
        return this.postRepository.actualizar(entidad);
    }

    @Override
    public Post buscarIDPost(long id) {
        return this.postRepository.buscarporID(id);
    }

    @Override
    public List<Post> buscarTodasPost() {
        return this.postRepository.buscarTodas();
    }

    @Override
    public boolean eliminarPost(long id) {
        return this.postRepository.eliminar(id);
    }

    @Override
    public List<Post> buscarComoPost(String busqueda) {
        return this.postRepository.buscarComo(busqueda);
    }

    @Override
    public boolean guardarUsuario(Usuario entidad) {
        return this.usuarioRepository.guardar(entidad);
    }

    @Override
    public boolean actualizarUsuario(Usuario entidad) {
        return this.usuarioRepository.actualizar(entidad);
    }

    @Override
    public Usuario buscarIDUsuario(long id) {
        return this.usuarioRepository.buscarporID(id);
    }

    @Override
    public List<Usuario> buscarTodasUsuario() {
        return this.usuarioRepository.buscarTodas();
    }

    @Override
    public boolean eliminarUsuario(long id) {
        return this.usuarioRepository.eliminar(id);
    }

    @Override
    public List<Usuario> buscarComoUsuario(String busqueda) {
        return this.usuarioRepository.buscarComo(busqueda);
    }

}
