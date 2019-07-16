package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import modelo.Orquestra;
import service.OrquestraService;
import util.FacesMensagens;

@ManagedBean(name="orquestra")
@SessionScoped
public class OrquestraBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Orquestra obj = new Orquestra();
	private List<Orquestra> orquestras;
	private OrquestraService service = new OrquestraService();
	
	public OrquestraBean() {
		setOrquestras(service.buscarTodos());
	}
	
	public void salvar() {
		try{
			service.salvar(obj);
			setOrquestras(service.buscarTodos()); 
			
			FacesMensagens.info("Registro salvo com sucesso.");
			limpa();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public void excluir() {
		try{
			service.remover(obj.getCodigo());
			setOrquestras(service.buscarTodos()); 
		
			FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public String editar() {
		return "cadastro_orquestra?faces-redirect=true";
	}
	
	public String novo() {
		limpa();
		return "cadastro_orquestra?faces-redirect=true";
	}
	
	private void limpa() {
		obj = new Orquestra();
	}
	
	public void preRender(ComponentSystemEvent e) {
		setOrquestras(service.buscarTodos());
	}

	public Orquestra getObj() {
		return obj;
	}

	public void setObj(Orquestra obj) {
		this.obj = obj;
	}

	public List<Orquestra> getOrquestras() {
		return orquestras;
	}

	public void setOrquestras(List<Orquestra> orquestras) {
		this.orquestras = orquestras;
	}
	

}
