package br.unitins.curriculoggac.model;

public enum Atributo {
	  ENDERECO_WEB(1,"Endereço Web"),
	  FORMACAO_ACADEMICA(2,"Formação Acadêmica"),
	  QUALIFICACAO(3,"Qualificação"),
	  INFORMACAO_ADICIONAL(4,"Informação Adicional"),
	  EXPERIENCIA_PROFISSIONAL(5,"Experiência Profissional");
	  
	   
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
