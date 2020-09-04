package com.demo.encuesta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AlumnoFormulario", schema = "dbo")
public class AlumnoFormulario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idAlumnoFormulario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDALUMNO")
	private Alumno alumno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPREGUNTA")
	private Preguntas preguntas;
	
	@Column(name = "RESPUESTA")
	private String respuesta;
}
