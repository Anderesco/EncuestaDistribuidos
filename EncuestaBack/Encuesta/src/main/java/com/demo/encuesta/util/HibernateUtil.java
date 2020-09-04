package com.demo.encuesta.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.demo.encuesta.entity.Alumno;
import com.demo.encuesta.entity.AlumnoFormulario;
import com.demo.encuesta.entity.Dimension;
import com.demo.encuesta.entity.Preguntas;


public class HibernateUtil 
{
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactoria()
	{
		if(sessionFactory == null)
		{
			try
			{
				Configuration configuration = new Configuration();
				
				Properties ajustes = new Properties();
				
				ajustes.put(Environment.SHOW_SQL, "true");
				ajustes.put(Environment.URL, "jdbc:jtds:sqlserver://localhost;databaseName=encuesta");
				ajustes.put(Environment.USER, "sa");
				ajustes.put(Environment.PASS, "sqlserver");
				ajustes.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
				
				ajustes.put(Environment.SHOW_SQL, "true");
                ajustes.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //ajustes.put(Environment.HBM2DDL_AUTO, "create");
                
                configuration.setProperties(ajustes);
                configuration.addAnnotatedClass(Alumno.class);
                configuration.addAnnotatedClass(Dimension.class);
                configuration.addAnnotatedClass(Preguntas.class);
                configuration.addAnnotatedClass(AlumnoFormulario.class);

                
                ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch(Exception e) { e.printStackTrace(); }
		}
		
		return sessionFactory;
	}
}
