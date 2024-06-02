package test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import org.junit.Test;

import modelos.*;
import controlador.*;

public class Prueba {

	
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

			flag=true;
		} else {
			
			error=true;
		}
        
		} while (error);
		
		assertEquals(true,flag);
	}
	
	@Test
	public void AgregarLibroF() {
		boolean flag=true;
		LibroControlador libroControlador = new LibroControlador();
		
		String titulo = "Garfield";
        String autor = "Jim Davis";
        String genero = "Comedia";
        int stock = 20;
        String precio = "100";
        int idSucursal = 4;
        
        if (titulo!="" && autor!="" && genero!="" && stock>0 && precio!="" && (idSucursal>=1 && idSucursal<=3)) {
        	Libro nuevoLibro = new Libro(0, titulo, autor, genero, stock, precio, idSucursal);
        	
			flag=true;
		} else {
			flag=false;
		}
        
		
		
		assertEquals(false,flag);
	}
	
	
	@Test
	public void EliminarLibroV() {
		boolean flag=false;
		LibroControlador libroControlador = new LibroControlador();
		LinkedList<Libro> librosEliminados = new LinkedList<>();
	    for (Libro libro : librosEliminados) {
	        if (!libro.isEliminado()) {
	        	librosEliminados.add(libro);
	        }
	    }

	    Libro[] librosArray = librosEliminados.toArray(new Libro[0]);
	    
	    Libro libroAEliminar = new Libro(34, "El Mentiroso de la Montaña", "Marcos de Aguirre", "Novela", 50, "100", 3);
        if (libroControlador.verificarLibroTest(libroAEliminar)) {
            
        	flag=true;
        } else {
            
        }
        
		assertEquals(true,flag);
	}
	
	@Test
	public void EliminarLibroF() {
		boolean flag=false;
		LibroControlador libroControlador = new LibroControlador();
		LinkedList<Libro> librosEliminados = new LinkedList<>();
	    for (Libro libro : librosEliminados) {
	        if (!libro.isEliminado()) {
	        	librosEliminados.add(libro);
	        }
	    }

	    Libro[] librosArray = librosEliminados.toArray(new Libro[0]);
	    
	    Libro libroAEliminar = new Libro(34, "Nombre Incorrecto", "Marcos de Aguirre", "Novela", 50, "100", 3);
        if (libroControlador.verificarLibroTest(libroAEliminar)) {

        	flag=true;
        } else {

        }
        
		assertEquals(true,flag);
	}
	
	
	@Test
	public void EditarLibroV() {
		boolean flag=true;
		LinkedList<Libro> librosEditables = new LinkedList<>();
	    for (Libro libro : librosEditables) {
	        if (!libro.isEliminado()) {
	        	librosEditables.add(libro);
	        }
	    }	    
	        int eleEditar = 0;
	    	
	        switch (eleEditar) {
	        case 0:
                String nuevoTitulo = "a";
                	if (nuevoTitulo.isBlank()) {
                		flag=false;
					}
                break;
            case 1:
            	String nuevoAutor = "a";
            	if (nuevoAutor.isBlank()) {
            		flag=false;
				}
                break;
            case 2:
            	String nuevoGenero = "a";
            	if (nuevoGenero.isBlank()) {
            		flag=false;
				}
                break;
            case 3:
            	int nuevoStock = 0;
                	if (nuevoStock<=0) {
                		flag=false;
					}
                break;
            case 4:
            	String nuevoPrecio = "a";
                	if (nuevoPrecio.isBlank()) {
                		flag=false;
					}
                break;
            case 5:
            	int nuevoIdSucursal = 0;
                	if (nuevoIdSucursal<=0) {
                		flag=false;
					}
                break;
            case 6:
                
                break;
        }
        
		assertEquals(true,flag);
	}
	
	@Test
	public void EditarLibroF() {
		boolean flag=true;
		LinkedList<Libro> librosEditables = new LinkedList<>();
	    for (Libro libro : librosEditables) {
	        if (!libro.isEliminado()) {
	        	librosEditables.add(libro);
	        }
	    }	    
	        int eleEditar = 0;
	    	
	        switch (eleEditar) {
	        case 0:
                String nuevoTitulo = "";
                	if (nuevoTitulo.isBlank()) {
                		flag=false;
					}
                break;
            case 1:
            	String nuevoAutor = "a";
            	if (nuevoAutor.isBlank()) {
            		flag=false;
				}
                break;
            case 2:
            	String nuevoGenero = "a";
            	if (nuevoGenero.isBlank()) {
            		flag=false;
				}
                break;
            case 3:
            	int nuevoStock = 0;
                	if (nuevoStock<=0) {
                		flag=false;
					}
                break;
            case 4:
            	String nuevoPrecio = "a";
                	if (nuevoPrecio.isBlank()) {
                		flag=false;
					}
                break;
            case 5:
            	int nuevoIdSucursal = 0;
                	if (nuevoIdSucursal<=0) {
                		flag=false;
					}
                break;
            case 6:
                
                break;
        }
        
		assertEquals(false,flag);
	}
	
	
	@Test
	public void AgregarUsuarioV() {
		boolean flag=true;
		
		String mail = "jose@gmail.com";
        String contraseña = "123";
        String tipo="Gerente";
        
        
        if (tipo=="Gerente") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
                	flag=false;
			}
            int idSucursal_fk = 1;
            
            
		} else if (tipo=="Empleado") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            	flag=false;
			}
            int idSucursal_fk = 1;

            flag=true;
			
		} else if (tipo=="Escritor") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            	flag=false;
			}

            
		} 
		
		assertEquals(true,flag);
	}
	
	@Test
	public void AgregarUsuarioF() {
		boolean flag=true;
		
		String mail = "jose@gmail.com";
        String contraseña = "123";
        String tipo="Gerente";
        
        
        if (tipo=="Gerente") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 999999999;
            if (dni > 99999999) {
                	flag=false;
			}
            int idSucursal_fk = 1;
            
            
		} else if (tipo=="Empleado") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            		flag=false;
			}
            int idSucursal_fk = 1;

            flag=true;
			
		} else if (tipo=="Escritor") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            		flag=false;
			}

            
		} 
		
		assertEquals(false,flag);
	}
	
	
	@Test
	public void EliminarUsuarioV() {
		boolean flag=false;
		UsuarioControlador usuarioControlador = new UsuarioControlador();

		int seguir=0;
        do {
        	int eliminar =1;
        	if (usuarioControlador.getUserById2(eliminar)==null) {
				flag=false;
			} else {
				
				int opcionselect=0;
				
                if (opcionselect==0) {
					if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("gerente")) {

						flag=true;
					} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("empleado")) {

						flag=true;
					} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("escritor")) {

						flag=true;
					}
					
				} else {
					
				}
                seguir=1;
			}
		} while (seguir==0);
		
		assertEquals(true,flag);
	}
	
	@Test
	public void EliminarUsuarioF() {
		boolean flag=true;
		UsuarioControlador usuarioControlador = new UsuarioControlador();

        	int eliminar =99;
        	if (usuarioControlador.getUserById2(eliminar)==null) {
				flag=false;
			} else {
				
				int opcionselect=0;
				
                if (opcionselect==0) {
					if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("gerente")) {

						flag=true;
					} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("empleado")) {

						flag=true;
					} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("escritor")) {

						flag=true;
					}
					
				} else {
					
				}
			}
		
		assertEquals(false,flag);
	}
	
	
	@Test
	public void EditarUsuarioV() {
		boolean flag=false;
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		 	
	    	int eleEditar=0;
	    	
	        switch (eleEditar) {
            case 0:
                String nuevoMail = "benja@gmail.com";

                flag=true;
                break;
            case 1:
                String nuevoContraseña = "123";

                flag=true;
                break;
            case 2:

            	flag=true;
                break;
            case 3:
                
            	break;
        }

		
		assertEquals(true,flag);
	}
	
	@Test
	public void EditarUsuarioF() {
		boolean flag=false;
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		 	
	    	int eleEditar=9;
	    	
	        switch (eleEditar) {
            case 0:
                String nuevoMail = "benja@gmail.com";

                flag=true;
                break;
            case 1:
                String nuevoContraseña = "123";

                flag=true;
                break;
            case 2:

            	flag=true;
                break;
            case 3:
                
            	break;
        }

		
		assertEquals(false,flag);
	}
}
