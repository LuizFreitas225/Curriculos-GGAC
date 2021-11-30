package br.unitins.curriculoggac.model;

public enum Atributo {
	  ENDERECO_WEB(1,"Endere�o Web"),
	  FORMACAO_ACADEMICA(2,"Forma��o Acad�mica"),
	  QUALIFICACAO(3,"Qualifica��o"),
	  INFORMACAO_ADICIONAL(4,"Informa��o Adicional"),
	  EXPERIENCIA_PROFISSIONAL(5,"Experi�ncia Profissional");
	  
	   
		private String label;
		  private Integer id;
			
			private Atributo( int id, String label) {
				this.label = label;
				this.id = id;
			}


			public String getLabel() {
				return label;
			}

			public Integer getId() {
				return id;
			}
			
			public static Atributo valueOf(Integer id) {
				if (id == null)
					return null;
				for (Atributo atributo : Atributo.values()) {
					if (atributo.getId().equals(id))
						return atributo;
				}
				return null;
			}
}
