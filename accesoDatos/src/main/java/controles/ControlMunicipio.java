package controles;

import dao.FabricaFachadaDAO;
import dominio.Municipio;
import dao.IFachada;

import java.util.List;

class ControlMunicipio implements BaseControl<Municipio> {

    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlMunicipio() {
    }

    private static class SingletonInstance {
        private static final ControlMunicipio SingletonInstance = new ControlMunicipio();
    }

    public static ControlMunicipio getInstance() {
        return ControlMunicipio.SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Municipio entidad) {
        return fachada.guardarMunicipio(entidad);
    }

    @Override
    public boolean actualizar(Municipio entidad) {
        return fachada.actualizarMunicipio(entidad);
    }

    @Override
    public Municipio buscarporID(long id) {
        return fachada.buscarIDMunicipio(id);
    }

    @Override
    public List<Municipio> buscarTodas() {
        return fachada.buscarTodasMunicipio();
    }

    @Override
    public boolean eliminar(long id) {
        return fachada.eliminarMunicipio(id);
    }

    @Override
    public List<Municipio> buscarComo(String busqueda) {
        return fachada.buscarComoMunicipio(busqueda);
    }
}
