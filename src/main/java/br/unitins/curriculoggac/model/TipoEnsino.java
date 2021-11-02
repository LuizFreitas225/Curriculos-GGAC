package br.unitins.curriculoggac.model;

public enum TipoEnsino {
	EDUCACAO_INFANTIL(1,"Educação Infantil"),
	PRE_ESCOLA(2,"Pré-Escola"),
	ENSINO_FUNDAMENTAl(3,"Ensino Fundamental"),
	 ENSINO_MEDIO(4,"Ensino Médio"),
	 ENSINO_MEDIO_TECNICO(5,"Ensino Médio Técnico"),
	 GRADUACAO(6,"Graduação"),
	 POS_GRADUACAO(7,"Pós-Graduação"),
	 MESTRADO(8,"Mestrado"),
	 DOUTORADO(9,"Doutorado"),
	 POS_DOUTORADO(10,"Pós-Doutorado");
	 
	 
	
	  private String label;
	  private Integer id;
		
		private TipoEnsino( int id, String label) {
			this.label = label;
			this.id = id;
		}


		public String getLabel() {
			return label;
		}

		public Integer getId() {
			return id;
		}
		
		public static TipoEnsino valueOf(Integer id) {
			if (id == null)
				return null;
			for (TipoEnsino tipoEnsino : TipoEnsino.values()) {
				if (tipoEnsino.getId().equals(id))
					return tipoEnsino;
			}
			return null;
		}
	   
}