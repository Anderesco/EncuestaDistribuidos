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
@Table(name = "Preguntas", schema = "dbo")
public class Preguntas 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idPreguntas;
	
	@Column(name = "NOMBREPREGUNTA")
	private String nombrePregunta;
	
	@Column(name = "DESCRIPION")
	private String descricionPregunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDDIMENSION")
	private Dimension dimension;
}
