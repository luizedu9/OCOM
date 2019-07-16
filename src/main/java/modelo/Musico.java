package modelo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MUSICO")
public class Musico extends Integrante{

	private static final long serialVersionUID = 1L;
	
	private Instrumento instrumento;
	
	public Musico(Integer codigo, String nome, Date dtNascimento, String cpf, String login, String senha, Sexo sexo, String endereco, String email, Instrumento instrumento, Orquestra orquestra) {
		super(codigo, nome, dtNascimento, cpf, login, senha, sexo, endereco, email, orquestra);
		this.instrumento = instrumento;
	}

	public Musico() {
		
	}
	
	public Instrumento getInstrumento() {
		return instrumento;
	}	

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

	@Override
	public String toString() {
		return "Musico [instrumento=" + instrumento + "]";
	}	

}
