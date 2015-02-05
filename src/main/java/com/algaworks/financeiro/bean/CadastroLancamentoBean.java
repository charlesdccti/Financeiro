package com.algaworks.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.model.Lancamento;
import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.model.TipoLancamento;
import com.algaworks.financeiro.regras.CadastroLancamentos;
import com.algaworks.financeiro.regras.NegocioException;
import com.algaworks.financeiro.repository.Lancamentos;
import com.algaworks.financeiro.repository.Pessoas;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroLancamentos cadastro;

    @Inject
    private Pessoas pessoas;

    @Inject
    private Lancamentos lancamentos;

    private Lancamento lancamento = new Lancamento();
    private List<Pessoa> todasPessoas;

    public void prepararCadastro() {
        this.todasPessoas = pessoas.listaTodos();
        if (this.lancamento == null) {
            this.lancamento = new Lancamento();
        }
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            cadastro.salvar(this.lancamento);

            this.lancamento = new Lancamento();

            context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso."));
        } catch (NegocioException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
    }

    public List<Pessoa> getTodasPessoas() {
        return this.todasPessoas;
    }

    public TipoLancamento[] getTipoLancamentos() {
        return TipoLancamento.values();
    }

    public Lancamento getLancamento() {
        return this.lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public void descricaoModificada(ValueChangeEvent value) {
        System.out.println("Valor antigo: " + value.getOldValue());
        System.out.println("Valor novo: " + value.getNewValue());
//		FacesContext.getCurrentInstance().renderResponse();
    }

    public void dataVencimentoAlterada(AjaxBehaviorEvent event) {
        if (this.lancamento.getDataPagamento() == null) {
            this.lancamento.setDataPagamento(this.lancamento.getDataVencimento());
        }
    }

    public List<String> pesquisarDescricoes(String descricao) {
        return this.lancamentos.descricoesQueContem(descricao);
    }

}
