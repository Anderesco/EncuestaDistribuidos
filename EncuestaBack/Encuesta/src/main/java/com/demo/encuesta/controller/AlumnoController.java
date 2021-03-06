package com.demo.encuesta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.encuesta.bean.AlumnoBean;
import com.demo.encuesta.bean.AlumnoCicloBean;
import com.demo.encuesta.bean.AlumnosAnioBean;
import com.demo.encuesta.bean.BrechaBean;
import com.demo.encuesta.bean.CantidadTotalEncuestaBean;
import com.demo.encuesta.bean.DimensionAnioBean;
import com.demo.encuesta.bean.EspectativaPreguntaBean;
import com.demo.encuesta.bean.PositividadDimensionBean;
import com.demo.encuesta.bean.PreguntaEstadoBean;
import com.demo.encuesta.service.hibernate.AlumnoFormularioService;
import com.demo.encuesta.service.hibernate.AlumnoService;
import com.demo.encuesta.service.hibernate.DimensionService;

@CrossOrigin(origins="*")
@Controller
public class AlumnoController 
{
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	DimensionService dimensionService;
	
	@Autowired
	AlumnoFormularioService alumnoFormularioService;
	
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
	
	@ResponseBody
	@GetMapping("/alumno/espctativa/{dimensionID}")
	public List<EspectativaPreguntaBean> ObtenerEspectativasPorPreguntas(@PathVariable Integer dimensionID){
		return alumnoService.ObtenerEspectativasPorPreguntas(dimensionID);
	}
	
	@ResponseBody
	@GetMapping("/alumno/reporte/{idDimension}")
	public List<DimensionAnioBean> ObtenerDimenionPorAnio(@PathVariable Integer idDimension){
		return alumnoService.ObtenerConformidadDimensionAnio(idDimension);
	}
	
	@ResponseBody
	@GetMapping("/alumno/positividad")
	public List<PositividadDimensionBean> ObtenerPositividadimension(){
		return alumnoService.ObtenerDimensionPorcentaje();
	}
	
	@ResponseBody
	@GetMapping("/alumno/analisisBrecha/{idDimension}")
	public List<BrechaBean> ObtenerAnalisisBrecha(@PathVariable Integer idDimension){
		return dimensionService.ObtenerListaBrecha(idDimension);
	}
	
	@ResponseBody
	@GetMapping("/alumnoPregunta/{idTipo}/{idDimension}")
	public List<PreguntaEstadoBean> ObtenerPreguntaEspectativa(@PathVariable String idTipo, @PathVariable Integer idDimension){
		if(idTipo.equals("Espectativa"))
			return this.alumnoFormularioService.ObtenerAlumnosPreguntaEspectativa(idDimension);
		else if(idTipo.equals("Percepcion"))
			return this.alumnoFormularioService.ObtenerAlumnosPreguntaPercepcion(idDimension);
		else
			return null;
	}
}
