package dao;

import dominio.Anclado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

class AncladoRepository extends BaseRepository<Anclado> {

    private AncladoRepository() {
    }
    
    private static class SingletonInstance {
        private static final AncladoRepository ancladoRepository = new AncladoRepository();
    }
    
    public static AncladoRepository getInstance() {
        return SingletonInstance.ancladoRepository;
    }

    @Override
    public boolean guardar(Anclado entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Anclado entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Anclado anclado = entityManager.find(Anclado.class, entidad.getId());
        if (anclado != null) {
            anclado.setFechaHoraCreacion(entidad.getFechaHoraCreacion());
            anclado.setTitulo(entidad.getTitulo());
            anclado.setContenido(entidad.getContenido());
            anclado.setFechaHoraEdicion(entidad.getFechaHoraEdicion());
            entityManager.merge(anclado);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Anclado buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Anclado anclado = entityManager.find(Anclado.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return anclado;
    }

    @Override
    public List<Anclado> buscarTodas() {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Anclado.class));
        Query query = em.createQuery(cq);
        ArrayList<Anclado> anclados = new ArrayList<>(query.getResultList());
        em.getTransaction().commit();
        em.close();
        return anclados;
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        Anclado anclado = em.find(Anclado.class, id);
        if (anclado != null) {
            em.remove(anclado);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Anclado> buscarComo(String busqueda) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Anclado> cq = builder.createQuery(Anclado.class);
        Root<Anclado> root = cq.from(Anclado.class);
        cq = cq.select(root).where(builder.like(root.get("titulo"), "%" + busqueda + "%"));
        TypedQuery<Anclado> typedQuery = em.createQuery(cq);
        ArrayList<Anclado> pedidos = new ArrayList<>(typedQuery.getResultList());
        em.getTransaction().commit();
        em.close();
        return pedidos;
    }

    
    
}
