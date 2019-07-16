package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Ensaio;

public class EnsaioDAO extends HibernateGenericDAO<Ensaio, Integer> {
    
    public EnsaioDAO() {
        
    }
    
    public List<Ensaio> buscarPorNome(String nome){
        String sql = "Select c from Ensaio c " +
                    "where c.nome like ?1";
       
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Ensaio.class).setParameter("1", nome).getResultList();
    }
    
}
