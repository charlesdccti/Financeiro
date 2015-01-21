package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.algaworks.financeiro.model.Lancamento;

public class Lancamentos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	@Inject
	public Lancamentos(EntityManager em) {
		this.em = em;
	}
	
	public void adicionar(Lancamento lancamento) {
		EntityTransaction trx = this.em.getTransaction();
		trx.begin();
		this.em.persist(lancamento);
		trx.commit();
	}
	
	public List<Lancamento> listaTodos() {
		TypedQuery<Lancamento> qr = em.createQuery("from Lancamento", Lancamento.class);
		return qr.getResultList();
	}
	
	public List<String> descricoesQueContem(String descricao) {
		TypedQuery<String> qr = em.createQuery("select distinct descricao from Lancamento " +
				"where upper(descricao) like upper(:descricao)", String.class);
		qr.setParameter("descricao", "%" + descricao + "%");
		return qr.getResultList();
	}
	
	public Lancamento porId(Long id) {
		return em.find(Lancamento.class, id);
	}
	
	public Lancamento guardar(Lancamento lancamento) {
		Lancamento retorno = null;
		lancamento = this.em.merge(lancamento);
		return retorno;
	}
	
	public void remover(Lancamento lancamento) {
		this.em.remove(lancamento);
	}

}
