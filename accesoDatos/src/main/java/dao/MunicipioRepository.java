/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Municipio;
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
class MunicipioRepository extends BaseRepository<Municipio> {

    private MunicipioRepository() {
    }
    
    private static class SingletonInstance {
        private final static MunicipioRepository municipioRepository = new MunicipioRepository();
    }

    public static MunicipioRepository getInstance() {
        return SingletonInstance.municipioRepository;
    }
    
    @Override
    public boolean guardar(Municipio entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Municipio entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Municipio municipio = entityManager.find(Municipio.class, entidad.getIdmunicipio());
        if (municipio != null) {
            municipio.setEstado(entidad.getEstado());
            municipio.setNombre(entidad.getNombre());
            municipio.setUsuarios(entidad.getUsuarios());
            entityManager.merge(municipio);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Municipio buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Municipio municipio = entityManager.find(Municipio.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return municipio;
    }

    @Override
    public List<Municipio> buscarTodas() {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Municipio.class));
        Query query = em.createQuery(cq);
        ArrayList<Municipio> municipios = new ArrayList<>(query.getResultList());
        em.getTransaction().commit();
        em.close();
        return municipios;
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        Municipio municipio = em.find(Municipio.class, id);
        if (municipio != null) {
            em.remove(municipio);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Municipio> buscarComo(String busqueda) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Municipio> cq = builder.createQuery(Municipio.class);
        Root<Municipio> root = cq.from(Municipio.class);
        cq = cq.select(root).where(builder.like(root.get("nombre"), "%" + busqueda + "%"));
        TypedQuery<Municipio> typedQuery = em.createQuery(cq);
        ArrayList<Municipio> admins = new ArrayList<>(typedQuery.getResultList());
        em.getTransaction().commit();
        em.close();
        return admins;
    }

}
