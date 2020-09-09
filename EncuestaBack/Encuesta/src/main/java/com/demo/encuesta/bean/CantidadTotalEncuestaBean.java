package com.demo.encuesta.bean;

import java.io.Serializable;

public class CantidadTotalEncuestaBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long cantidadTotal;
	
	public CantidadTotalEncuestaBean(Long cantidadTotal) {
		super();
		this.cantidadTotal = cantidadTotal;
	}

	public Long getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(Long cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	
	

}
