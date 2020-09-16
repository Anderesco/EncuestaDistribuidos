package com.demo.encuesta.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.demo.encuesta.util.HibernateUtil;

@Repository
public class DimensionRepository 
{
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerAlumnos(Integer id)
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery("SELECT ID, Nombre FROM Dimension " +
            							     "where ID = :ID ")
            								 .setParameter("ID", id)
            								 .list();
        }
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerPorcentajePositividad()
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery(
            		"select w.nombre, case\r\n" + 
            		"when\r\n" + 
            		"NOMBRE = 'Capacidad de Respuesta'\r\n" + 
            		"then round(suma/5,2)\r\n" + 
            		"when\r\n" + 
            		"NOMBRE = 'Elementos Tangibles'\r\n" + 
            		"then round(suma/6,2)\r\n" + 
            		"when\r\n" + 
            		"NOMBRE = 'Empatía'\r\n" + 
            		"then round(suma/5,2)\r\n" + 
            		"when\r\n" + 
            		"NOMBRE = 'Expectativa de Fiabilidad'\r\n" + 
            		"then round(suma/5,2)\r\n" + 
            		"when\r\n" + 
            		"NOMBRE = 'Seguridad'\r\n" + 
            		"then round(suma/5,2)\r\n" + 
            		"else '' end porcentaje\r\n" + 
            		"from (\r\n" + 
            		"select t.nombre,\r\n" + 
            		"sum(CAST(t.porcentaje AS DECIMAL(5,1))) suma\r\n" + 
            		"from(\r\n" + 
            		"select f.NOMBRE,g.porcentaje from dimension f,\r\n" + 
            		"(\r\n" + 
            		"select a.iddimension, b.porcentaje from preguntas a,\r\n" + 
            		"(\r\n" + 
            		"select z.IDPREGUNTA, sum(CAST(z.cant_alu AS DECIMAL(5,1)) * CAST(z.respuesta AS DECIMAL(5,1))/(CAST( z.tot_alu AS DECIMAL(5,1))*5)) porcentaje\r\n" + 
            		"from(\r\n" + 
            		"select count(distinct(a.idalumno)) cant_alu, a.idpregunta, a.respuesta, count(distinct(b.ID)) tot_alu\r\n" + 
            		"from ALUMNOFORMULARIO a, alumno b\r\n" + 
            		"group by a.respuesta,a.idpregunta)z\r\n" + 
            		"group by IDPREGUNTA\r\n" + 
            		")b\r\n" + 
            		"where a.ID = b.IDPREGUNTA\r\n" + 
            		"and b.IDPREGUNTA > 26\r\n" + 
            		")g\r\n" + 
            		"where f.ID = g.IDDIMENSION\r\n" + 
            		")t\r\n" + 
            		"group by t.nombre\r\n" + 
            		")w;")
            		.list();
        }
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerAnalisisBrechaPercepcion(Integer id)
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery(
            		"select  SUM(CAST(a.respuesta AS DECIMAL(5,1)))/COUNT(l.ID) from ALUMNOFORMULARIO a\r\n" + 
            		"join PREGUNTAS p on a.IDPREGUNTA = p.ID\r\n" + 
            		"join ALUMNO l on l.ID = a.IDALUMNO\r\n" + 
            		"join DIMENSION d on d.ID = p.IDDIMENSION\r\n" + 
            		"where p.id>26 and d.ID = :ID\r\n" + 
            		"GROUP BY NOMBREPREGUNTA, p.ID, d.NOMBRE\r\n" + 
            		"order by p.ID")
            								 .setParameter("ID", id)
            								 .list();
        }
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerAnalisisBrechaEspectativa(Integer id)
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery(
            		"select DISTINCT d.NOMBRE, p.ID, p.NOMBREPREGUNTA, SUM(CAST(a.respuesta AS DECIMAL(5,1)))/COUNT(l.ID) from ALUMNOFORMULARIO a\r\n" + 
            		"join PREGUNTAS p on a.IDPREGUNTA = p.ID\r\n" + 
            		"join ALUMNO l on l.ID = a.IDALUMNO\r\n" + 
            		"join DIMENSION d on d.ID = p.IDDIMENSION\r\n" + 
            		"where p.id<27 and d.ID = :ID \r\n" + 
            		"GROUP BY NOMBREPREGUNTA, p.ID, d.NOMBRE\r\n" + 
            		"order by p.ID;")
            								 .setParameter("ID", id)
            								 .list();
        }
    }
}
