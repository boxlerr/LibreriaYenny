package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.libraryRepository;
import modelos.Biblioteca;
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
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users ");
	            ResultSet resultSet = statement.executeQuery();
	       
	            while (resultSet.next()) {
	            	Biblioteca library = new Biblioteca(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
	            	librarys.add(library);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
		return null;
	}

	@Override
	public Biblioteca getLibraryById(int id) {
		// TODO Auto-generated method stub
		return null;
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
