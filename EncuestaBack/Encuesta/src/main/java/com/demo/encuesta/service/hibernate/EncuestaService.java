package com.demo.encuesta.service.hibernate;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface EncuestaService 
{
	@SuppressWarnings("rawtypes")
	public ResponseEntity ExportarExcel(MultipartFile file) throws IOException;
}
