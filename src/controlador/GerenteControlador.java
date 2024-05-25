package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.GerenteRepository;
import modelos.Gerente;
import modelos.Usuario;

public class GerenteControlador implements GerenteRepository {
	private final Connection connection;

    public GerenteControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
	@Override
	public Gerente getGerenteById(Usuario user) {
		Gerente gerente = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gerente WHERE idUser_fk = ?");
            statement.setInt(1, user.getId());
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                gerente = new Gerente(user.getMail(), user.getContraseña(), user.getTipo(), resultSet.getInt("idGerente"), 
                		resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("dni"), resultSet.getInt("idSucursal_fk"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gerente;
	}

}
