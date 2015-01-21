package com.algaworks.financeiro.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.repository.Pessoas;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	
	@Inject
	private Pessoas pessoas;
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			pessoas.gravar(this.getPessoa());
			
			setPessoa(new Pessoa());
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa salva com sucesso.", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
