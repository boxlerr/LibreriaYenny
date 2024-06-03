package test;
import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.junit.Test;
import modelos.*;
import controlador.*;
public class TestAlex {

	@Test
	public void aplicarDescuentoPorId() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		int id = 19;
		
		if (libroControlador.getLibroById(id)!=null) {
			flag=true;
		}
		
		assertEquals(true,flag);
	}
	@Test
	public void aplicarDescuentoPorIdInexsistente() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		int id = 1;
		
		if (libroControlador.getLibroById(id)!=null) {
			flag=true;
		}
		assertEquals(false,flag);
	}
	@Test
	public void aplicarDescuentoPorTitulo() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		String titulo = "El secreto del bosque encantado";
		
		if (libroControlador.getLibroByTitulo(titulo)!=null) {
			flag=true;
		}
		
		assertEquals(true,flag);
	}
	@Test
	public void aplicarDescuentoPorTituloInexistente() {
		LibroControlador libroControlador = new LibroControlador();
		boolean flag = false;
		String titulo = "El loco y el cuerdo";
		
		if (libroControlador.getLibroByTitulo(titulo)!=null) {
			flag=true;
		}
		
		assertEquals(false,flag);
	}
	

}
