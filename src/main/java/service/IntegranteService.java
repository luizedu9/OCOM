package service;

import dao.IntegranteDAO;
import java.util.List;
import modelo.Integrante;
import util.NegocioException;

public class IntegranteService {
    
    private IntegranteDAO dao;
    
    public IntegranteService(){
        dao = new IntegranteDAO();
    }
    
    public Integrante buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;
        	//throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Integrante> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public Integrante buscarPorLogin(String login){ 
        return dao.buscarPorLogin(login);
    }
    
    
    public void salvar(Integrante entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Integrante> buscarTodos(){
        return dao.buscarTodos();
    }
    
    public Boolean isLoginValido(String login) throws NegocioException{
        
        if(login == null || login.trim().equals("")){
            throw new NegocioException("Digite o login!");
        }
        
        return dao.isLoginValido(login);
    }
}
