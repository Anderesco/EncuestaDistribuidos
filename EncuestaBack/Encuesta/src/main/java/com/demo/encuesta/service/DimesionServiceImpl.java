package com.demo.encuesta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.encuesta.bean.BrechaBean;
import com.demo.encuesta.dao.DimensionRepository;
import com.demo.encuesta.service.hibernate.DimensionService;

@Service("dimensionService")
public class DimesionServiceImpl implements DimensionService
{
	@Autowired
	DimensionRepository dimensionRepository;
	
	
	@Override
	public List<BrechaBean> ObtenerListaBrecha(Integer id) {
		List<Object[]> listaObjectoEspectativa = this.dimensionRepository.ObtenerAnalisisBrechaEspectativa(id);
		List<Object[]> listaObjetoPercepcion = this.dimensionRepository.ObtenerAnalisisBrechaPercepcion(id);
		List<BrechaBean> listaBrechaBean = new ArrayList<BrechaBean>();
		String dimension;
		
		for(Object[] objeto : listaObjectoEspectativa) {
			
		}
		
		
		return null;
	}

}
