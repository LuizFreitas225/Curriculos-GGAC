package br.unitins.curriculoggac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.EnderecoWebRepository;
import br.unitins.curriculoggac.application.FlashEasy;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.EnderecoWeb;


@Named
@SessionScoped
public class ConsultaEnderecoWebController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3583009770061848869L;

	private String filtro = "";
	private Curriculo curriculo;
	private List<EnderecoWeb> list;

	public ConsultaEnderecoWebController() {
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
		Util.redirect("enderecoweb.xhtml");
	}

	public void pesquisar() {
		EnderecoWebRepository repo = new EnderecoWebRepository();
		try {
			setList(repo.findByDescricao(filtro, getCurriculo()));
		} catch (Exception e) {
			setList(new ArrayList<EnderecoWeb>());
		}
	}

	public void select(int id) throws RepositoryException {
		EnderecoWebRepository repo = new EnderecoWebRepository();
		EnderecoWeb entity = repo.findById(id);

		if (entity != null) {
			Flash flash = FlashEasy.getInstance();
			flash.put("enderecoWebAtual", entity);
			flash.put("curriculoAtual", curriculo);
			Util.redirect("enderecoweb.xhtml");
		}

	}

	public void excluir(int id) throws RepositoryException {
		EnderecoWebRepository repo = new EnderecoWebRepository();
		EnderecoWeb entity = repo.findById(id);

		if (entity != null) {
			try {
				repo.remove(entity);
				Util.addInfoMessage(" Excluido com Sucesso.");
			} catch (Exception e) {
				Util.addErrorMessage("Erro ao executar Exclus�o.");
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
		Flash flash = FlashEasy.getInstance();
		Curriculo atual =(Curriculo) flash.get("curriculoAtual");
		if( curriculo != atual && atual != null) {
			curriculo = atual;
			setFiltro("");
			pesquisar();
			
		}
		
		
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public void setList(List<EnderecoWeb> list) {
		this.list = list;
	}

	public List<EnderecoWeb> getList() {
		return list;
	}
}