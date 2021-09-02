package br.unitins.curriculoggp.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.DAO.UsuarioDao;
import br.unitins.curriculoggp.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
   
	private static final long serialVersionUID = -5242237200720059655L;
	Usuario usuario;
      UsuarioDao usuarioDao = new UsuarioDao();
      
      public Usuario salvar() {
    	  Usuario aux = usuarioDao.inserir(getUsuario());
    	  if( aux != null ) {
    		  FacesContext.getCurrentInstance().addMessage(null,
  	   				new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão realizada com sucesso.", null));
    	  limpar();
    	  }
    	  return aux;
      }
      
      public void excluir(Usuario user) {
    	  usuarioDao.deletar(user);
    	  
    	  FacesContext.getCurrentInstance().addMessage(null,
	   				new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão realizada com sucesso.", null));
      }
      
      
      public Usuario atualizar() {
    	  Usuario aux = usuarioDao.atualizar(getUsuario());
    	  limpar();
    	  FacesContext.getCurrentInstance().addMessage(null,
	   				new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização realizada com sucesso.", null));
    	  return aux;
      }
      public void editar(Usuario user) {
    	  setUsuario(user);
      }
      
      public List<Usuario> getTodos(){
    	  return usuarioDao.buscarTodos();
      }
      
      public void limpar() {
    	  usuario = null;
      }
      
	public Usuario getUsuario() {
		if (usuario ==null)
			usuario= new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
      
      
	
}
