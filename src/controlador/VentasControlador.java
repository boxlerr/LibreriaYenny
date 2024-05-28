package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.VentasRepository;
import modelos.Ventas;

public class VentasControlador implements VentasRepository {
	
	private final Connection connection;

	public VentasControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
	
	@Override
	public boolean verificarDisponibilidadLibro(int idLibro) {
		try (PreparedStatement stmt = connection.prepareStatement("SELECT stock FROM libro WHERE idLibro = ?")) {
            stmt.setInt(1, idLibro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int stock = rs.getInt("stock");
                return stock > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false; 
	}

	@Override
	public int obtenerCantidadDisponible(int idLibro) {
		try (PreparedStatement stmt = connection.prepareStatement("SELECT stock FROM libro WHERE idLibro = ?")) {
            stmt.setInt(1, idLibro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("stock"); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
	}

	@Override
	public boolean registrarVenta(Ventas venta) {
		String query = "INSERT INTO ventas (idLibro, idEmpleado, cantidad, valorUnitario, valorTotal, fechaVenta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {stmt.setInt(1, venta.getIdLibro());stmt.setInt(2, venta.getIdEmpleado());stmt.setInt(3, venta.getCantidad());stmt.setDouble(4, venta.getValorUnitario());stmt.setDouble(5, venta.getValorTotal());
            stmt.setDate(6, java.sql.Date.valueOf(venta.getFechaVenta()));
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                int nuevoStock = obtenerCantidadDisponible(venta.getIdLibro()) - venta.getCantidad();
                actualizarStockLibro(venta.getIdLibro(), nuevoStock);
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
	}

	@Override
	public List<Ventas> obtenerVentasEmpleado(int idEmpleado) {
		List<Ventas> ventasEmpleado = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ventas WHERE idEmpleado = ?")) {
            stmt.setInt(1, idEmpleado);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ventas venta = new Ventas(rs.getInt("idVenta"),rs.getInt("idLibro"),rs.getInt("idEmpleado"),rs.getInt("cantidad"),rs.getDouble("valorUnitario"),rs.getDouble("valorTotal"),rs.getDate("fechaVenta").toLocalDate()
                );
                ventasEmpleado.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ventasEmpleado;
	}

	@Override
	public List<Ventas> obtenerVentasSucursal(int idSucursal) {
		List<Ventas> ventasSucursal = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ventas JOIN empleado ON ventas.idEmpleado = empleado.idEmpleado WHERE empleado.idSucursal_fk = ?")) {
            stmt.setInt(1, idSucursal);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ventas venta = new Ventas(rs.getInt("idVenta"),rs.getInt("idLibro"),rs.getInt("idEmpleado"),rs.getInt("cantidad"),rs.getDouble("valorUnitario"),rs.getDouble("valorTotal"),rs.getDate("fechaVenta").toLocalDate()
                );
                ventasSucursal.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ventasSucursal;
	}
	
	private void actualizarStockLibro(int idLibro, int nuevoStock) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE libro SET stock = ? WHERE idLibro = ?")) {
            stmt.setInt(1, nuevoStock);
            stmt.setInt(2, idLibro);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
