package br.unitins.curriculoggac.controller;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.application.FlashEasy;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.InformacaoAdicional;

@Named
@ViewScoped
public class InformacaoAdicionalController extends Controller<InformacaoAdicional> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011830080890275450L;
	private Curriculo curriculo;
	
	public InformacaoAdicionalController() {
		super();
		Flash flash = FlashEasy.getInstance();
		setEntity((InformacaoAdicional)flash.get("informacaoAdicionalAtual" ));
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
	public InformacaoAdicional getEntity() {
		if (entity == null) {
			entity = new InformacaoAdicional();
		}
		
		return entity;

	}
	
	public void voltar() {
		Util.redirect("consultainformacaoadicional.xhtml");
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