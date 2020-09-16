package com.demo.encuesta.bean;

import java.io.Serializable;

public class ValoresBrechaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPregunta;
	private String pregunta;
	private Double espectativa;
	private Double percepcion;
	
	
	public Integer getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public Double getEspectativa() {
		return espectativa;
	}
	public void setEspectativa(Double espectativa) {
		this.espectativa = espectativa;
	}
	public Double getPercepcion() {
		return percepcion;
	}
	public void setPercepcion(Double percepcion) {
		this.percepcion = percepcion;
	}
	
	
}
