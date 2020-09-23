package com.demo.encuesta.service.hibernate;

import java.util.List;

import com.demo.encuesta.bean.PreguntaEstadoBean;

public interface AlumnoFormularioService 
{
	List<PreguntaEstadoBean> ObtenerAlumnosPreguntaEspectativa(Integer idDimension);
	List<PreguntaEstadoBean> ObtenerAlumnosPreguntaPercepcion(Integer idDimension);
}
