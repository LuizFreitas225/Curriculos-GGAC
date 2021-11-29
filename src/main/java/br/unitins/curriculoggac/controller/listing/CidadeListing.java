package br.unitins.curriculoggac.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.endereco.CidadeRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.endereco.Cidade;

@Named
@ViewScoped
public class CidadeListing extends Listing<Cidade> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3532198145478361112L;
	private String filtro = "";

	public CidadeListing() {
		super("cidadelisting", new CidadeRepository());
		pesquisar();
	}

	@Override
	public void pesquisar() {
		CidadeRepository repo = new CidadeRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Cidade>());
		}

	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}