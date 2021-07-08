package controles;

import java.util.List;

public interface BaseControl <T>{
    public abstract boolean guardar(T entidad);
    public abstract boolean actualizar(T entidad);
    public abstract T buscarporID(long id);
    public abstract List<T> buscarTodas();
    public abstract boolean eliminar(long id);
    public abstract List<T> buscarComo(String busqueda);
}
