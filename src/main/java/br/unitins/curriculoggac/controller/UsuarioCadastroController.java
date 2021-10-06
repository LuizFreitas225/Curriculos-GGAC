package br.unitins.curriculoggac.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.Repository;
import br.unitins.curriculoggac.Repository.UsuarioRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Usuario;

@Named
@ViewScoped
public class UsuarioCadastroController extends Controller <Usuario> implements Serializable {
   
	private static final long serialVersionUID = -5242237200720059655L;
    String confirmarSenha= "";
    UsuarioRepository usuarioRepository;

	@Override
	public void salvar() {
		
		
		if(getConfirmarSenha().equals(entity.getSenha()) ) {
			try {
				List<Usuario> aux = getUsuarioRepository().findByEmail(entity.getEmail());
				if(! aux.isEmpty() ) {
					Util.addErrorMessage("Email já está em uso.");
					return;
				}
				usuarioRepository.save(entity);
			} catch (RepositoryException e) {
				Util.addErrorMessage("Problema ao salvar, tente novamente ou entre em contato com a TI.");
			}
		}else {
			
			Util.addErrorMessage("Verifique a confirmação de senha e tente novamente.");
		}
		
		
	}
    
	
	@Override
	public Usuario getEntity() {
		if (entity == null) {
			 entity = new Usuario();
		}
		return entity;
	}
 
    


	

	public UsuarioRepository getUsuarioRepository() {
		if(usuarioRepository == null ) {
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
	
}
