package com.demo.encuesta.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.demo.encuesta.entity.Preguntas;
import com.demo.encuesta.util.HibernateUtil;

@Repository
public class PreguntaRepository 
{
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerPreguntasPorDimension(Integer ID) 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery(
            		"select p.ID, p.NOMBREPREGUNTA from PREGUNTAS p\r\n" + 
            		"inner join DIMENSION d on d.ID = p.IDDIMENSION\r\n" + 
            		"where p.IDDIMENSION = :ID")
            		.setParameter("ID", ID)
            		.list();
        }
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerConformidadPorAnio(Integer id){
		try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery(
            		"select alumno.BASE, count(alform.RESPUESTA) from ALUMNO alumno\r\n" + 
            		"inner join ALUMNOFORMULARIO alform on alform.IDALUMNO = alumno.ID\r\n" + 
            		"inner join PREGUNTAS pregunta on pregunta.ID = alform.IDPREGUNTA\r\n" + 
            		"inner join DIMENSION dimension on dimension.ID = pregunta.IDDIMENSION\r\n" + 
            		"where alform.RESPUESTA > 3 and dimension.ID = :ID and pregunta.ID >= 27\r\n" + 
            		"group by alumno.BASE;")
            		.setParameter("ID", id)
            		.list();
        }
	}
	
	public List<Preguntas> ObtenerPreguntasTotales() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery(
            		"select * from PREGUNTAS", Preguntas.class).list();
        }
    }
}
