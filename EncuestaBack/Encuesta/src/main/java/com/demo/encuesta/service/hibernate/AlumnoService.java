package com.demo.encuesta.service.hibernate;

import java.util.List;

import com.demo.encuesta.bean.AlumnoBean;
import com.demo.encuesta.bean.AlumnoCicloBean;
import com.demo.encuesta.bean.AlumnosAnioBean;
import com.demo.encuesta.bean.CantidadTotalEncuestaBean;
import com.demo.encuesta.bean.EspectativaPreguntaBean;

public interface AlumnoService 
{
	public List<AlumnoBean> ObtenerAlumnos();
	public List<AlumnosAnioBean> ObtenerAlumnosPorAnio();
	public List<AlumnoCicloBean> ObtenerAlumnosPorCiclo();
	public List<CantidadTotalEncuestaBean> ObtenerCantidadTotalEncuestados();
	public List<EspectativaPreguntaBean> ObtenerEspectativasPorPreguntas(Integer ID);
}
