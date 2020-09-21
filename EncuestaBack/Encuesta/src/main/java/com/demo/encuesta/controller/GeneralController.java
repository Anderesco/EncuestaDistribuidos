package com.demo.encuesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.encuesta.service.hibernate.UsuarioService;

@CrossOrigin(origins="*")
@Controller
public class GeneralController 
{
	@Autowired
	private UsuarioService usuarioService;
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@PostMapping("/login")
	public ResponseEntity Login(@RequestParam String usuario, @RequestParam String contrasenia){
		return usuarioService.Login(usuario, contrasenia);
	}
}
