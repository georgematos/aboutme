package br.com.codecub.aboutme.negocio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CursoLivre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7847554177067844983L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 100)
	private String titulo;

	@Column(nullable = false, length = 100)
	private String instituicao;

	@Temporal(value = TemporalType.DATE)
	private Date dataIncio;

	@Temporal(value = TemporalType.DATE)
	private Date dataFim;

	private Integer cargaHoraria;

	@Column(length = 100)
	private String link;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

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

	public Date getDataIncio() {
		return dataIncio;
	}

	public void setDataIncio(Date dataIncio) {
		this.dataIncio = dataIncio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}
