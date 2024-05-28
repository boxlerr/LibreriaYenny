package modelos;
import java.time.LocalDate;

public class Prestamos {
	private int idPrestamo;
    private int idLibro;
    private int idUsuario;
    private int idSucursal;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    
    public Prestamos(int idPrestamo, int idLibro, int idUsuario, int idSucursal, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
		super();
		this.idPrestamo = idPrestamo;
		this.idPrestamo = idPrestamo;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.idSucursal = idSucursal;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
		
	}
	
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", idLibro=" + idLibro + ", idUsuario=" + idUsuario
				+ ", idSucursal=" + idSucursal + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion="
				+ fechaDevolucion + "]";
	}
	
	
}
