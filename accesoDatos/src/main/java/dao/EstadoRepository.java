package dao;

import dominio.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

class EstadoRepository extends BaseRepository<Estado> {

    private EstadoRepository() {
    }

    private static class SingletonInstance{
        private static final EstadoRepository estadoRepository= new EstadoRepository();
    }
    
    public static EstadoRepository getInstance() {
        return SingletonInstance.estadoRepository;
    }
    
    @Override
    public boolean guardar(Estado entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Estado entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Estado estado = entityManager.find(Estado.class, entidad.getIdestado());
        if (estado != null) {
            estado.setNombre(entidad.getNombre());
            estado.setMunicipios(entidad.getMunicipios());
            entityManager.merge(estado);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Estado buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Estado estado = entityManager.find(Estado.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return estado;
    }

    @Override
    public List<Estado> buscarTodas() {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Estado.class));
        Query query = em.createQuery(cq);
        ArrayList<Estado> estados = new ArrayList<>(query.getResultList());
        em.getTransaction().commit();
        em.close();
        return estados;
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        Estado estado = em.find(Estado.class, id);
        if (estado != null) {
            em.remove(estado);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Estado> buscarComo(String busqueda) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Estado> cq = builder.createQuery(Estado.class);
        Root<Estado> root = cq.from(Estado.class);
        cq = cq.select(root).where(builder.like(root.get("nombre"), "%" + busqueda + "%"));
        TypedQuery<Estado> typedQuery = em.createQuery(cq);
        ArrayList<Estado> estados = new ArrayList<>(typedQuery.getResultList());
        em.getTransaction().commit();
        em.close();
        return estados;
    }

}
