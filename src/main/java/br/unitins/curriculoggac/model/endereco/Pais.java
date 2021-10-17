package br.unitins.curriculoggac.model.endereco;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "O nome do país é um campo obrigatório.")
	@Column(nullable = false, length = 150)
	private String nome;
	@NotNull(message = "A nacionalidade do país é um campo obrigatório.")
	@Column(nullable = false, length = 150)
	private String nacionalidade;
	@OneToMany(mappedBy = "pais") //, cascade = { CascadeType.REMOVE })
    private List<Estado> listEstados;
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Pais(Integer id, @NotEmpty(message = "O nome é um campo obrigatório.") String nome,
			@NotEmpty(message = "A nacionalidade é um campo obrigatório.") String nacionalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
	}



	public List<Estado> getListEstados() {
		return listEstados;
	}



	public void setListEstados(List<Estado> listEstados) {
		this.listEstados = listEstados;
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

}
