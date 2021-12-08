package br.unitins.curriculoggac.model;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {
	ADMINISTRADOR(1, "Administrador"), 		   
	USUARIO(2, "Usuário");     
	
	private Integer id;
	private String label;
	private List<String> paginasComPermissao;
	
	Perfil(Integer id, String label) {
		this.id = id;
		this.label = label;
		paginasComPermissao = new ArrayList<String>();
		
		// acesso para todos os usuarios
		paginasComPermissao.add("/CurriculoGGP/faces/login.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/sempermissao.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/cadastrousuario.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/meusdados.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/inicial.xhtml");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/img-usuario");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/paginaconsultacurriculo.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/visualizacaocurriculo.xhtml");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/consultaqualificacao.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/qualificacao.xhtml");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/consultaenderecoweb.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/enderecoweb.xhtml");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/consultainformacaoadicional.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/informacaoadicional.xhtml");

		paginasComPermissao.add("/CurriculoGGP/faces/pages/cidade.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/cidadelisting.xhtml");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/curriculo.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/curriculolisting.xhtml");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/estado.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/estadolisting.xhtml");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/pais.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/paislisting.xhtml");
		
		paginasComPermissao.add("/CurriculoGGP/faces/pages/formacaoacademica.xhtml");
		paginasComPermissao.add("/CurriculoGGP/faces/pages/consultaformacaoacademica.xhtml");
		
		
		
		
		if (id.equals(1)) { // ADM
			
			
			
			paginasComPermissao.add("/CurriculoGGP/faces/pages/gerenciamentousuario.xhtml");
			paginasComPermissao.add("/CurriculoGGP/faces/pages/usuariolisting.xhtml");
			
		
		} else if (id.equals(2)) { // Usuario
		
			
			
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