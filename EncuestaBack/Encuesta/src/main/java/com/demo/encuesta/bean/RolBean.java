package com.demo.encuesta.bean;

import java.io.Serializable;

public class RolBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nombreRol;

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Override
	public String toString() {
		return "RolBean {\n nombreRol=" + nombreRol + "\n}";
	}
	
	
}
