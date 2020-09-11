package com.demo.encuesta.bean;

import java.io.Serializable;

public class PositividadDimensionBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreDimension;
	private Double porcentaje;
	
	public String getNombreDimension() {
		return nombreDimension;
	}
	public void setNombreDimension(String nombreDimension) {
		this.nombreDimension = nombreDimension;
	}
	public Double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
}
