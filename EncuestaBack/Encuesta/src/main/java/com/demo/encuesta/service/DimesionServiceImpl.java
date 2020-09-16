package com.demo.encuesta.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.encuesta.bean.BrechaBean;
import com.demo.encuesta.bean.ValoresBrechaBean;
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
		List<BrechaBean> listaBrechaBean = listaObjectoEspectativa.parallelStream()
				.map(objeto -> {
					BrechaBean brechaBean = new BrechaBean();
					List<ValoresBrechaBean> listaValoresBean = new ArrayList<>();
					ValoresBrechaBean valoresBean = new ValoresBrechaBean();
					
					brechaBean.setDimension((String) objeto[0]);
					valoresBean.setIdPregunta((Integer) objeto[1]);
					valoresBean.setPregunta((String) objeto[2]);
					valoresBean.setEspectativa(Double.parseDouble(String.valueOf((BigDecimal) objeto[3])));
					valoresBean.setPercepcion(null);
					
					listaValoresBean.add(valoresBean);
					
					brechaBean.setItems(listaValoresBean);
					
					return brechaBean;
				})
				.collect(Collectors.toList());
		
		
		
		
		return listaBrechaBean;
	}

}
