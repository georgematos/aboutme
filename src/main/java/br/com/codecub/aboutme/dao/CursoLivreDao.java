package br.com.codecub.aboutme.dao;

import java.util.List;

import br.com.codecub.aboutme.negocio.CursoLivre;

public interface CursoLivreDao {

	void adiciona(CursoLivre c);
	void altera(CursoLivre c);
	void remove(Long id);
	CursoLivre getById(Long id);
	List<CursoLivre> lista(Long id);
	
}
