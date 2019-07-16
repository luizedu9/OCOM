package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Apresentacao;

public class ApresentacaoDAO extends HibernateGenericDAO<Apresentacao, Integer> {
    
    public ApresentacaoDAO() {
        
    }
    
    public List<Apresentacao> buscarPorNome(String nome){
        String sql = "Select c from Apresentacao c " +
                    "where c.nome like ?1";
       
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Apresentacao.class).setParameter("1", nome).getResultList();
    }
    
}
