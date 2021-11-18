package br.unitins.curriculoggac.model;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {
	ADMINISTRADOR(1, "Administrador"), 		   
	USUARIO(2, "Usu�rio");     
	
	private Integer id;
	private String label;
	private List<String> paginasComPermissao;
	
	Perfil(Integer id, String label) {
		this.id = id;
		this.label = label;
		paginasComPermissao = new ArrayList<String>();
		
		// acesso para todos os usuarios
		paginasComPermissao.add("/CurriculoGGP/faces/login.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/cadastrousuario.xhtml");
		
		
		
		if (id.equals(1)) { // ADM
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/gerenciamentousuario.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/usuariolisting.xhtml");
			
			
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/cidade.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/cidadelisting.xhtml");
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/curriculo.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/curriculoListing.xhtml");
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/estado.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/estadolisting.xhtml");
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/pais.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/paislisting.xhtml");
			
			
		} else if (id.equals(2)) { // Usuario
		
			
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/cidade.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/cidadelisting.xhtml");
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/curriculo.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/curriculoListing.xhtml");
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/estado.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/estadolisting.xhtml");
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/pais.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/paislisting.xhtml");
		}
	}
	
	public List<String> getPaginasComPermissao() {
		return paginasComPermissao;
	}
	
	public static Perfil valueOf(Integer id) {
		if (id == null)
			return null;
		for (Perfil perfil : Perfil.values()) {
			if (perfil.getId().equals(id))
				return perfil;
		}
		return null;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Integer getId() {
		return id;
	}
}