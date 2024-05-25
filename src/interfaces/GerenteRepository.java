package interfaces;

import java.util.List;

import modelos.Gerente;
import modelos.Usuario;

public interface GerenteRepository {
	//prototipos de metodos     
    Gerente getGerenteById(Usuario user); //llama solo a uno, por su id
    
}
