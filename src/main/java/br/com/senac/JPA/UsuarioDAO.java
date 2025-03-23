
package br.com.senac.JPA;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import br.com.senac.JPA.JPAUtil;



public class UsuarioDAO {
    
    public Usuario login(String login, String senha) {
        Usuario usuario = null;

        EntityManager em = JPAUtil.getEntityManager();

        Query consulta = em.createQuery("SELECT u FROM Usuario u WHERE login = :login AND senha = :senha");
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);

        List<Usuario> usuarios = consulta.getResultList();
        
        if (usuarios != null && !usuarios.isEmpty()) {
            return usuarios.get(0); 
        }

        return usuario;
    }
}


