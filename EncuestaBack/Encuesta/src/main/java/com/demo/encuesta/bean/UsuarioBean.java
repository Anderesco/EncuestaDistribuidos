package com.demo.encuesta.bean;

import java.io.Serializable;

public class UsuarioBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nombreUsuario;
	private String contraseña;
	private String nombreRol;
	private PersonaBean persona;
	
	public UsuarioBean() {
		super();
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public PersonaBean getPersona() {
		return persona;
	}

	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "UsuarioBean {" + "\n" +
			   "nombreUsuario=" + nombreUsuario + ",\n" +
			   "contrasenia=" + contraseña + ",\n " + 
			   "nombreRol=" + nombreRol + "\n" +
			   "persona=" + persona + "\n" +
			   "}";
	}
	
}
