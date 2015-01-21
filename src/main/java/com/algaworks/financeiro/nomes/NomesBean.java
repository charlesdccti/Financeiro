package com.algaworks.financeiro.nomes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
@ViewScoped
public class NomesBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private List<String> nomes = new ArrayList<String>();
	
	private HtmlInputText inputNome;
	private HtmlCommandButton botaoAdicionar;
	
	public String adicionar() {
		nomes.add(nome);
		inputNome.setValue("");
		if (nomes.size() == 3) {
			inputNome.setDisabled(true);
			botaoAdicionar.setDisabled(true);
			botaoAdicionar.setValue("Muitos nome adicionados...");
			return "Ola";
		}
		return null;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<String> getNomes() {
		return nomes;
	}

	public HtmlInputText getInputNome() {
		return inputNome;
	}

	public void setInputNome(HtmlInputText inputNome) {
		this.inputNome = inputNome;
	}

	public HtmlCommandButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public void setBotaoAdicionar(HtmlCommandButton botaoAdicionar) {
		this.botaoAdicionar = botaoAdicionar;
	}

}
