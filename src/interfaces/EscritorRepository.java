package interfaces;

import modelos.Escritor;
import modelos.Usuario;

public interface EscritorRepository {
	
	Escritor getEscritorById (Usuario user);
	
	void addEscritor(Usuario usuario, Escritor escritor); 
}
