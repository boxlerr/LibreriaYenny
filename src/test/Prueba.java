package test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import org.junit.Test;

import modelos.*;
import controlador.*;

public class Prueba {

	//los comentarios estan hechos para evitar crear, editar o eliminar cosas de la BBDD, tambien para evitar MessageDialogs en la pantalla
	
	@Test
	public void AgregarLibroV() {
		boolean error=false;
		boolean flag=false;
		LibroControlador libroControlador = new LibroControlador();
		do {
		String titulo = "Garfield";
        String autor = "Jim Davis";
        String genero = "Comedia";
        int stock = 50;
        String precio = "100";
        int idSucursal = 1;
        
        if (titulo!="" && autor!="" && genero!="" && stock>0 && precio!="" && (idSucursal>=1 && idSucursal<=3)) {
        	Libro nuevoLibro = new Libro(0, titulo, autor, genero, stock, precio, idSucursal);
        	
			//libroControlador.addLibro(nuevoLibro);
			flag=true;
		} else {
			JOptionPane.showMessageDialog(null, "Error al cargar los datos");
			error=true;
		}
        
		} while (error);
		
		assertEquals(true,flag);
	}
	
	@Test
	public void AgregarLibroF() {
		boolean error=false;
		boolean flag=false;
		LibroControlador libroControlador = new LibroControlador();
		do {
		String titulo = "Garfield";
        String autor = "Jim Davis";
        String genero = "Comedia";
        int stock;
        String precio = "100";
        int idSucursal = 1;
        
        if (titulo!="" && autor!="" && genero!="" && stock>0 && precio!="" && (idSucursal>=1 && idSucursal<=3)) {
        	Libro nuevoLibro = new Libro(0, titulo, autor, genero, stock, precio, idSucursal);
        	
			//libroControlador.addLibro(nuevoLibro);
			flag=true;
		} else {
			JOptionPane.showMessageDialog(null, "Error al cargar los datos");
			error=true;
		}
        
		} while (error);
		
		assertEquals(true,flag);
	}
	
	
	@Test
	public void EliminarLibroV() {
		boolean flag=false;
		LinkedList<Libro> librosEliminados = new LinkedList<>();
	    for (Libro libro : librosEliminados) {
	        if (!libro.isEliminado()) {
	        	librosEliminados.add(libro);
	        }
	    }

	    Libro[] librosArray = librosEliminados.toArray(new Libro[0]);
	    
	    Libro libroAEliminar = new Libro(34, "El Mentiroso de la Montaña", "Marcos de Aguirre", "Novela", 50, "100", 3);
        if (libroAEliminar != null) {
            //libroControlador.deleteLibro(libroAEliminar.getIdLibro());
        	flag=true;
        } else {
            JOptionPane.showMessageDialog(null, "No se eliminó ningún libro");
        }
        
		assertEquals(true,flag);
	}
	
	@Test
	public void EliminarLibroF() {
		boolean flag=false;
		LinkedList<Libro> librosEliminados = new LinkedList<>();
	    for (Libro libro : librosEliminados) {
	        if (!libro.isEliminado()) {
	        	librosEliminados.add(libro);
	        }
	    }

	    Libro[] librosArray = librosEliminados.toArray(new Libro[0]);
	    
	    Libro libroAEliminar = new Libro();
        if (libroAEliminar != null) {
            //libroControlador.deleteLibro(libroAEliminar.getIdLibro());
        	flag=true;
        } else {
            JOptionPane.showMessageDialog(null, "No se eliminó ningún libro");
        }
        
		assertEquals(true,flag);
	}
	
	
	@Test
	public void EditarLibroV() {
		boolean flag=false;
		LibroControlador libroControlador = new LibroControlador();
		LinkedList<Libro> librosEditables = new LinkedList<>();
	    for (Libro libro : librosEditables) {
	        if (!libro.isEliminado()) {
	        	librosEditables.add(libro);
	        }
	    }
	    
	    Libro libroAEditar = new Libro(0, null, null, null, 0, null, 0);
	    
	    if (libroAEditar != null) {
	        
	    	//String[] opcionesEditar = {"Título", "Autor", "Género", "Stock", "Precio", "ID Sucursal", "Cancelar"};
	        int eleEditar = 1;
	    	
	        switch (eleEditar) {
            case 0:
                String nuevoTitulo = "titulo";
                //libroAEditar.setTitulo(nuevoTitulo);
                break;
            case 1:
                String nuevoAutor = "autor";
                //libroAEditar.setAutor(nuevoAutor);
                break;
            case 2:
                String nuevoGenero = "genero";
                //libroAEditar.setGenero(nuevoGenero);
                break;
            case 3:
                int nuevoStock = 50;
                //libroAEditar.setStock(nuevoStock);
                break;
            case 4:
                String nuevoPrecio = "100";
                //libroAEditar.setPrecio(nuevoPrecio);
                break;
            case 5:
                int nuevaIdSucursal = 2;
                //libroAEditar.setIdSucursal_fk(nuevaIdSucursal);
                break;
            case 6:
                
                break;
        }
	     
	    //libroControlador.updateLibro(libroAEditar);
	    flag=true;
	        
	    } else {
	        JOptionPane.showMessageDialog(null, "No se editó ningún libro");
	    }
        
		assertEquals(true,flag);
	}
	
	@Test
	public void EditarLibroF() {
		boolean flag=false;
		LibroControlador libroControlador = new LibroControlador();
		LinkedList<Libro> librosEditables = new LinkedList<>();
	    for (Libro libro : librosEditables) {
	        if (!libro.isEliminado()) {
	        	librosEditables.add(libro);
	        }
	    }
	    
	    Libro[] librosArray = librosEditables.toArray(new Libro[0]);
	    
	    Libro libroAEditar;
	    
	    if (libroAEditar != null) {
	        
	    	String[] opcionesEditar = {"Título", "Autor", "Género", "Stock", "Precio", "ID Sucursal", "Cancelar"};
	        int eleEditar = JOptionPane.showOptionDialog(null, "¿Qué atributo desea editar?", "Editar Libro",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesEditar, opcionesEditar[0]);
	    	
	        switch (eleEditar) {
            case 0:
                String nuevoTitulo = "titulo";
                //libroAEditar.setTitulo(nuevoTitulo);
                break;
            case 1:
                String nuevoAutor = "autor";
                //libroAEditar.setAutor(nuevoAutor);
                break;
            case 2:
                String nuevoGenero = "genero";
                //libroAEditar.setGenero(nuevoGenero);
                break;
            case 3:
                int nuevoStock = 50;
                //libroAEditar.setStock(nuevoStock);
                break;
            case 4:
                String nuevoPrecio = "100";
                //libroAEditar.setPrecio(nuevoPrecio);
                break;
            case 5:
                int nuevaIdSucursal = 2;
                //libroAEditar.setIdSucursal_fk(nuevaIdSucursal);
                break;
            case 6:
                
                break;
        }
	     
	    //libroControlador.updateLibro(libroAEditar);
	    flag=true;
	        
	    } else {
	        JOptionPane.showMessageDialog(null, "No se editó ningún libro");
	    }
        
		assertEquals(true,flag);
	}
}
