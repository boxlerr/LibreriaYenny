	package modelos;
	import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
	
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
	                List<Libro> librosDisponibles = libroControlador.getAllLibros();
	                String[] librosDisponiblesArray = new String[librosDisponibles.size()];
	                for (int i = 0; i < librosDisponibles.size(); i++) {
	                    librosDisponiblesArray[i] = librosDisponibles.get(i).getTitulo();
	                }
	                String libroSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el libro que desea vender:", "Venta de Libro", JOptionPane.QUESTION_MESSAGE, null, librosDisponiblesArray, librosDisponiblesArray[0]);
	                int idLibroSeleccionado = librosDisponibles.get(Arrays.asList(librosDisponiblesArray).indexOf(libroSeleccionado)).getIdLibro();
	                int cantidadDisponible = libroControlador.obtenerCantidadDisponible(idLibroSeleccionado);
	                double valorUnitario = libroControlador.obtenerPrecioLibro(idLibroSeleccionado);
	                JOptionPane.showMessageDialog(null, "Cantidad disponible: " + cantidadDisponible, "Inventario", JOptionPane.INFORMATION_MESSAGE);
	                JOptionPane.showMessageDialog(null, "Precio del libro: " + valorUnitario, "Información", JOptionPane.INFORMATION_MESSAGE);
	                int cantidadVenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad a vender:", "Venta de Libro", JOptionPane.QUESTION_MESSAGE));

	                if (cantidadVenta <= cantidadDisponible) {
	                	
	                    double valorTotal = valorUnitario * cantidadVenta;
	                    LocalDate fechaVenta = LocalDate.now();
	                    Ventas venta = new Ventas(0, idLibroSeleccionado, this.idEmpleado, cantidadVenta, valorUnitario, valorTotal, fechaVenta);
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
				case 1://prestar libro
					
					break;
				case 2:	//ver inventario
					String[] libros = new String[libroControlador.getAllLibros().size()];
					for (int i = 0; i < libros.length; i++) {
						libros[i] = libroControlador.getAllLibros().get(i).toString();
					}
					JOptionPane.showMessageDialog(null, libros);				
					break;
				case 3: // registrar devolucion de libro
					break;
				case 4: //ver lista de prestamos
					break;
				case 5: //ver lista de ventas
					 VentasControlador ventasControlador = new VentasControlador();
					 List<Ventas> listaVentas = ventasControlador.obtenerListaVentas();

					 StringBuilder mensaje = new StringBuilder();
					 for (Ventas venta : listaVentas) {
					 mensaje.append(venta.toString()).append("\n");
					 }
					JOptionPane.showMessageDialog(null, mensaje.toString(), "Lista de Ventas", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 6:
					JOptionPane.showMessageDialog(null, "Gracias por su servicio");
					break;
		
				}
			} while (ele!=6);
		}
		
	}
