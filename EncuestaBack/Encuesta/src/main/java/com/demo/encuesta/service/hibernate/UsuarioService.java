package com.demo.encuesta.service.hibernate;

import org.springframework.http.ResponseEntity;

public interface UsuarioService 
{
	@SuppressWarnings("rawtypes")
	public ResponseEntity Login(String usuario, String contrasenia);
}
