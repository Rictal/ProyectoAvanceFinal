package controles;

import dao.FabricaFachadaDAO;
import dominio.Comentario;
import dao.IFachada;

import java.util.List;

class ControlComentario implements BaseControl<Comentario> {

    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlComentario() {

    }

    private static class SingletonInstance {
        private static final ControlComentario SingletonInstance = new ControlComentario();
    }

    public static ControlComentario getInstance() {
        return ControlComentario.SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Comentario entidad) {
        return fachada.guardarComentario(entidad);
    }

    @Override
    public boolean actualizar(Comentario entidad) {
        return fachada.actualizarComentario(entidad);
    }

    @Override
    public Comentario buscarporID(long id) {
        return fachada.buscarIDComentario(id);
    }

    @Override
    public List<Comentario> buscarTodas() {
        return fachada.buscarTodasComentario();
    }

    @Override
    public boolean eliminar(long id) {
        return fachada.eliminarComentario(id);
    }

    @Override
    public List<Comentario> buscarComo(String busqueda) {
        return fachada.buscarComoComentario(busqueda);
    }
}
