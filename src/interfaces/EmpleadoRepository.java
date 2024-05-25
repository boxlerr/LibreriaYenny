package interfaces;

import modelos.Empleado;
import modelos.Usuario;

public interface EmpleadoRepository {
	//prototipos de metodos     
    Empleado getEmpleadoById(Usuario user); //llama solo a uno, por su id
}