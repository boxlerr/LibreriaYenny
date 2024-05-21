package modelos;

public class Gerente extends Usuario {
	private String cuit;
	private int idsucursal;
	
	public Gerente(String nombre, String apellido, String cuit, int idsucursal) {
		super(nombre, apellido);
		this.cuit = cuit;
		this.idsucursal = idsucursal;

	}
	

}
