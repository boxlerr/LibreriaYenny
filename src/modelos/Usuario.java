package modelos;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	public Usuario(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public void Ingreso(String identificador, Biblioteca biblioteca, String ape) {
		
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public boolean IniciarSesion(String nombre,String apellido) {
		if (nombre.length()>=4 && apellido.length()>=4) {
				
			if (this.getApellido().equals(apellido)){
				if( this.getNombre().equals(nombre)) {
					return true;
				} else {
					//Error nombre
					return false;
				}
						
			} else {
				//Error apellido
				return false;
			}
		} else {
			return false;
	
		}
	}
	
}
