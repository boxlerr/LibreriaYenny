package interfaces;

import java.util.List;

import modelos.Gerente;
import modelos.Usuario;

public interface GerenteRepository {
	//prototipos de metodos
	List<Gerente> getAllGerentes();
	
    Gerente getGerenteById(Usuario user); //llama solo a uno, por su id
        
    Gerente updateGerente(Gerente gerente);
    
    void deleteGerente(int id);

	void addGerente(Gerente gerente, Usuario usuario);
}
