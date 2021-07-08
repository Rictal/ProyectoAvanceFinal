/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Comun;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author l3tal
 */
class ComunRepository extends BaseRepository<Comun> {

    private ComunRepository() {
    }

    private static class SingletonInstance {
        private final static ComunRepository comunRepository = new ComunRepository();
    }

    public static ComunRepository getInstance() {
        return SingletonInstance.comunRepository;
    }

    @Override
    public boolean guardar(Comun entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Comun entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Comun comun = entityManager.find(Comun.class, entidad.getId());
        if (comun != null) {
            comun.setContenido(entidad.getContenido());
            comun.setComentarios(entidad.getComentarios());
            comun.setFechaHoraCreacion(entidad.getFechaHoraCreacion());
            comun.setFechaHoraEdicion(entidad.getFechaHoraEdicion());
            comun.setTitulo(entidad.getTitulo());
            comun.setUsuario(entidad.getUsuario());
            entityManager.merge(comun);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Comun buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Comun comun = entityManager.find(Comun.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return comun;
    }

    @Override
    public List<Comun> buscarTodas() {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Comun.class));
        Query query = em.createQuery(cq);
        ArrayList<Comun> comunes = new ArrayList<>(query.getResultList());
        em.getTransaction().commit();
        em.close();
        return comunes;
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        Comun comun = em.find(Comun.class, id);
        if (comun != null) {
            em.remove(comun);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Comun> buscarComo(String busqueda) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Comun> cq = builder.createQuery(Comun.class);
        Root<Comun> root = cq.from(Comun.class);
        cq = cq.select(root).where(builder.like(root.get("titulo"), "%" + busqueda + "%"));
        TypedQuery<Comun> typedQuery = em.createQuery(cq);
        ArrayList<Comun> comunes = new ArrayList<>(typedQuery.getResultList());
        em.getTransaction().commit();
        em.close();
        return comunes;
    }

}
