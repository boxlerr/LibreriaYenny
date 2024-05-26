package modelos;

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

	
	@Override
	public void Ingreso (LibroControlador libroControlador, BibliotecaControlador bibliotecaControlador) {
		String[] opciones = {"Administrar libros","Administrar cuentas", "Ver inventario", "Cerrar sesión"};
		int ele=0;
		
		do {
			ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones, opciones[0]);
			
			switch (ele) {
			
			case 0:
				String[] opciones1 = {"Agregar libro","Eliminar libro", "Volver"};
				int ele1=0;
				
				ele1 = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones1, opciones1[0]);
				
				switch (ele1) {
				case 0:
					
					break;

				case 1:
					
					break;
				
				case 2:
					
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
