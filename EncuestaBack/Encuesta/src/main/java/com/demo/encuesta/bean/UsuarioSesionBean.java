package com.demo.encuesta.bean;

public class UsuarioSesionBean 
{
	private Long ID;
	private String usuario;
	private String contraseña;
	
	
	public UsuarioSesionBean(Long ID, String usuario, String contraseña) {
		this.ID = ID;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public Long getID() {
		return ID;
	}
	
	public void setID(Long iD) {
		ID = iD;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "UsuarioSesionBean {\n" +
			   "usuario=" + usuario + ",\n" +
			   " contraseña=" + contraseña + "\n}";
	}
	
	
}
