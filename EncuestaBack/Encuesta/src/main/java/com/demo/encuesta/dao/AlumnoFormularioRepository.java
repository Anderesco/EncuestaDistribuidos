package com.demo.encuesta.dao;

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
}
