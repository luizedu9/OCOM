package service;

import dao.EnsaioDAO;
import java.util.List;
import modelo.Ensaio;

public class EnsaioService {
    
    private EnsaioDAO dao;
    
    public EnsaioService(){
        dao = new EnsaioDAO();
    }
    
    public Ensaio buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;
        	//throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Ensaio> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Ensaio entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Ensaio> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
