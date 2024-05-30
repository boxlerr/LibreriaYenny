package modelos;

import java.time.LocalDate;

public class Prestamos {
    private int idPrestamo;
    private int idLibro;

    private int idSucursal;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String nombreCliente;
    private String apellidoCliente;

    public Prestamos(int idPrestamo, int idLibro, int idSucursal, LocalDate fechaPrestamo, LocalDate fechaDevolucion, String nombreCliente, String apellidoCliente) {
        super();
        this.idPrestamo = idPrestamo;
        this.idLibro = idLibro;

        this.idSucursal = idSucursal;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    @Override
    public String toString() {
        return "Prestamo [idPrestamo=" + idPrestamo + ", idLibro=" + idLibro + ", idUsuario=" 
                + ", idSucursal=" + idSucursal + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion="
                + fechaDevolucion + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + "]";
    }
}
