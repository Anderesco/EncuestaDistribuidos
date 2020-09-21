package com.demo.encuesta.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.encuesta.dao.UsuarioRepository;
import com.demo.encuesta.service.hibernate.UsuarioService;

@Service("usuarioLogin")
public class UsuarioServiceImpl implements UsuarioService
{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity Login(String usuario, String contrasenia) {
		Map<String, String> map = new TreeMap<String, String>();
		try {
			Object[] listaUsuario = this.usuarioRepository.ObtenerUsuarios(usuario, contrasenia).get(0);
				map.put("responseCode", "00");
				map.put("messageResponse", "Autenticación Correcta");
				map.put("nombres", (String) listaUsuario[0]);
				map.put("apelidoPaterno", (String) listaUsuario[1]);
				map.put("apellidoMaterno", (String) listaUsuario[2]);
				map.put("correo", (String) listaUsuario[3]);
				map.put("usuario", (String) listaUsuario[4]);
			
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("responseCode", "-");
			map.put("messageResponse", "Usuario o Contraseña incorrecta");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
		}
	}

}
