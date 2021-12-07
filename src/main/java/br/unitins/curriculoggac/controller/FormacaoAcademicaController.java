package br.unitins.curriculoggac.controller;

import java.io.Serializable;

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
public class FormacaoAcademicaController extends Controller<FormacaoAcademica> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011830080890275450L;
	private Curriculo curriculo;
	
	public FormacaoAcademicaController() {
		super();
		Flash flash = FlashEasy.getInstance();
		setEntity((FormacaoAcademica)flash.get("formacaoAtual" ));
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
	public FormacaoAcademica getEntity() {
		if (entity == null) {
			entity = new FormacaoAcademica();
		}
		
		return entity;

	}
	
	public StatusFormacao[] getListStatus(){
		return StatusFormacao.values();
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

}