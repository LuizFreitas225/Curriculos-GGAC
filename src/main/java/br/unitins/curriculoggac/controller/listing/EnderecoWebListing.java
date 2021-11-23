package br.unitins.curriculoggac.controller.listing;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.unitins.curriculoggac.Repository.EnderecoWebRepository;
import br.unitins.curriculoggac.Repository.endereco.EstadoRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.EnderecoWeb;
import br.unitins.curriculoggac.model.endereco.Estado;

public class EnderecoWebListing extends Listing<EnderecoWeb> {

	private static final long serialVersionUID = -4837662985103408066L;

	private String filtro = "";
	private Curriculo curriculoAtual;

	public EnderecoWebListing() {
		super("enderecoweblisting", new EnderecoWebRepository());
		
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		setCurriculoAtual((Curriculo) flash.get("curriculoAtual"));
	}

	@Override
	public void pesquisar() {
		EnderecoWebRepository repo = new EnderecoWebRepository();
		try {
			setList(repo.findByDescricao(filtro,getCurriculoAtual()));
		} catch (RepositoryException e) {
			setList(new ArrayList<EnderecoWeb>());
		}

	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Curriculo getCurriculoAtual() {
		return curriculoAtual;
	}

	public void setCurriculoAtual(Curriculo curriculoAtual) {
		this.curriculoAtual = curriculoAtual;
	}

}