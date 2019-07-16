package security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import modelo.Integrante;

public class IntegranteSistema extends User{
private static final long serialVersionUID = 1L;
	
	private Integrante integrante;
	
	public IntegranteSistema(Integrante integrante, Collection<? extends GrantedAuthority> authorities) {
		super(integrante.getEmail(), integrante.getSenha(), authorities);
		this.integrante = integrante;
	}

	public Integrante getUsuario() {
		return integrante;
	}
}
