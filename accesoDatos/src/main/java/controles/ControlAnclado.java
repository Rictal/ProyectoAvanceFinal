package controles;

import dao.FabricaFachadaDAO;
import dominio.Anclado;
import dao.IFachada;

import java.util.List;

class ControlAnclado implements BaseControl<Anclado> {

    private final IFachada fachada = FabricaFachadaDAO.getInstance();

    private ControlAnclado() {

    }

    private static class SingletonInstance {
        private static final ControlAnclado SingletonInstance = new ControlAnclado();
    }

    public static ControlAnclado getInstance() {
        return ControlAnclado.SingletonInstance.SingletonInstance;
    }

    @Override
    public boolean guardar(Anclado entidad) {
        return fachada.guardarAnclado(entidad);
    }

    @Override
    public boolean actualizar(Anclado entidad) {
        return fachada.actualizarAnclado(entidad);
    }

    @Override
    public Anclado buscarporID(long id) {
        return fachada.buscarporIDAAnclado(id);
    }

    @Override
    public List<Anclado> buscarTodas() {
        return fachada.buscarTodasAnclado();
    }

    @Override
    public boolean eliminar(long id) {
        return fachada.eliminarAnclado(id);
    }

    @Override
    public List<Anclado> buscarComo(String busqueda) {
        return fachada.buscarComoAnclado(busqueda);
    }
}
