package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Musico;

public class MusicoDAO extends HibernateGenericDAO<Musico, Integer> {

    public MusicoDAO() {
        
    }
    
    public List<Musico> buscarPorNome(String nome){
        String sql = "Select c from Musico c " +
                     "where c.nome like ?1";
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Musico.class).setParameter("1", nome).getResultList();
    }
    
    public boolean isLoginValido(String login){
        String sql = "SELECT a FROM Musico a WHERE a.login LIKE :Login";
       
        EntityManager em = getEntityManager();
        Musico user =  em.createQuery(sql, Musico.class)
               .setParameter("Login", login)
               .getSingleResult();
       
        if(user != null)
           return true;
        else
           return false;
    }
    
}
