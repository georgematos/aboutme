package br.com.codecub.aboutme.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Curriculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4791096559165051275L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 600)
	private String qualificacoes;
	
	@Column(length = 100)
	private String objProfissional;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="curriculo_id")
	private List<FormacaoAcademica> formacaoAcademica;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="curriculo_id")
	private List<ExperienciaProfissional> experienciaProfissional;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="curriculo_id")
	private List<CursoLivre> cursoLivre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQualificacoes() {
		return qualificacoes;
	}

	public void setQualificacoes(String qualificacoes) {
		this.qualificacoes = qualificacoes;
	}

	public String getObjProfissional() {
		return objProfissional;
	}

	public void setObjProfissional(String objProfissional) {
		this.objProfissional = objProfissional;
	}

	public List<FormacaoAcademica> getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(List<FormacaoAcademica> formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public List<ExperienciaProfissional> getExperienciaProfissional() {
		return experienciaProfissional;
	}

	public void setExperienciaProfissional(
			List<ExperienciaProfissional> experienciaProfissional) {
		this.experienciaProfissional = experienciaProfissional;
	}

	public List<CursoLivre> getCursoLivre() {
		return cursoLivre;
	}

	public void setCursoLivre(List<CursoLivre> cursoLivre) {
		this.cursoLivre = cursoLivre;
	}

}
