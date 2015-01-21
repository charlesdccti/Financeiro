package com.algaworks.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.repository.Pessoas;

@Named
@ViewScoped
public class ConsultaPessoasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Pessoa> pessoas;
	private Pessoa pessoaSelecionada;
	@Inject
	private Pessoas pessoasRepository;
	
	public void consultar() {
		 this.pessoas = pessoasRepository.listaTodos();
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}
	
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			pessoasRepository.remover(this.pessoaSelecionada);
			this.consultar();
			context.addMessage(null, new FacesMessage("Pessoa excluída com sucesso."));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

}
