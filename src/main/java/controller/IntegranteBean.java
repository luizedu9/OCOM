package controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import modelo.Admin;
import modelo.Instrumento;
import modelo.Maestro;
import modelo.Integrante;
import modelo.Musico;
import modelo.Sexo;
import service.IntegranteService;
import util.FacesMensagens;

@ManagedBean(name="integrante")
@SessionScoped
public class IntegranteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integrante obj = new Integrante();
	private List<Integrante> integrantes;
	private IntegranteService service = new IntegranteService();
	private String[] permissoes;
	private List<Instrumento> instrumentos;
	
	public IntegranteBean() {
		setIntegrantes(service.buscarTodos());
		obj.setSexo(Sexo.MASCULINO);
		setInstrumentos(Arrays.asList(Instrumento.values()));
	}
	
	public void salvar() {
		try{
			Set<String> roles = new HashSet<String>();
			for(int i = 0; i < permissoes.length; i++) {
				System.out.println(permissoes[i]);
				roles.add(permissoes[i]);
			}
			
			if(roles.contains("ADMIN")) {
				Admin novo = new Admin();
				novo.setNome(obj.getNome());
				novo.setCpf(obj.getCpf());
				novo.setDtNascimento(obj.getDtNascimento());
				novo.setEmail(obj.getEmail());
				novo.setEndereco(obj.getEndereco());
				novo.setLogin(obj.getLogin());
				novo.setSenha(obj.getSenha());
				novo.setSexo(obj.getSexo());
				novo.setInstrumento(obj.getInstrumento());
				novo.setPermissao(roles);
				service.salvar(novo);
			} else if(roles.contains("MAESTRO")) {
				Maestro novo = new Maestro();
				novo.setNome(obj.getNome());
				novo.setCpf(obj.getCpf());
				novo.setDtNascimento(obj.getDtNascimento());
				novo.setEmail(obj.getEmail());
				novo.setEndereco(obj.getEndereco());
				novo.setLogin(obj.getLogin());
				novo.setSenha(obj.getSenha());
				novo.setSexo(obj.getSexo());
				novo.setPermissao(roles);
				service.salvar(novo);
			} else if(roles.contains("MUSICO")) {
				Musico novo = new Musico();
				novo.setNome(obj.getNome());
				novo.setCpf(obj.getCpf());
				novo.setDtNascimento(obj.getDtNascimento());
				novo.setEmail(obj.getEmail());
				novo.setEndereco(obj.getEndereco());
				novo.setLogin(obj.getLogin());
				novo.setSenha(obj.getSenha());
				novo.setSexo(obj.getSexo());
				novo.setPermissao(roles);
				novo.setInstrumento(obj.getInstrumento());
				service.salvar(novo);
			}
			
			setIntegrantes(service.buscarTodos()); 
			FacesMensagens.info("Registro salvo com sucesso.");
			limpar();
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public void excluir() {
		try{
			service.remover(obj.getCodigo());
			setIntegrantes(service.buscarTodos()); 
		
			FacesMensagens.info("Registro excluído com sucesso.");
		}
		catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
	}
	
	public String editar() {
		return "cadastro_integrante?faces-redirect=true";
	}
	
	public String novo() {
		limpar();
		return "cadastro_integrante?faces-redirect=true";
	}
	
	private void limpar() {
		obj = new Integrante();
		obj.setSexo(Sexo.MASCULINO);
		permissoes = null;
	}
	
	public String atribuirPermissao(String permissao) {
		
		Set<String> roles = obj.getPermissao();
		if (roles.contains(permissao))
			roles.remove(permissao);
		else
			roles.add(permissao);
		
		try {
			service.salvar(obj);
		} catch (Exception e) {
			FacesMensagens.error(e.getMessage());
		}
		return null;
	}
	
	public void preRender(ComponentSystemEvent e) {
		setIntegrantes(service.buscarTodos());
	}
	
	public Sexo[] getSexos() {
        return Sexo.values();
    }

	public Integrante getObj() {
		return obj;
	}

	public void setObj(Integrante obj) {
		this.obj = obj;
	}

	public List<Integrante> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

	public String[] getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(String[] permissoes) {
		this.permissoes = permissoes;
	}

	public IntegranteService getService() {
		return service;
	}

	public void setService(IntegranteService service) {
		this.service = service;
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

}
