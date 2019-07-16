package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Maestro;

public class MaestroDAO extends HibernateGenericDAO<Maestro, Integer> {

    public MaestroDAO() {
        
    }
    
    public List<Maestro> buscarPorNome(String nome){
        String sql = "Select c from Maestro c " +
                     "where c.nome like ?1";
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Maestro.class).setParameter("1", nome).getResultList();
    }
    
    public boolean isLoginValido(String login){
        String sql = "SELECT a FROM Maestro a WHERE a.login LIKE :Login";
       
        EntityManager em = getEntityManager();
        Maestro user =  em.createQuery(sql, Maestro.class)
               .setParameter("Login", login)
               .getSingleResult();
       
        if(user != null)
           return true;
        else
           return false;
    }
    
}
