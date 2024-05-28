package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.PrestamoRepository;


public class PrestamoControlador implements PrestamoRepository {
	
	private final Connection connection;

    public PrestamoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void realizarPrestamo(int idLibro, int idUsuario, int idSucursal) {

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO prestamos (idLibro, idUsuario, idSucursal_fk, fechaPrestamo) VALUES (?, ?, ?, NOW())");
            ps.setInt(1, idLibro);
            ps.setInt(2, idUsuario);
            ps.setInt(3, idSucursal);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoControlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            	connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrestamoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void devolverLibro(int idPrestamo) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE prestamos SET fechaDevolucion = NOW() WHERE idPrestamo = ?");
            ps.setInt(1, idPrestamo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoControlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            	connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrestamoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
