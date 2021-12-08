package br.unitins.curriculoggac.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.ExperienciaProfissionalRepository;
import br.unitins.curriculoggac.application.FlashEasy;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.ExperienciaProfissional;

@Named
@ViewScoped
public class ConsultaExperienciaProfissionalController  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3583009770061848869L;

	private String filtro = "";
	private Curriculo curriculo;
	private List<ExperienciaProfissional> list;

	public ConsultaExperienciaProfissionalController() {
		super();
		Flash flash = FlashEasy.getInstance();
		setCurriculo((Curriculo) flash.get("curriculoAtual"));
		if (curriculo != null) {
			pesquisar();
		}

	}

	public void novo() {

		Flash flash = FlashEasy.getInstance();
		flash.put("curriculoAtual", curriculo);
		Util.redirect("experienciaprofissional.xhtml");
	}

	public void pesquisar() {
		ExperienciaProfissionalRepository repo = new ExperienciaProfissionalRepository();
		try {
			setList(repo.findByNome(filtro, getCurriculo()));
		} catch (Exception e) {
			setList(new ArrayList<ExperienciaProfissional>());
		}
	}

	public void select(int id) throws RepositoryException {
		ExperienciaProfissionalRepository repo = new ExperienciaProfissionalRepository();
		ExperienciaProfissional entity = repo.findById(id);

		if (entity != null) {
			Flash flash = FlashEasy.getInstance();
			flash.put("experienciaProfissionalAtual", entity);
			flash.put("curriculoAtual", curriculo);
			Util.redirect("experienciaprofissional.xhtml");
		}

	}

	public void excluir(int id) throws RepositoryException {
		ExperienciaProfissionalRepository repo = new ExperienciaProfissionalRepository();
		ExperienciaProfissional entity = repo.findById(id);

		if (entity != null) {
			try {
				repo.remove(entity);
				Util.addInfoMessage(" Excluido com Sucesso.");
			} catch (Exception e) {
				Util.addErrorMessage("Erro ao executar Exclusão.");
				e.printStackTrace();
			}

		}

	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public void setList(List<ExperienciaProfissional> list) {
		this.list = list;
	}

	public List<ExperienciaProfissional> getList() {
		return list;
	}

}