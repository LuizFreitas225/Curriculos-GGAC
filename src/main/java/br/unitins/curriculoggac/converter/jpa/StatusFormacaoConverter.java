package br.unitins.curriculoggac.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.curriculoggac.model.StatusFormacao;


@Converter(autoApply = true)
public class StatusFormacaoConverter implements AttributeConverter<StatusFormacao, Integer> {

	@Override
	public Integer convertToDatabaseColumn(StatusFormacao statusFormacao) {
		return statusFormacao == null ? null : statusFormacao.getId();
	}

	@Override
	public StatusFormacao convertToEntityAttribute(Integer id) {
		return StatusFormacao.valueOf(id);
	}

}
