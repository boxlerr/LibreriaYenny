package modelos;

import javax.swing.JOptionPane;

public class Gerente extends Usuario {
	private String cuit;
	private int idsucursal;
	
	public Gerente(String nombre, String apellido, String cuit, int idsucursal) {
		super(nombre, apellido);
		this.cuit = cuit;
		this.idsucursal = idsucursal;

	}
	
	@Override
	public String toString() {
		return "Gerente [cuit=" + cuit + ", idsucursal=" + idsucursal + "]";
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public int getIdsucursal() {
		return idsucursal;
	}

	public void setIdsucursal(int idsucursal) {
		this.idsucursal = idsucursal;
	}


	@Override
	public void Ingreso (String identificador, Biblioteca biblioteca, String apellido) {
		String[] opciones = {"Administrar libros","Administrar cuentas", "Detalles de los libros del inventario", "Salir"};
		int ele=0;
		
		do {
			ele = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones, opciones[0]);
			
			switch (ele) {
			
			case 0:
				String[] opciones1 = {"Agregar libro","Eliminar libro", "Volver"};
				int ele1=0;
				
				ele1 = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones1, opciones1[0]);
				
				switch (ele1) {
				case 0:
					
					break;

				case 1:
					
					break;
				
				case 2:
					
					break;
				}
				
				break;
				
			case 1:
				String[] opciones2 = {"Añadir cuenta","Eliminar cuenta","Editar cuenta", "Volver"};
				int ele2=0;
				
				ele2 = JOptionPane.showOptionDialog(null, "¿Que desea hacer?", "Gerente - " + apellido, 0, 0, null, opciones2, opciones2[0]);
				
				switch (ele2) {
				case 0:
					
					break;

				case 1:
					
					break;
					
				case 2:
					
					break;
				
				case 3:
					
					break;
				}
				
				break;
				
			case 2:
				
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "Gracias por su servicio");
				break;
	
			}
		} while (ele!=3);
	}
}
