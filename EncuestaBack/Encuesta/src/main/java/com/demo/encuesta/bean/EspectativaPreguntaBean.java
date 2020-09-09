package com.demo.encuesta.bean;

import java.io.Serializable;
import java.util.List;

public class EspectativaPreguntaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombrePregunta;
	private List<EspectativaCicloBean> ciclos;
	
	
	public String getNombrePregunta() {
		return nombrePregunta;
	}
	public void setNombrePregunta(String nombrePregunta) {
		this.nombrePregunta = nombrePregunta;
	}
	public List<EspectativaCicloBean> getCiclos() {
		return ciclos;
	}
	public void setCiclos(List<EspectativaCicloBean> ciclos) {
		this.ciclos = ciclos;
	}
	
	
}
