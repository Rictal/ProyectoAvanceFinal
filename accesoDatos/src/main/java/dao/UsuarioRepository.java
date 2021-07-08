/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Usuario;
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
class UsuarioRepository extends BaseRepository<Usuario> {

    private UsuarioRepository() {
    }
    
    private static class SingletonInstance {
        private final static UsuarioRepository usuarioRepository = new UsuarioRepository();
    }

    public static UsuarioRepository getInstance() {
        return SingletonInstance.usuarioRepository;
    }
    
    @Override
    public boolean guardar(Usuario entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Usuario entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Usuario usuario = entityManager.find(Usuario.class, entidad.getIdusuario());
        if (usuario != null) {
            usuario.setNombreCompleto(entidad.getNombreCompleto());
            usuario.setEmail(entidad.getEmail());
            usuario.setContrasenia(entidad.getContrasenia());
            usuario.setTelefono(entidad.getTelefono());
            usuario.setAvatar(entidad.getAvatar());
            usuario.setCiudad(entidad.getCiudad());
            usuario.setFechaNacimiento(entidad.getFechaNacimiento());
            usuario.setGenero(entidad.getGenero());
            usuario.setComunes(entidad.getComunes());
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Usuario buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuario;
    }

    @Override
    public List<Usuario> buscarTodas() {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Usuario.class));
        Query query = em.createQuery(cq);
        ArrayList<Usuario> usuarios = new ArrayList<>(query.getResultList());
        em.getTransaction().commit();
        em.close();
        return usuarios;
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.remove(usuario);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().commit();
        em.close();
        return false;
    }

    @Override
    public List<Usuario> buscarComo(String busqueda) {
        EntityManager em = this.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = builder.createQuery(Usuario.class);
        Root<Usuario> root = cq.from(Usuario.class);
        cq = cq.select(root).where(builder.like(root.get("email"), "%" + busqueda + "%"));
        TypedQuery<Usuario> typedQuery = em.createQuery(cq);
        ArrayList<Usuario> admins = new ArrayList<>(typedQuery.getResultList());
        em.getTransaction().commit();
        em.close();
        return admins;
    }

}
