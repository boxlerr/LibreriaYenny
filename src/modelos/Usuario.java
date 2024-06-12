package modelos;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.BibliotecaControlador;
import controlador.EmpleadoControlador;
import controlador.EscritorControlador;
import controlador.GerenteControlador;
import controlador.LibroControlador;
import controlador.UsuarioControlador;

public class Usuario {
	private int id;
	private String mail;
	private String contraseña;
	private String tipo;
	
	
	public Usuario(String mail, String contraseña, String tipo) {
		super();
		this.mail = mail;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}
	public Usuario(int id, String mail, String contraseña, String tipo) {
		super();
		this.id = id;
		this.mail = mail;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}
	public Usuario() {
		
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", mail=" + mail + ", contraseña=" + contraseña + ", tipo=" + tipo + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static Usuario usuariosEditables(List<Usuario> list) {
	    LinkedList<Usuario> usuariosEditables = new LinkedList<>();
	    for (Usuario usuario : list) {
	        	usuariosEditables.add(usuario);
	    }
	    if (usuariosEditables.isEmpty()) {
	        return null;
	    }
	    Usuario[] usuariosArray = usuariosEditables.toArray(new Usuario[0]);
	    return (Usuario) JOptionPane.showInputDialog(null, "Seleccione un usuario para editar:", "Usuarios Disponibles", JOptionPane.QUESTION_MESSAGE, null, usuariosArray, usuariosArray[0]);
	}
	
	public void Ingreso(LibroControlador libroControlador, BibliotecaControlador bibliotecaControlador, UsuarioControlador usuarioControlador, GerenteControlador gerenteControlador, EmpleadoControlador empleadoControlador, EscritorControlador escritorControlador) {
		
	}

	
}
