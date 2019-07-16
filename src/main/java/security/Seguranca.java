package security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@ManagedBean
@RequestScoped
public class Seguranca {

	public String getNomeUsuario() {
		String nome = null;
		
		IntegranteSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNome();
		}
		
		return nome;
	}
	
	public String getLoginUsuario() {
		String nome = null;
		
		IntegranteSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getLogin();
		}
		
		return nome;
	}
	
	public int getCodigoUsuario() {
		int cod = 0;
		
		IntegranteSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			cod = usuarioLogado.getUsuario().getCodigo();
		}
		
		return cod;
	}

	public IntegranteSistema getUsuarioLogado() {
		IntegranteSistema usuario = null;
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (auth != null && auth.getPrincipal() != null) {
			usuario = (IntegranteSistema) auth.getPrincipal();
		}
		return usuario;
	}
	
	public boolean isPermAdmin(){
		 ExternalContext externalContext =
		  FacesContext.getCurrentInstance().getExternalContext();
		 
		  return  externalContext.isUserInRole("ADMIN");
	}
	
	public boolean isPermMaestro(){
		 ExternalContext externalContext =
		  FacesContext.getCurrentInstance().getExternalContext();
		 
		  return  externalContext.isUserInRole("MAESTRO");
	}
	
	public boolean isPermMusico(){
		 ExternalContext externalContext =
		  FacesContext.getCurrentInstance().getExternalContext();
		 
		  return  externalContext.isUserInRole("MUSICO");
	}
	
	public String getLogout(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		String aux = request.getContextPath()+"/j_spring_security_logout";
		return aux;
	}
	
}
