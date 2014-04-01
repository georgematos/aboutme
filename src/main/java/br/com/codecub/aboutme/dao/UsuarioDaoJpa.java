package br.com.codecub.aboutme.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.codecub.aboutme.negocio.Curriculo;
import br.com.codecub.aboutme.negocio.CursoLivre;
import br.com.codecub.aboutme.negocio.FormacaoAcademica;
import br.com.codecub.aboutme.negocio.Usuario;

@Repository // Anota a classe como injetável
public class UsuarioDaoJpa implements UsuarioDao {

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
	public void adiciona(Usuario usuario) {
		manager.persist(usuario);
	}
	
	@Override
	@Transactional
	public ArrayList<Usuario> lista() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		TypedQuery<Usuario> query = manager.createQuery("from Usuario", Usuario.class);
		usuarios = (ArrayList<Usuario>) query.getResultList();
		
		return usuarios;
		
	}

	@Override
	@Transactional
	public Usuario getById(Long id) {
		TypedQuery<Usuario> query = manager.createQuery("from Usuario where id='" + id + "'", Usuario.class);
		Usuario usuario = query.getSingleResult();
		return usuario;
	}
	
	@Override
	@Transactional
	public Usuario getByEmail(String email) {
		
		try {
			TypedQuery<Usuario> query = manager.createQuery("from Usuario where email='" + email + "'", Usuario.class);
			Usuario user = query.getSingleResult();
			manager.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@Transactional
	public void remove(Long id) {
		Usuario usuario = getById(id);
		manager.remove(usuario);
	}

	@Override
	@Transactional
	public void altera(Usuario usuario) {
		manager.merge(usuario);
	}

	@Override
	@Transactional
	public List<FormacaoAcademica> getFormacaoAcademica(Long id) {
		try {
			TypedQuery<FormacaoAcademica> query = manager.createQuery("from FormacaoAcademica where curriculo_id=" + id, FormacaoAcademica.class);
			List<FormacaoAcademica> formacao = query.getResultList();
			return formacao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public List<CursoLivre> getCursos(Long id) {
		try {
			TypedQuery<CursoLivre> query = manager.createQuery("from CursoLivre where curriculo_id=" + id, CursoLivre.class);
			List<CursoLivre> cursos = query.getResultList();
			return cursos;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@Transactional
	public List<Curriculo> getCurriculo(Long id) {
		try {
			TypedQuery<Curriculo> query = manager.createQuery("from Curriculo where usuario_id=" + id, Curriculo.class);
			List<Curriculo> curriculos = query.getResultList();
			return curriculos;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
