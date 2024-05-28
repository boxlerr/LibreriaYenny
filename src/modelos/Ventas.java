package modelos;

import java.time.LocalDate;

public class Ventas {
	
	private int idVenta;
    private int idLibro;
    private int idEmpleado;
    private int cantidad;
    private double valorUnitario;
    private double valorTotal;
    private LocalDate fechaVenta;
    
    public Ventas(int idVenta, int idLibro, int idEmpleado, int cantidad, double valorUnitario, double valorTotal, LocalDate fechaVenta) {
        super();
        this.idVenta = idVenta;
        this.idLibro = idLibro;
        this.idEmpleado = idEmpleado;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.fechaVenta = fechaVenta;
    }
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	@Override
	public String toString() {
		return "Ventas [idVenta=" + idVenta + ", idLibro=" + idLibro + ", idEmpleado=" + idEmpleado + ", cantidad="
				+ cantidad + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + ", fechaVenta="
				+ fechaVenta + "]";
	}	
}
	
	
    
    