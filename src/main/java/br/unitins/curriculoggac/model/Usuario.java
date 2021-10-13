package br.unitins.curriculoggac.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;




@Entity
public class Usuario {
	@Id
	@Column(nullable= false, length = 70, unique = true)
	@NotEmpty(message =  "O email � um campo obrigat�rio.")
	@Email(message = "Insira um email v�lido.")
	private String email;
	@Column(nullable= false, length = 150)
	@NotEmpty(message =  "A senha � um campo obrigat�rio.")
	private  String senha;
	@Column(nullable= false, length = 150)
	@NotEmpty(message =  "O nome � um campo obrigat�rio.")
	private  String nome;
	@NotEmpty(message =  "O sobrenome � um campo obrigat�rio.")
	@Column(nullable= false, length = 150)
	private  String sobreNome;
	
	@OneToMany(mappedBy = "usuario")
    private List<Curriculo> listCurriculo;
	
	public Usuario() {
		super();
		
	}
    

	public Usuario( @Email String email, String senha) {
		super();
		
		this.email = email;
		this.senha = senha;
	}




	public String getSobreNome() {
		return sobreNome;
	}


	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
