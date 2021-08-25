package br.unitins.curriculoggp.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.DAO.UsuarioDao;
import br.unitins.curriculoggp.model.Usuario;

@Named
@RequestScoped
public class UsuarioController {
      Usuario usuario;
      UsuarioDao usuarioDao = new UsuarioDao();
      
      public void salvar(Usuario usuario) {
    	  usuarioDao.inserir(usuario);
      }
	
}
