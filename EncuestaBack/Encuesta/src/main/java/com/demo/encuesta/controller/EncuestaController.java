package com.demo.encuesta.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.demo.encuesta.service.hibernate.EncuestaService;

@Controller
public class EncuestaController 
{
	@Autowired
	EncuestaService encuestaService;
	
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@PostMapping("/exportarExcel")
	public ResponseEntity ExportarExcel(@RequestParam("file") MultipartFile file) throws IOException {
		return this.encuestaService.ExportarExcel(file);
	}
}
