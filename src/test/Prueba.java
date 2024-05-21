package test;
import java.util.Iterator;
import org.junit.Test;
import modelos.*;
import controlador.UsuarioControlador;
import vista.*;
public class Prueba {
	
@Test
public void PruebaIniciarSesionV(){
	UsuarioControlador controlador = new UsuarioControlador();
	boolean flag;
	for (Usuario usuario: controlador.getAllUsers()) {
		
		if (Usuario.Ingreso("","","")==true) {
			flag=true;
			break;
		} else {

		}
		
		
	}
}
}
