package com.demo.encuesta.bean;

import java.io.Serializable;

public class ConformidadAnioBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer anio;
	private Integer espectativaPositiva;
	
	
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getEspectativaPositiva() {
		return espectativaPositiva;
	}
	public void setEspectativaPositiva(Integer espectativaPositiva) {
		this.espectativaPositiva = espectativaPositiva;
	}
	
	
}
