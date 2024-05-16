package modelos;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Biblioteca {
	
	private LinkedList <Libro> librosdisponibles = new LinkedList <Libro>();
	private LinkedList <Prestamo> prestamos = new LinkedList <Prestamo>();
	
	@Override
	public String toString() {
		return "Biblioteca [librosdisponibles=" + librosdisponibles + ", prestamos=" + prestamos + "]";
	}
	public LinkedList<Libro> getLibrosdisponibles() {
		return librosdisponibles;
	}
	public void setLibrosdisponibles(LinkedList<Libro> librosdisponibles) {
		this.librosdisponibles = librosdisponibles;
	}
	public LinkedList<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(LinkedList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}


	public void Prestar (String nombre, String ape, String id) {
		String[] librosdisponibles = new String[this.getLibrosdisponibles().size()]; 
		
		for (int i = 0; i < this.getLibrosdisponibles().size(); i++) {
			librosdisponibles[i]=this.getLibrosdisponibles().get(i).toString();
		}
		
		String seleccionado = (String) JOptionPane.showInputDialog(null, "Elija de esta lista de libros disponibles", "Préstamos", 0, null, librosdisponibles, librosdisponibles[0]);
		JOptionPane.showMessageDialog(null, "Se prestó: " + seleccionado);
		int indiceABorrar=-1;
		for (Libro libro : this.getLibrosdisponibles()) {
			if(libro.toString().equals(seleccionado)) {
				indiceABorrar = this.getLibrosdisponibles().indexOf(libro);
				this.getPrestamos().add(new Prestamo(seleccionado, nombre, ape, id, LocalDate.now()));
			}
		}
		if(indiceABorrar!=-1) {
			this.getLibrosdisponibles().remove(indiceABorrar);
		}
	}
	
	public void Devolucion () {
		String titulo = JOptionPane.showInputDialog("Ingrese el título del libro que se está devolviendo");
		String autor = JOptionPane.showInputDialog("Ingrese el autor del libro que se está devolviendo");
		JOptionPane.showMessageDialog(null, "Se registró la devolución del libro '" + titulo + "'");
		
		this.getLibrosdisponibles().add(new Libro (titulo, autor, true));
	}
	
}
