package br.unitins.curriculoggac.converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.curriculoggac.Repository.CurriculoRepository;
import br.unitins.curriculoggac.model.Curriculo;

@FacesConverter(forClass = Curriculo.class)
public class CurriculoConverter implements Converter<Curriculo> {

	@Override
	public Curriculo getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;

		CurriculoRepository repo = new CurriculoRepository();
		try {
			return repo.findById(Integer.valueOf(value.trim()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Curriculo curriculo) {
		if (curriculo == null || curriculo.getId() == null)
			return null;

		return curriculo.getId().toString();
	}

}
