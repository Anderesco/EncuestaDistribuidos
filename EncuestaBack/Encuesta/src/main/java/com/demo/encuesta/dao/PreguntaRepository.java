package com.demo.encuesta.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.demo.encuesta.util.HibernateUtil;

@Repository
public class PreguntaRepository 
{
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerPreguntasPorDimension(Integer ID) 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery("select p.ID, p.NOMBREPREGUNTA from PREGUNTAS p\r\n" + 
            		"inner join DIMENSION d on d.ID = p.IDDIMENSION\r\n" + 
            		"where p.IDDIMENSION = :ID")
            		.setParameter("ID", ID)
            		.list();
        }
    }
}
