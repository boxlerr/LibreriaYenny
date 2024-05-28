package interfaces;

public interface  PrestamoRepository {
	
	void realizarPrestamo(int idLibro, int idUsuario, int idSucursal);
	void devolverLibro(int idPrestamo);
}