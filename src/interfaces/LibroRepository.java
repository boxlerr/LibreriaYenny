package interfaces;

import java.util.List;

import modelos.Libro;

public interface LibroRepository {
	//prototipos de metodos 
    List<Libro> getAllLibros(); // llama a todos los libros de la bdd
    
    Libro getLibroById(int idLibro); //llama solo a uno, por su id
    
    void addLibro(Libro libro); //añade libros a la bdd
    
    void updateLibro(Libro libro); //actualiza los libros de la bdd
    
    void deleteLibro(int idLibro); //eliminar libros de la bdd
}
