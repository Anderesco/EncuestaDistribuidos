package com.demo.encuesta.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.encuesta.bean.PreguntaEstadoBean;
import com.demo.encuesta.dao.AlumnoFormularioRepository;
import com.demo.encuesta.service.hibernate.AlumnoFormularioService;

@Service("alumnoFormularioService")
public class AlumnoFormularioServiceImpl implements AlumnoFormularioService
{
	
	@Autowired
	private AlumnoFormularioRepository alumnoFormularioRepository;

	@Override
	public List<PreguntaEstadoBean> ObtenerAlumnosPreguntaEspectativa(Integer idDimension) {
		return alumnoFormularioRepository.ObtenerEspectativaPorPregunta(idDimension).stream()
				.map(objeto -> {
					PreguntaEstadoBean preguntaEstadoBean = new PreguntaEstadoBean();
					preguntaEstadoBean.setPregunta((Integer) objeto[0]);
					preguntaEstadoBean.setNombrePregunta((String) objeto[1]);
					preguntaEstadoBean.setPositividad((Integer) objeto[2]);
					preguntaEstadoBean.setRegular((Integer) objeto[3]);
					preguntaEstadoBean.setNegatividad((Integer) objeto[4]);
					
					return preguntaEstadoBean;
				})
				.collect(Collectors.toList());
	}

	@Override
	public List<PreguntaEstadoBean> ObtenerAlumnosPreguntaPercepcion(Integer idDimension) {
		return alumnoFormularioRepository.ObtenerPercepcionPorPregunta(idDimension).parallelStream()
				.map(objeto -> {
					PreguntaEstadoBean preguntaEstadoBean = new PreguntaEstadoBean();
					preguntaEstadoBean.setPregunta((Integer) objeto[0]);
					preguntaEstadoBean.setNombrePregunta((String) objeto[1]);
					preguntaEstadoBean.setPositividad((Integer) objeto[2]);
					preguntaEstadoBean.setRegular((Integer) objeto[3]);
					preguntaEstadoBean.setNegatividad((Integer) objeto[4]);
					
					return preguntaEstadoBean;
				})
				.collect(Collectors.toList());
	}

}
