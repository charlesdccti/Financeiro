package com.algaworks.financeiro.testes;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MeuBean {

	private String nome;
	private int quantidadeDeCaracteres;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void transformar() {
		this.nome = this.nome.toUpperCase();
		this.setQuantidadeDeCaracteres(this.nome.length());
	}

	public int getQuantidadeDeCaracteres() {
		return quantidadeDeCaracteres;
	}

	public void setQuantidadeDeCaracteres(int quantidadeDeCaracteres) {
		this.quantidadeDeCaracteres = quantidadeDeCaracteres;
	}
}