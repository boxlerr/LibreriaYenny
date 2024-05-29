package vista;
import javax.swing.JOptionPane;

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
//				String[] usuarios = new String[usuarioControlador.getAllUsers().size()];
//				for (int i = 0; i < usuarios.length; i++) {
//					usuarios[i] = usuarioControlador.getAllUsers().get(i).toString();
//				}
//				JOptionPane.showMessageDialog(null, usuarios);
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
				String mail2 = JOptionPane.showInputDialog("Ingrese mail");
				String contraseña2 = JOptionPane.showInputDialog("Ingrese contraseña");
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
		

		
//		do {
//			
//			inicio = JOptionPane.showOptionDialog(null, "Bienvenido a la librería", "Librería", 0, 0, null, opciones, opciones[0]);
//				
//			switch (inicio) {
//			case 0:
//				
//				JOptionPane.showMessageDialog(null, "Ingresa como gerente");
//				String usuario1 = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
//				String ape1 = JOptionPane.showInputDialog("Ingrese su apellido");
//				String cuit = JOptionPane.showInputDialog("Ingrese su cuit");
//				
//				Gerente gerente = new Gerente (usuario1, ape1, cuit, 0);
//				gerente.Ingreso(cuit, biblioteca, ape1);
//				
//				break;
//				
//			case 1:
//				//login admin: admin - 1234
//				JOptionPane.showMessageDialog(null, "Ingresa como empleado");
//				String ape = JOptionPane.showInputDialog("Ingrese su apellido");
//				
//				int intentos=3;
//				
//					do {
//						String usuario = JOptionPane.showInputDialog("Ingrese nombre de usuario");
//						String contraseña =JOptionPane.showInputDialog("Ingrese contraseña");
//						if (contraseña.equals("1234")&&usuario.equals("admin")) {
//							Empleado empleado = new Empleado (usuario, ape, contraseña);
//							empleado.Ingreso(contraseña, biblioteca, ape);
//							intentos=0;
//						} else {
//							intentos--;
//							JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecta \nIntentos restantes " + intentos);
//						}
//					} while (intentos>0);
//				break;
//				
//			case 2:
//				JOptionPane.showMessageDialog(null, "Ingresa como cliente");
//				String nombre2 = JOptionPane.showInputDialog("Ingrese su nombre");
//				String ape2 = JOptionPane.showInputDialog("Ingrese su apellido");
//				String indentificador2 =JOptionPane.showInputDialog("Ingrese su indentificador");
//				Cliente cliente = new Cliente (nombre2, ape2, indentificador2);
//				cliente.Ingreso(indentificador2, biblioteca, ape2);
//				break;
//				
//			case 3:
//				JOptionPane.showMessageDialog(null, "Préstamos realizados:\n" + biblioteca.getPrestamos());
//				JOptionPane.showMessageDialog(null, "Libros disponibles:\n" + biblioteca.getLibrosdisponibles());
//				JOptionPane.showMessageDialog(null, "Se cierra el sistema por hoy, que tenga buena noche!");
//				break;
//			}
//		} while (inicio!=3);

	}

}
