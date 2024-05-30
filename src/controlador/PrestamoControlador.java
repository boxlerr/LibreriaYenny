package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.PrestamoRepository;
import modelos.Prestamos;

public class PrestamoControlador implements PrestamoRepository {
    
    private final Connection connection;

    public PrestamoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void realizarPrestamo(int idLibro, int idSucursal, String nombreCliente, String apellidoCliente) {
        try {
            connection.setAutoCommit(false); 
            PreparedStatement ps = connection.prepareStatement("INSERT INTO prestamos (idLibro, idSucursal_fk, Nombre_cliente, Apellido_cliente, fechaPrestamo) VALUES (?, ?, ?, ?, NOW())");
            ps.setInt(1, idLibro);
            ps.setInt(2, idSucursal);
            ps.setString(3, nombreCliente);
            ps.setString(4, apellidoCliente);
            ps.executeUpdate();
            PreparedStatement psUpdate = connection.prepareStatement("UPDATE libro SET stock = stock - 1 WHERE idLibro = ?");
            psUpdate.setInt(1, idLibro);
            psUpdate.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback(); 
            } catch (SQLException e) {
                Logger.getLogger(PrestamoControlador.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(PrestamoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void devolverLibro(int idPrestamo) {
        try {
            connection.setAutoCommit(false); 
            PreparedStatement psSelect = connection.prepareStatement("SELECT idLibro FROM prestamos WHERE idPrestamo = ?");
            psSelect.setInt(1, idPrestamo);
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                int idLibro = rs.getInt("idLibro");
                PreparedStatement ps = connection.prepareStatement("UPDATE prestamos SET fechaDevolucion = NOW() WHERE idPrestamo = ?");
                ps.setInt(1, idPrestamo);
                ps.executeUpdate();
                PreparedStatement psUpdate = connection.prepareStatement("UPDATE libro SET stock = stock + 1 WHERE idLibro = ?");
                psUpdate.setInt(1, idLibro);
                psUpdate.executeUpdate();
                connection.commit();
            }
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                Logger.getLogger(PrestamoControlador.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(PrestamoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Prestamos> obtenerListaPrestamos() {
        List<Prestamos> listaPrestamos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM prestamos")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Prestamos prestamo = new Prestamos(rs.getInt("idPrestamo"), rs.getInt("idLibro"), rs.getInt("idSucursal_fk"), rs.getDate("fechaPrestamo").toLocalDate(), rs.getDate("fechaDevolucion") != null ? rs.getDate("fechaDevolucion").toLocalDate() : null, rs.getString("Nombre_cliente"), rs.getString("Apellido_cliente"));
                listaPrestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPrestamos;
    }
}