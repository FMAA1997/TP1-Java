package tp1Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp1.Grupo;

public class PruebasGrupo {
	
	@Test
	public void test01CrearGrupoConNombre(){
		Grupo grupo = new Grupo("Ejemplo");
		
		assertEquals(grupo.obtenerNombre(), "Ejemplo");
	}
	
	@Test
	public void test02AgregarContacto(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.agregarContacto("Jorge");
		
		assertTrue(grupo.cantidadMiembros() == 2);
	}
	
	@Test
	public void test03PerteneceContactoConContactoAgregadoEsTrue(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.agregarContacto("Jesus");
		
		assertTrue(grupo.perteneceContacto("Jesus"));
	}
	
	@Test
	public void test04PerteneceContactoConContactoNoAgregadoEsFalse(){
		Grupo grupo = new Grupo("Ejemplo");
		
		assertFalse(grupo.perteneceContacto("Juan"));
	}
	
	@Test
	public void test05ChequearCantidadDeMiembros(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.agregarContacto("Juan");
		grupo.agregarContacto("Jose");
		grupo.agregarContacto("Pablo");
		
		assertTrue(grupo.cantidadMiembros() == 4);
	}
	
	@Test
	public void test06RecibirMensajes(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.agregarContacto("Juan");
		grupo.recibirMensaje("Juan", "Hola");
		grupo.recibirMensaje("Juan", "Que Tal");
		
		assertTrue(grupo.cantidadMensajesRecibidos() == 2);
	}
	
	@Test
	public void test07EnviarMensajes(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.enviarMensaje("Hola");
		grupo.enviarMensaje("Hoa");
		
		assertTrue(grupo.cantidadMensajesEnviados() == 2);
	}
	
	@Test
	public void test08RecibirMensajesDeDistintosMiembrosYChequearLaCantidadRecibidaDeCadaUno(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.agregarContacto("Juan");
		grupo.agregarContacto("Jesus");
		grupo.recibirMensaje("Juan", "Hola");
		grupo.recibirMensaje("Juan", "Todo bien");
		grupo.recibirMensaje("Jesus", "hola");
		
		assertTrue(grupo.cantidadDeMensajes("Juan") == 2);
		assertTrue(grupo.cantidadDeMensajes("Jesus") == 1);
	}
	
	@Test
	public void test09RecibirMensajesDeDistintosMiembrosYChequearLaCantidadTotalDeMensajesRecibidos(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.agregarContacto("Juan");
		grupo.agregarContacto("Jesus");
		grupo.recibirMensaje("Juan", "Hola");
		grupo.recibirMensaje("Juan", "Todo bien");
		grupo.recibirMensaje("Jesus", "hola");
		
		assertTrue(grupo.cantidadMensajesRecibidos() == 3);
	}
	
	@Test
	public void test10EnviarMensajesYChequearLaCantidadTotalDeMensajesEnviados(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.enviarMensaje("Hola");
		grupo.enviarMensaje("Hoa");
		grupo.enviarMensaje("Respondan");
		
		assertTrue(grupo.cantidadMensajesEnviados() == 3);
	}
	
	@Test
	public void test11ObtenerConversacionYChequearQueEsteEnOrden(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.agregarContacto("Juan");
		grupo.agregarContacto("Jesus");
		grupo.enviarMensaje("Hola");
		grupo.recibirMensaje("Juan", "Hola");
		grupo.recibirMensaje("Juan", "Todo bien");
		grupo.recibirMensaje("Jesus", "hola");
		
		assertEquals(grupo.obtenerConversacion().get(2), "Juan: Todo bien");
		assertEquals(grupo.obtenerConversacion().get(3), "Juan: Hola");
		assertEquals(grupo.obtenerConversacion().get(4), "Yo: Hola");
	}
	
	@Test
	public void test12BorrarMensajesYChequearQueLaCantidadDeMensajesEs0(){
		Grupo grupo = new Grupo("Ejemplo");
		grupo.agregarContacto("Juan");
		grupo.agregarContacto("Jesus");
		grupo.enviarMensaje("Hola");
		grupo.recibirMensaje("Juan", "Hola");
		grupo.recibirMensaje("Juan", "Todo bien");
		grupo.recibirMensaje("Jesus", "hola");
		grupo.borrarMensajes();
		
		assertTrue(grupo.cantidadMensajesEnviados() == 0);
		assertTrue(grupo.cantidadMensajesRecibidos() == 0);
	}
		

}
