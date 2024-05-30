package test;
import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.junit.Test;
import modelos.*;
import controlador.*;

public class TestsEros {
	
	@Test
	public void InicioCorrecto() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		boolean flag = false;
		for (Usuario usuario : usuarioControlador.getAllUsers()) {
			if (usuarioControlador.getUserById("eros@davinci.edu.ar", "123")!=null) {
				flag=true;
				break;
			}
		}
		assertEquals(true,flag);
	}
	@Test
	public void InicioIncorrecto() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		boolean flag = false;
		for (Usuario usuario : usuarioControlador.getAllUsers()) {
			if (usuarioControlador.getUserById("eros@davinci.edu.ar", "asd")!=null) {
				flag=true;
				break;
			}
		}
		assertEquals(false,flag);
	}
	
	
	@Test
	public void CrearCuenta() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		boolean flag = false;
		
		String mail = "pedro@gmail.com";
		String contraseña = "asdfgh123";
		
		if (usuarioControlador.verificarMailTest(mail) && usuarioControlador.verificarContraseñaTest(contraseña)) {
			flag=true;
		}
		
		assertEquals(true,flag);
	}
	@Test
	public void CrearCuentaIncorrecto() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		boolean flag = false;
		
		String mail = "pedrogmailcom";
		String contraseña = "asdfgh123";
		
		if (usuarioControlador.verificarMailTest(mail) && usuarioControlador.verificarContraseñaTest(contraseña)) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	@Test
	public void CrearCuentaIncorrecto2() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		boolean flag = false;
		
		String mail = "eros@davinci.edu.ar";
		String contraseña = "asdfgh123";
		
		if (usuarioControlador.verificarMailTest(mail) && usuarioControlador.verificarContraseñaTest(contraseña)) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	@Test
	public void CrearCuentaIncorrecto3() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		boolean flag = false;
		
		String mail = "pedro@gmail.com";
		String contraseña = "a123";
		
		if (usuarioControlador.verificarMailTest(mail) && usuarioControlador.verificarContraseñaTest(contraseña)) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	@Test
	public void CrearCuentaIncorrecto4() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		boolean flag = false;
		
		String mail = "pedro@gmail.com";
		String contraseña = "asdfghjkg";
		
		if (usuarioControlador.verificarMailTest(mail) && usuarioControlador.verificarContraseñaTest(contraseña)) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	@Test
	public void CrearCuentaIncorrecto5() {
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		boolean flag = false;
		
		String mail = "pedro@gmail.com";
		String contraseña = "";
		
		if (usuarioControlador.verificarMailTest(mail) && usuarioControlador.verificarContraseñaTest(contraseña)) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	
	
	@Test
	public void verInventarioPorId() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		int id = 19;
		
		if (libroControlador.getLibroById(id)!=null) {
			flag=true;
		}
		
		assertEquals(true,flag);
	}
	@Test
	public void verInventarioPorIdInexistente() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		int id = 1;
		
		if (libroControlador.getLibroById(id)!=null) {
			flag=true;
		}
		assertEquals(false,flag);
	}
	
	@Test
	public void verInventarioPorTitulo() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		String titulo = "El secreto del bosque encantado";
		
		if (libroControlador.getLibroByTitulo(titulo)!=null) {
			flag=true;
		}
		
		assertEquals(true,flag);
	}
	@Test
	public void verInventarioPorTituloInexistente() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		String titulo = "El loco";
		
		if (libroControlador.getLibroByTitulo(titulo)!=null) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	
	@Test
	public void verInventarioPorAutor() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		String autor = "Carlos Ruiz";
		
		if (libroControlador.getLibrosByAutor(autor)!=null) {
			flag=true;
		}
		
		assertEquals(true,flag);
	}
	@Test
	public void verInventarioPorAutorInexistente() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		String autor = "Andrea";
		
		if (libroControlador.getLibrosByAutor(autor)!=null) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	
	@Test
	public void verInventarioPorGenero() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		String genero = "Misterio";
		
		if (libroControlador.getLibrosByGenero(genero)!=null) {
			flag=true;
		}
		
		assertEquals(true,flag);
	}
	@Test
	public void verInventarioPorGeneroInexistente() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		String genero = "Miisterioo";
		
		if (libroControlador.getLibrosByGenero(genero)!=null) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	
	
	
}
