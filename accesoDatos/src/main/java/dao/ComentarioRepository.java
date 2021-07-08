/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Comentario;
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
class ComentarioRepository extends BaseRepository<Comentario> {

    private ComentarioRepository() {
    }
    
    private static class SingletonInstance {
        private static final ComentarioRepository comentarioRepository = new ComentarioRepository();
    }
    
    public static ComentarioRepository getInstance() {
        return SingletonInstance.comentarioRepository;
    }
    
    @Override
    public boolean guardar(Comentario entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Comentario entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Comentario comentario = entityManager.find(Comentario.class, entidad.getId());
        if (comentario != null) {           
            comentario.setFechaHora(entidad.getFechaHora());
            comentario.setContenido(entidad.getContenido());
            //comun es el post al que pertenece el comentario
            comentario.setComun(entidad.getComun());
            //normal es el usuario al que le pertenece el comentario
            comentario.setNormal(entidad.getNormal());
            entityManager.merge(comentario);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Comentario buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Comentario anclado = entityManager.find(Comentario.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return anclado;
    }

    @Override
    public List<Comentario> buscarTodas() {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Comentario.class));
        Query query = em.createQuery(cq);
        ArrayList<Comentario> comentarios = new ArrayList<>(query.getResultList());
        em.getTransaction().commit();
        em.close();
        return comentarios;
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        Comentario comentario = em.find(Comentario.class, id);
        if (comentario != null) {
            em.remove(comentario);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Comentario> buscarComo(String busqueda) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Comentario> cq = builder.createQuery(Comentario.class);
        Root<Comentario> root = cq.from(Comentario.class);
        cq = cq.select(root).where(builder.like(root.get("contenido"), "%" + busqueda + "%"));
        TypedQuery<Comentario> typedQuery = em.createQuery(cq);
        ArrayList<Comentario> pedidos = new ArrayList<>(typedQuery.getResultList());
        em.getTransaction().commit();
        em.close();
        return pedidos;
    }

}
