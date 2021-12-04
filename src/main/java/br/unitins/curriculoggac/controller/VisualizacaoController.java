package br.unitins.curriculoggac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Atributo;
import br.unitins.curriculoggac.model.Curriculo;

@Named
@ViewScoped
public class VisualizacaoController extends Controller<Curriculo>  implements Serializable{

	
	private static final long serialVersionUID = 4455921962753064357L;

	public VisualizacaoController() {
		super();

		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("curriculoAtual");
		setEntity((Curriculo) flash.get("curriculoAtual"));
		
		// Redireciona se o curriculo entity for null
		//getEntity();
	}

	public void select(int id) {

		if (entity != null) {
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			flash.put("curriculoAtual", entity);
			

			if (id == 1) {

			} else if (id == 2) {

			} else if (id == 3) {

			} else if (id == 4) {

			} else if (id == 5) {

			}
		}else {
			Util.redirect("paginaconsultacurriculo.xhtml");
		}
	}

	public List<Atributo> getListAtributo() {
		List<Atributo> lista= new ArrayList<Atributo>();
		Atributo[] vetor=  Atributo.values();
		for( int index=0;index < vetor.length; index++ ) {
			lista.add(vetor[index]);
		}
		return lista;
	}

	@Override
	public Curriculo getEntity() {

		
		return entity;
	}
}