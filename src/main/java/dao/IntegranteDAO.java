package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import modelo.Integrante;

public class IntegranteDAO extends HibernateGenericDAO<Integrante, Integer> {

    public IntegranteDAO() {
        
    }
    
    public List<Integrante> buscarPorNome(String nome){
        String sql = "Select c from Integrante c " +
                     "where c.nome = :nome";
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Integrante.class).setParameter("nome", nome).getResultList();
    }
    
    public Integrante buscarPorLogin(String login){
        String sql = "Select c from Integrante c " +
                     "where c.login = :login";
        EntityManager em = getEntityManager();
        Integrante result;
        try {
        	result = em.createQuery(sql, Integrante.class).setParameter("login", login).getSingleResult();
        } catch(NoResultException e) {
        	return null;
        }
        
        return result;
    }
    
    public boolean isLoginValido(String login){
        String sql = "SELECT a FROM Integrante a WHERE a.login LIKE :Login";
       
        EntityManager em = getEntityManager();
        Integrante user =  em.createQuery(sql, Integrante.class)
               .setParameter("Login", login)
               .getSingleResult();
       
        if(user != null)
           return true;
        else
           return false;
    }
    
}
