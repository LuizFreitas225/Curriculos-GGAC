package br.unitins.curriculoggac.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


import br.unitins.curriculoggac.Repository.endereco.PaisRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.endereco.Pais;

@Named
@ViewScoped
public class PaisListing extends Listing<Pais> {
	
	
	private static final long serialVersionUID = -4837662985103408066L;
	
	private String filtro = "";
	public PaisListing() {
		super("paislisting", new PaisRepository());
	}
	@Override
	public void pesquisar() {
		PaisRepository repo = new PaisRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Pais>());
		}
		
	}
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
    
}
