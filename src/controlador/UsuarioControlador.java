package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfaces.UserRepository;
import modelos.Usuario;

public class UsuarioControlador implements UserRepository {
    private final Connection connection;

    public UsuarioControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Usuario user = new Usuario(resultSet.getInt("id"), resultSet.getString("mail"), resultSet.getString("contraseña"), resultSet.getString("tipo"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Usuario getUserById(String mail, String contraseña) {
        Usuario user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE mail = ? and contraseña = ?");
            statement.setString(1, mail);
            statement.setString(2, contraseña);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new Usuario(resultSet.getInt("id"), resultSet.getString("mail"), resultSet.getString("contraseña"), resultSet.getString("tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    @Override
    public Usuario getUserById2(int id) {
        Usuario user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new Usuario(resultSet.getInt("id"), resultSet.getString("mail"), resultSet.getString("contraseña"), resultSet.getString("tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

	@Override
    public void addUser(Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (mail, contraseña, tipo) VALUES (?, ?, ?)");
            statement.setString(1, usuario.getMail());
            statement.setString(2, usuario.getContraseña());
            statement.setString(3, usuario.getTipo());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
            	
                System.out.println("Usuario insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
    public void updateUser(Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET mail = ?, contraseña = ?, tipo = ? WHERE id = ?");
            statement.setString(1, usuario.getMail());
            statement.setString(2, usuario.getContraseña());
            statement.setString(3, usuario.getTipo());
            statement.setInt(4, usuario.getId());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario actualizado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuario eliminado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
	public boolean verificarMailExistencia(String mail) {
				String mails = "";
				for (int i = 0; i < this.getAllUsers().size(); i++) {
					mails = mails + this.getAllUsers().get(i).getMail();
				}
				
				if (mails.contains(mail)) {
					return false;
				} else {
					return true;

				}
		}
    @Override
	public boolean verificarMailValido(String mail) {
    	if (mail.contains("@") && mail.contains(".")) {
    		return true;
		} else {
			return false;
		}
		
	}
    public boolean verificarMailTest(String mail2) {
    	boolean retorno = true;
				String mails = "";
				for (int i = 0; i < this.getAllUsers().size(); i++) {
					mails = mails + this.getAllUsers().get(i).getMail();
				}
				
				if (mail2.contains("@") && mail2.contains(".")) {
					if (mails.contains(mail2)) {
						retorno = false;
					}
				} else {
					retorno = false;
				}
			return retorno;
		
		}
    
    @Override
	public boolean verificarContraseñaCaracteres(String contraseña) {
    					
				if (contraseña.length()<6) {
					return false;
				} 
				return true;
				
		
		}
    
    @Override
	public boolean verificarNumeros(String verificacion) {
    					
    	if (!verificacion.contains("1")&&!verificacion.contains("2")&&!verificacion.contains("3")&&!verificacion.contains("4")&&!verificacion.contains("5")&&!verificacion.contains("6")&&!verificacion.contains("7")&&!verificacion.contains("8")&&!verificacion.contains("9")) {
					return false;
				} 
				return true;
				
		
		}
    
    public boolean verificarContraseñaTest(String contraseña2) {
    	boolean retorno = true;
				
				if (contraseña2.isBlank()) {
					retorno = false;
				} else if (contraseña2.length()<6) {
					retorno = false;
				} else if (!contraseña2.contains("1")&&!contraseña2.contains("2")&&!contraseña2.contains("3")&&!contraseña2.contains("4")&&!contraseña2.contains("5")&&!contraseña2.contains("6")&&!contraseña2.contains("7")&&!contraseña2.contains("8")&&!contraseña2.contains("9")) {
					retorno = false;
				} else {
				}
				
			return retorno;
		
		}
    
    @Override
	public boolean VerificarDNI(String DNI) {
		if (DNI.length()==8) {
			for (int i = 0; i < DNI.length(); i++) {
	            if (Character.isLetter(DNI.charAt(i))) {
	                return false;
	            }
	        }
			return true;
		} else {
			return false;
		}
		
	}
  
}
