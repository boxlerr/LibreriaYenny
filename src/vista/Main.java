package vista;
import javax.swing.JOptionPane;

import controlador.DatabaseConnection;
import modelos.*;

class Main {

	public static void main(String[] args) {
		
		
		 DatabaseConnection.getInstance().getConnection();
		
		
		Libro harrypotter = new Libro ("Harry Potter", "J. K. Rowling", true);
		Libro señordelosanillos = new Libro ("El señor de los anillos", "Tolkien", true);
		Libro gaturro = new Libro ("Gaturro", "Nick", true);
		Libro ryj = new Libro ("Romeo y Julieta", "Shakespeare", true);
		Libro hamlet = new Libro ("Hamlet", "Shakespeare", true);
		
		
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.getLibrosdisponibles().add(harrypotter);
		biblioteca.getLibrosdisponibles().add(señordelosanillos);
		biblioteca.getLibrosdisponibles().add(gaturro);
		biblioteca.getLibrosdisponibles().add(ryj);
		biblioteca.getLibrosdisponibles().add(hamlet);
		
		
		
		String[] opciones = {"Empleado","Cliente","Terminar el día"};
		int inicio;
		
		do {
			
			inicio = JOptionPane.showOptionDialog(null, "Bienvenido a la librería. \nElija con que rol desea iniciar el programa", "Librería", 0, 0, 
					null, opciones, opciones[0]);
				
			switch (inicio) {
			case 0:
				//login admin: admin - 1234
				JOptionPane.showMessageDialog(null, "Ingresa como empleado");
				String ape = JOptionPane.showInputDialog("Ingrese su apellido");
				
				int intentos=3;
				
				
					do {
						String usuario = JOptionPane.showInputDialog("Ingrese nombre de usuario");
						String contraseña =JOptionPane.showInputDialog("Ingrese contraseña");
						if (contraseña.equals("1234")&&usuario.equals("admin")) {
							Empleado empleado = new Empleado (usuario, ape, contraseña);
							empleado.Ingreso(contraseña, biblioteca, ape);
							intentos=0;
						} else {
							intentos--;
							JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecta \nIntentos restantes " + intentos);
						}
					} while (intentos>0);
				break;
				
			case 1:
				JOptionPane.showMessageDialog(null, "Ingresa como cliente");
				String nombre2 = JOptionPane.showInputDialog("Ingrese su nombre");
				String ape2 = JOptionPane.showInputDialog("Ingrese su apellido");
				String indentificador2 =JOptionPane.showInputDialog("Ingrese su indentificador");
				Cliente cliente = new Cliente (nombre2, ape2, indentificador2);
				cliente.Ingreso(indentificador2, biblioteca, ape2);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Préstamos realizados:\n" + biblioteca.getPrestamos());
				JOptionPane.showMessageDialog(null, "Libros disponibles:\n" + biblioteca.getLibrosdisponibles());
				JOptionPane.showMessageDialog(null, "Se cierra el sistema por hoy, que tenga buena noche!");
				break;
			}
		} while (inicio!=2);

	}

}
