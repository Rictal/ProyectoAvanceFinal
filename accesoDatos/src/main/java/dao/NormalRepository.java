/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Normal;
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
class NormalRepository extends BaseRepository<Normal> {

    private NormalRepository() {
    }
    
    private static class SingletonInstance {
        private final static NormalRepository normalRepository = new NormalRepository();
    }

    public static NormalRepository getInstance() {
        return SingletonInstance.normalRepository;
    }
    
    @Override
    public boolean guardar(Normal entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Normal entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Normal normal = entityManager.find(Normal.class, entidad.getIdusuario());
        if (normal != null) {
            normal.setNombreCompleto(entidad.getNombreCompleto());
            normal.setEmail(entidad.getEmail());
            normal.setContrasenia(entidad.getContrasenia());
            normal.setTelefono(entidad.getTelefono());
            normal.setAvatar(entidad.getAvatar());
            normal.setCiudad(entidad.getCiudad());
            normal.setFechaNacimiento(entidad.getFechaNacimiento());
            normal.setGenero(entidad.getGenero());
            normal.setComunes(entidad.getComunes());
            normal.setComentarios(entidad.getComentarios());
            entityManager.merge(normal);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Normal buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Normal normal = entityManager.find(Normal.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return normal;
    }

    @Override
    public List<Normal> buscarTodas() {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Normal.class));
        Query query = em.createQuery(cq);
        ArrayList<Normal> normales = new ArrayList<>(query.getResultList());
        em.getTransaction().commit();
        em.close();
        return normales;
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        Normal normal = em.find(Normal.class, id);
        if (normal != null) {
            em.remove(normal);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Normal> buscarComo(String busqueda) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Normal> cq = builder.createQuery(Normal.class);
        Root<Normal> root = cq.from(Normal.class);
        cq = cq.select(root).where(builder.like(root.get("nombreCompleto"), "%" + busqueda + "%"));
        TypedQuery<Normal> typedQuery = em.createQuery(cq);
        ArrayList<Normal> normales = new ArrayList<>(typedQuery.getResultList());
        em.getTransaction().commit();
        em.close();
        return normales;
    }

}
