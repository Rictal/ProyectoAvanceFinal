package controles;

import dao.FabricaFachadaDAO;
import dominio.Admor;
import dao.IFachada;

import java.util.List;

class ControlAdmor implements BaseControl<Admor> {

    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlAdmor() {

    }

    private static class SingletonInstance {
        private static final ControlAdmor SingletonInstance = new ControlAdmor();
    }

    public static ControlAdmor getInstance() {
        return ControlAdmor.SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Admor entidad) {
        return fachada.guardarAdmor(entidad);
    }

    @Override
    public boolean actualizar(Admor entidad) {
        return fachada.actualizarAdmor(entidad);
    }

    @Override
    public Admor buscarporID(long id) {
        return fachada.buscarporIDAdmor(id);
    }

    @Override
    public List<Admor> buscarTodas() {
        return fachada.buscarTodasAdmor();
    }

    @Override
    public boolean eliminar(long id) {
        return fachada.eliminarAdmor(id);
    }

    @Override
    public List<Admor> buscarComo(String busqueda) {
        return fachada.buscarComoAdmor(busqueda);
    }
}
