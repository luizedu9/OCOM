package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import modelo.Ensaio;
import service.EnsaioService;
import util.FacesMensagens;

@ManagedBean(name="ensaio")
@SessionScoped
public class EnsaioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Ensaio obj = new Ensaio();
	private List<Ensaio> ensaios;
	private EnsaioService service = new EnsaioService();
	
	public EnsaioBean() {
		setEnsaios(service.buscarTodos());
	}
	
	public void salvar() {
		try{
			service.salvar(obj);
			setEnsaios(service.buscarTodos()); 
			
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
			setEnsaios(service.buscarTodos()); 
		
			FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public String editar() {
		return "cadastro_ensaio?faces-redirect=true";
	}
	
	public String novo() {
		limpa();
		return "cadastro_ensaio?faces-redirect=true";
	}
	
	private void limpa() {
		obj = new Ensaio();
	}
	
	public void preRender(ComponentSystemEvent e) {
		setEnsaios(service.buscarTodos());
	}

	public Ensaio getObj() {
		return obj;
	}

	public void setObj(Ensaio obj) {
		this.obj = obj;
	}

	public List<Ensaio> getEnsaios() {
		return ensaios;
	}

	public void setEnsaios(List<Ensaio> ensaios) {
		this.ensaios = ensaios;
	}
	

}
