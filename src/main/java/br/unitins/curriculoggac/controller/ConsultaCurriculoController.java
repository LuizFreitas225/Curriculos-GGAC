package br.unitins.curriculoggac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



import br.unitins.curriculoggac.Repository.CurriculoRepository;
import br.unitins.curriculoggac.application.FlashEasy;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Session;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.Usuario;
@Named
@ViewScoped
public class ConsultaCurriculoController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3583009770061848869L;

	private String filtro = "";
	
	public ConsultaCurriculoController() {
		super();
		pesquisar();
	}
	private List<Curriculo> list;
	public void pesquisar() {
		CurriculoRepository repo = new CurriculoRepository();
		try {
			setList(repo.findByDescricao(filtro,20, getUsuarioLogado()));
		} catch (RepositoryException e) {
			setList(new ArrayList<Curriculo>());
		}
	}

	public void select(int id) throws RepositoryException {
		CurriculoRepository repo = new CurriculoRepository();
		Curriculo curriculo = repo.findById(id);
	
		if(curriculo != null) {
			Flash flash = FlashEasy.getInstance();
			flash.put("curriculoAtual", curriculo );
			Util.redirect("visualizacaocurriculo.xhtml");	
		}
	    	
	}
	
	public void novo()  {
		
	    Util.redirect("curriculo.xhtml");	
	}
	public void excluir(int id) throws RepositoryException {
		CurriculoRepository repo = new CurriculoRepository();
		Curriculo curriculo = repo.findById(id);
	
		if(curriculo != null) {
			try {
				repo.remove(curriculo);
				Util.addInfoMessage("Curriculo Excluido com Sucesso.");
			}catch(Exception e){
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
	
	public List<Curriculo> getList() {
		return list;
	}

	public void setList(List<Curriculo> list) {
		this.list = list;
	}
	public Usuario getUsuarioLogado() {
		// obtendo o usuario da sessao
		
		Usuario usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
		
		return usuarioLogado;
	}

}
