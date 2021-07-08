/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Post;
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
class PostRepository extends BaseRepository<Post> {

    private PostRepository() {
    }

    private static class SingletonInstance {
        private final static PostRepository postRepository = new PostRepository();
    }

    public static PostRepository getInstance() {
        return SingletonInstance.postRepository;
    }

    @Override
    public boolean guardar(Post entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Post entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, entidad.getId());
        if (post != null) {
            post.setTitulo(entidad.getTitulo());
            post.setFechaHoraCreacion(entidad.getFechaHoraCreacion());
            post.setContenido(entidad.getContenido());
            post.setFechaHoraEdicion(entidad.getFechaHoraEdicion());
            entityManager.merge(post);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Post buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return post;
    }

    @Override
    public List<Post> buscarTodas() {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Post.class));
        Query query = em.createQuery(cq);
        ArrayList<Post> posts = new ArrayList<>(query.getResultList());
        em.getTransaction().commit();
        em.close();
        return posts;
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        Post post = em.find(Post.class, id);
        if (post != null) {
            em.remove(post);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Post> buscarComo(String busqueda) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Post> cq = builder.createQuery(Post.class);
        Root<Post> root = cq.from(Post.class);
        cq = cq.select(root).where(builder.like(root.get("titulo"), "%" + busqueda + "%"));
        TypedQuery<Post> typedQuery = em.createQuery(cq);
        ArrayList<Post> posts = new ArrayList<>(typedQuery.getResultList());
        em.getTransaction().commit();
        em.close();
        return posts;
    }

}
