package modelos;
import java.time.LocalDate;

public class Prestamo {
	private String libro;
	private String nombre;
	private String apellido;
	private String idprestatario;
	private LocalDate fecha;
	public Prestamo(String libro, String nombre, String apellido, String idprestatario, LocalDate fecha) {
		super();
		this.libro = libro;
		this.nombre = nombre;
		this.apellido = apellido;
		this.idprestatario = idprestatario;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Prestamo del libro=" + libro + "NombrePrestatario=" + nombre + ", ApellidoPrestatario=" + apellido + ", ID prestatario="
				+ idprestatario + ", fecha=" + fecha + "]\n---------------\n";
	}
	public String getLibro() {
		return libro;
	}
	public void setLibro(String libro) {
		this.libro = libro;
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
	public String getIdprestatario() {
		return idprestatario;
	}
	public void setIdprestatario(String idprestatario) {
		this.idprestatario = idprestatario;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
