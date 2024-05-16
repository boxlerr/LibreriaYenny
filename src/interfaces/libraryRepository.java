package interfaces;

import java.util.List;

import modelos.Biblioteca;

public interface libraryRepository {

	//prototipos de metodos 
    List<Biblioteca> getAllLibrarys(); // llama a todos los usuarios de la bdd
    
    Biblioteca getLibraryById(int id); //llama solo a uno, por su id
    
    void addLibrary(Biblioteca Library); //añade usuarios a la bdd
    
    void updateLibrary(Biblioteca Library); //actualiza los usuarios de la bdd
    
    void deleteLibrary(int id); //eliminar usuarios de la bdd
}
