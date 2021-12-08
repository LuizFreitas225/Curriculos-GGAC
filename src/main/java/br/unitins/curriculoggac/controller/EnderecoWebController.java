package br.unitins.curriculoggac.controller;

import java.io.Serializable;



import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;

import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.EnderecoWeb;



import javax.inject.Named;

import br.unitins.curriculoggac.application.FlashEasy;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;

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
		Flash flash = FlashEasy.getInstance();
		Curriculo atual =(Curriculo) flash.get("curriculoAtual");
		if( curriculo != atual && atual != null) {
			curriculo = atual;
		}
		
		
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

}
