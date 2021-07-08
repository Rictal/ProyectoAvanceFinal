package controles;

import dao.FabricaFachadaDAO;
import dao.IFachada;
import dominio.Post;

import java.util.List;

class ControlPost implements BaseControl<Post>{
    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlPost() {
    }

    private static class SingletonInstance {
        private static final ControlPost SingletonInstance = new ControlPost();
    }

    public static ControlPost getInstance() {
        return ControlPost.SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Post entidad) {
        return this.fachada.guardarPost(entidad);
    }

    @Override
    public boolean actualizar(Post entidad) {
        return this.fachada.actualizarPost(entidad);
    }

    @Override
    public Post buscarporID(long id) {
        return this.fachada.buscarIDPost(id);
    }

    @Override
    public List<Post> buscarTodas() {
        return this.fachada.buscarTodasPost();
    }

    @Override
    public boolean eliminar(long id) {
        return this.fachada.eliminarPost(id);
    }

    @Override
    public List<Post> buscarComo(String busqueda) {
        return this.fachada.buscarComoPost(busqueda);
    }
}
