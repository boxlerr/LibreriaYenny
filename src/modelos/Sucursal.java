package modelos;

public class Sucursal {
    private int idSucursal;
    private String nombre;
    private String direccion;

    public Sucursal(int idSucursal, String nombre, String direccion) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
