package vista;
import javax.swing.JOptionPane;
import org.hamcrest.core.StringContains;
import com.mysql.jdbc.Connection;
import controlador.*;
import modelos.*;

class Main {

	public static void main(String[] args) {
		
		
		DatabaseConnection.getInstance().getConnection();
		
		UsuarioControlador usuarioControlador = new UsuarioControlador();
		GerenteControlador gerenteControlador = new GerenteControlador();
		EmpleadoControlador empleadoControlador = new EmpleadoControlador();
		EscritorControlador escritorControlador = new EscritorControlador();
		LibroControlador libroControlador = new LibroControlador();
		BibliotecaControlador bibliotecaControlador = new BibliotecaControlador();
		
		
		int inicio;
		do {
		String[] opciones = {"Iniciar sesión","Crear cuenta","Salir"};
		
			
		inicio = JOptionPane.showOptionDialog(null, "Bienvenido a la librería", "Librería", 0, 0, null, opciones, opciones[0]);
		
		
			switch (inicio) {
			case 0:
				JOptionPane.showMessageDialog(null, "Iniciar sesion");
				String mail = JOptionPane.showInputDialog("Ingrese su mail");
				String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña");
				
				if (usuarioControlador.getUserById(mail, contraseña)!=null) {
					switch (usuarioControlador.getUserById(mail, contraseña).getTipo()) {
					case "gerente":
						
						JOptionPane.showMessageDialog(null, "Ingresa como gerente: " + gerenteControlador.getGerenteById(usuarioControlador.getUserById(mail, contraseña)));
						gerenteControlador.getGerenteById(usuarioControlador.getUserById(mail, contraseña)).Ingreso(libroControlador, bibliotecaControlador, usuarioControlador, gerenteControlador, empleadoControlador, escritorControlador);
						break;
					case "empleado":
						JOptionPane.showMessageDialog(null, "Ingresa como empleado: " + empleadoControlador.getEmpleadoById(usuarioControlador.getUserById(mail, contraseña)));
						empleadoControlador.getEmpleadoById(usuarioControlador.getUserById(mail, contraseña)).Ingreso(libroControlador, bibliotecaControlador, usuarioControlador, gerenteControlador, empleadoControlador, escritorControlador);
						break;
					case "escritor":
						JOptionPane.showMessageDialog(null, "Ingresa como escritor: " + escritorControlador.getEscritorById(usuarioControlador.getUserById(mail, contraseña)));
						escritorControlador.getEscritorById(usuarioControlador.getUserById(mail, contraseña)).Ingreso(libroControlador, bibliotecaControlador, usuarioControlador, gerenteControlador, empleadoControlador, escritorControlador);
						break;
					case "cliente":
						JOptionPane.showMessageDialog(null, "No se puede ingresar con cuentas cliente");
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ese usuario no se encuentra registrado, mail o contraseña incorrecta");
				}
				
				
				break;
					
			case 1:
				
				String mail2 = "";
				//mail2=usuarioControlador.verificarMail(mail2);
				
				String contraseña2 = "";
//				contraseña2=usuarioControlador.verificarContraseña(contraseña2);
				
				
				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				String apellido = JOptionPane.showInputDialog("Ingrese apellido");
				int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni"));
				
				usuarioControlador.addUser(new Usuario(mail2, contraseña2, "Escritor"));
				escritorControlador.addEscritor(usuarioControlador.getUserById(mail2, contraseña2), new Escritor(mail2, contraseña2, "Escritor", nombre, apellido, dni));
				
				break;
					
			case 2:
					
				break;
					
			}
		} while (inicio!=2);

	}

}
