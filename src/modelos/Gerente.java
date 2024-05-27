package modelos;

import java.util.List;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import controlador.BibliotecaControlador;
import controlador.LibroControlador;

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
	public void Ingreso (LibroControlador libroControlador, BibliotecaControlador bibliotecaControlador) {
		String[] opciones = {"Administrar libros","Administrar cuentas", "Ver inventario", "Aplicar descuento", "Cerrar sesión"};
		int ele=0;
		
		do {
			ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones, opciones[0]);
			
			switch (ele) {
			
			case 0:
				String[] opciones1 = {"Agregar libro","Eliminar libro", "Editar libro", "Volver"};
				int ele1=0;
				
				ele1 = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones1, opciones1[0]);
				
				switch (ele1) {
				case 0:
					boolean error=false;
					do {
						
					String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
                    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                    String genero = JOptionPane.showInputDialog("Ingrese el género del libro:");
                    int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de stock:"));
                    String precio = JOptionPane.showInputDialog("Ingrese el precio:");
                    int idSucursal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la sucursal:"));
                    
                    if (titulo!="" && autor!="" && genero!="" && stock>0 && precio!="" && (idSucursal>=1 && idSucursal<=3)) {
                    	Libro nuevoLibro = new Libro(0, titulo, autor, genero, stock, precio, idSucursal);
                    	libroControlador.addLibro(nuevoLibro);
					} else {
						JOptionPane.showMessageDialog(null, "Error al cargar los datos");
						error=true;
					}
                    
					} while (error);
					break;

				case 1:
					Libro libroAEliminar = librosEliminados(libroControlador.getAllLibros());
                    if (libroAEliminar != null) {
                        libroControlador.deleteLibro(libroAEliminar.getIdLibro());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se eliminó ningún libro");
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
			                String nuevoPrecio = JOptionPane.showInputDialog("Ingrese el nuevo precio:");
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
				        JOptionPane.showMessageDialog(null, "No se editó ningún libro");
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
					
					break;

				case 1:
					
					break;
					
				case 2:
					
					break;
				
				case 3:
					
					break;
				}
				
				break;
				
			case 2:
				
				String[] opciones3 = {"Ver todo el inventario", "Ver inventario por sucursal", "Buscar por título", "Buscar por id",
						"Buscar por autor", "Buscar por género", "Volver"};
				
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
					String[] bibliotecas = {"Once", "Belgrano", "Abasto"};
					String opcionselect = (String) JOptionPane.showInputDialog(null, "Seleccione sucursal", null, 0, null, bibliotecas, bibliotecas[0]);
					
					JOptionPane.showMessageDialog(null, "Sucursal: " + bibliotecaControlador.getLibraryByNombre(opcionselect) + "\nInventario: \n" +
							libroControlador.getLibrosBySucursal(bibliotecaControlador.getLibraryByNombre(opcionselect).getIdSucursal()));
					
					break;
					
				case 2:
					String titulo=JOptionPane.showInputDialog("Ingrese el título del libro que desea buscar");
					if (libroControlador.getLibroByTitulo(titulo)!=null) {
						JOptionPane.showMessageDialog(null, libroControlador.getLibroByTitulo(titulo)+ "\nSe encuentra en la sucursal: \n" + 
					bibliotecaControlador.getLibraryById(libroControlador.getLibroByTitulo(titulo).getIdSucursal_fk()));
					} else {
						JOptionPane.showMessageDialog(null, "Ese titulo/libro no se encuentra en nuestra base de datos");
					}
					
					break;
				
				case 3:
					int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del libro que busca"));
					if (libroControlador.getLibroById(id)!=null) {
						JOptionPane.showMessageDialog(null, libroControlador.getLibroById(id) + "\nSe encuentra en la sucursal: \n" + 
					bibliotecaControlador.getLibraryById(libroControlador.getLibroById(id).getIdSucursal_fk()));
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró ningun libro con ese id");
					}
					break;
					
				case 4:
					String autor=JOptionPane.showInputDialog("Ingrese el autor");
					if (libroControlador.getLibrosByAutor(autor)!=null) {
						JOptionPane.showMessageDialog(null, "Autor: " + autor + "\nLibros: \n" + libroControlador.getLibrosByAutor(autor));
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró ningun libro de ese autor");
					}
					
					break;
				case 5:
					String genero=JOptionPane.showInputDialog("Ingrese el género");
					if (libroControlador.getLibrosByGenero(genero)!=null) {
						JOptionPane.showMessageDialog(null, "Género: " + genero + "\nLibros: \n" + libroControlador.getLibrosByGenero(genero));
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró ningun libro de ese género");
					}
					break;
				
				case 6:
					
					break;
					
				}
				
				break;

			case 3:
				//Aplicar descuento
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Gracias por su servicio");
				break;
	
			}
		} while (ele!=4);
	}
}
