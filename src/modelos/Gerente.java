package modelos;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.BibliotecaControlador;
import controlador.LibroControlador;
import controlador.UsuarioControlador;

public class Gerente extends Usuario {
	private int idGerente;
	private String nombre;
	private String apellido;
	private int dni;
	private int idSucursal_fk;
	
	public Gerente(String mail, String contraseña, String tipo, String nombre, String apellido, int dni, int idSucursal_fk) {
		super(mail, contraseña, tipo);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.idSucursal_fk = idSucursal_fk;
	}
	public Gerente(String mail, String contraseña, String tipo, int idGerente, String nombre, String apellido, int dni, int idSucursal_fk) {
		super(mail, contraseña, tipo);
		this.idGerente = idGerente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.idSucursal_fk = idSucursal_fk;
	}

	@Override
	public String toString() {
		return "Gerente [idGerente=" + idGerente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", idSucursal_fk=" + idSucursal_fk + "]";
	}


	public int getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
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

	public int getIdSucursal_fk() {
		return idSucursal_fk;
	}

	public void setIdSucursal_fk(int idSucursal_fk) {
		this.idSucursal_fk = idSucursal_fk;
	}

	private Libro librosEliminados(List<Libro> list) {
	    LinkedList<Libro> librosEliminados = new LinkedList<>();
	    for (Libro libro : list) {
	        if (!libro.isEliminado()) {
	        	librosEliminados.add(libro);
	        }
	    }
	    if (librosEliminados.isEmpty()) {
	        return null;
	    }
	    Libro[] librosArray = librosEliminados.toArray(new Libro[0]);
	    return (Libro) JOptionPane.showInputDialog(null, "Seleccione un libro para eliminar:", "Libros Disponibles", JOptionPane.QUESTION_MESSAGE, null, librosArray, librosArray[0]);
	}
	
	private Libro librosEditables(List<Libro> list) {
	    LinkedList<Libro> librosEditables = new LinkedList<>();
	    for (Libro libro : list) {
	        if (!libro.isEliminado()) {
	        	librosEditables.add(libro);
	        }
	    }
	    if (librosEditables.isEmpty()) {
	        return null;
	    }
	    Libro[] librosArray = librosEditables.toArray(new Libro[0]);
	    return (Libro) JOptionPane.showInputDialog(null, "Seleccione un libro para editar:", "Libros Disponibles", JOptionPane.QUESTION_MESSAGE, null, librosArray, librosArray[0]);
	}
	
	@Override
	public void Ingreso (LibroControlador libroControlador, BibliotecaControlador bibliotecaControlador, UsuarioControlador usuarioControlador) {
		String[] opciones = {"Administrar libros","Administrar cuentas", "Ver inventario", "Cerrar sesión"};
		int ele=0;
		
		do {
			ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones, opciones[0]);
			
			switch (ele) {
			
			case 0:
				String[] opciones1 = {"Agregar libro", "Eliminar libro", "Editar Libro", "Volver"};
				int ele1=0;
				
				ele1 = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones1, opciones1[0]);
				
				switch (ele1) {
				case 0:
					String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
                    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                    String genero = JOptionPane.showInputDialog("Ingrese el género del libro:");
                    int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de stock:"));
                    int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio:"));
                    int idSucursal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la sucursal:"));
                    
                    Libro nuevoLibro = new Libro(0, titulo, autor, genero, stock, precio, idSucursal);
                    
					libroControlador.addLibro(nuevoLibro);
					
					break;

				case 1:
					Libro libroAEliminar = librosEliminados(libroControlador.getAllLibros());
                    if (libroAEliminar != null) {
                        libroControlador.deleteLibro(libroAEliminar.getIdLibro());
                        JOptionPane.showMessageDialog(null, "Libro eliminado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay libros disponibles para eliminar.");
                    }
                    break;
				
				case 2:
					Libro libroAEditar = librosEditables(libroControlador.getAllLibros());
					
				    if (libroAEditar != null) {
				        
				    	String[] opcionesEditar = {"Título", "Autor", "Género", "Stock", "Precio", "ID Sucursal", "Cancelar"};
				        int eleEditar = JOptionPane.showOptionDialog(null, "¿Qué atributo desea editar?", "Editar Libro",
				                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesEditar, opcionesEditar[0]);
				    	
				        switch (eleEditar) {
			            case 0:
			                String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el nuevo título:");
			                libroAEditar.setTitulo(nuevoTitulo);
			                break;
			            case 1:
			                String nuevoAutor = JOptionPane.showInputDialog("Ingrese el nuevo autor:");
			                libroAEditar.setAutor(nuevoAutor);
			                break;
			            case 2:
			                String nuevoGenero = JOptionPane.showInputDialog("Ingrese el nuevo género:");
			                libroAEditar.setGenero(nuevoGenero);
			                break;
			            case 3:
			                int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock:"));
			                libroAEditar.setStock(nuevoStock);
			                break;
			            case 4:
			                int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio:"));
			                libroAEditar.setPrecio(nuevoPrecio);
			                break;
			            case 5:
			                int nuevaIdSucursal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva ID de la sucursal:"));
			                libroAEditar.setIdSucursal_fk(nuevaIdSucursal);
			                break;
			            case 6:
			                
			                break;
			        }
				     
				    libroControlador.updateLibro(libroAEditar);
				        
				    } else {
				        JOptionPane.showMessageDialog(null, "No hay libros disponibles para editar.");
				    }
				    break;
					
				case 3:
					
					break;	
				}
				
				break;
				
			case 1:
				String[] opciones2 = {"Añadir cuenta","Eliminar cuenta","Editar cuenta", "Volver"};
				int ele2=0;
				
				ele2 = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones2, opciones2[0]);
				
				switch (ele2) {
				case 0:
					String mail = JOptionPane.showInputDialog("Ingrese el mail del usuario:");
                    String contraseña = JOptionPane.showInputDialog("Ingrese la contraseña del usuario:");
                    String[] tiposUsuario = {"Gerente", "Empleado", "Escritor"};
                    String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de usuario:", "Tipo de Usuario", 
                    		JOptionPane.QUESTION_MESSAGE, null, tiposUsuario, tiposUsuario[0]);
                    
                    Usuario nuevoUsuario = new Usuario(0, mail, contraseña, tipo);
                    
                    usuarioControlador.addUser(nuevoUsuario);
				
					break;

					//diego@gmail.com
					
				case 1:
					
					break;
					
				case 2:
					
					break;
				
				case 3:
					
					break;
				}
				
				break;
				
			case 2:
				
				String[] opciones3 = {"Ver todo el inventario", "Ver inventario de esta sucursal", "Buscar por título", "Buscar por id",
						"Buscar por autor", "Buscar por sucursal", "Buscar por género", "Volver"};
				
				int ele3 = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones3, opciones3[0]);
				
				switch (ele3) {
				case 0:
					String[] libros = new String[libroControlador.getAllLibros().size()];
					for (int i = 0; i < libros.length; i++) {
						libros[i] = libroControlador.getAllLibros().get(i).toString();
					}
					JOptionPane.showMessageDialog(null, libros);
					break;

				case 1:
					
					break;
					
				case 2:
					
					break;
				
				case 3:
					int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del libro que busca"));
					JOptionPane.showMessageDialog(null, libroControlador.getLibroById(id) + "\n Se encuentra en la sucursal: \n" + bibliotecaControlador.getLibraryById(libroControlador.getLibroById(id).getIdSucursal_fk()));
					break;
					
				case 4:
					
					break;
				case 5:
					
					break;
				
				case 6:
					
					break;
					
				case 7:
					
					break;
				}
				
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "Gracias por su servicio");
				break;
	
			}
		} while (ele!=3);
	}
	
}
