package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.util.Transactional;

public class Pessoas implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	@Inject
	public Pessoas(EntityManager em) {
		this.em = em; 
	}
	
	public Pessoa buscaPorId(Long id) {
		return em.find(Pessoa.class, id);
	}
	
	public List<Pessoa> listaTodos() {
		TypedQuery<Pessoa> qr = em.createQuery("from Pessoa", Pessoa.class);
		return qr.getResultList();
	}
	
	@Transactional
	public Pessoa gravar(Pessoa pessoa) {
		Pessoa retorno = null;
		retorno = em.merge(pessoa);
		return retorno;
	}
	
	@Transactional
	public void remover(Pessoa pessoa) {
		pessoa = this.buscaPorId(pessoa.getId());
		em.remove(pessoa);
	}
	
}
