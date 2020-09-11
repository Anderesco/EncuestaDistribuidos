package com.demo.encuesta.bean;

import java.io.Serializable;

public class AlumnosAnioBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String anio;
	private String cantidad;
	
	
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}
