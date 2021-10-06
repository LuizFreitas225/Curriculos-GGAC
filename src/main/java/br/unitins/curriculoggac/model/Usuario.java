package br.unitins.curriculoggac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;




@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
	
	@Column(nullable= false, length = 70, unique = true)
	@NotEmpty(message =  "O email é um campo obrigatório.")
	@Email(message = "Insira um email válido.")
	private String email;
	@Column(nullable= false, length = 150)
	@NotEmpty(message =  "A senha é um campo obrigatório.")
	private  String senha;
	@Column(nullable= false, length = 150)
	@NotEmpty(message =  "O nome é um campo obrigatório.")
	private  String nome;
	@NotEmpty(message =  "O sobrenome é um campo obrigatório.")
	@Column(nullable= false, length = 150)
	private  String sobreNome;
	
	public Usuario() {
		super();
		
	}
    

	public Usuario(Integer id, @Email String email, String senha) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
