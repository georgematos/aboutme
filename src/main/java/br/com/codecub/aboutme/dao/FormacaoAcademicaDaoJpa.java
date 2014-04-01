package br.com.codecub.aboutme.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.codecub.aboutme.negocio.FormacaoAcademica;

@Repository // Anota a classe como injetável
public class FormacaoAcademicaDaoJpa implements FormacaoAcademicaDao {

	/**
	 * O EntityManager é injetado pelo Spring através da anotação @PersistenceContext.
	 * Criar o EnityManager dessa maneira exige que o construtor da classe seja o padrão, ou seja,
	 * não deve ser declarado. Essa anotação diz para o Spring controlar o EntityManager por nós,
	 * desde a criação até o fechamento.
	 */
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public void adiciona(FormacaoAcademica f) {
		manager.persist(f);
	}
	
	@Override
	@Transactional
	public ArrayList<FormacaoAcademica> lista(Long id) {
		
		ArrayList<FormacaoAcademica> formacoes = new ArrayList<>();
		TypedQuery<FormacaoAcademica> query = manager.createQuery("from Mensagem where usuario_id=" + id, FormacaoAcademica.class);
		formacoes = (ArrayList<FormacaoAcademica>) query.getResultList();
		
		return formacoes;
		
	}

	@Override
	@Transactional
	public FormacaoAcademica getById(Long id) {
		FormacaoAcademica f = manager.find(FormacaoAcademica.class, id);
		return f;
	}
	
	@Override
	@Transactional
	public void remove(Long id) {
		FormacaoAcademica f = getById(id);
		manager.remove(f);
	}

	@Override
	@Transactional
	public void altera(FormacaoAcademica f) {
		manager.merge(f);
	}

}
