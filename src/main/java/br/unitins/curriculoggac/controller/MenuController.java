
package br.unitins.curriculoggac.controller;



import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.application.Session;


@Named
@RequestScoped
public class MenuController { 
    
	

	public String encerrarSessao() {
		Session.getInstance().invalidateSession();
		return "/faces/login.xhtml?faces-redirect=true" ;
	}
	


	
}
	

