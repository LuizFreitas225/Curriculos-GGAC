package br.unitins.curriculoggac.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.curriculoggac.model.Perfil;


@Converter(autoApply = true)
public class PerfilConverter implements AttributeConverter<Perfil, Integer>{

	@Override
	public Integer convertToDatabaseColumn(Perfil perfil) {
		return perfil == null ? null : perfil.getId();
	}

	@Override
	public Perfil convertToEntityAttribute(Integer id) {
		return Perfil.valueOf(id);
	}
}
