package service;

import dao.ApresentacaoDAO;
import java.util.List;
import modelo.Apresentacao;

public class ApresentacaoService {
    
    private ApresentacaoDAO dao;
    
    public ApresentacaoService(){
        dao = new ApresentacaoDAO();
    }
    
    public Apresentacao buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;
        	//throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Apresentacao> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Apresentacao entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Apresentacao> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
