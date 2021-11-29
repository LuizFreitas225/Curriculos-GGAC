package br.unitins.curriculoggac.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.endereco.EstadoRepository;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.endereco.Estado;

@Named
@ViewScoped
public class EstadoListing extends Listing<Estado> {

	private static final long serialVersionUID = -4837662985103408066L;

	private String filtro = "";

	public EstadoListing() {
		super("estadolisting", new EstadoRepository());
		pesquisar();
	}

	@Override
	public void pesquisar() {
		EstadoRepository repo = new EstadoRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Estado>());
		}

	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
