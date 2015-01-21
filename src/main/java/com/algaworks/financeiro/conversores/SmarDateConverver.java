package com.algaworks.financeiro.conversores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("smartDate")
public class SmarDateConverver implements Converter {
	
	private static final DateFormat FORMATADOR = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Date dataConvertida = null;
		
		if (value == null || value.trim().equals("")) {
			return null;	
		}
		
		if ("hoje".equalsIgnoreCase(value)) {
			dataConvertida = Calendar.getInstance().getTime();
		} else if ("amanha".equalsIgnoreCase(value)) {
			Calendar amanha = Calendar.getInstance();
			amanha.add(Calendar.DAY_OF_MONTH, 1);
			dataConvertida = amanha.getTime();
		} else if ("ontem".equalsIgnoreCase(value)) {
			Calendar ontem = Calendar.getInstance();
			ontem.add(Calendar.DAY_OF_MONTH, -1);
			dataConvertida = ontem.getTime();
		} else {
			try {
				dataConvertida = FORMATADOR.parse(value);
			} catch (ParseException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Data incorreta.", "A data digitada está incorreta."));
			}
		}
		
		return dataConvertida;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return FORMATADOR.format((Date) value);
	}

}
