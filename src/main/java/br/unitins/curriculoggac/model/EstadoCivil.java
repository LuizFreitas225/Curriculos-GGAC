package br.unitins.curriculoggac.model;

public enum EstadoCivil {
      SOLTEIRO(1,"Solteiro(a)"),
      CASADO(2,"Casado(a)"),
      VIUVO(3,"Viuvo(a)");
	
	private String label;
	private Integer id;
	
	private EstadoCivil( int id, String label) {
		this.label = label;
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public Integer getId() {
		return id;
	}
   
	public static EstadoCivil valueOf(Integer id) {
		if (id == null)
			return null;
		for (EstadoCivil estadoCivil : EstadoCivil.values()) {
			if (estadoCivil.getId().equals(id))
				return estadoCivil;
		}
		return null;
	}
	
	

}
