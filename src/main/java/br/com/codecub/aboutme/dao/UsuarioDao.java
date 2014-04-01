package br.com.codecub.aboutme.dao;

import java.util.List;

import br.com.codecub.aboutme.negocio.Curriculo;
import br.com.codecub.aboutme.negocio.CursoLivre;
import br.com.codecub.aboutme.negocio.FormacaoAcademica;
import br.com.codecub.aboutme.negocio.Usuario;

public interface UsuarioDao {

	void adiciona(Usuario usuario);
	void altera(Usuario usuario);
	void remove(Long id);
	Usuario getByEmail(String email);
	Usuario getById(Long id);
	List<Curriculo> getCurriculo(Long id);
	List<FormacaoAcademica> getFormacaoAcademica(Long id);
	List<CursoLivre> getCursos(Long id);
	List<Usuario> lista();
	
}
