package com.algaworks.financeiro.testes;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CadastroTorcedorBean {
	
	private String timeFavorito;

	public String getTimeFavorito() {
		return timeFavorito;
	}

	public void setTimeFavorito(String timeFavorito) {
		this.timeFavorito = timeFavorito;
	}
	
	public void mostrarSelecionado() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selecionado", "Item selecionado " + timeFavorito);
		context.addMessage(null, msg);
	}
	
}
