package interfaces;

import java.util.List;

import modelos.Prestamos;

public interface  PrestamoRepository {
	
	void devolverLibro(int idPrestamo);
	List<Prestamos> obtenerListaPrestamos();
	void realizarPrestamo(int idLibro, int idSucursal, String nombreCliente, String apellidoCliente);
}