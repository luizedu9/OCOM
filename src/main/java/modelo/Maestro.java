package modelo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MAESTRO")
public class Maestro extends Integrante {

	private static final long serialVersionUID = 1L;
	
	public Maestro(Integer codigo, String nome, Date dtNascimento, String cpf, String login, String senha, Sexo sexo, String endereco, String email, Orquestra orquestra) {
		super(codigo, nome, dtNascimento, cpf, login, senha, sexo, endereco, email, orquestra);
	}

	public Maestro() {
		
	}
	


}
