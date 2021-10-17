package br.unitins.curriculoggac.model.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "O nome é um campo obrigatório.")
	@Column(nullable = false, length = 150)
	private String nome;
	@NotEmpty(message = "A sigla é um campo obrigatório.")
	@Column(nullable = false, length = 150)
	private String sigla;
	@NotNull(message = "Faça  a busca e selecione um país válido.")
	@JoinColumn(nullable = false)
	@ManyToOne()
	private Pais pais;
	
	public Estado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estado(Integer id, @NotEmpty(message = "O nome é um campo obrigatório.") String nome,
			@NotEmpty(message = "A sigla é um campo obrigatório.") String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	

}
