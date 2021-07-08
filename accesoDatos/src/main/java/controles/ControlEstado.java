package controles;

import dao.FabricaFachadaDAO;
import dominio.Estado;
import dao.IFachada;

import java.util.List;

class ControlEstado implements BaseControl<Estado> {

    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlEstado() {
    }

    private static class SingletonInstance {
        private static final ControlEstado SingletonInstance = new ControlEstado();
    }

    public static ControlEstado getInstance() {
        return ControlEstado.SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Estado entidad) {
        return fachada.guardarEstado(entidad);
    }

    @Override
    public boolean actualizar(Estado entidad) {
        return fachada.actualizarEstado(entidad);
    }

    @Override
    public Estado buscarporID(long id) {
        return fachada.buscarIDEstado(id);
    }

    @Override
    public List<Estado> buscarTodas() {
        return fachada.buscarTodasEstado();
    }

    @Override
    public boolean eliminar(long id) {
        return fachada.eliminarEstado(id);
    }

    @Override
    public List<Estado> buscarComo(String busqueda) {
        return fachada.buscarComoEstado(busqueda);
    }
}
