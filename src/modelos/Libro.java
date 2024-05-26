package modelos;

public class Libro {
	private int idLibro;
	private String titulo;
	private String autor;
	private String genero;
	private int stock;
	private int idSucursal_fk;
	public Libro(int idLibro, String titulo, String autor, String genero, int stock, int idSucursal_fk) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.stock = stock;
		this.idSucursal_fk = idSucursal_fk;
	}
	public Libro(String titulo, String autor, String genero, int stock, int idSucursal_fk) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.stock = stock;
		this.idSucursal_fk = idSucursal_fk;
	}
	
	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero
				+ ", stock=" + stock + ", idSucursal_fk=" + idSucursal_fk + "]";
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
	public int getIdSucursal_fk() {
		return idSucursal_fk;
	}
	public void setIdSucursal_fk(int idSucursal_fk) {
		this.idSucursal_fk = idSucursal_fk;
	}
	
	
	
	
}	
