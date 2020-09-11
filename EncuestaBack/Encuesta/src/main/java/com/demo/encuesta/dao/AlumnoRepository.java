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
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerAlumnosPorAnio() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery("select base, count(base) from ALUMNO group by base;").list();
        }
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerAlumnosPorCiclo() 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery("select ciclo, count(base) from ALUMNO group by ciclo;").list();
        }
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerCicloEspectativa(Integer ID) 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery("select a.CICLO, count(af.RESPUESTA) from ALUMNO a\r\n" + 
            		"inner join ALUMNOFORMULARIO af on af.IDALUMNO = a.ID\r\n" + 
            		"inner join PREGUNTAS p on p.ID = af.IDPREGUNTA\r\n" + 
            		"inner join DIMENSION d on d.ID = p.IDDIMENSION\r\n" + 
            		"where p.ID = :ID and af.RESPUESTA > 3\r\n" + 
            		"group by a.CICLO;")
            								.setParameter("ID", ID)
            								.list();
        }
    }
}
