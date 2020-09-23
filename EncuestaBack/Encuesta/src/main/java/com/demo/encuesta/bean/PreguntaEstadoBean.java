package com.demo.encuesta.bean;

import java.io.Serializable;

public class PreguntaEstadoBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pregunta;
	private String nombrePregunta;
	private Integer positividad;
	private Integer regular;
	private Integer negatividad;
	
	
	public Integer getPregunta() {
		return pregunta;
	}
	public void setPregunta(Integer pregunta) {
		this.pregunta = pregunta;
	}
	public String getNombrePregunta() {
		return nombrePregunta;
	}
	public void setNombrePregunta(String nombrePregunta) {
		this.nombrePregunta = nombrePregunta;
	}
	public Integer getPositividad() {
		return positividad;
	}
	public void setPositividad(Integer positividad) {
		this.positividad = positividad;
	}
	public Integer getRegular() {
		return regular;
	}
	public void setRegular(Integer regular) {
		this.regular = regular;
	}
	public Integer getNegatividad() {
		return negatividad;
	}
	public void setNegatividad(Integer negatividad) {
		this.negatividad = negatividad;
	}
}
