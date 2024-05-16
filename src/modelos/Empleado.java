package modelos;
import javax.swing.JOptionPane;

public class Empleado extends Usuario {
	private String idempleado;
	

	public Empleado(String nombre, String apellido, String idempleado) {
		super(nombre, apellido);
		this.idempleado = idempleado;
	}
	
	public void VerLista (Biblioteca biblioteca) {
		JOptionPane.showMessageDialog(null, biblioteca.getLibrosdisponibles());
	}
	public void Prestar (Biblioteca biblioteca) {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del solicitante");
		String ape = JOptionPane.showInputDialog("Ingrese el apellido del solicitante");
		String id = JOptionPane.showInputDialog("Ingrese el identificador del solicitante");
		biblioteca.Prestar(nombre, ape, id);
	}
	
	public void Devolucion (Biblioteca biblioteca) {
		biblioteca.Devolucion();
	}

	@Override
	public void Ingreso (String identificador, Biblioteca biblioteca) {
		String[] opciones = {"Ver lista de libros disponibles","Prestar libro","Registrar devolución de libro", "Ver lista de préstamos", "Salir"};
		int ele=0;
		do {
			ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Empleado", 0, 0, null, opciones, opciones[0]);
			
			switch (ele) {
			case 0:
				this.VerLista(biblioteca);
				break;
			case 1:
				this.Prestar(biblioteca);
				break;
			case 2:
				this.Devolucion(biblioteca);
				break;
			case 3:
				if(!biblioteca.getPrestamos().isEmpty()) {
					JOptionPane.showMessageDialog(null, biblioteca.getPrestamos());
					} else {
						JOptionPane.showMessageDialog(null, "No se han realizado préstamos aún");
					}
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Gracias por su servicio");
				break;
	
			}
		} while (ele!=4);
	}

	@Override
	public String toString() {
		return "Empleado [idempleado=" + idempleado + "]";
	}

	public String getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}
	
	
}
