package modelos;

import javax.swing.JOptionPane;

import controlador.BibliotecaControlador;
import controlador.EmpleadoControlador;
import controlador.EscritorControlador;
import controlador.GerenteControlador;
import controlador.LibroControlador;
import controlador.UsuarioControlador;

public class Escritor extends Usuario {
	private int idEscritor;
	private String nombre;
	private String apellido;
	private int dni;
	public Escritor(String mail, String contraseña, String tipo, String nombre, String apellido, int dni) {
		super(mail, contraseña, tipo);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	public Escritor(String mail, String contraseña, String tipo, int idEscritor, String nombre, String apellido, int dni) {
		super(mail, contraseña, tipo);
		this.idEscritor = idEscritor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Escritor [idEscritor=" + idEscritor + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
	public int getIdEscritor() {
		return idEscritor;
	}
	public void setIdEscritor(int idEscritor) {
		this.idEscritor = idEscritor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	@Override
	public void Ingreso (LibroControlador libroControlador, BibliotecaControlador bibliotecaControlador, UsuarioControlador usuarioControlador, GerenteControlador gerenteControlador, EmpleadoControlador empleadoControlador, EscritorControlador escritorControlador) {
		String[] opciones = {"Enviar propuesta de libro","Ver estado de propuesta","Ver estado de produccion del libro", "Cerrar sesión"};
		int ele=0;
		do {
			ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Empleado - ", 0, 0, null, opciones, opciones[0]);
			
			switch (ele) {
			case 0:
				
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Gracias por confiar en nosotros");
				break;
	
			}
		} while (ele!=3);
	}
	
	
}
