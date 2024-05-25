package modelos;
import javax.swing.JOptionPane;

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
	public void Ingreso () {
		String[] opciones = {"Vender libro","Prestar libro","Ver inventario", "Registrar devolucion de libro", "Ver lista de préstamos", "Cerrar sesión"};
		int ele=0;
		do {
			ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Empleado - ", 0, 0, null, opciones, opciones[0]);
			
			switch (ele) {
			case 0:
				
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Gracias por su servicio");
				break;
	
			}
		} while (ele!=5);
	}
	
}
