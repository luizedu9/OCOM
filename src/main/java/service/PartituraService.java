package service;

import dao.PartituraDAO;
import java.util.List;

import modelo.Instrumento;
import modelo.Partitura;

public class PartituraService {
    
    private PartituraDAO dao;
    
    public PartituraService(){
        dao = new PartituraDAO();
    }
    
    public Partitura buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;
        	//throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Partitura> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Partitura entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Partitura> buscarTodos(){
        return dao.buscarTodos();
    }
 
    
    public List<Partitura> buscarInstrumento(Instrumento instrumento){
        return dao.buscarPorInstrumento(instrumento);
    }
}
