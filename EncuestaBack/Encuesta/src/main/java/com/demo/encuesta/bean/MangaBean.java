package com.demo.encuesta.bean;

import java.io.Serializable;
import java.util.Map;

public class MangaBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nombre1;
	private String nombre2;
	private String autores;
	private Integer año;
	private String estadoActual;
	private Integer capitulos;
	private String descripcion;
	private String precuela;
	private String secuela;
	private String[] genero;
	private Map<Double, String> listaCapitulos;
	
	
	public MangaBean() {
		super();
	}
	
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public String getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}
	public Integer getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(Integer capitulos) {
		this.capitulos = capitulos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String[] getGenero() {
		return genero;
	}

	public void setGenero(String[] genero) {
		this.genero = genero;
	}
	
	public String getPrecuela() {
		return precuela;
	}

	public void setPrecuela(String precuela) {
		this.precuela = precuela;
	}

	public String getSecuela() {
		return secuela;
	}

	public void setSecuela(String secuela) {
		this.secuela = secuela;
	}
	
	public Map<Double, String> getListaCapitulos() {
		return listaCapitulos;
	}

	public void setListaCapitulos(Map<Double, String> listaCapitulos) {
		this.listaCapitulos = listaCapitulos;
	}

	@Override
	public String toString() 
	{
		return "MangaBean {\n" +
			   "nombre1=" + nombre1 + ",\n" +
			   "nombre2=" + nombre2 + ",\n " +
			   "autores=" + autores + ",\n " +
			   "año=" + año + ",\n " +
			   "estadoActual=" + estadoActual + ",\n " +
			   "precuela=" + precuela +",\n" +
			   "secuela=" + secuela + ",\n" +
			   "capitulos=" + capitulos + ", " +
			   "descripcion=" + descripcion+ ",\n" +
			   "Genero=" + genero + ", " +
			   "listaCapitulos=" + listaCapitulos + "\n}";
	}
	
	
}
