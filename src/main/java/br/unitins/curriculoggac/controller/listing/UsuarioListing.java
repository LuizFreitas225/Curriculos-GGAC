package br.unitins.curriculoggac.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.unitins.curriculoggac.Repository.UsuarioRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.model.Usuario;


@Named
@ViewScoped
public class UsuarioListing extends Listing<Usuario> {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5775964050050694368L;
	private String filtro = "";

	public UsuarioListing() {
		super("usuariolisting", new UsuarioRepository());
		pesquisar();
	}

	@Override
	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Usuario>());
		}

	}
	
	public void select(String id) {
		Usuario obj = null;
		UsuarioRepository repo = new UsuarioRepository();
		try {
			obj = repo.findById(id);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		PrimeFaces.current().dialog().closeDynamic(obj);
	}
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
}
