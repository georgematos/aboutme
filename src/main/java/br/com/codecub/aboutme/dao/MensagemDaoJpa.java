package br.com.codecub.aboutme.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.codecub.aboutme.negocio.Mensagem;

@Repository // Anota a classe como injet�vel
public class MensagemDaoJpa implements MensagemDao {

	/**
	 * O EntityManager � injetado pelo Spring atrav�s da anota��o @PersistenceContext.
	 * Criar o EnityManager dessa maneira exige que o construtor da classe seja o padr�o, ou seja,
	 * n�o deve ser declarado. Essa anota��o diz para o Spring controlar o EntityManager por n�s,
	 * desde a cria��o at� o fechamento.
	 */
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public void adiciona(Mensagem m) {
		manager.persist(m);
	}
	
	@Override
	@Transactional
	public ArrayList<Mensagem> lista(Long id) {
		
		ArrayList<Mensagem> msgs = new ArrayList<>();
		TypedQuery<Mensagem> query = manager.createQuery("from Mensagem where usuario_id=" + id, Mensagem.class);
		msgs = (ArrayList<Mensagem>) query.getResultList();
		
		return msgs;
		
	}

	@Override
	@Transactional
	public Mensagem getById(Long id) {
		Mensagem m = manager.find(Mensagem.class, id);
		return m;
	}
	
	@Override
	@Transactional
	public void remove(Long id) {
		Mensagem m = getById(id);
		manager.remove(m);
	}

	@Override
	@Transactional
	public void altera(Mensagem m) {
		manager.merge(m);
	}

}
