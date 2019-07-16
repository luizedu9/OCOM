package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import modelo.Apresentacao;
import service.ApresentacaoService;
import util.FacesMensagens;

@ManagedBean(name="apresentacao")
@SessionScoped
public class ApresentacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Apresentacao obj = new Apresentacao();
	private List<Apresentacao> apresentacoes;
	private ApresentacaoService service = new ApresentacaoService();
	
	public ApresentacaoBean() {
		setApresentacoes(service.buscarTodos());
	}
	
	public void salvar() {
		try{
			service.salvar(obj);
			setApresentacoes(service.buscarTodos()); 
			
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
			setApresentacoes(service.buscarTodos()); 
		
			FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public String editar() {
		return "cadastro_apresentacao?faces-redirect=true";
	}
	
	public String novo() {
		limpa();
		return "cadastro_apresentacao?faces-redirect=true";
	}
	
	private void limpa() {
		obj = new Apresentacao();
	}
	
	public void preRender(ComponentSystemEvent e) {
		setApresentacoes(service.buscarTodos());
	}

	public Apresentacao getObj() {
		return obj;
	}

	public void setObj(Apresentacao obj) {
		this.obj = obj;
	}

	public List<Apresentacao> getApresentacoes() {
		return apresentacoes;
	}

	public void setApresentacoes(List<Apresentacao> apresentacoes) {
		this.apresentacoes = apresentacoes;
	}
	

}
