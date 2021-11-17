package br.unitins.curriculoggac.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.curriculoggac.Repository.CurriculoRepository;
import br.unitins.curriculoggac.Repository.PessoaRepository;
import br.unitins.curriculoggac.application.Session;
import br.unitins.curriculoggac.controller.listing.CurriculoListing;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.EstadoCivil;
import br.unitins.curriculoggac.model.Pessoa;
import br.unitins.curriculoggac.model.Usuario;


@Named
@ViewScoped
public class CurriculoController extends Controller<Curriculo> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6480735934135149007L;
	CurriculoRepository curriculoRepository;
	PessoaRepository pessoaRepository;
	private Pessoa pessoa;
	private Usuario usuarioLogado;

	public void salvarCurriculo() {

		getEntity().setUsuario(getUsuarioLogado());
		getEntity().setPessoa(getPessoa());
		getEntity().setDescricao("Currículo do(a) " + getPessoa().getNome());
		salvar();
	}

	public PessoaRepository getCurriculoRepository() {

		if (curriculoRepository == null) {
			curriculoRepository = new CurriculoRepository();
		}

		return pessoaRepository;
	}

	public void setCurriculoaRepository(CurriculoRepository curriculoRepository) {
		this.curriculoRepository = curriculoRepository;
	}

	public PessoaRepository getPessoaRepository() {

		if (pessoaRepository == null) {
			pessoaRepository = new PessoaRepository();
		}

		return pessoaRepository;
	}

	public void setPessoaRepository(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public Usuario getUsuarioLogado() {
		// obtendo o usuario da sessao
		if (usuarioLogado == null) {
			usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
		}
		return usuarioLogado;
	}

	public void abrirCurriculoListing() {
		CurriculoListing listing = new CurriculoListing();
		listing.open();

		System.out.println("Abrir Curriculo List");
	}
    
	public void obterCurriculoListing(SelectEvent<Curriculo> event) {
		setEntity(event.getObject());
	}
	public Pessoa getPessoa() {

		if (pessoa == null) {
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public Curriculo getEntity() {
		if (entity == null) {
			entity = new Curriculo();
		}
		return entity;
	}
	
	public EstadoCivil[] getListEstadoCivil(){
		return EstadoCivil.values();
	}
}
