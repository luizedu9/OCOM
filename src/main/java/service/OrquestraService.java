package service;

import dao.OrquestraDAO;
import java.util.List;
import modelo.Orquestra;

public class OrquestraService {
    
    private OrquestraDAO dao;
    
    public OrquestraService(){
        dao = new OrquestraDAO();
    }
    
    public Orquestra buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;
        	//throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Orquestra> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Orquestra entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Orquestra> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
