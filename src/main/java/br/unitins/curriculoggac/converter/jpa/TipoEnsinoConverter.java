package br.unitins.curriculoggac.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


import br.unitins.curriculoggac.model.TipoEnsino;
@Converter(autoApply = true)
public class TipoEnsinoConverter implements AttributeConverter<TipoEnsino, Integer> {
	
		

			@Override
			public Integer convertToDatabaseColumn(TipoEnsino tipoEnsino) {
				return tipoEnsino == null ? null : tipoEnsino.getId();
			}

			@Override
			public TipoEnsino convertToEntityAttribute(Integer id) {
				return TipoEnsino.valueOf(id);
			}

		
	
}
