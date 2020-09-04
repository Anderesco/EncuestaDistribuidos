package com.demo.encuesta.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.demo.encuesta.entity.Alumno;
import com.demo.encuesta.util.HibernateUtil;

@Repository
public class AlumnoRepository 
{
	public List<Alumno> ObtenerAlumnos() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery("SELECT * FROM Alumno", Alumno.class).list();
        }
    }
}
