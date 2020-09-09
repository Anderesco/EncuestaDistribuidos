package com.demo.encuesta.bean;

import java.io.Serializable;

public class AlumnoCicloBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ciclo;
	private String total;
	
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
}
