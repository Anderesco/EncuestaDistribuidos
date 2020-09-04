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
@Table(name = "Alumno", schema= "dbo")
public class Alumno 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idAlumno;
	
	@Column(name = "BASE")
	private Integer base;
	
	@Column(name = "ESCUELA")
	private String escuela;
	
	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "CICLO")
	private String ciclo;
	
	@OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
	private List<AlumnoFormulario> listaAlumnoFormularios;

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public List<AlumnoFormulario> getListaAlumnoFormularios() {
		return listaAlumnoFormularios;
	}

	public void setListaAlumnoFormularios(List<AlumnoFormulario> listaAlumnoFormularios) {
		this.listaAlumnoFormularios = listaAlumnoFormularios;
	}
}
