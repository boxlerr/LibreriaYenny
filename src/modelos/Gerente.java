package modelos;

import java.util.List;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import controlador.BibliotecaControlador;
import controlador.EmpleadoControlador;
import controlador.EscritorControlador;
import controlador.GerenteControlador;
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

	@Override
	public void Ingreso (LibroControlador libroControlador, BibliotecaControlador bibliotecaControlador, UsuarioControlador usuarioControlador, GerenteControlador gerenteControlador, EmpleadoControlador empleadoControlador, EscritorControlador escritorControlador) {
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
					Libro libroAEliminar = Libro.librosEliminados(libroControlador.getAllLibros());
                    if (libroAEliminar != null) {
                        libroControlador.deleteLibro(libroAEliminar.getIdLibro());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se eliminó ningún libro");
                    }
					break;
				
				case 2:
					Libro libroAEditar = Libro.librosEditables(libroControlador.getAllLibros());
					
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
					String mail = JOptionPane.showInputDialog("Ingrese el mail del usuario:");
                    String contraseña = JOptionPane.showInputDialog("Ingrese la contraseña del usuario:");
                    String[] tiposUsuario = {"Gerente", "Empleado", "Escritor"};
                    String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de usuario:", "Tipo de Usuario", 
                    		JOptionPane.QUESTION_MESSAGE, null, tiposUsuario, tiposUsuario[0]);
                    
                    Usuario nuevoUsuario = new Usuario(mail, contraseña, tipo);
                    
                    
                    if (tipo=="Gerente") {
						String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
	                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del usuario:");
	                    int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del usuario:"));
	                    if (dni > 99999999) {
	                    	do {
		                    	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
							} while (dni > 99999999);
						}
	                    int idSucursal_fk = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la sucursal donde trabajara:"));
	                    
	                    usuarioControlador.addUser(nuevoUsuario);
	                    Gerente newGerente = new Gerente(mail, contraseña, tipo, nombre, apellido, dni, idSucursal_fk);
	                    gerenteControlador.addGerente(newGerente, usuarioControlador.getUserById(mail, contraseña));
	                    
	                    
					} else if (tipo=="Empleado") {
						String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
	                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del usuario:");
	                    int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del usuario:"));
	                    if (dni > 99999999) {
	                    	do {
		                    	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
							} while (dni > 99999999);
						}
	                    int idSucursal_fk = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la sucursal donde trabajara:"));
	                    
	                    usuarioControlador.addUser(nuevoUsuario);
	                    Empleado newEmpleado = new Empleado(mail, contraseña, tipo, nombre, apellido, dni, idSucursal_fk);
	                    empleadoControlador.addEmpleado(newEmpleado, usuarioControlador.getUserById(mail, contraseña));
						
					} else if (tipo=="Escritor") {
						String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
	                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del usuario:");
	                    int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del usuario:"));
	                    if (dni > 99999999) {
	                    	do {
		                    	dni = Integer.parseInt(JOptionPane.showInputDialog("ERROR: Ingrese un dni válido"));
							} while (dni > 99999999);
						}
	                    
	                    usuarioControlador.addUser(nuevoUsuario);
	                    Escritor newEscritor = new Escritor(mail, contraseña, tipo, nombre, apellido, dni);
	                    escritorControlador.addEscritor(usuarioControlador.getUserById(mail, contraseña), newEscritor);
					} 
              
					break;

				case 1:
                    int seguir=0;
                    do {
                    	int eliminar =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del usuario que desea eliminar"));
                    	if (usuarioControlador.getUserById2(eliminar)==null) {
    						JOptionPane.showMessageDialog(null, "No se encontró ningun usuario con ese id");
    					} else {
    						String[] sino = {"Si", "Cancelar"};
    						int opcionselect = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el siguiente usuario? \n" + 
    	                    usuarioControlador.getUserById2(eliminar), "¿Eliminar?", 0, 0, null, sino, sino[0]);
    	                    if (opcionselect==0) {
    							if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("gerente")) {
    								usuarioControlador.deleteUser(eliminar);
    								gerenteControlador.deleteGerente(eliminar);
								} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("empleado")) {
									usuarioControlador.deleteUser(eliminar);
									empleadoControlador.deleteEmpleado(eliminar);
								} else if (usuarioControlador.getUserById2(eliminar).getTipo().equalsIgnoreCase("escritor")) {
									usuarioControlador.deleteUser(eliminar);
									escritorControlador.deleteEscritor(eliminar);
								}
    							
    						} else {
    							JOptionPane.showMessageDialog(null, "No se eliminó ningun usuario");
    						}
    	                    seguir=1;
    					}
					} while (seguir==0);
                    
                    
                    
					break;
					
				case 2:
					Usuario usuarioAEditar = Usuario.usuariosEditables(usuarioControlador.getAllUsers());
					
				    if (usuarioAEditar != null) {
				        
				    	String[] opcionesEditar = {"Mail", "Contraseña", "Tipo de Usuario", "Cancelar"};
				        int eleEditar = JOptionPane.showOptionDialog(null, "¿Qué atributo desea editar?", "Editar Usuario",
				                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesEditar, opcionesEditar[0]);
				    	
				        switch (eleEditar) {
			            case 0:
			                String nuevoMail = JOptionPane.showInputDialog("Ingrese el nuevo mail:");
			                usuarioAEditar.setMail(nuevoMail);
			                break;
			            case 1:
			                String nuevoContraseña = JOptionPane.showInputDialog("Ingrese la nueva contraseña:");
			                usuarioAEditar.setContraseña(nuevoContraseña);
			                break;
			            case 2:
			            	String[] tiposUsuario1 = {"Gerente", "Empleado", "Escritor"};
		                    String nuevoTipo = (String) JOptionPane.showInputDialog(null, "Seleccione el nuevo tipo de usuario:", "Tipo de Usuario", 
		                    		JOptionPane.QUESTION_MESSAGE, null, tiposUsuario1, tiposUsuario1[0]);
		                    
		                    usuarioAEditar.setTipo(nuevoTipo);
			                
			                break;
			            case 3:
			                
			            	break;
			        }
				     
				    usuarioControlador.updateUser(usuarioAEditar);
				        
				    } else {
				        JOptionPane.showMessageDialog(null, "No se editó ningún usuario");
				    }
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
				String[] busqueda = {"Buscar por titulo", "Buscar por id", "Salir"};
				int opcionselect = JOptionPane.showOptionDialog(null, "Como desea buscar su libro para aplicar descuento", "Librería", 0, 0, null, busqueda, busqueda[0]);
				switch (opcionselect) {
				case 0:
					String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro a aplicar descuento");
					if (libroControlador.getLibroByTitulo(titulo)!=null) {
						JOptionPane.showMessageDialog(null, "Se aplicará descuento a: " +libroControlador.getLibroByTitulo(titulo).toString());
						String nuevoPrecio = JOptionPane.showInputDialog("Ingrese DESCUENTO % + Nuevo precio");
						Libro libroAEditar = libroControlador.getLibroByTitulo(titulo);
						libroAEditar.setPrecio(nuevoPrecio);
						libroControlador.updateLibro(libroAEditar);
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró ningun libro con ese titulo");
					}
					break;

				case 1:
					int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del libro a aplicar descuento"));
					if (libroControlador.getLibroById(id)!=null) {
						JOptionPane.showMessageDialog(null, "Se aplicará descuento a: " +libroControlador.getLibroById(id).toString());
						String nuevoPrecio1 = JOptionPane.showInputDialog("Ingrese DESCUENTO % + Nuevo precio");
						Libro libroAEditar1 = libroControlador.getLibroById(id);
						libroAEditar1.setPrecio(nuevoPrecio1);
						libroControlador.updateLibro(libroAEditar1);
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró ningun libro con ese id");
					}
					
					break;
					
				case 2:
					
					break;
				}

				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Gracias por su servicio");
				break;
	
			}
		} while (ele!=4);
	}
}
