package interfaces;

import java.util.List;

import modelos.Gerente;
import modelos.Usuario;

public interface GerenteRepository {
	//prototipos de metodos
	List<Gerente> getAllGerentes();
	
    Gerente getGerenteById(Usuario user); //llama solo a uno, por su id
    
    Gerente addGerente(Gerente gerente);
    
    Gerente updateGerente(Gerente gerente);
    
    Gerente deleteGerente(Gerente gerente);

	void addGerente(Gerente gerente, Usuario usuario);
}
