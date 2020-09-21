package com.demo.encuesta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario", schema = "dbo")
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idUsuario;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "ApellidoPaterno")
	private String apellidoPaterno;
	
	@Column(name = "ApellidoMaterno")
	private String apellidoMaterno;
	
	@Column(name = "Correo")
	private String correo;
	
	@Column(name = "NombreUsuario")
	private String nombreUsuario;
	
	@Column(name = "Contrasenia")
	private String contrasenia;
	
	@Column(name = "ContraseniaEnc")
	private String contraseniaEnc;

	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getContraseniaEnc() {
		return contraseniaEnc;
	}

	public void setContraseniaEnc(String contraseniaEnc) {
		this.contraseniaEnc = contraseniaEnc;
	}
	
	
}
