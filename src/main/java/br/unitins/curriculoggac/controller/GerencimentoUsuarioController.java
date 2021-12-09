package br.unitins.curriculoggac.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.curriculoggac.Repository.UsuarioRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;

import br.unitins.curriculoggac.controller.listing.UsuarioListing;
import br.unitins.curriculoggac.model.EstadoCivil;
import br.unitins.curriculoggac.model.Perfil;

import br.unitins.curriculoggac.model.Usuario;

@Named
@ViewScoped
public class GerencimentoUsuarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = -5242237200720059655L;
	String confirmarSenha = "";
	String senha = "";
	UsuarioRepository usuarioRepository;

	public void salvarUsuario() {

		if (getConfirmarSenha().equals(getSenha())) {
			try {
				Usuario aux = getUsuarioRepository().findById(entity.getEmail());
				if (aux != null) {
					Util.addErrorMessage("Email já está em uso.");

				}
				

					String hash = Util.hash(entity.getEmail() + getSenha());
					entity.setSenha(hash);
					

				
				getUsuarioRepository().save(entity);
				Util.addInfoMessage("Registro Realizado com Sucesso.");
			} catch (RepositoryException e) {
				Util.addErrorMessage("Problema ao salvar, tente novamente ou entre em contato com a TI.");

			}
		} else {

			Util.addErrorMessage("Verifique a confirmação de senha e tente novamente.");

		}

		limpar();
		setConfirmarSenha("");

	}
	public void baixar() {

		
		Util.redirect("/CurriculoGGP/faces/usuarioreportservlet");
	}

	public String alterarUsuario() {

		if (getConfirmarSenha().equals(getSenha())) {
			
			if(! getSenha().isEmpty()) {
           	 String hash = Util.hash(entity.getEmail() + getSenha());
				entity.setSenha(hash);
				
            }
			try {
                 
				getUsuarioRepository().save(entity);
				Util.addInfoMessage("Alteração realizada com sucesso.");
			} catch (RepositoryException e) {
				Util.addErrorMessage("Problema ao salvar, tente novamente ou entre em contato com a TI.");
				return null;
			}
		} else {

			Util.addErrorMessage("Verifique a confirmação de senha e tente novamente.");
			return null;
		}

		limpar();
		setConfirmarSenha("");
		return "login.xhtml?faces-redirect=true";
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	public void abrirUsuarioListing() {
		UsuarioListing listing = new UsuarioListing();
		listing.open();

		System.out.println("Abrir Usuario List");
	}

	public void obterUsuarioListing(SelectEvent<Usuario> event) {
		setEntity(event.getObject());
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioRepository getUsuarioRepository() {
		if (usuarioRepository == null) {
			usuarioRepository = new UsuarioRepository();
		}
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Perfil[] getListPerfil() {
		return Perfil.values();
	}

}
