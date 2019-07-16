package dao;

import java.util.List;
import javax.persistence.EntityManager;

import modelo.Instrumento;
import modelo.Partitura;

public class PartituraDAO extends HibernateGenericDAO<Partitura, Integer> {
    
    public PartituraDAO() {
        
    }
    
    public List<Partitura> buscarPorNome(String nome) {
		String sql = "Select c from Partitura c where c.nome = :nome";

		EntityManager em = getEntityManager();
		return em.createQuery(sql, Partitura.class).setParameter("nome", nome).getResultList();
	}
    
    public List<Partitura> buscarPorInstrumento(Instrumento instrumento) {
		String sql = "Select c from Partitura c where c.instrumento = :nome";

		EntityManager em = getEntityManager();
		return em.createQuery(sql, Partitura.class).setParameter("nome", instrumento).getResultList();
	}
    
}
