package com.algaworks.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.model.Lancamento;
import com.algaworks.financeiro.regras.CadastroLancamentos;
import com.algaworks.financeiro.regras.NegocioException;
import com.algaworks.financeiro.repository.Lancamentos;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Lancamentos lancamentosRepository;
	private List<Lancamento> lancamentos;
	private Lancamento lancamentoSelecionado;
	@Inject
	private CadastroLancamentos cadastro;
	
	public void consultar() {
		 this.lancamentos = lancamentosRepository.listaTodos();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			cadastro.excluir(this.getLancamentoSelecionado());
			this.consultar();
			context.addMessage(null, new FacesMessage("Lançamento excluído com sucesso."));
		} catch (NegocioException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}	
	

}
