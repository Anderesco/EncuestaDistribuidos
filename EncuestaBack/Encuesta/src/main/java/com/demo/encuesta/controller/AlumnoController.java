package com.demo.encuesta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.encuesta.bean.AlumnoBean;
import com.demo.encuesta.bean.AlumnoCicloBean;
import com.demo.encuesta.bean.AlumnosAnioBean;
import com.demo.encuesta.bean.CantidadTotalEncuestaBean;
import com.demo.encuesta.service.hibernate.AlumnoService;

@CrossOrigin(origins="*")
@Controller
public class AlumnoController 
{
	@Autowired
	AlumnoService alumnoService;
	
	@ResponseBody
	@GetMapping("/alumno")
	public List<AlumnoBean> ObtenerAlumnos(){
		return alumnoService.ObtenerAlumnos();
	}
	
	@ResponseBody
	@GetMapping("/alumno/anio")
	public List<AlumnosAnioBean> ObtenerAlumnosAnio(){
		return alumnoService.ObtenerAlumnosPorAnio();
	}
	
	@ResponseBody
	@GetMapping("/alumno/ciclo")
	public List<AlumnoCicloBean> ObtenerAlumnosCiclo(){
		return alumnoService.ObtenerAlumnosPorCiclo();
	}
	
	@ResponseBody
	@GetMapping("/alumno/total")
	public List<CantidadTotalEncuestaBean> ObtenerTotalEncuetados(){
		return alumnoService.ObtenerCantidadTotalEncuestados();
	}
	
}
