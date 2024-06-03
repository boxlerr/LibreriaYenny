package modelos;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Libro {
	private int idLibro;
	private String titulo;
	private String autor;
	private String genero;
	private int stock;
	private String precio;
	private int idSucursal_fk;	
	private boolean eliminado;
	public Libro(int idLibro, String titulo, String autor, String genero, int stock, String precio, int idSucursal_fk) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.stock = stock;
		this.precio = precio;
		this.idSucursal_fk = idSucursal_fk;
	}
	public Libro(String titulo, String autor, String genero, int stock, String precio, int idSucursal_fk) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.stock = stock;
		this.precio = precio;
		this.idSucursal_fk = idSucursal_fk;
	}
	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero
				+ ", stock=" + stock + ", precio=" + precio + ", idSucursal_fk=" + idSucursal_fk + "]";
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public int getIdSucursal_fk() {
		return idSucursal_fk;
	}
	public void setIdSucursal_fk(int idSucursal_fk) {
		this.idSucursal_fk = idSucursal_fk;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	public static Libro librosEliminados(List<Libro> list) {
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
	
	public static Libro librosEditables(List<Libro> list) {
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
}	
