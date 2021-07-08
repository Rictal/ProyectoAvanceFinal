package controles;

import dao.FabricaFachadaDAO;
import dao.IFachada;
import dominio.Usuario;

import java.util.List;

class ControlUsuario implements BaseControl<Usuario> {
    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlUsuario() {
    }

    private static class SingletonInstance {
        private static final ControlUsuario SingletonInstance = new ControlUsuario();
    }

    public static ControlUsuario getInstance() {
        return SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Usuario entidad) {
        return this.fachada.guardarUsuario(entidad);
    }

    @Override
    public boolean actualizar(Usuario entidad) {
        return this.fachada.actualizarUsuario(entidad);
    }

    @Override
    public Usuario buscarporID(long id) {
        return this.fachada.buscarIDUsuario(id);
    }

    @Override
    public List<Usuario> buscarTodas() {
        return this.fachada.buscarTodasUsuario();
    }

    @Override
    public boolean eliminar(long id) {
        return this.fachada.eliminarUsuario(id);
    }

    @Override
    public List<Usuario> buscarComo(String busqueda) {
        return this.fachada.buscarComoUsuario(busqueda);
    }
}
