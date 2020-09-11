package com.demo.encuesta.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Dimension", schema = "dbo")
public class Dimension 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idDimension;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@OneToMany(mappedBy = "dimension", fetch = FetchType.LAZY)
	private List<Preguntas> listaPreguntas;

	@Override
	public String toString() {
		return "Dimension [idDimension=" + idDimension + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", listaPreguntas=" + listaPreguntas + "]";
	}
	
	
}
