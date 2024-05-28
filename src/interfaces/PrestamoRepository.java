package interfaces;

import java.util.List;

import modelos.Prestamos;

public interface  PrestamoRepository {
	
	void realizarPrestamo(int idLibro, int idUsuario, int idSucursal);
	void devolverLibro(int idPrestamo);
	List<Prestamos> obtenerListaPrestamos();
}