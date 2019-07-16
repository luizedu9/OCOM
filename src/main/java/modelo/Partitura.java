package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Partitura implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private Instrumento instrumento;
	@Lob
	private byte[] partitura;
	@ManyToOne
	@JoinColumn(name="codOrquestra")
	private Orquestra orquestra;
	
	public Partitura() {
		
	}

	public Partitura(Integer codigo, String nome, Instrumento instrumento, byte[] partitura) {
		this.codigo = codigo;
		this.nome = nome;
		this.instrumento = instrumento;
		this.partitura = partitura;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

	public byte[] getPartitura() {
		return partitura;
	}

	public void setPartitura(byte[] partitura) {
		this.partitura = partitura;
	}

	public Orquestra getOrquestra() {
		return orquestra;
	}

	public void setOrquestra(Orquestra orquestra) {
		this.orquestra = orquestra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partitura other = (Partitura) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
