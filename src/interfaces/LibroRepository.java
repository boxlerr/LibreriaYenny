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
    
    void addLibro(Libro libro); //añade libros a la bdd
    
    void updateLibro(Libro libro); //actualiza los libros de la bdd
    
    void deleteLibro(int id); //eliminar libros de la bdd
    
    double obtenerPrecioLibro(int id);

	int obtenerCantidadDisponible(int id);

}
