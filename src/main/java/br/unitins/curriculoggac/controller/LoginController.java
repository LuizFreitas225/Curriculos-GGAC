package br.unitins.curriculoggac.controller;



import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.UsuarioRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Session;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Usuario;

@Named
@RequestScoped
public class LoginController {
	private UsuarioRepository usuarioRepository;
    private String email="";
    private String senha="";
    
    
    public String entrar() throws RepositoryException {
    	try {
    		 Usuario usuarioLogado = getUsuarioRepository().validarLogin(email, senha);
    		 if(usuarioLogado == null) {
    			 Util.addErrorMessage("Email ou senha incorreto.");
    			 return null;
    		 }else {
    			 Session.getInstance().set("usuarioLogado", usuarioLogado);	
    			 Util.addInfoMessage("Login realizado com sucesso.");
    			 return "curriculo.xhtml?faces-redirect=true";
    		 }
    	}catch(Exception e) {
    		e.printStackTrace();
    		Util.addErrorMessage("Erro ao logar.Tente novamente mais tarde.");
    	}
       
    	return null;
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
    
    
}
