package br.com.codecub.aboutme.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.codecub.aboutme.negocio.CursoLivre;

@Repository // Anota a classe como injet�vel
public class CursoLivreDaoJpa implements CursoLivreDao {

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
	public void adiciona(CursoLivre c) {
		manager.persist(c);
	}
	
	@Override
	@Transactional
	public ArrayList<CursoLivre> lista(Long id) {
		
		ArrayList<CursoLivre> cursos = new ArrayList<>();
		TypedQuery<CursoLivre> query = manager.createQuery("from Mensagem where usuario_id=" + id, CursoLivre.class);
		cursos = (ArrayList<CursoLivre>) query.getResultList();
		
		return cursos;
		
	}

	@Override
	@Transactional
	public CursoLivre getById(Long id) {
		CursoLivre c = manager.find(CursoLivre.class, id);
		return c;
	}
	
	@Override
	@Transactional
	public void remove(Long id) {
		CursoLivre c = getById(id);
		manager.remove(c);
	}

	@Override
	@Transactional
	public void altera(CursoLivre c) {
		manager.merge(c);
	}

}
