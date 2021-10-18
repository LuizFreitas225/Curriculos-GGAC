package br.unitins.curriculoggac.controller.endereco;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.controller.Controller;
import br.unitins.curriculoggac.controller.listing.CidadeListing;
import br.unitins.curriculoggac.controller.listing.EstadoListing;
import br.unitins.curriculoggac.model.endereco.Cidade;
import br.unitins.curriculoggac.model.endereco.Estado;
@Named
@ViewScoped
public class CidadeController extends Controller<Cidade> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011830080890275450L;

	@Override
	public Cidade getEntity() {
		if (entity == null) {
			entity = new Cidade();
		}
		if (entity.getEstado() == null) {
			entity.setEstado(new Estado());
		}
		return entity;

	}

	@Override
	public void salvar() {
		try {
			if (getEntity().getEstado().getId() == null) {
				Util.addErrorMessage("Abra a busca e selecione um país cadastrado.");
			}
			salvarPrincipal();
		} catch (RepositoryException e) {
			Util.addErrorMessage("Problema ao salvar, tente novamente ou entre em contato com a TI.");
		}

	}

	public void obterCidadeListing(SelectEvent<Cidade> event) {
		setEntity(event.getObject());
	}

	public void abrirCidadeListing() {
		CidadeListing listing = new CidadeListing();
		listing.open();

	}

	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();

		
	}

	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}

}
