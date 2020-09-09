package com.demo.encuesta.service.hibernate;

import java.util.List;

import com.demo.encuesta.bean.AlumnoBean;
import com.demo.encuesta.bean.AlumnosAnioBean;

public interface AlumnoService 
{
	public List<AlumnoBean> ObtenerAlumnos();
	public List<AlumnosAnioBean> ObtenerAlumnosPorAnio();
}
