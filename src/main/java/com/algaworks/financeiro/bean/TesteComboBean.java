package com.algaworks.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TesteComboBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String opcao = "1";
	private boolean mostraCampo1 = true;
	private List<String> lista = getEsportes();
	private String combo2;
	
	public void valorAlterado(AjaxBehaviorEvent event) {
		this.lista = new ArrayList<String>();
		
		this.mostraCampo1 = !this.opcao.equals("3");
		
		System.out.println("Combo1: " + this.opcao);
		System.out.println("Combo2: " + this.combo2);
		
		switch (this.opcao) {
		case "1":
			lista = getEsportes();
			break;
		case "2":
			lista = getFilmes();
			break;
		case "3":
			lista = getLinguagens();
			break;
		case "4":
			lista = getCarros();
			break;
		default:
			break;
		}
		
	}
	
	public void combo2Alterado(AjaxBehaviorEvent event) {
		System.out.println("Combo2: " + this.combo2);
	}
	
	private List<String> getEsportes() {
		List<String> lista = new ArrayList<String>();
		lista.add("Futebol");
		lista.add("Volei");
		lista.add("Basquete");
		lista.add("Tênis");
		return lista;
	}

	private List<String> getFilmes() {
		List<String> lista = new ArrayList<String>();
		lista.add("Rambo");
		lista.add("Senhor dos anéis");
		lista.add("Exterminador do Futuro");
		lista.add("Mangue Negro");
		return lista;
	}

	private List<String> getLinguagens() {
		List<String> lista = new ArrayList<String>();
		lista.add("Java");
		lista.add("C#");
		lista.add("Delphi");
		lista.add("Clipper");
		return lista;
	}

	private List<String> getCarros() {
		List<String> lista = new ArrayList<String>();
		lista.add("Corolla");
		lista.add("Fit");
		lista.add("207");
		lista.add("Celta");
		return lista;
	}
	
	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public boolean isMostraCampo1() {
		return mostraCampo1;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

	public String getCombo2() {
		return combo2;
	}

	public void setCombo2(String combo2) {
		this.combo2 = combo2;
	}

}
