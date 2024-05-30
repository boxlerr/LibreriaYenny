package interfaces;

import modelos.Empleado;
import modelos.Usuario;

public interface EmpleadoRepository {
	
    Empleado getEmpleadoById(Usuario user);
    void addEmpleado(Empleado empleado, Usuario usuario);
    void deleteEmpleado(int id);
}
