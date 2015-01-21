package com.algaworks.financeiro.validadores;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("diasUteis")
public class DiasUteisValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent componente, Object value)
			throws ValidatorException {
		
		Date data = (Date) value;
		
		Calendar dataValidar = Calendar.getInstance();
		dataValidar.setTime(data);
		
		int diaSemana = dataValidar.get(Calendar.DAY_OF_WEEK);
		
		if (diaSemana == Calendar.SATURDAY || diaSemana == Calendar.SUNDAY) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Data inválida", "A data não é um dia útil."));
		}

	}

}
