package br.unitins.curriculoggac.controller.endereco;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.controller.Controller;
import br.unitins.curriculoggac.controller.listing.EstadoListing;
import br.unitins.curriculoggac.controller.listing.PaisListing;
import br.unitins.curriculoggac.model.endereco.Estado;
import br.unitins.curriculoggac.model.endereco.Pais;

@Named
@ViewScoped
public class EstadoController extends Controller<Estado> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011830080890275450L;

	@Override
	public Estado getEntity() {
		if (entity == null) {
			entity = new Estado();
		}
		if (entity.getPais() == null) {
           entity.setPais(new Pais());
		}
		return entity;

	}
	@Override
	public void salvar() {
		try {
			if(getEntity().getPais().getId() == null) {
				Util.addErrorMessage("Abra a busca e selecione um país cadastrado.");
			}
			salvarPrincipal();
		} catch (RepositoryException e) {
			Util.addErrorMessage("Problema ao salvar, tente novamente ou entre em contato com a TI.");
		}

	}
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();

		System.out.println("Abrir Estado List");
	}

	public void obterEstadoListing(SelectEvent<Estado> event) {
		setEntity(event.getObject());
	}

	public void abrirPaisListing() {
		PaisListing listing = new PaisListing();
		listing.open();

		System.out.println("Abrir Pais List");
	}

	public void obterPaisListing(SelectEvent<Pais> event) {
		getEntity().setPais(event.getObject());
	}

}
