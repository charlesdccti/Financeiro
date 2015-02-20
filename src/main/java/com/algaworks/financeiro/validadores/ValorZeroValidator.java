package com.algaworks.financeiro.validadores;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("valorZero")
public class ValorZeroValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		BigDecimal valor = (BigDecimal) value;
		
		if (valor.compareTo(BigDecimal.ZERO) <= 0) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "O valor deve ser maior que 0 (zero).", ""));	
		}

	}

}
