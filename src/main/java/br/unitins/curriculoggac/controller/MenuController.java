
package br.unitins.curriculoggac.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.CurriculoRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Session;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.Usuario;

@Named
@RequestScoped
public class MenuController {

	private Usuario usuarioLogado;
	private Curriculo curriculo;

	public String encerrarSessao() {
		Session.getInstance().invalidateSession();
		return "/faces/login.xhtml?faces-redirect=true";
	}

	public List<Curriculo> completeCurriculo(String query) {
		CurriculoRepository repo = new CurriculoRepository();
		try {
			return repo.findByDescricao(query, 5, getUsuarioLogado());
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Curriculo>();
	}

	public void gerenciarCurriculo() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("curriculoMenu", getCurriculo());
		Util.redirect("../pages/curriculo.xhtml");

	}

	public Usuario getUsuarioLogado() {
		// obtendo o usuario da sessao
		if (usuarioLogado == null) {
			usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
		}
		return usuarioLogado;
	}

	public Curriculo getCurriculo() {
		if (curriculo == null) {
			curriculo = new Curriculo();
		}
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

}
