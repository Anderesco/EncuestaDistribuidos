package com.demo.encuesta.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.demo.encuesta.entity.AlumnoFormulario;
import com.demo.encuesta.util.HibernateUtil;

@Repository
public class AlumnoFormularioRepository 
{
	public Long guardarAlumnoFormulario(AlumnoFormulario alumnoFormulario) 
	{
        Transaction transaction = null;
        Long codigo = (long) 0;
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            transaction = session.beginTransaction(); 
            codigo = (Long) session.save(alumnoFormulario);
            transaction.commit();    
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        return codigo;
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerEspectativaPorPregunta(Integer ID) 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery(
            		"select af1.IDPREGUNTA, p.NOMBREPREGUNTA, count(af2.RESPUESTA) as Positividad, count(af3.RESPUESTA) as Regular, count(af4.RESPUESTA) as Negativo from ALUMNOFORMULARIO af1\r\n" + 
            		"left join ALUMNOFORMULARIO af2 on af2.ID = af1.ID and af2.RESPUESTA > 3\r\n" + 
            		"left join ALUMNOFORMULARIO af3 on af3.ID = af1.ID and af3.RESPUESTA = 3\r\n" + 
            		"left join ALUMNOFORMULARIO af4 on af4.ID = af1.ID and af4.RESPUESTA < 3\r\n" + 
            		"inner join PREGUNTAS p on p.ID = af1.IDPREGUNTA\r\n" + 
            		"where af1.IDPREGUNTA < 27 and p.IDDIMENSION = :ID\r\n" + 
            		"group by af1.IDPREGUNTA, p.NOMBREPREGUNTA\r\n" + 
            		"order by af1.IDPREGUNTA;")
            		.setParameter("ID", ID)
            		.list();
        }
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerPercepcionPorPregunta(Integer ID) 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery(
            		"select af1.IDPREGUNTA, p.NOMBREPREGUNTA, count(af2.RESPUESTA) as Positividad, count(af3.RESPUESTA) as Regular, count(af4.RESPUESTA) as Negativo from ALUMNOFORMULARIO af1\r\n" + 
            		"left join ALUMNOFORMULARIO af2 on af2.ID = af1.ID and af2.RESPUESTA > 3\r\n" + 
            		"left join ALUMNOFORMULARIO af3 on af3.ID = af1.ID and af3.RESPUESTA = 3\r\n" + 
            		"left join ALUMNOFORMULARIO af4 on af4.ID = af1.ID and af4.RESPUESTA < 3\r\n" + 
            		"inner join PREGUNTAS p on p.ID = af1.IDPREGUNTA\r\n" + 
            		"where af1.IDPREGUNTA >= 27 and p.IDDIMENSION = :ID\r\n" + 
            		"group by af1.IDPREGUNTA, p.NOMBREPREGUNTA\r\n" + 
            		"order by af1.IDPREGUNTA;")
            		.setParameter("ID", ID)
            		.list();
        }
    }
}
