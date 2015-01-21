package com.algaworks.financeiro.ola;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "ola")
public class OlaBean {

	private String nome;
	private String sobreNome;
	private String nomeCompleto;
	
	public void dizerOla() {
		nomeCompleto = nome.toUpperCase() + " " + sobreNome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
}
