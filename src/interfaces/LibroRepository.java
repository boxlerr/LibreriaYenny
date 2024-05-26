package interfaces;

import java.util.List;

import modelos.Libro;

public interface LibroRepository {
	//prototipos de metodos 
    List<Libro> getAllLibros(); // llama a todos los libros de la bdd
    
    Libro getLibroById(int id); //llama solo a uno, por su id
    
    List<Libro> getLibrosBySucursal(int idsucursal); 
    
    Libro getLibroByTitulo(String titulo); //llama solo a uno, por su titulo
    
    List<Libro> getLibrosByAutor(String autor); 
    
    List<Libro> getLibrosByGenero(String genero); 
    
    void addLibro(); //añade libros a la bdd
    
    void updateLibro(); //actualiza los libros de la bdd
    
    void deleteLibro(); //eliminar libros de la bdd
}
