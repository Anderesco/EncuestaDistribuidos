package com.demo.encuesta.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.demo.encuesta.util.HibernateUtil;

@Repository
public class UsuarioRepository 
{
	@SuppressWarnings("unchecked")
	public List<Object[]> ObtenerUsuarios(String nombreUsuario, String contrasenia) 
    {
        try (Session session = HibernateUtil.getSessionFactoria().openSession()) {
            return session.createNativeQuery("SELECT Nombre, ApellidoPaterno, ApellidoMaterno, Correo, NombreUsuario "
            		+ " FROM dbo.USUARIO "
            		+ "where NombreUsuario = :nombreUsuario "
            		+ "and Contrasenia = :contrasenia ;"
            		)
            		.setParameter("nombreUsuario", nombreUsuario)
            		.setParameter("contrasenia", contrasenia)
            		.list();
        }
    }
}
