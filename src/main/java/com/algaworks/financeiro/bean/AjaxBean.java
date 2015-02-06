package com.algaworks.financeiro.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AjaxBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private String linguagem;
	public boolean desabilitarCampo = false;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void caixaAlta() {
		this.nome = nome.toUpperCase();
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	public void desabilitar() {
		desabilitarCampo = (linguagem.equals("4"));
	}

	public boolean isDesabilitarCampo() {
		return desabilitarCampo;
	}

	public void setDesabilitarCampo(boolean desabilitarCampo) {
		this.desabilitarCampo = desabilitarCampo;
	}

}
