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
public class ExperienciaProfissional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6378187302447560108L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 45)
	private String empresa;
	
	@Column(nullable = false, length = 45)
	private String cargo;
	
	@Column(nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(value = TemporalType.DATE)
	private Date dataTermino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

}
