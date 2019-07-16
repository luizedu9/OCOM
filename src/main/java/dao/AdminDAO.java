package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Admin;

public class AdminDAO extends HibernateGenericDAO<Admin, Integer> {

    public AdminDAO() {
        
    }
    
    public List<Admin> buscarPorNome(String nome){
        String sql = "Select c from Admin c " +
                     "where c.nome like ?1";
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Admin.class).setParameter("1", nome).getResultList();
    }
    
    public boolean isLoginValido(String login){
        String sql = "SELECT a FROM Admin a WHERE a.login LIKE :Login";
       
        EntityManager em = getEntityManager();
        Admin user =  em.createQuery(sql, Admin.class)
               .setParameter("Login", login)
               .getSingleResult();
       
        if(user != null)
           return true;
        else
           return false;
    }
    
}
