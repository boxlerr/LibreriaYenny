package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfaces.GerenteRepository;
import modelos.Gerente;
import modelos.Usuario;

public class GerenteControlador implements GerenteRepository {
	private final Connection connection;

    public GerenteControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
    @Override
    public List<Gerente> getAllGerentes() {
        List<Gerente> gerentes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Gerente gerente = new Gerente(resultSet.getString("mail"), resultSet.getString("contraseña"), resultSet.getString("tipo"), 
            			resultSet.getInt("idGerente"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("dni"), resultSet.getInt("idSucursal_fk"));
            	gerentes.add(gerente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gerentes;
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
	
	@Override
    public void addGerente(Gerente gerente, Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO gerente (idUser_fk, nombre, apellido, dni, idSucursal_fk) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, usuario.getId());
            statement.setString(2, gerente.getNombre());
            statement.setString(3, gerente.getApellido());
            statement.setInt(4, gerente.getDni());
            statement.setInt(5, gerente.getIdSucursal_fk());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
            	JOptionPane.showMessageDialog(null, "Usuario gerente creado exitosamente");
                System.out.println("Gerente insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

	@Override
	public Gerente updateGerente(Gerente gerente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGerente(int id) {
		try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM gerente WHERE idUser_fk = ?");
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
