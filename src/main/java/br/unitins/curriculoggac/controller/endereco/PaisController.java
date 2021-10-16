package br.unitins.curriculoggac.controller.endereco;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.curriculoggac.Repository.endereco.PaisRepository;
import br.unitins.curriculoggac.controller.Controller;
import br.unitins.curriculoggac.controller.listing.PaisListing;
import br.unitins.curriculoggac.model.endereco.Pais;

@Named
@ViewScoped
public class PaisController extends Controller <Pais> implements Serializable {

	
	private static final long serialVersionUID = 4580210212026857209L;
    
	@Override
	public Pais getEntity() {
		if( entity == null) {
			entity = new Pais();
		}
		return entity;
		
	}
	
	public void abrirPaisListing() {
		PaisListing listing = new PaisListing();
		listing.open();
		
		System.out.println("Abrir Pais List");
	}
	
	public void obterPaisListing(SelectEvent<Pais> event) {
		setEntity(event.getObject());
	}
	
	
	
	

}
