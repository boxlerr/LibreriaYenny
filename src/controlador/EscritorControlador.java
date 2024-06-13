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
            	JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
                System.out.println("Escritor insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	
	@Override
	public void deleteEscritor(int idEscritor) {
		try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM escritor WHERE idUser_fk = ?");
            statement.setInt(1, idEscritor);
            
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
