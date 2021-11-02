package br.unitins.curriculoggac.model;

public enum StatusFormacao {
   EM_ANDAMENTO(1,"Em Andamento"),
   CONCLUIDO(2,"Concluído"),
   INCONCLUIDO(3,"Inconcluído");
   
	private String label;
	  private Integer id;
		
		private StatusFormacao( int id, String label) {
			this.label = label;
			this.id = id;
		}


		public String getLabel() {
			return label;
		}

		public Integer getId() {
			return id;
		}
		
		public static StatusFormacao valueOf(Integer id) {
			if (id == null)
				return null;
			for (StatusFormacao statusFormacao : StatusFormacao.values()) {
				if (statusFormacao.getId().equals(id))
					return statusFormacao;
			}
			return null;
		}
}
