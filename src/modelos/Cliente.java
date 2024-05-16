package modelos;
import javax.swing.JOptionPane;

public class Cliente extends Usuario {
	private String indentificador;


	public Cliente(String nombre, String apellido, String indentificador) {
		super(nombre, apellido);
		this.indentificador = indentificador;
	}
	
	public void VerLista (Biblioteca biblioteca) {
		JOptionPane.showMessageDialog(null, biblioteca.getLibrosdisponibles());
	}
	
	public void Pedir (Biblioteca biblioteca) {
		biblioteca.Prestar(this.getNombre(), this.getApellido(), this.getIndentificador());
	}
	
	public void Devolver (Biblioteca biblioteca) {
		biblioteca.Devolucion();
	}
	
	@Override
	public void Ingreso(String identificador, Biblioteca biblioteca) {
		String[] opciones = {"Ver lista de libros disponibles","Pedir prestado un libro","Devolver un libro", "Salir"};
		int ele=0;
		do {
			ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Cliente", 0, 0, null, opciones, opciones[0]);
			
			switch (ele) {
			case 0:
				this.VerLista(biblioteca);
				break;
			case 1:
				this.Pedir(biblioteca);
				break;
			case 2:
				this.Devolver(biblioteca);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Gracias por visitarnos, que tenga un buen día.");
				break;
	
			}
		} while (ele!=3);
	}

	@Override
	public String toString() {
		return "Cliente [indentificador=" + indentificador + "]";
	}

	public String getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(String indentificador) {
		this.indentificador = indentificador;
	}


	
	
}
