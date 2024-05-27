	package controlador;
	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	
	import javax.swing.JOptionPane;
	
	import interfaces.LibroRepository;
	import modelos.Libro;
	
	public class LibroControlador implements LibroRepository {
	    private final Connection connection;
	
	    public LibroControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }
	
	    @Override
	    public List<Libro> getAllLibros() {
	        List<Libro> libros = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM libro");
	            ResultSet resultSet = statement.executeQuery();
	       
	            while (resultSet.next()) {
	            	Libro libro = new Libro(resultSet.getInt("idLibro"), resultSet.getString("titulo"), resultSet.getString("autor"), 
	            			resultSet.getString("genero"), resultSet.getInt("stock"), resultSet.getInt("precio"), resultSet.getInt("idSucursal_fk"));
	                libros.add(libro);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return libros;
	    }
	    
	    @Override
	    public Libro getLibroById(int id) {
	        Libro libro = null;
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM libro WHERE idLibro = ?");
	            statement.setInt(1, id);
	            ResultSet resultSet = statement.executeQuery();
	       
	            while (resultSet.next()) {
	            	libro = new Libro(resultSet.getInt("idLibro"), resultSet.getString("titulo"), resultSet.getString("autor"), 
	            			resultSet.getString("genero"), resultSet.getInt("stock"), resultSet.getInt("precio"), resultSet.getInt("idSucursal_fk"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return libro;
	    }
	
	//    @Override
	//    public Usuario getUserById(String mail, String contraseña) {
	//        Usuario user = null;
	//        try {
	//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE mail = ? and contraseña = ?");
	//            statement.setString(1, mail);
	//            statement.setString(2, contraseña);
	//            
	//            ResultSet resultSet = statement.executeQuery();
	//            
	//            if (resultSet.next()) {
	//                user = new Usuario(resultSet.getInt("id"), resultSet.getString("mail"), resultSet.getString("contraseña"), resultSet.getString("tipo"));
	//            }
	//        } catch (SQLException e) {
	//            e.printStackTrace();
	//        }
	//        return user;
	//    }
	//
	//	@Override
	//    public void addUser(Usuario usuario) {
	//        try {
	//            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (mail, contraseña, tipo) VALUES (?, ?, ?)");
	//            statement.setString(1, usuario.getMail());
	//            statement.setString(2, usuario.getContraseña());
	//            statement.setString(3, usuario.getTipo());
	//            
	//            int rowsInserted = statement.executeUpdate();
	//            if (rowsInserted > 0) {
	//            	JOptionPane.showMessageDialog(null, "Su usuario se creó correctamente");
	//                System.out.println("Usuario insertado exitosamente");
	//            }
	//        } catch (SQLException e) {
	//            e.printStackTrace();
	//        }
	//    }
	//
	//	@Override
	//    public void updateUser(Usuario usuario) {
	//        try {
	//            PreparedStatement statement = connection.prepareStatement("UPDATE users SET mail = ?, contraseña = ? WHERE id = ?");
	//            statement.setString(1, usuario.getMail());
	//            statement.setString(2, usuario.getContraseña());
	//            statement.setString(3, usuario.getTipo());
	//            statement.setInt(3, usuario.getId());
	//            
	//            int rowsUpdated = statement.executeUpdate();
	//            if (rowsUpdated > 0) {
	//                System.out.println("Usuario actualizado exitosamente");
	//            }
	//        } catch (SQLException e) {
	//            e.printStackTrace();
	//        }
	//    }
	//
	//    @Override
	//    public void deleteUser(int id) {
	//        try {
	//            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
	//            statement.setInt(1, id);
	//            
	//            int rowsDeleted = statement.executeUpdate();
	//            if (rowsDeleted > 0) {
	//                System.out.println("Usuario eliminado exitosamente");
	//            }
	//        } catch (SQLException e) {
	//            e.printStackTrace();
	//        }
	//    }
	
		@Override
		public void addLibro(Libro libro) {
			try {
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO libro (titulo, autor, genero, stock, precio, idSucursal_fk) VALUES (?, ?, ?, ?, ?, ?)");
	            statement.setString(1, libro.getTitulo());
	            statement.setString(2, libro.getAutor());
	            statement.setString(3, libro.getGenero());
	            statement.setInt(4, libro.getStock());
	            statement.setInt(5, libro.getPrecio());
	            statement.setInt(6, libro.getIdSucursal_fk());
	            
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	            	JOptionPane.showMessageDialog(null, "Libro añadido exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	
		@Override
		public void updateLibro(Libro libro) {
			try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE libro SET titulo = ?, autor= ?, genero = ?, stock = ?, precio = ?, idSucursal_fk = ? WHERE idLibro = ?");
	            statement.setString(1, libro.getTitulo());
	            statement.setString(2, libro.getAutor());
	            statement.setString(3, libro.getGenero());
	            statement.setInt(4, libro.getStock());
	            statement.setInt(5, libro.getPrecio());
	            statement.setInt(6, libro.getIdSucursal_fk());
	            statement.setInt(7, libro.getIdLibro());
	            
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	            	JOptionPane.showMessageDialog(null, "Libro actualizado exitosamente");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	
		@Override
		public void deleteLibro(int idLibro) {
			try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM libro WHERE idLibro = ?");
	            statement.setInt(1, idLibro);
	            
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	            	JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	
	
	  
	}
