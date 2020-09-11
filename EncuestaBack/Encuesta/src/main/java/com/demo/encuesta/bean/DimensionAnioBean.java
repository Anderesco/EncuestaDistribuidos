package com.demo.encuesta.bean;

import java.io.Serializable;
import java.util.List;

public class DimensionAnioBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String dimension;
	private List<ConformidadAnioBean> listaConformidadAnioBean;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public List<ConformidadAnioBean> getListaConformidadAnioBean() {
		return listaConformidadAnioBean;
	}
	public void setListaConformidadAnioBean(List<ConformidadAnioBean> listaConformidadAnioBean) {
		this.listaConformidadAnioBean = listaConformidadAnioBean;
	}
	
	
}
