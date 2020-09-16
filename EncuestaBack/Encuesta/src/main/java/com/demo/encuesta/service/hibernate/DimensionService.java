package com.demo.encuesta.service.hibernate;

import java.util.List;

import com.demo.encuesta.bean.BrechaBean;

public interface DimensionService 
{
	public List<BrechaBean> ObtenerListaBrecha(Integer id);
}
