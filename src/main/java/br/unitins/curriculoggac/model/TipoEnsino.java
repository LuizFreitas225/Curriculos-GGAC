package br.unitins.curriculoggac.model;

public enum TipoEnsino {
	EDUCACAO_INFANTIL(1,"Educa��o Infantil"),
	PRE_ESCOLA(2,"Pr�-Escola"),
	ENSINO_FUNDAMENTAl(3,"Ensino Fundamental"),
	 ENSINO_MEDIO(4,"Ensino M�dio"),
	 ENSINO_MEDIO_TECNICO(5,"Ensino M�dio T�cnico"),
	 GRADUACAO(6,"Gradua��o"),
	 POS_GRADUACAO(7,"P�s-Gradua��o"),
	 MESTRADO(8,"Mestrado"),
	 DOUTORADO(9,"Doutorado"),
	 POS_DOUTORADO(10,"P�s-Doutorado");
	 
	 
	
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