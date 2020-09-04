package com.demo.encuesta.bean;

import java.io.Serializable;

public class AlumnoBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer base;
	private String escuela;
	private String sexo;
	private String ciclo;
	
	public AlumnoBean() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBase() {
		return base;
	}
	public void setBase(Integer base) {
		this.base = base;
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
}
