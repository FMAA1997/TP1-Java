package tp1Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.Contacto;

public class PruebasContacto {
	
	@Test
	public void test01CrearUnContacto(){
		Contacto contacto = new Contacto("Jorge");
		
		assertEquals(contacto.obtenerNombre(), "Jorge");
	}
	
	@Test
	public void test02RecibirUnMensaje(){
		Contacto contacto = new Contacto("Jorge");
		contacto.recibirMensaje("Hola");
		
		assertTrue(contacto.cantidadMensajesRecibidos() == 1);
	}
	
	@Test
	public void test03EnviarUnMensaje(){
		Contacto contacto = new Contacto("Logan");
		contacto.enviarMensaje("Hola");
		
		assertTrue(contacto.cantidadMensajesEnviados() == 1);
	}
	
	@Test
	public void test04ChequearCantidadDeMensajesRecibidos(){
		Contacto contacto = new Contacto("Jorge");
		contacto.recibirMensaje("Hola");
		contacto.recibirMensaje("Hola");
		contacto.recibirMensaje("Hola");
		contacto.recibirMensaje("Hola");
		
		assertTrue(contacto.cantidadMensajesRecibidos() == 4);
	}
	
	@Test
	public void test05ChequearCantidadDeMensajesEnviados(){
		Contacto contacto = new Contacto("Logan");
		contacto.enviarMensaje("Hola");
		contacto.enviarMensaje("Hola");
		contacto.enviarMensaje("Hola");
		contacto.enviarMensaje("Hola");
		
		assertTrue(contacto.cantidadMensajesEnviados() == 4);
	}
	
	@Test
	public void test06ObtenerConversacion(){
		Contacto contacto = new Contacto("Jorge");
		contacto.recibirMensaje("Hola");
		contacto.enviarMensaje("Sup");
		contacto.recibirMensaje("Todo bien");
		contacto.enviarMensaje("Que Suerte");
		
		assertEquals(contacto.obtenerConversacion().get(1), "Yo: Que Suerte");
		assertEquals(contacto.obtenerConversacion().get(2), "Jorge: Todo bien");
		assertEquals(contacto.obtenerConversacion().get(3), "Yo: Sup");
	}
	
	@Test
	public void test07BorrarConversacion(){
		Contacto contacto = new Contacto("Jorge");
		contacto.recibirMensaje("Hola");
		contacto.enviarMensaje("Sup");
		contacto.recibirMensaje("Todo bien");
		contacto.enviarMensaje("Que Suerte");
		contacto.borrarConversacion();
		
		assertTrue(contacto.cantidadMensajesEnviados() == 0);
		assertTrue(contacto.cantidadMensajesRecibidos() == 0);
	}

}
