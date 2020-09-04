package com.demo.encuesta.bean;

public class PersonaBean 
{
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	@Override
	public String toString() {
		return "PersonaBean {" + "\n" 
				+ "nombre=" + nombre + ",\n"
				+ "apellidoPaterno=" + apellidoPaterno + ",\n"
				+ "apellidoMaterno=" + apellidoMaterno + ",\n"
				+ " correo=" + correo + "\n"
				+ "}";
	}
	
	
}
