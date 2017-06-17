package tp1Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.Chat;

public class PruebasChat {
	
	@Test
	public void test01InicialmenteUnChatNoTieneMensajes(){
		Chat chat = new Chat();
		
		assertTrue(chat.cantidadMensajesEnviados() == 0);
		assertTrue(chat.cantidadMensajesRecibidos() == 0);
	}
	
	@Test
	public void test02EnviarUnMensaje(){
		Chat chat = new Chat();
		chat.enviarMensaje("Hola");
		
		assertTrue(chat.cantidadMensajesEnviados() == 1);
	}
	
	@Test
	public void test03RecibirUnMensaje(){
		Chat chat = new Chat();
		chat.recibirMensaje("Juan", "Hola");
		
		assertTrue(chat.cantidadMensajesRecibidos() == 1);
	}
	
	@Test
	public void test04ChequearCantidadMensajesRecibidos(){
		Chat chat = new Chat();
		chat.recibirMensaje("Juan", "Hola");
		chat.recibirMensaje("Juan", "Hola");
		chat.recibirMensaje("Juan", "Hola");
		chat.recibirMensaje("Juan", "Hola");

		
		assertTrue(chat.cantidadMensajesRecibidos() == 4);
	}
	
	@Test
	public void test05ChequearCantidadMensajesEnviados(){
		Chat chat = new Chat();
		chat.enviarMensaje("Hola");
		chat.enviarMensaje("Hola");
		chat.enviarMensaje("Hola");
		chat.enviarMensaje("Hola");
		chat.enviarMensaje("Hola");
		
		assertTrue(chat.cantidadMensajesEnviados() == 5);
	}
	
	@Test
	public void test06ObtenerConversacion(){
		Chat chat = new Chat();
		chat.recibirMensaje("Juan", "Hola");
		chat.enviarMensaje("Sup");
		chat.recibirMensaje("Juan", "todo bien");
		
		assertEquals(chat.obtenerConversacion().get(1), "Juan: todo bien");
		assertEquals(chat.obtenerConversacion().get(2), "Yo: Sup");
	}
	
	@Test
	public void test07BorrarMensajes(){
		Chat chat = new Chat();
		chat.recibirMensaje("Juan", "Hola");
		chat.recibirMensaje("Juan", "Hola");
		chat.recibirMensaje("Juan", "Hola");
		chat.recibirMensaje("Juan", "Hola");
		chat.enviarMensaje("Hola");
		chat.enviarMensaje("Hola");
		chat.enviarMensaje("Hola");
		chat.borrarConversacion();
		
		assertTrue(chat.cantidadMensajesEnviados() == 0);
		assertTrue(chat.cantidadMensajesRecibidos() == 0);
	}

}
