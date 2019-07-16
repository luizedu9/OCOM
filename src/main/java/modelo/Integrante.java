package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipoIntegrante", discriminatorType = DiscriminatorType.STRING)
public class Integrante implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;
    String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "dtNasc", nullable = true)
    Date dtNascimento;
    String cpf;
    @Column(unique = true, length = 30)
    String login;
    String senha;
    @Enumerated(EnumType.STRING)
    Sexo sexo;	 
    String endereco;
    String email;
    Instrumento instrumento;
	@ElementCollection
	@JoinTable(name="integrante_permissao",
			   uniqueConstraints = { @UniqueConstraint(columnNames={"codIntegrante","permissao"}) },
			   joinColumns = @JoinColumn(name="codIntegrante"))
	@Column(name="permissao", length=50)
	private Set<String> permissao = new HashSet<String>();
	@ManyToOne
	@JoinColumn(name="codOrquestra")
	private Orquestra orquestra;
     
	public Integrante(Integer codigo, String nome, Date dtNascimento, String cpf, String login, String senha, Sexo sexo, String endereco, String email, Orquestra orquestra) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.sexo = sexo;
		this.endereco = endereco;
		this.email = email;
		this.orquestra = orquestra;
	}
     
	public Integrante() {
		
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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Integrante)) {
			return false;
		}
		Integrante other = (Integrante) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Integrante [codigo=" + codigo + ", nome=" + nome + 
				", dtNascimento=" + dtNascimento + ", cpf=" + cpf + 
				", login=" + login + ", sexo=" + sexo + ", endereco=" + endereco + 
				", email=" + email + "]";
	}
	 
	 
}
