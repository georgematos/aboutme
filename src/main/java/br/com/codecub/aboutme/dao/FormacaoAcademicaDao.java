package br.com.codecub.aboutme.dao;

import java.util.List;

import br.com.codecub.aboutme.negocio.FormacaoAcademica;

public interface FormacaoAcademicaDao {

	void adiciona(FormacaoAcademica f);
	void altera(FormacaoAcademica f);
	void remove(Long id);
	FormacaoAcademica getById(Long id);
	List<FormacaoAcademica> lista(Long id);
	
}
