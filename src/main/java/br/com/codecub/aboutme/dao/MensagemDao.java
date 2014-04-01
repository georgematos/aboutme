package br.com.codecub.aboutme.dao;

import java.util.List;

import br.com.codecub.aboutme.negocio.Mensagem;

public interface MensagemDao {

	void adiciona(Mensagem m);
	void altera(Mensagem m);
	void remove(Long id);
	Mensagem getById(Long id);
	List<Mensagem> lista(Long id);
	
}
