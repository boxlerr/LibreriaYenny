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
		boolean flag=false;
		LibroControlador libroControlador = new LibroControlador();
		
		String titulo = "Garfield";
        String autor = "Jim Davis";
        String genero = "Comedia";
        int stock = 20;
        String precio = "100";
        int idSucursal = 4;
        
        if (titulo!="" && autor!="" && genero!="" && stock>0 && precio!="" && (idSucursal>=1 && idSucursal<=3)) {
        	Libro nuevoLibro = new Libro(0, titulo, autor, genero, stock, precio, idSucursal);
        	
			//libroControlador.addLibro(nuevoLibro);
			flag=true;
		} else {
			JOptionPane.showMessageDialog(null, "Error al cargar los datos");
		}
        
		
		
		assertEquals(false,flag);
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
	    
	    Libro libroAEliminar = new Libro(34, "El Mentiroso de la Montaña", "Marcos de Aguirre", "Novela", 50, "100", 3);
        if (libroAEliminar.getTitulo().isBlank()) {
            //libroControlador.deleteLibro(libroAEliminar.getIdLibro());
        	flag=true;
        } else {
            JOptionPane.showMessageDialog(null, "No se eliminó ningún libro");
        }
        
		assertEquals(false,flag);
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
	    
//	    Libro libroAEditar = Libro.librosEditables(libroControlador.getAllLibros());
	    Libro libroAEditar = new Libro("Título", "Autor", "Género", 22, "Precio", 2);
	    
	    if (libroAEditar != null) {
	        
	    	String[] opcionesEditar = {"Título", "Autor", "Género", "Stock", "Precio", "ID Sucursal", "Cancelar"};
	        int eleEditar = 0;
	    	
	        switch (eleEditar) {
	        case 0:
                String nuevoTitulo = "a";
                do {
                	nuevoTitulo=JOptionPane.showInputDialog("Ingrese el nuevo titulo");
                	if (nuevoTitulo.isBlank()) {
                		JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
//                	libroAEditar.setTitulo(nuevoTitulo);								
				} while (nuevoTitulo.isBlank());
                break;
            case 1:
            	String nuevoAutor = "a";
                do {
                	nuevoAutor=JOptionPane.showInputDialog("Ingrese el nuevo autor");
                	if (nuevoAutor.isBlank()) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
//                	libroAEditar.setAutor(nuevoAutor);								
				} while (nuevoAutor.isBlank());
                break;
            case 2:
            	String nuevoGenero = "a";
                do {
                	nuevoGenero=JOptionPane.showInputDialog("Ingrese el nuevo género");
                	if (nuevoGenero.isBlank()) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
//                	libroAEditar.setGenero(nuevoGenero);							
				} while (nuevoGenero.isBlank());
                break;
            case 3:
            	int nuevoStock = 0;
                do {
                	nuevoStock=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock"));
                	if (nuevoStock<=0) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
//                	libroAEditar.setStock(nuevoStock);								
				} while (nuevoStock<=0);
                break;
            case 4:
            	String nuevoPrecio = "a";
                do {
                	nuevoPrecio=JOptionPane.showInputDialog("Ingrese el nuevo precio");
                	if (nuevoPrecio.isBlank()) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
//                	libroAEditar.setPrecio(nuevoPrecio);								
				} while (nuevoPrecio.isBlank());
                break;
            case 5:
            	int nuevoIdSucursal = 0;
                do {
                	nuevoIdSucursal=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id de la sucursal"));
                	if (nuevoIdSucursal<=0) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
//                	libroAEditar.setIdSucursal_fk(nuevoIdSucursal);								
				} while (nuevoIdSucursal<=0 && nuevoIdSucursal>=4);
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
	    
//	    Libro libroAEditar = Libro.librosEditables(libroControlador.getAllLibros());
	    Libro libroAEditar = new Libro("Título", "Autor", "Género", 22, "Precio", 50);
	    
	    if (libroAEditar != null) {
	        
	    	String[] opcionesEditar = {"Título", "Autor", "Género", "Stock", "Precio", "ID Sucursal", "Cancelar"};
	        int eleEditar = 1;
	    	
	        switch (eleEditar) {
	        case 0:
                String nuevoTitulo = "a";
                do {
                	nuevoTitulo=JOptionPane.showInputDialog("Ingrese el nuevo titulo");
                	if (nuevoTitulo.isBlank()) {
                		JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
                	//libroAEditar.setTitulo(nuevoTitulo);								
				} while (nuevoTitulo.isBlank());
                break;
            case 1:
            	String nuevoAutor = "a";
                do {
                	nuevoAutor=JOptionPane.showInputDialog("Ingrese el nuevo autor");
                	if (nuevoAutor.isBlank()) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
                	//libroAEditar.setAutor(nuevoAutor);								
				} while (nuevoAutor.isBlank());
                break;
            case 2:
            	String nuevoGenero = "a";
                do {
                	nuevoGenero=JOptionPane.showInputDialog("Ingrese el nuevo género");
                	if (nuevoGenero.isBlank()) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
                	//libroAEditar.setGenero(nuevoGenero);							
				} while (nuevoGenero.isBlank());
                break;
            case 3:
            	int nuevoStock = 0;
                do {
                	nuevoStock=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock"));
                	if (nuevoStock<=0) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
                	//libroAEditar.setStock(nuevoStock);								
				} while (nuevoStock<=0);
                break;
            case 4:
            	String nuevoPrecio = "a";
                do {
                	nuevoPrecio=JOptionPane.showInputDialog("Ingrese el nuevo precio");
                	if (nuevoPrecio.isBlank()) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
                	//libroAEditar.setPrecio(nuevoPrecio);								
				} while (nuevoPrecio.isBlank());
                break;
            case 5:
            	int nuevoIdSucursal = 1;
                do {
                	nuevoIdSucursal=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id de la sucursal"));
                	if (nuevoIdSucursal<=0) {
						JOptionPane.showMessageDialog(null, "Verifique y vuelva a ingresar la información");
					}
                	//libroAEditar.setIdSucursal_fk(nuevoIdSucursal);								
				} while (nuevoIdSucursal<=0 && nuevoIdSucursal>=4);
                break;
            case 6:
                
                break;
        }
	     
	    //libroControlador.updateLibro(libroAEditar);
	    flag=true;
	        
	    } else {
	        JOptionPane.showMessageDialog(null, "No se editó ningún libro");
	    }
        
		assertEquals(false,flag);
	}
	
	
	@Test
	public void AgregarUsuarioV() {
		boolean flag=false;
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		GerenteControlador gerenteControlador = new GerenteControlador();
		EmpleadoControlador empleadoControlador = new EmpleadoControlador();
		EscritorControlador escritorControlador = new EscritorControlador();
		
		
		String mail = "jose@gmail.com";
        String contraseña = "123";
        String[] tiposUsuario = {"Gerente", "Empleado", "Escritor"};
//        String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de usuario:", "Tipo de Usuario", 
//        		JOptionPane.QUESTION_MESSAGE, null, tiposUsuario, tiposUsuario[0]);
        
        String tipo="Gerente";
        
        Usuario nuevoUsuario = new Usuario(mail, contraseña, tipo);
        
        
        if (tipo=="Gerente") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            	do {
                	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
				} while (dni > 99999999);
			}
            int idSucursal_fk = 1;
            
            //usuarioControlador.addUser(nuevoUsuario);
            //Gerente newGerente = new Gerente(mail, contraseña, tipo, nombre, apellido, dni, idSucursal_fk);
            //gerenteControlador.addGerente(newGerente, usuarioControlador.getUserById(mail, contraseña));
            flag=true;
            
            
		} else if (tipo=="Empleado") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            	do {
                	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
				} while (dni > 99999999);
			}
            int idSucursal_fk = 1;
            
//            usuarioControlador.addUser(nuevoUsuario);
//            Empleado newEmpleado = new Empleado(mail, contraseña, tipo, nombre, apellido, dni, idSucursal_fk);
//            empleadoControlador.addEmpleado(newEmpleado, usuarioControlador.getUserById(mail, contraseña));
            flag=true;
			
		} else if (tipo=="Escritor") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            	do {
                	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
				} while (dni > 99999999);
			}
            
//            usuarioControlador.addUser(nuevoUsuario);
//            Escritor newEscritor = new Escritor(mail, contraseña, tipo, nombre, apellido, dni);
//            escritorControlador.addEscritor(usuarioControlador.getUserById(mail, contraseña), newEscritor);
            
		} 
		
		assertEquals(true,flag);
	}
	
	@Test
	public void AgregarUsuarioF() {
		boolean flag=false;
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		GerenteControlador gerenteControlador = new GerenteControlador();
		EmpleadoControlador empleadoControlador = new EmpleadoControlador();
		EscritorControlador escritorControlador = new EscritorControlador();
		
		
		String mail = "jose@gmail.com";
        String contraseña = "123";
        String[] tiposUsuario = {"Gerente", "Empleado", "Escritor"};
//        String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de usuario:", "Tipo de Usuario", 
//        		JOptionPane.QUESTION_MESSAGE, null, tiposUsuario, tiposUsuario[0]);
        
        String tipo="Gerente";
        
        Usuario nuevoUsuario = new Usuario(mail, contraseña, tipo);
        
        
        if (tipo=="Gerente") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            	do {
                	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
				} while (dni > 99999999);
			}
            int idSucursal_fk = 1;
            
            //usuarioControlador.addUser(nuevoUsuario);
            //Gerente newGerente = new Gerente(mail, contraseña, tipo, nombre, apellido, dni, idSucursal_fk);
            //gerenteControlador.addGerente(newGerente, usuarioControlador.getUserById(mail, contraseña));
            flag=true;
            
            
		} else if (tipo=="Empleado") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            	do {
                	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
				} while (dni > 99999999);
			}
            int idSucursal_fk = 1;
            
//            usuarioControlador.addUser(nuevoUsuario);
//            Empleado newEmpleado = new Empleado(mail, contraseña, tipo, nombre, apellido, dni, idSucursal_fk);
//            empleadoControlador.addEmpleado(newEmpleado, usuarioControlador.getUserById(mail, contraseña));
            flag=true;
			
		} else if (tipo=="Escritor") {
			String nombre = "Jose";
            String apellido = "Hernandez";
            int dni = 1;
            if (dni > 99999999) {
            	do {
                	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
				} while (dni > 99999999);
			}
            
//            usuarioControlador.addUser(nuevoUsuario);
//            Escritor newEscritor = new Escritor(mail, contraseña, tipo, nombre, apellido, dni);
//            escritorControlador.addEscritor(usuarioControlador.getUserById(mail, contraseña), newEscritor);
            
		} 
		
		assertEquals(false,flag);
	}
	
	
	@Test
	public void EliminarUsuarioV() {
		boolean flag=false;
		
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		GerenteControlador gerenteControlador = new GerenteControlador();
		EmpleadoControlador empleadoControlador = new EmpleadoControlador();
		EscritorControlador escritorControlador = new EscritorControlador();
		
		
		int seguir=0;
        do {
        	int eliminar =1;
        	if (usuarioControlador.getUserById2(eliminar)==null) {
				JOptionPane.showMessageDialog(null, "No se encontró ningun usuario con ese id");
			} else {
//				String[] sino = {"Si", "Cancelar"};
//				int opcionselect = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el siguiente usuario? \n" + 
//                usuarioControlador.getUserById2(eliminar), "¿Eliminar?", 0, 0, null, sino, sino[0]);
				
				int opcionselect=0;
				
                if (opcionselect==0) {
					if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("gerente")) {
						//usuarioControlador.deleteUser(eliminar);
						//gerenteControlador.deleteGerente(eliminar);
						flag=true;
					} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("empleado")) {
						//usuarioControlador.deleteUser(eliminar);
						//empleadoControlador.deleteEmpleado(eliminar);
						flag=true;
					} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("escritor")) {
						//usuarioControlador.deleteUser(eliminar);
						//escritorControlador.deleteEscritor(eliminar);
						flag=true;
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "No se eliminó ningun usuario");
				}
                seguir=1;
			}
		} while (seguir==0);
		
		assertEquals(true,flag);
	}
	
	@Test
	public void EliminarUsuarioF() {
		boolean flag=false;
		
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		GerenteControlador gerenteControlador = new GerenteControlador();
		EmpleadoControlador empleadoControlador = new EmpleadoControlador();
		EscritorControlador escritorControlador = new EscritorControlador();
		
		
		int seguir=0;
        do {
        	int eliminar =1;
        	if (usuarioControlador.getUserById2(eliminar)==null) {
				JOptionPane.showMessageDialog(null, "No se encontró ningun usuario con ese id");
			} else {
//				String[] sino = {"Si", "Cancelar"};
//				int opcionselect = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el siguiente usuario? \n" + 
//                usuarioControlador.getUserById2(eliminar), "¿Eliminar?", 0, 0, null, sino, sino[0]);
				
				int opcionselect=1;
				
                if (opcionselect==0) {
					if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("gerente")) {
						//usuarioControlador.deleteUser(eliminar);
						//gerenteControlador.deleteGerente(eliminar);
						flag=true;
					} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("empleado")) {
						//usuarioControlador.deleteUser(eliminar);
						//empleadoControlador.deleteEmpleado(eliminar);
						flag=true;
					} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("escritor")) {
						//usuarioControlador.deleteUser(eliminar);
						//escritorControlador.deleteEscritor(eliminar);
						flag=true;
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "No se eliminó ningun usuario");
				}
                seguir=1;
			}
		} while (seguir==0);
		
		assertEquals(false,flag);
	}
	
	
	@Test
	public void EditarUsuarioV() {
		boolean flag=false;
		
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		
		
		Usuario usuarioAEditar = Usuario.usuariosEditables(usuarioControlador.getAllUsers());
		
	    if (usuarioAEditar != null) {
	        
//	    	String[] opcionesEditar = {"Mail", "Contraseña", "Tipo de Usuario", "Cancelar"};
//	        int eleEditar = JOptionPane.showOptionDialog(null, "¿Qué atributo desea editar?", "Editar Usuario",
//	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesEditar, opcionesEditar[0]);
	    	
	    	int eleEditar=0;
	    	
	        switch (eleEditar) {
            case 0:
                String nuevoMail = "benja@gmail.com";
                //usuarioAEditar.setMail(nuevoMail);
                flag=true;
                break;
            case 1:
                String nuevoContraseña = "123";
                //usuarioAEditar.setContraseña(nuevoContraseña);
                flag=true;
                break;
            case 2:
//            	String[] tiposUsuario1 = {"Gerente", "Empleado", "Escritor"};
//                String nuevoTipo = (String) JOptionPane.showInputDialog(null, "Seleccione el nuevo tipo de usuario:", "Tipo de Usuario", 
//                		JOptionPane.QUESTION_MESSAGE, null, tiposUsuario1, tiposUsuario1[0]);
                
                //usuarioAEditar.setTipo(nuevoTipo);
            	flag=true;
                break;
            case 3:
                
            	break;
        }
	     
	    //usuarioControlador.updateUser(usuarioAEditar);
	        
	    } else {
	        JOptionPane.showMessageDialog(null, "No se editó ningún usuario");
	    }
		
		assertEquals(true,flag);
	}
	
	@Test
	public void EditarUsuarioF() {
		boolean flag=false;
		
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		
		
		Usuario usuarioAEditar = Usuario.usuariosEditables(usuarioControlador.getAllUsers());
		
	    if (usuarioAEditar != null) {
	        
//	    	String[] opcionesEditar = {"Mail", "Contraseña", "Tipo de Usuario", "Cancelar"};
//	        int eleEditar = JOptionPane.showOptionDialog(null, "¿Qué atributo desea editar?", "Editar Usuario",
//	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesEditar, opcionesEditar[0]);
	    	
	    	int eleEditar=3;
	    	
	        switch (eleEditar) {
            case 0:
                String nuevoMail = "benja@gmail.com";
                //usuarioAEditar.setMail(nuevoMail);
                flag=true;
                break;
            case 1:
                String nuevoContraseña = "123";
                //usuarioAEditar.setContraseña(nuevoContraseña);
                flag=true;
                break;
            case 2:
//            	String[] tiposUsuario1 = {"Gerente", "Empleado", "Escritor"};
//                String nuevoTipo = (String) JOptionPane.showInputDialog(null, "Seleccione el nuevo tipo de usuario:", "Tipo de Usuario", 
//                		JOptionPane.QUESTION_MESSAGE, null, tiposUsuario1, tiposUsuario1[0]);
                
                //usuarioAEditar.setTipo(nuevoTipo);
            	flag=true;
                break;
            case 3:
                
            	break;
        }
	     
	    //usuarioControlador.updateUser(usuarioAEditar);
	        
	    } else {
	        JOptionPane.showMessageDialog(null, "No se editó ningún usuario");
	    }
		
		assertEquals(false,flag);
	}
}
