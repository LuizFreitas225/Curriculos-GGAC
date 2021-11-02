package br.unitins.curriculoggac.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.curriculoggac.model.EstadoCivil;

@Converter(autoApply = true)
public class EstadoCivilConverter implements AttributeConverter<EstadoCivil, Integer>{
	
	

		@Override
		public Integer convertToDatabaseColumn(EstadoCivil estadoCivil) {
			return estadoCivil == null ? null : estadoCivil.getId();
		}

		@Override
		public EstadoCivil convertToEntityAttribute(Integer id) {
			return EstadoCivil.valueOf(id);
		}

	
}
