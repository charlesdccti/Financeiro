package com.algaworks.financeiro.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.repository.Pessoas;
import com.algaworks.financeiro.util.CDILocator;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {
	
	// @Inject (ainda não é suportado)
	Pessoas pessoas;
	
	public PessoaConverter() {
		this.pessoas = CDILocator.getBean(Pessoas.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Pessoa pessoa = null;

		if (value != null) {
			pessoa = pessoas.buscaPorId(new Long(value));
		}
		return pessoa;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Pessoa pessoa = (Pessoa) value;
			return pessoa.getId() == null ? null : pessoa.getId().toString();
		}
		return null;
	}
}
