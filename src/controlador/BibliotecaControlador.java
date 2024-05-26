package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.libraryRepository;
import modelos.Biblioteca;
import modelos.Libro;
import modelos.Usuario;

public class BibliotecaControlador implements libraryRepository{
	private final Connection connection;

    public BibliotecaControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public List<Biblioteca> getAllLibrarys() {
		   List<Biblioteca> librarys = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
	            ResultSet resultSet = statement.executeQuery();
	       
	            while (resultSet.next()) {
	            	Biblioteca library = new Biblioteca(resultSet.getInt("idSucursal"), resultSet.getString("nombre"), resultSet.getString("direccion"));
	            	librarys.add(library);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return librarys;
	}

	@Override
	public Biblioteca getLibraryById(int id) {
		Biblioteca biblioteca = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM biblioteca WHERE idSucursal = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	biblioteca = new Biblioteca(resultSet.getInt("idSucursal"), resultSet.getString("nombre"), resultSet.getString("dirección"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biblioteca;
    }
	
	@Override
	public Biblioteca getLibraryByNombre(String nombre) {
		Biblioteca biblioteca = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM biblioteca WHERE nombre = ?");
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	biblioteca = new Biblioteca(resultSet.getInt("idSucursal"), resultSet.getString("nombre"), resultSet.getString("dirección"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biblioteca;
    }

	@Override
	public void addLibrary(Biblioteca Library) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLibrary(Biblioteca Library) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLibrary(int id) {
		// TODO Auto-generated method stub
		
	}
}
