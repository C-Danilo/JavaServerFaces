package br.fepi.si.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.fepi.si.financeiro.model.Pessoa;

public class Pessoas implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public Pessoas(EntityManager em) {
		this.em = em;
	}

	public List<Pessoa> todosPessoas() {
		TypedQuery<Pessoa> query = em.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}
}
