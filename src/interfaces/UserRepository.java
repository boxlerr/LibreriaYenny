package interfaces;


import java.util.List;

import modelos.Usuario;

public interface UserRepository {
	//prototipos de metodos 
    List<Usuario> getAllUsers(); // llama a todos los usuarios de la bdd
    
    Usuario getUserById(String mail, String contraseña); //llama solo a uno, por su id
    
    Usuario getUserById2(int id); //llama solo a uno, por su id
    
    void addUser(Usuario user); //añade usuarios a la bdd
    
    void updateUser(Usuario user); //actualiza los usuarios de la bdd
    
    void deleteUser(int id); //eliminar usuarios de la bdd

	boolean verificarMailValido(String mail2);

	boolean verificarMailExistencia(String mail2);

	boolean verificarContraseñaCaracteres(String contraseña);

	boolean verificarNumeros(String verificacion);

	boolean VerificarDNI(String DNI);
}
