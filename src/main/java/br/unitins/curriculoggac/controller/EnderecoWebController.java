package br.unitins.curriculoggac.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.primefaces.event.SelectEvent;

import br.unitins.curriculoggac.controller.listing.PaisListing;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.EnderecoWeb;
import br.unitins.curriculoggac.model.endereco.Pais;

public class EnderecoWebController extends Controller<EnderecoWeb> implements Serializable {

		private static final long serialVersionUID = 4580210212026857209L;
		private Curriculo curriculoAtual;
		@Override
		public EnderecoWeb getEntity() {
			if (entity == null) {
				entity = new EnderecoWeb();
			}
			return entity;

		}

		public EnderecoWebController() {
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			setCurriculoAtual((Curriculo) flash.get("curriculoAtual"));
		}

		

		public Curriculo getCurriculoAtual() {
			return curriculoAtual;
		}

		public void setCurriculoAtual(Curriculo curriculoAtual) {
			this.curriculoAtual = curriculoAtual;
		}
     
}
