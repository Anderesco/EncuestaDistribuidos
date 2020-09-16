package com.demo.encuesta.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.encuesta.bean.AlumnoBean;
import com.demo.encuesta.bean.AlumnoCicloBean;
import com.demo.encuesta.bean.AlumnosAnioBean;
import com.demo.encuesta.bean.CantidadTotalEncuestaBean;
import com.demo.encuesta.bean.ConformidadAnioBean;
import com.demo.encuesta.bean.DimensionAnioBean;
import com.demo.encuesta.bean.EspectativaCicloBean;
import com.demo.encuesta.bean.EspectativaPreguntaBean;
import com.demo.encuesta.bean.PositividadDimensionBean;
import com.demo.encuesta.dao.AlumnoRepository;
import com.demo.encuesta.dao.DimensionRepository;
import com.demo.encuesta.dao.PreguntaRepository;
import com.demo.encuesta.service.hibernate.AlumnoService;

@Service("alumnoService")
public class AlumnoServiceImpl implements AlumnoService
{
	
	@Autowired
	private AlumnoRepository alumnoRepositorio;
	
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Autowired
	private DimensionRepository dimensionRepository;

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
		List<EspectativaPreguntaBean> espectativaPregunta = new ArrayList<EspectativaPreguntaBean>();
		
		List<Object[]> preguntasPorDimension = this.preguntaRepository.ObtenerPreguntasPorDimension(ID);
		
		for(Object[] preguntas : preguntasPorDimension) {
			EspectativaPreguntaBean preguntasBean = new EspectativaPreguntaBean();
			preguntasBean.setId((Integer) preguntas[0]);
			preguntasBean.setNombrePregunta((String) preguntas[1]);
			preguntasBean.setCiclos(this.alumnoRepositorio.ObtenerCicloEspectativa((Integer) preguntas[0])
					.stream().map(objeto -> {
						EspectativaCicloBean cicloBean = new EspectativaCicloBean();
						cicloBean.setCiclo((String) objeto[0]);
						cicloBean.setEspectativaPostiva((Integer) objeto[1]);
						return cicloBean;
					})
					.collect(Collectors.toList()));
			
			espectativaPregunta.add(preguntasBean);
		}
		
		return espectativaPregunta;
	}

	@Override
	public List<DimensionAnioBean> ObtenerConformidadDimensionAnio(Integer ID) {
		return this.dimensionRepository.ObtenerAlumnos(ID)
				.stream()
				.map(objeto -> {
					DimensionAnioBean dimensionBean = new DimensionAnioBean();
					dimensionBean.setId((Integer) objeto[0]);
					dimensionBean.setDimension((String) objeto[1]);
					dimensionBean.setListaConformidadAnioBean(this.preguntaRepository.ObtenerConformidadPorAnio(dimensionBean.getId()).stream()
							.map(objeto2 -> {
								ConformidadAnioBean conformidadBean = new ConformidadAnioBean();
								conformidadBean.setAnio((Integer) objeto2[0]);
								conformidadBean.setEspectativaPositiva((Integer) objeto2[1]);
								
								return conformidadBean;
							})
							.collect(Collectors.toList()));
					
					return dimensionBean;
				})
				.collect(Collectors.toList());
	}

	@Override
	public List<PositividadDimensionBean> ObtenerDimensionPorcentaje() {
		return this.dimensionRepository.ObtenerPorcentajePositividad().parallelStream()
				.map(objeto -> {
					PositividadDimensionBean positividadDimensionBean = new PositividadDimensionBean();
					positividadDimensionBean.setNombreDimension((String) objeto[0]);
					positividadDimensionBean.setPercepcion(Double.parseDouble((String) objeto[1]));
					positividadDimensionBean.setEspectativa(Double.parseDouble((String) objeto[2]));	
					
					return positividadDimensionBean;
				})
				.collect(Collectors.toList());
	}
	
	
	
}
