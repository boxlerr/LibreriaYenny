package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import controlador.VentasControlador;


public class TestEmpleado {
	@Test
	public void verificarDisponibilidadLibroTest() throws SQLException {
	    VentasControlador controlador = new VentasControlador();

	    boolean flag = false;
	    if (controlador.verificarDisponibilidadLibro(2)) {
	        flag = true;
	    }
	    assertEquals(true, flag);
	}

@Test
public void verificarNoDisponibilidadLibroTest() throws SQLException {
    VentasControlador controlador = new VentasControlador();
 
    boolean flag = false;
    if (!controlador.verificarDisponibilidadLibro(7857)) { 
        flag = true;
    }
    assertEquals(true, flag);
}

//tengo sueño no hago mas
}