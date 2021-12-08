package br.unitins.curriculoggac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.application.FlashEasy;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Atributo;
import br.unitins.curriculoggac.model.Curriculo;

@Named
@ViewScoped
public class VisualizacaoController extends Controller<Curriculo> implements Serializable {

	private static final long serialVersionUID = 4455921962753064357L;

	private Atributo atributoCurriculo;

	public VisualizacaoController() {
		super();

		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("curriculoAtual");
		setEntity((Curriculo) flash.get("curriculoAtual"));

		
	}

	public void select(int id) {

		if (entity != null) {
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			flash.put("curriculoAtual", entity);

			if (id == 1) {
				Util.redirect("consultaenderecoweb.xhtml");
			} else if (id == 2) {
				Util.redirect("consultaformacaoacademica.xhtml");
			} else if (id == 3) {
				Util.redirect("consultaqualificacao.xhtml");
			} else if (id == 4) {
				Util.redirect("consultainformacaoadicional.xhtml");
			} else if (id == 5) {
				Util.redirect("consultaexperienciaprofissional.xhtml");
			}
		} else {
			Util.redirect("paginaconsultacurriculo.xhtml");
		}
		Flash flash = FlashEasy.getInstance();
		flash.keep("curriculoAtual");
	}

	public List<Atributo> getListAtributo() {
		List<Atributo> lista = new ArrayList<Atributo>();
		Atributo[] vetor = Atributo.values();
		for (int index = 0; index < vetor.length; index++) {
			lista.add(vetor[index]);
		}
		return lista;
	}

	@Override
	public Curriculo getEntity() {

		return entity;
	}

	public Atributo getAtributoCurriculo() {
		return atributoCurriculo;
	}



}
