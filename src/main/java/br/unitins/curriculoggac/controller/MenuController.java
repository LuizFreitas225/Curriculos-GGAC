package br.unitins.curriculoggac.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.PessoaRepository;
import br.unitins.curriculoggac.application.Session;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.Pessoa;
import br.unitins.curriculoggac.model.Usuario;

@Named
@RequestScoped
public class MenuController extends Controller<Curriculo> implements Serializable { 
    /**
	 * 
	 */
	private static final long serialVersionUID = -146340669568842766L;
	private Pessoa pessoa;
    private Usuario usuarioLogado;
    
    PessoaRepository pessoaRepository;
    
    
	public void salvarCurriculo() {
		
//		try {
//			getPessoaRepository().save(getPessoa());
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			Util.addErrorMessage("Problema ao salvar os dados pessoais.");
//			return;
//		}
		getEntity().setUsuario(getUsuarioLogado());
		getEntity().setPessoa(getPessoa());
		getEntity().setDescricao("Currículo do(a) " +getPessoa().getNome());
		salvar();
	}
	@Override
	public Curriculo getEntity() {
		if( entity == null) {
			entity = new Curriculo();
		}
		return entity;
	}
	
	public String encerrarSessao() {
		Session.getInstance().invalidateSession();
		return "login.xhtml";
	}
	public Pessoa getPessoa() {
	
		if( pessoa == null) {
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
}
