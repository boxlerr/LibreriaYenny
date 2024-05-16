package modelos;

public class Libro {
	private String titulo;
	private String autor;
	private boolean disponible;
	
	public Libro(String titulo, String autor, boolean disponible) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.disponible = disponible;
	}


	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", disponible=" + disponible + "]\n";
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


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
}	
