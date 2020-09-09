package com.demo.encuesta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.encuesta.bean.AlumnoBean;
import com.demo.encuesta.bean.AlumnosAnioBean;
import com.demo.encuesta.dao.AlumnoRepository;
import com.demo.encuesta.service.hibernate.AlumnoService;

@Service("alumnoService")
public class AlumnoServiceImpl implements AlumnoService
{
	
	@Autowired
	private AlumnoRepository alumnoRepositorio;

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
	
	
	
}
