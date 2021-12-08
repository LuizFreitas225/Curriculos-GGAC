package br.unitins.curriculoggac.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.primefaces.event.SelectEvent;

import br.unitins.curriculoggac.controller.listing.PaisListing;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.EnderecoWeb;
import br.unitins.curriculoggac.model.endereco.Pais;

import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.application.FlashEasy;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.EstadoCivil;
import br.unitins.curriculoggac.model.FormacaoAcademica;
import br.unitins.curriculoggac.model.StatusFormacao;

@Named
@ViewScoped
public class EnderecoWebController extends Controller<EnderecoWeb> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011830080890275450L;
	private Curriculo curriculo;
	
	public EnderecoWebController() {
		super();
		Flash flash = FlashEasy.getInstance();
		setEntity((EnderecoWeb)flash.get("enderecoWebAtual" ));
		setCurriculo((Curriculo) flash.get("curriculoAtual"));
	}
	@Override
	public void salvar() {
		getEntity().setPessoa(getCurriculo().getPessoa());
		try {
			salvarPrincipal();
		} catch (RepositoryException e) {
			Util.addErrorMessage("Problema ao salvar, tente novamente ou entre em contato com a TI.");
		}

	}
	@Override
	public EnderecoWeb getEntity() {
		if (entity == null) {
			entity = new EnderecoWeb();
		}
		
		return entity;

	}
	
	

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

}
