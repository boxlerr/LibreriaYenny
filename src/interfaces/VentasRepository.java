package interfaces;


import java.util.List;
import modelos.Ventas;

public interface VentasRepository {
	
	boolean verificarDisponibilidadLibro(int idLibro);
	int obtenerCantidadDisponible(int idLibro);
	boolean registrarVenta(Ventas venta);
	List<Ventas> obtenerVentasEmpleado(int idEmpleado);
	List<Ventas> obtenerVentasSucursal(int idSucursal);
	List<Ventas> obtenerListaVentas();
	boolean deleteVenta(int id);
	boolean updateVenta(Ventas updateVenta);

}