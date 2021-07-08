package controles;

import dao.FabricaFachadaDAO;
import dao.IFachada;
import dominio.Normal;

import java.util.List;

class ControlNormal implements BaseControl<Normal> {
    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlNormal() {
    }

    private static class SingletonInstance {
        private static final ControlNormal SingletonInstance = new ControlNormal();
    }

    public static ControlNormal getInstance() {
        return ControlNormal.SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Normal entidad) {
        return this.fachada.guardarNormal(entidad);
    }

    @Override
    public boolean actualizar(Normal entidad) {
        return this.fachada.actualizarNormal(entidad);
    }

    @Override
    public Normal buscarporID(long id) {
        return this.fachada.buscarIDNormal(id);
    }

    @Override
    public List<Normal> buscarTodas() {
        return this.fachada.buscarTodasNormal();
    }

    @Override
    public boolean eliminar(long id) {
        return this.fachada.eliminarNormal(id);
    }

    @Override
    public List<Normal> buscarComo(String busqueda) {
        return this.fachada.buscarComoNormal(busqueda);
    }
}
