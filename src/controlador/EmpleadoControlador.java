package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.EmpleadoRepository;
import modelos.Empleado;
import modelos.Usuario;

public class EmpleadoControlador implements EmpleadoRepository {
	private final Connection connection;

    public EmpleadoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
	@Override
	public Empleado getEmpleadoById(Usuario user) {
		Empleado empleado = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM empleado WHERE idUser_fk = ?");
            statement.setInt(1, user.getId());
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                empleado = new Empleado(user.getMail(), user.getContraseña(), user.getTipo(), resultSet.getInt("idEmpleado"), 
                		resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("dni"), resultSet.getInt("idSucursal_fk"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
	}
	
	@Override
	public void addEmpleado(Empleado empleado, Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO empleado (idUser_fk, nombre, apellido, dni, idSucursal_fk) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, usuario.getId());
            statement.setString(2, empleado.getNombre());
            statement.setString(3, empleado.getApellido());
            statement.setInt(4, empleado.getDni());
            statement.setInt(5, empleado.getIdSucursal_fk());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
            	JOptionPane.showMessageDialog(null, "Usuario empleado creado exitosamente");
                System.out.println("Empleado insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
	
	@Override
	public void deleteEmpleado(int id) {
		try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM empleado WHERE idUser_fk = ?");
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
            	JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
                System.out.println("Usuario eliminado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
