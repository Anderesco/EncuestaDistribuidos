package com.demo.encuesta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.encuesta.bean.AlumnoBean;
import com.demo.encuesta.bean.AlumnoCicloBean;
import com.demo.encuesta.bean.AlumnosAnioBean;
import com.demo.encuesta.bean.CantidadTotalEncuestaBean;
import com.demo.encuesta.bean.EspectativaCicloBean;
import com.demo.encuesta.bean.EspectativaPreguntaBean;
import com.demo.encuesta.dao.AlumnoRepository;
import com.demo.encuesta.dao.PreguntaRepository;
import com.demo.encuesta.service.hibernate.AlumnoService;

@Service("alumnoService")
public class AlumnoServiceImpl implements AlumnoService
{
	
	@Autowired
	private AlumnoRepository alumnoRepositorio;
	
	@Autowired
	private PreguntaRepository preguntaRepository;

	@Override
	public List<AlumnoBean> ObtenerAlumnos() {
		return alumnoRepositorio.ObtenerAlumnos().stream()
				.map(alumno -> {
					AlumnoBean alumnoBean = new AlumnoBean();
					
					alumnoBean.setId(alumno.getIdAlumno());
					alumnoBean.setBase(alumno.getBase());
					alumnoBean.setEscuela(alumno.getEscuela());
					alumnoBean.setSexo(alumno.getSexo());
					alumnoBean.setCiclo(alumno.getCiclo());
					
					return alumnoBean;
				}).collect(Collectors.toList());
	}

	@Override
	public List<AlumnosAnioBean> ObtenerAlumnosPorAnio() {
		List<Object[]> listaAlumnosAnio = this.alumnoRepositorio.ObtenerAlumnosPorAnio();
		List<AlumnosAnioBean> listaAlumnosPorAnio = new ArrayList<AlumnosAnioBean>();
		
		for(Object[] objetoAlumno : listaAlumnosAnio) {
			AlumnosAnioBean anioBean = new AlumnosAnioBean();
			anioBean.setAnio(String.valueOf((Integer) objetoAlumno[0]));
			anioBean.setCantidad(String.valueOf((Integer) objetoAlumno[1]));
			
			listaAlumnosPorAnio.add(anioBean);
		}
		
		return listaAlumnosPorAnio;
	}

	@Override
	public List<AlumnoCicloBean> ObtenerAlumnosPorCiclo() {
		List<Object[]> listaAlumnosCiclo = this.alumnoRepositorio.ObtenerAlumnosPorCiclo();
		List<AlumnoCicloBean> listaAlumnosPorCiclo = new ArrayList<AlumnoCicloBean>();
		
		for(Object[] objetoAlumno : listaAlumnosCiclo) {
			AlumnoCicloBean anioBean = new AlumnoCicloBean();
			anioBean.setCiclo(String.valueOf((String) objetoAlumno[0]));
			anioBean.setTotal(String.valueOf((Integer) objetoAlumno[1]));
			
			listaAlumnosPorCiclo.add(anioBean);
		}
		
		return listaAlumnosPorCiclo;
	}

	@Override
	public List<CantidadTotalEncuestaBean> ObtenerCantidadTotalEncuestados() {
		List<CantidadTotalEncuestaBean> cantidadTotal = new ArrayList<CantidadTotalEncuestaBean>();
		CantidadTotalEncuestaBean totalBean = new CantidadTotalEncuestaBean(this.alumnoRepositorio.ObtenerAlumnos().stream().count());
		cantidadTotal.add(totalBean);
		
		return cantidadTotal;
	}

	@Override
	public List<EspectativaPreguntaBean> ObtenerEspectativasPorPreguntas(Integer ID) {
		List<EspectativaCicloBean> espectativaCicloBean = new ArrayList<>();
		List<EspectativaPreguntaBean> espectativaPregunta = new ArrayList<EspectativaPreguntaBean>();
		
		List<Object[]> preguntasPorDimension = this.preguntaRepository.ObtenerPreguntasPorDimension(ID);
		
		for(Object[] preguntasObj : preguntasPorDimension) {
			List<Object[]> listaObjetos = this.alumnoRepositorio.ObtenerCicloEspectativa((Integer) preguntasObj[0]);
			
			for(Object[] listaObjetoPreguntas : listaObjetos) {
				EspectativaCicloBean cicloBean = new EspectativaCicloBean();
			}
		}
		
		
		
		
		return null;
	}
	
	
	
}
