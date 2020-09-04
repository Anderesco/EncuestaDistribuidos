package com.demo.encuesta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.encuesta.bean.AlumnoBean;
import com.demo.encuesta.service.hibernate.AlumnoService;

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
}
