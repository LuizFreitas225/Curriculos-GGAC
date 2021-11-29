package br.unitins.curriculoggac.controller.listing;

import java.util.ArrayList;

import javax.inject.Named;

import br.unitins.curriculoggac.Repository.CurriculoRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Session;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.Usuario;

import javax.faces.view.ViewScoped;

@Named
@ViewScoped
public class CurriculoListing extends Listing<Curriculo> {

	private static final long serialVersionUID = -4010944566429542698L;
	private String filtro = "";

	public CurriculoListing() {
		super("curriculolisting", new CurriculoRepository());
		pesquisar();
	}

	@Override
	public void pesquisar() {
		CurriculoRepository repo = new CurriculoRepository();
		try {
			setList(repo.findByDescricao(filtro, 20, getUsuarioLogado()));
		} catch (RepositoryException e) {
			setList(new ArrayList<Curriculo>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Usuario getUsuarioLogado() {
		// obtendo o usuario da sessao

		Usuario usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");

		return usuarioLogado;
	}

}