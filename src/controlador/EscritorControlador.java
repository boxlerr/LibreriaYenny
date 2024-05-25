package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import interfaces.EscritorRepository;
import modelos.Escritor;
import modelos.Usuario;

public class EscritorControlador implements EscritorRepository {
	private final Connection connection;

    public EscritorControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
	@Override
	public Escritor getEscritorById(Usuario user) {
		Escritor escritor = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM escritor WHERE idUser_fk = ?");
            statement.setInt(1, user.getId());
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                escritor = new Escritor(user.getMail(), user.getContraseña(), user.getTipo(), resultSet.getInt("idEscritor"), 
                		resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("dni"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return escritor;
	}
	@Override
    public void addEscritor(Usuario usuario, Escritor escritor) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO escritor (idUser_fk, nombre, apellido, dni) VALUES (?, ?, ?, ?)");
            statement.setInt(1, usuario.getId());
            statement.setString(2, escritor.getNombre());
            statement.setString(3, escritor.getApellido());
            statement.setInt(4, escritor.getDni());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
