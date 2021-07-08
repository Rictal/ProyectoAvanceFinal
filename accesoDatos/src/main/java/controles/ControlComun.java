package controles;

import dao.FabricaFachadaDAO;
import dominio.Comun;
import dao.IFachada;

import java.util.List;

class ControlComun implements BaseControl<Comun> {

    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlComun() {

    }

    private static class SingletonInstance {
        private static final ControlComun SingletonInstance = new ControlComun();
    }

    public static ControlComun getInstance() {
        return ControlComun.SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Comun entidad) {
        return fachada.guardarComun(entidad);
    }

    @Override
    public boolean actualizar(Comun entidad) {
        return fachada.actualizarComun(entidad);
    }

    @Override
    public Comun buscarporID(long id) {
        return fachada.buscarIDComun(id);
    }

    @Override
    public List<Comun> buscarTodas() {
        return fachada.buscarTodasComun();
    }

    @Override
    public boolean eliminar(long id) {
        return fachada.eliminarComun(id);
    }

    @Override
    public List<Comun> buscarComo(String busqueda) {
        return fachada.buscarComoComun(busqueda);
    }
}
