package com.demo.encuesta.dao;

import java.util.List;

import org.hibernate.Session;

import com.demo.encuesta.entity.Dimension;
import com.demo.encuesta.util.HibernateUtil;

public class DimensionRepository 
{
	@SuppressWarnings("unchecked")
	public List<Dimension> ObtenerAlumnos(String dimension) 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery("SELECT ID FROM Dimension " +
            								  "where nombre = :nombre;")
            								.setParameter("nombre", dimension)
            								 .list();
        }
    }
}
