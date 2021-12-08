package br.unitins.curriculoggac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import br.unitins.curriculoggac.Repository.InformacaoAdicionalRepository;
import br.unitins.curriculoggac.application.FlashEasy;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.InformacaoAdicional;


@Named
@ViewScoped
public class ConsultaInformacaoAdicionalController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3583009770061848869L;

	private String filtro = "";
	private Curriculo curriculo;
	private List<InformacaoAdicional> list;

	public ConsultaInformacaoAdicionalController() {
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
		Util.redirect("informacaoadicional.xhtml");
	}

	public void pesquisar() {
		InformacaoAdicionalRepository repo = new  InformacaoAdicionalRepository();
		try {
			setList(repo.findByNome(filtro, getCurriculo()));
		} catch (Exception e) {
			setList(new ArrayList< InformacaoAdicional>());
		}
	}

	public void select(int id) throws RepositoryException {
		 InformacaoAdicionalRepository repo = new  InformacaoAdicionalRepository();
		 InformacaoAdicional entity = repo.findById(id);

		if (entity != null) {
			Flash flash = FlashEasy.getInstance();
			flash.put("informacaoAdicionalAtual", entity);
			flash.put("curriculoAtual", curriculo);
			Util.redirect("informacaoadicional.xhtml");
		}

	}

	public void excluir(int id) throws RepositoryException {
		 InformacaoAdicionalRepository repo = new  InformacaoAdicionalRepository();
		 InformacaoAdicional entity = repo.findById(id);

		if (entity != null) {
			try {
				repo.remove(entity);
				Util.addInfoMessage(" Excluido com Sucesso.");
			} catch (Exception e) {
				Util.addErrorMessage("Erro ao executar Exclusao.");
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

	public void setList(List< InformacaoAdicional> list) {
		this.list = list;
	}

	public List< InformacaoAdicional> getList() {
		return list;
	}

}
