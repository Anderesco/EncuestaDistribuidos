package com.demo.encuesta.bean;

import java.io.Serializable;
import java.util.List;

public class BrechaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dimension;
	private List<ValoresBrechaBean> items;
	
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public List<ValoresBrechaBean> getItems() {
		return items;
	}
	public void setItems(List<ValoresBrechaBean> items) {
		this.items = items;
	}
	
}
