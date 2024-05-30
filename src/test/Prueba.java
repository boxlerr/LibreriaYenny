package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.Usuario;
import controlador.UsuarioControlador;

public class Prueba {
	
	//no hay que hacer un test para todo, lo mas sencillo y/o repetitivo no hace falta. Para probar al principio si.
	//con lo mas importante de caso de uso habria que hacerlo, verificar si los errores andan
	
//	@Test
//	public void PruebaIniciarSesionV() {
//		UsuarioControlador controlador = new UsuarioControlador();
//		boolean flag=false;
//		
//		for (Usuario users : controlador.getAllUsers()) {
//			
//								//nombre que SI existe en la BBDD
//			if (users.IniciarSesion("Felipe", "Garcia")==true) {
//				flag=true;
//				break;
//			} 
//		}
//		
//		//esto verifica si la funcion anda - ej.: aca espero un true y recibo un true, no marca failure
//		assertEquals(true,flag);
//	}
//	
//	@Test
//	public void PruebaIniciarSesionF() {
//		UsuarioControlador controlador = new UsuarioControlador();
//		boolean flag=false;
//		
//		for (Usuario users : controlador.getAllUsers()) {
//			
//								//nombre que NO existe en la BBDD
//			if (users.IniciarSesion("Andres", "Garcia")==true) {
//				flag=true;
//				break;
//			} 
//		}
//		
//		//aca aproposito seteo un nombre que no esta en la BBDD y como el assert espera un false tampoco marca failure
//		assertEquals(false,flag);
//	}
}
