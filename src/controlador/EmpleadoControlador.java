package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
