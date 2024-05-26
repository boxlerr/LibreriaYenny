package interfaces;

import java.util.List;

import modelos.Biblioteca;

public interface libraryRepository {

	//prototipos de metodos 
    List<Biblioteca> getAllLibrarys(); 
    
    Biblioteca getLibraryById(int id); 
    
    Biblioteca getLibraryByNombre(String nombre);
    
    void addLibrary(Biblioteca Library);
    
    void updateLibrary(Biblioteca Library); 
    
    void deleteLibrary(int id);

	
}
