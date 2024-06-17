	package modelos;
	import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.Set;

	
	import controlador.*;

	
	public class Empleado extends Usuario {
		private int idEmpleado;
		private String nombre;
		private String apellido;
		private int dni;
		private int idSucursal_fk;
		
		public Empleado(String mail, String contraseña, String tipo, String nombre, String apellido, int dni, int idSucursal_fk) {
			super(mail, contraseña, tipo);
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.idSucursal_fk = idSucursal_fk;
		}
		public Empleado(String mail, String contraseña, String tipo, int idEmpleado, String nombre, String apellido, int dni, int idSucursal_fk) {
			super(mail, contraseña, tipo);
			this.idEmpleado = idEmpleado;
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.idSucursal_fk = idSucursal_fk;
		}
	
		public Empleado(String text, String text2, String tipo, String text3, String text4, int parseInt,
				Object selectedItem) {

		}
		
		@Override
		public String toString() {
			return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
					+ ", idSucursal_fk=" + idSucursal_fk + "]";
		}
		
		public int getIdEmpleado() {
			return idEmpleado;
		}
		public void setIdEmpleado(int idEmpleado) {
			this.idEmpleado = idEmpleado;
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
		
		
	//	public void VerLista (Biblioteca biblioteca) {
	//		JOptionPane.showMessageDialog(null, biblioteca.getLibrosdisponibles());
	//	}
	//	public void Prestar (Biblioteca biblioteca) {
	//		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del solicitante");
	//		String ape = JOptionPane.showInputDialog("Ingrese el apellido del solicitante");
	//		String id = JOptionPane.showInputDialog("Ingrese el identificador del solicitante");
	//		biblioteca.Prestar(nombre, ape, id);
	//	}
	//	
	//	public void Devolucion (Biblioteca biblioteca) {
	//		biblioteca.Devolucion();
	//	}
	
		@Override
		public void Ingreso (LibroControlador libroControlador, BibliotecaControlador bibliotecaControlador, UsuarioControlador usuarioControlador, GerenteControlador gerenteControlador, EmpleadoControlador empleadoControlador, EscritorControlador escritorControlador) {
			String[] opciones = {"Vender libro","Prestar libro","Ver inventario", "Registrar devolucion de libro", "Ver lista de préstamos", 
					"Ver lista de ventas", "Cerrar sesión"};
			int ele=0;
			do {
				ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Empleado - ", 0, 0, null, opciones, opciones[0]);
				
				switch (ele) {
				case 0: //vender libro	
					
	                String[] sucursalesDisponiblesArray = {"1 - Once", "2 - Belgrano", "3 - Abasto"};	                
	                String sucursalSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione la sucursal:", "Venta de Libro", JOptionPane.QUESTION_MESSAGE, null, sucursalesDisponiblesArray, sucursalesDisponiblesArray[0]);
	                if (sucursalSeleccionada == null) {
	                    JOptionPane.showMessageDialog(null, "No se seleccionó ninguna sucursal.", "Venta cancelada", JOptionPane.INFORMATION_MESSAGE);
	                    break;
	                }
	                int idSucursalSeleccionada = Integer.parseInt(sucursalSeleccionada.split(" - ")[0]);
	                List<Libro> librosDisponibles = libroControlador.getLibrosBySucursal(idSucursalSeleccionada);
	                if (librosDisponibles.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "No hay libros disponibles en esta sucursal.", "Error", JOptionPane.ERROR_MESSAGE);
	                    break;
	                }

	                String[] librosDisponiblesArray = new String[librosDisponibles.size()];
	                for (int i = 0; i < librosDisponibles.size(); i++) {
	                    librosDisponiblesArray[i] = librosDisponibles.get(i).getTitulo();
	                }
	                String libroSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el libro que desea vender:", "Venta de Libro", JOptionPane.QUESTION_MESSAGE, null, librosDisponiblesArray, librosDisponiblesArray[0]);
	                if (libroSeleccionado == null) {
	                    JOptionPane.showMessageDialog(null, "No se seleccionó ningún libro.", "Venta cancelada", JOptionPane.INFORMATION_MESSAGE);
	                    break;
	                }

	                int idLibroSeleccionado = librosDisponibles.get(Arrays.asList(librosDisponiblesArray).indexOf(libroSeleccionado)).getIdLibro();
	                int cantidadDisponible = libroControlador.obtenerCantidadDisponible(idLibroSeleccionado);
	                double valorUnitario = libroControlador.obtenerPrecioLibro(idLibroSeleccionado);
	                JOptionPane.showMessageDialog(null, "Cantidad disponible: " + cantidadDisponible, "Inventario", JOptionPane.INFORMATION_MESSAGE);
	                JOptionPane.showMessageDialog(null, "Precio del libro: " + valorUnitario, "Información", JOptionPane.INFORMATION_MESSAGE);
	                int cantidadVenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad a vender:", "Venta de Libro", JOptionPane.QUESTION_MESSAGE));

	                if (cantidadVenta <= cantidadDisponible) {
	                    double valorTotal = valorUnitario * cantidadVenta;
	                    LocalDate fechaVenta = LocalDate.now();
	                    Ventas venta = new Ventas(0, idLibroSeleccionado, idEmpleado, cantidadVenta, valorUnitario, valorTotal, fechaVenta);
	                    VentasControlador ventasControlador = new VentasControlador();
	                    if (ventasControlador.registrarVenta(venta)) {
	                        JOptionPane.showMessageDialog(null, "Venta realizada con éxito. Valor total: " + valorTotal, "Venta de Libro", JOptionPane.INFORMATION_MESSAGE);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error al realizar la venta.", "Venta de Libro", JOptionPane.ERROR_MESSAGE);
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "No hay suficiente stock para realizar la venta.", "Venta de Libro", JOptionPane.ERROR_MESSAGE);
	                }
	                
					break;
				case 1://prestar libro  //TENGO QUE ACOMODAR CATCHHHHHHSSSHSHSHS
					 try {
					 String[] sucursalesDisponiblesPrestamo = {"1 - Once", "2 - Belgrano", "3 - Abasto"};
					 String sucursalSeleccionadaPrestamo = (String) JOptionPane.showInputDialog(null, "Seleccione la sucursal:", "Préstamo de Libro", JOptionPane.QUESTION_MESSAGE, null, sucursalesDisponiblesPrestamo, sucursalesDisponiblesPrestamo[0]);
					 if (sucursalSeleccionadaPrestamo == null) {
					     JOptionPane.showMessageDialog(null, "No se seleccionó ninguna sucursal.", "Préstamo cancelado", JOptionPane.INFORMATION_MESSAGE);
					     break;
					  }
					  int idSucursalSeleccionadaPrestamo = Integer.parseInt(sucursalSeleccionadaPrestamo.split(" - ")[0]);
					  List<Libro> librosDisponiblesPrestamos = libroControlador.getLibrosBySucursal(idSucursalSeleccionadaPrestamo);
					  if (librosDisponiblesPrestamos.isEmpty()) {
					       JOptionPane.showMessageDialog(null, "No hay libros disponibles en esta sucursal.", "Error", JOptionPane.ERROR_MESSAGE);
					       break;
					}
					        String[] librosDisponiblesArrayPrestamo = new String[librosDisponiblesPrestamos.size()];
					        for (int i = 0; i < librosDisponiblesPrestamos.size(); i++) {
					            librosDisponiblesArrayPrestamo[i] = librosDisponiblesPrestamos.get(i).getTitulo();
					        }
					        String libroSeleccionadoPrestamo = (String) JOptionPane.showInputDialog(null, "Seleccione el libro que desea prestar:", "Préstamo de Libro", JOptionPane.QUESTION_MESSAGE, null, librosDisponiblesArrayPrestamo, librosDisponiblesArrayPrestamo[0]);
					        if (libroSeleccionadoPrestamo == null) {
					            JOptionPane.showMessageDialog(null, "No se seleccionó ningún libro.", "Préstamo cancelado", JOptionPane.INFORMATION_MESSAGE);
					            break;
					        }
					        int idLibroSeleccionadoPrestamo = librosDisponiblesPrestamos.get(Arrays.asList(librosDisponiblesArrayPrestamo).indexOf(libroSeleccionadoPrestamo)).getIdLibro();
					        if (librosDisponiblesPrestamos.get(Arrays.asList(librosDisponiblesArrayPrestamo).indexOf(libroSeleccionadoPrestamo)).getStock() <= 0) {
					            JOptionPane.showMessageDialog(null, "No hay stock disponible para el libro seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
					            break;
					        }
					        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
					        String apellidoCliente = JOptionPane.showInputDialog("Ingrese el apellido del cliente:");
					        PrestamoControlador prestamoControlador = new PrestamoControlador();
					        prestamoControlador.realizarPrestamo(idLibroSeleccionadoPrestamo, idSucursalSeleccionadaPrestamo, nombreCliente, apellidoCliente);

					        JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito.");

					    } catch (NumberFormatException e) {
					        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
					    } catch (Exception e) {
					        JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar el préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
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
				case 3: // registrar devolucion de libro
					try {

				    PrestamoControlador prestamoControlador = new PrestamoControlador();
				    List<Prestamos> listaPrestamos = prestamoControlador.obtenerListaPrestamos();
				    String[] opcionesDevolver = new String[listaPrestamos.size()];

				    for (int i = 0; i < listaPrestamos.size(); i++) {
				        Prestamos prestamo = listaPrestamos.get(i);
				        opcionesDevolver[i] = "ID de Préstamo: " + prestamo.getIdPrestamo() + " - Nombre: " + prestamo.getNombreCliente() + " " + prestamo.getApellidoCliente();
				    }

				    String opcionSeleccionada = (String) JOptionPane.showInputDialog(
				            null,
				            "Seleccione el préstamo a devolver:",
				            "Devolución de Libro",
				            JOptionPane.QUESTION_MESSAGE,
				            null,
				            opcionesDevolver,
				            opciones[0]);
				    if (opcionSeleccionada == null) {
				        JOptionPane.showMessageDialog(null, "No se seleccionó ningún préstamo.", "Operación Cancelada", JOptionPane.INFORMATION_MESSAGE);
				        return;
				    }
				    int idPrestamo = Integer.parseInt(opcionSeleccionada.split(" ")[3]);
				    prestamoControlador.devolverLibro(idPrestamo);

				    JOptionPane.showMessageDialog(null, "Libro devuelto con éxito.");
				} catch (NumberFormatException e) {
				    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
				    JOptionPane.showMessageDialog(null, "Ocurrió un error al devolver el libro.", "Error", JOptionPane.ERROR_MESSAGE);
				}
					break;
				case 4: //ver lista de prestamos
					 try {
					     PrestamoControlador prestamoControlador = new PrestamoControlador();
					        List<Prestamos> listaPrestamos = prestamoControlador.obtenerListaPrestamos();

					        if (listaPrestamos.isEmpty()) {
					            JOptionPane.showMessageDialog(null, "No hay préstamos registrados.", "Lista de Préstamos", JOptionPane.INFORMATION_MESSAGE);
					        } else {
					            while (true) {
					        Set<String> nombresApellidosClientes = new HashSet<>();  //ni idea me lo hizo gpt queria poder seleccinar el prestamo con su nombre y apellido.
					        for (Prestamos prestamo : listaPrestamos) {
					            nombresApellidosClientes.add(prestamo.getNombreCliente() + " " + prestamo.getApellidoCliente());
					        }
					        String[] clientesDisponibles = nombresApellidosClientes.toArray(new String[0]);
					        clientesDisponibles = Arrays.copyOf(clientesDisponibles, clientesDisponibles.length + 1);
					        clientesDisponibles[clientesDisponibles.length - 1] = "Cancelar";
					        String clienteSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione un cliente:", "Selección de Cliente", JOptionPane.QUESTION_MESSAGE, null, clientesDisponibles, clientesDisponibles[0]);

					    if (clienteSeleccionado != null && !clienteSeleccionado.equals("Cancelar")) { 
					    StringBuilder mensajeDetallePrestamo = new StringBuilder("Detalles del Préstamo para " + clienteSeleccionado + ":\n\n");
					    for (Prestamos prestamo : listaPrestamos) {
					      String nombreCompletoCliente = prestamo.getNombreCliente() + " " + prestamo.getApellidoCliente();
					      if (nombreCompletoCliente.equals(clienteSeleccionado)) {
					          mensajeDetallePrestamo.append("ID de Préstamo: ").append(prestamo.getIdPrestamo()).append("\n");
					          mensajeDetallePrestamo.append("ID de Libro: ").append(prestamo.getIdLibro()).append("\n");
					          mensajeDetallePrestamo.append("ID de Sucursal: ").append(prestamo.getIdSucursal()).append("\n");
					          mensajeDetallePrestamo.append("Fecha de Préstamo: ").append(prestamo.getFechaPrestamo()).append("\n");
					          mensajeDetallePrestamo.append("Fecha de Devolución: ").append(prestamo.getFechaDevolucion() != null ? prestamo.getFechaDevolucion() : "No devuelto").append("\n");
					          mensajeDetallePrestamo.append("----------------------------------\n");
					          }
					    }
					    JOptionPane.showMessageDialog(null, mensajeDetallePrestamo.toString(), "Detalles del Préstamo", JOptionPane.INFORMATION_MESSAGE);
					    } else if (clienteSeleccionado == null || clienteSeleccionado.equals("Cancelar")) {
					    JOptionPane.showMessageDialog(null, "Volviendo al menu...", "Préstamo cancelado", JOptionPane.INFORMATION_MESSAGE);
					    break;
					    }
					      }
					        }
			} catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener la lista de préstamos.", "Error", JOptionPane.ERROR_MESSAGE);
			}
					    break;
				case 5: //ver lista de ventas
					 VentasControlador ventasControlador = new VentasControlador();
					 List<Ventas> listaVentas = ventasControlador.obtenerListaVentas();

					 StringBuilder mensajeVenta = new StringBuilder();
					 for (Ventas venta : listaVentas) {
					 mensajeVenta.append(venta.toString()).append("\n");
					 }
					JOptionPane.showMessageDialog(null, mensajeVenta.toString(), "Lista de Ventas", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 6:
					JOptionPane.showMessageDialog(null, "Gracias por usar el software de Yenny");
					break;
		
				}
			} while (ele!=6);
		}
		
	}
