package br.unitins.curriculoggac.controller.listing;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import br.unitins.curriculoggac.Repository.endereco.PaisRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.endereco.Pais;

@Named
@ViewScoped
public class PaisListing extends Listing<Pais> {
	
	
	private static final long serialVersionUID = -4837662985103408066L;
	
	Boolean paisListingRedirect ;
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

	
	public String crud() {
		Flash flash =  FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("paisRedirect", true);
		return "pais.xhtml?faces-redirect=true";
	}
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	public Boolean getPaisListingRedirect() {
		if( paisListingRedirect ==null)
			paisListingRedirect= false;
		
		return paisListingRedirect;
	}
	public void setPaisListingRedirect(Boolean paisListingRedirect) {
		this.paisListingRedirect = paisListingRedirect;
	}
	
	
    
}
