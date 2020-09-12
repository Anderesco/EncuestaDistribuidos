package com.demo.encuesta.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.encuesta.dao.AlumnoFormularioRepository;
import com.demo.encuesta.dao.AlumnoRepository;
import com.demo.encuesta.dao.PreguntaRepository;
import com.demo.encuesta.entity.Alumno;
import com.demo.encuesta.entity.AlumnoFormulario;
import com.demo.encuesta.service.hibernate.EncuestaService;

@Service("exportarExcelService")
public class EncuestaServiceImpl implements EncuestaService
{
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Autowired
	private AlumnoFormularioRepository alumnoFormularioRepository;
	
	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity ExportarExcel(MultipartFile file) throws IOException 
	{
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet worksheet = workbook.getSheetAt(0);
			
			for(int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
				if(index > 0) {
					XSSFRow row = worksheet.getRow(index);
					Alumno alumno = new Alumno();
					AlumnoFormulario alumnoFormulario = new AlumnoFormulario();
								
					char sexo = row.getCell(4).getStringCellValue().charAt(0);
					
					alumno.setBase((int) row.getCell(6).getNumericCellValue());
					alumno.setEscuela((String) row.getCell(8).getStringCellValue());
					alumno.setSexo(String.valueOf(sexo));
					alumno.setCiclo(String.valueOf((int) row.getCell(7).getNumericCellValue()));
					
					alumnoRepository.guardarAlumno(alumno);
					
					for(int i = 0; i < this.preguntaRepository.ObtenerPreguntasTotales().size(); i++) {
						alumnoFormulario.setAlumno(alumno);
						alumnoFormulario.setPreguntas(this.preguntaRepository.ObtenerPreguntasTotales().get(i));
						alumnoFormulario.setRespuesta(String.valueOf((int) row.getCell(i + 9).getNumericCellValue()));
						
						this.alumnoFormularioRepository.guardarAlumnoFormulario(alumnoFormulario);
					}
					
				}
			}
			
			response.put("mensaje", "Se ha cargado correctamente el Excel");
			
		} catch (Exception e) {
			response.put("mensaje", "Error al cargar el Excel");
		}
		
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
