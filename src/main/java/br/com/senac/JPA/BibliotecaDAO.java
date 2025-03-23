
package br.com.senac.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class BibliotecaDAO {
     
     public void cadastrar(Biblioteca biblioteca) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin(); 
            em.persist(biblioteca); 
            em.getTransaction().commit(); 
        } catch(Exception e) {
            em.getTransaction().rollback(); 
            throw e; 
        } finally {
            JPAUtil.closeEtityManager(); 
        }
    }
     
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Biblioteca b = em.find(Biblioteca.class, id); 
            if (b != null) {
                em.getTransaction().begin(); 
                em.remove(b); 
                em.getTransaction().commit(); 
            }
        } catch(Exception e) {
            em.getTransaction().rollback(); 
            throw e; 
        } finally {
            JPAUtil.closeEtityManager(); 
        }
    }
    
    public List<Biblioteca> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Biblioteca> bibliotecas = null;
        try {
            Query consulta = em.createQuery("SELECT b FROM Biblioteca b"); 
            bibliotecas = consulta.getResultList(); 
        } finally {
            JPAUtil.closeEtityManager(); 
        }
        return bibliotecas; 
    }
    
    public List<Biblioteca> listar(String filtroDescricao) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Biblioteca> bibliotecas = null;
        try {
            String textoQuery = "SELECT b FROM Biblioteca b WHERE (:genero is null OR b.genero LIKE :genero)";

            Query consulta = em.createQuery(textoQuery);
            consulta.setParameter("genero", filtroDescricao.isEmpty() ? null : "%" + filtroDescricao + "%");

            bibliotecas = consulta.getResultList(); 
        } finally {
            JPAUtil.closeEtityManager(); 
        }
        return bibliotecas; 
    }
     
     

     
    
}
