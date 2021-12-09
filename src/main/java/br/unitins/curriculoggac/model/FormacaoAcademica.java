package br.unitins.curriculoggac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FormacaoAcademica extends Formacao {
	
	private String semestre;
	
	private TipoEnsino tipoEnsino ;
	
	

	public TipoEnsino getTipoEnsino() {
		return tipoEnsino;
	}

	public void setTipoEnsino(TipoEnsino tipoEnsino) {
		this.tipoEnsino = tipoEnsino;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
