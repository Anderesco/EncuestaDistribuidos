package com.demo.encuesta.bean;

import java.io.Serializable;

public class PositividadDimensionBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreDimension;
	private Double espectativa;
	private Double percepcion;
	
	public String getNombreDimension() {
		return nombreDimension;
	}
	public void setNombreDimension(String nombreDimension) {
		this.nombreDimension = nombreDimension;
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
