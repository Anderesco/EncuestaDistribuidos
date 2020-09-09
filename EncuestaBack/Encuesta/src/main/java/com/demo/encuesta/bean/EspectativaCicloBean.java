package com.demo.encuesta.bean;

import java.io.Serializable;

public class EspectativaCicloBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ciclo;
	private Integer espectativaPostiva;
	
	
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public Integer getEspectativaPostiva() {
		return espectativaPostiva;
	}
	public void setEspectativaPostiva(Integer espectativaPostiva) {
		this.espectativaPostiva = espectativaPostiva;
	}
}
