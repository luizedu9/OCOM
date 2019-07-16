package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Orquestra;

public class OrquestraDAO extends HibernateGenericDAO<Orquestra, Integer> {
    
    public OrquestraDAO() {
        
    }
    
    public List<Orquestra> buscarPorNome(String nome){
        String sql = "Select c from Orquestra c " +
                    "where c.nome like ?1";
       
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Orquestra.class).setParameter("1", nome).getResultList();
    }
    
}
