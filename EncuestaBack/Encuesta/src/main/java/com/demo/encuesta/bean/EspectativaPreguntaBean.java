package com.demo.encuesta.bean;

import java.io.Serializable;
import java.util.List;

public class EspectativaPreguntaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombrePregunta;
	private List<EspectativaCicloBean> ciclos;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	@Override
	public String toString() {
		return "EspectativaPreguntaBean [nombrePregunta=" + nombrePregunta + ", ciclos=" + ciclos + "]";
	}
	
	
}
