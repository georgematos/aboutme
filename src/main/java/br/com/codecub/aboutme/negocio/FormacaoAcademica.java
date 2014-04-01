package br.com.codecub.aboutme.negocio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FormacaoAcademica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5109934529312507951L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 100)
	private String instituicao;

	@Column(nullable = false, length = 100)
	private String curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
