package tp1Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp1.AlgoChat;
import tp1.ContactoExistente;
import tp1.ContactoInexistente;
import tp1.GrupoExistente;
import tp1.GrupoInexistente;
import tp1.NoPerteneceContacto;

public class PruebasAlgoChat {
	
	@Test
	public void test01CrearConNombre(){
		AlgoChat algochat = new AlgoChat("Hernan");
		assertEquals(algochat.nombreUsuario(), "Hernan");
	}
	
	@Test
	public void test02CantidadDeContactosInicial(){
		AlgoChat algochat = new AlgoChat("Juan");
		
		assertTrue(algochat.cantidadDeContactos() == 0);
	}
	
	@Test
	public void test03CantidadDeGruposInicial(){
		AlgoChat algochat = new AlgoChat("Juan");
		
		assertTrue(algochat.cantidadDeGrupos() == 0);
	}
	
	@Test
	public void test04AgregarContactosYChequearCantidad(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Julio");
		algochat.agregarContacto("Humberto");
		
		assertTrue(algochat.cantidadDeContactos() == 2);
	}
	
	@Test (expected = ContactoExistente.class)
	public void test05AgregarContactoExistenteLanzaContactoExistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Juan");
		algochat.agregarContacto("Juan");
	}
	
	@Test
	public void test06ChequearQueExisteContacto(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Juan");
		assertTrue(algochat.existeContacto("Juan"));
	}
	@Test
	public void test07ChequearQueNoExisteContacto(){
		AlgoChat algochat = new AlgoChat("Juan");
		assertFalse(algochat.existeContacto("Juan"));
	}
	
	@Test
	public void test08EnviarMensajeAUnContactoYChequearCantTotalDeMensajes(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Raul");
		algochat.enviarMensajeA("Raul", "Holis");
		
		assertTrue(algochat.cantidadTotalMensajesEnviados() == 1);
	}
	
	@Test (expected = ContactoInexistente.class)
	public void test09EnviarMensajeAContactoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.enviarMensajeA("Juan", "Hola");
	}
	
	@Test
	public void test10RecibirMensajeYChequearCantTotalMensajesRecibidos(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Jose");
		algochat.recibirMensajeDe("Jose", "Hola");
		
		assertTrue(algochat.cantidadTotalMensajesRecibidos() == 1);
	}
	
	@Test (expected = ContactoInexistente.class)
	public void test11RecibirMensajeDeContactoNoAgregadoLanzaContactoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.recibirMensajeDe("Horacio", "Mensaje");
	}
	
	@Test
	public void test12ChequearCantidadDeMensajesRecibidosDeUnContacto(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Jesus");
		algochat.recibirMensajeDe("Jesus", "Hola");
		algochat.recibirMensajeDe("Jesus", "Que tal?");
		
		assertTrue(algochat.cantidadMensajesDe("Jesus") == 2);
	}
	
	@Test (expected = ContactoInexistente.class)
	public void test13ChequearCantDeMensajesDeUnContactoNoAgregadoLanzaContactoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.cantidadMensajesDe("Alguien");
	}
	
	@Test
	public void test14ChequearCantDeMensajesEnviadosAUnContacto(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Julio");
		algochat.enviarMensajeA("Julio", "Hola");
		algochat.enviarMensajeA("Julio", "Respondeme");
		
		assertTrue(algochat.cantidadMensajesEnviadosA("Julio") == 2);
	}
	
	@Test (expected = ContactoInexistente.class)
	public void test15ChequearCantDeMensajesEnviadosAContactoNoAgregadoLanzaContactoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.cantidadMensajesEnviadosA("H");
	}
	
	@Test
	public void test16ObtenerConversacionConUnContacto(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Julio");
		algochat.recibirMensajeDe("Julio", "Hola!");
		algochat.enviarMensajeA("Julio", "Que Onda?");
		
		assertEquals(algochat.obtenerConversacionCon("Julio").get(1), "Yo: Que Onda?");
		assertEquals(algochat.obtenerConversacionCon("Julio").get(2), "Julio: Hola!");
	}
	
	@Test (expected = ContactoInexistente.class)
	public void test17ObtenerConversacionConContactoNoAgregadoLanzaContactoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.obtenerConversacionCon("Jose");
	}
	
	@Test
	public void test18CrearUnGrupoYChequearCantidadDeGrupos(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("Grupete");
		
		assertTrue(algochat.cantidadDeGrupos() == 1);
	}
	
	@Test (expected = GrupoExistente.class)
	public void test19CrearGrupoYaCreadoLanzaGrupoExistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("Tarde");
		algochat.crearGrupo("Tarde");
	}
	
	@Test
	public void test20ChequearQueExisteGrupoCreado(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("Grupo");
		
		assertTrue(algochat.existeGrupo("Grupo"));
	}
	
	@Test
	public void test21ChequearQueNoExisteGrupoNoCreado(){
		AlgoChat algochat = new AlgoChat("Juan");
		
		assertFalse(algochat.existeGrupo("Alumnos"));
	}
	
	@Test
	public void test22ChequearCantidadDeMiembrosInicialmenteEs1(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("Ejemplo");
		
		assertTrue(algochat.cantidadMiembrosEnGrupo("Ejemplo") == 1);
	}
	
	@Test
	public void test23AgregarUnContactoAGrupoAumentaLaCantidadDeMiembros(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Julio");
		algochat.crearGrupo("Tarde");
		algochat.agregarContactoAGrupo("Julio", "Tarde");
		
		assertTrue(algochat.cantidadMiembrosEnGrupo("Tarde") == 2);
	}
	
	@Test (expected = GrupoInexistente.class)
	public void test24AgregarUnContactoAGrupoNoCreadoLanzaGrupoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Ricardo");
		algochat.agregarContactoAGrupo("Ricardo", "Alguno");
	}
	
	@Test (expected = ContactoInexistente.class)
	public void test25AgregarUnContactoInexistenteAUnGrupoExistenteLanzaContactoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("Tarde");
		algochat.agregarContactoAGrupo("Jorge", "Tarde");
	}
	
	@Test (expected = ContactoExistente.class)
	public void test26AgregarContactoYaPertenecienteAGrupoLanzaContactoExistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Juan");
		algochat.crearGrupo("Mañana");
		algochat.agregarContactoAGrupo("Juan", "Mañana");
		algochat.agregarContactoAGrupo("Juan", "Mañana");
	}
	
	@Test
	public void test27RecibirMensajeDeGrupoYChequearCantMensajesRecibidosDeEseGrupo(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Jose");
		algochat.crearGrupo("Tarde");
		algochat.agregarContactoAGrupo("Jose", "Tarde");
		algochat.recibirMensajeDeGrupo("Tarde", "Jose", "Que Hubo");
		
		assertTrue(algochat.cantidadMensajesRecibidosDelGrupo("Tarde") == 1);
	}
	
	@Test (expected = GrupoInexistente.class)
	public void test28ChequearCantDeMensajesRecibidosDeGrupoNoCreadoLanzaGrupoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.cantidadMensajesRecibidosDelGrupo("Ninguno");
	}
	
	@Test (expected = GrupoInexistente.class)
	public void test29RecibirMensajeDeGrupoNoCreadoLanzaGrupoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Roberto");
		algochat.recibirMensajeDeGrupo("Algo", "Roberto", "Hola");
	}
	
	@Test (expected = ContactoInexistente.class)
	public void test30RecibirMensajeDeGrupoCreadoYContactoNoAgregadoLanzContactoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("Tarde");
		algochat.recibirMensajeDeGrupo("Tarde", "Julio", "Mensaje");
	}
	
	@Test (expected = NoPerteneceContacto.class)
	public void test31RecibirMensajeDeGrupoDeContactoQueNoPerteneceLanzaNoPerteneceContacto(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Jose");
		algochat.crearGrupo("Grupete");
		algochat.recibirMensajeDeGrupo("Grupete", "Jose", "Jelou");
	}
	
	@Test
	public void test32ChequearCantidadDeMensajesRecibidosDeGrupo(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Julio");
		algochat.agregarContacto("Humberto");
		algochat.agregarContacto("Daniel");
		algochat.crearGrupo("AFA");
		algochat.agregarContactoAGrupo("Julio", "AFA");
		algochat.agregarContactoAGrupo("Humberto", "AFA");
		algochat.agregarContactoAGrupo("Daniel", "AFA");
		algochat.recibirMensajeDeGrupo("AFA", "Julio", "Todo pasa");
		algochat.recibirMensajeDeGrupo("AFA", "Daniel", "Hola");
		algochat.recibirMensajeDeGrupo("AFA", "Humberto", "Holaa");
		
		assertTrue(algochat.cantidadMensajesRecibidosDelGrupo("AFA") == 3);
	}
	
	@Test
	public void test33EnviarMensajeAGrupoAumentaLaCantDeMensajesEnviadosAlGrupo(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("Grupo");
		algochat.enviarMensajeAGrupo("Grupo", "Hola");
		
		assertTrue(algochat.cantidadMensajesEnviadosAlGrupo("Grupo") == 1);
	}
	
	@Test (expected = GrupoInexistente.class)
	public void test34EnviarMensajeAGrupoNoCreadoLanzaGrupoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.enviarMensajeAGrupo("Ninguno", "NoExistis");
	}
	
	@Test
	public void test35ChequearCantDeMensajesEnviadosAUnGrupo(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("L");
		algochat.enviarMensajeAGrupo("L", "No hay nadie");
		algochat.enviarMensajeAGrupo("L", "hola");
		
		assertTrue(algochat.cantidadMensajesEnviadosAlGrupo("L") == 2);
	}
	
	@Test (expected = GrupoInexistente.class)
	public void test36ChequearCantDeMensajesEnviadosAGrupoNoCreadoLanzaGrupoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.cantidadMensajesEnviadosAlGrupo("AFA");
	}
	
	@Test
	public void test37ChequearCantDeMiembrosDeUnGrupo(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Juan");
		algochat.agregarContacto("Jose");
		algochat.crearGrupo("Nombres");
		algochat.agregarContactoAGrupo("Juan", "Nombres");
		algochat.agregarContactoAGrupo("Jose", "Nombres");
		
		assertTrue(algochat.cantidadMiembrosEnGrupo("Nombres") == 3);
	}
	
	@Test (expected = GrupoInexistente.class)
	public void test38ChequearCantMiembrosDeGrupoNoCreadoLanzaGrupoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.cantidadMiembrosEnGrupo("LALA");
	}
	
	@Test
	public void test39ObtenerConversacionConGrupoEstaEnOrden(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Juan");
		algochat.agregarContacto("Luis");
		algochat.crearGrupo("Ejemplo");
		algochat.agregarContactoAGrupo("Juan", "Ejemplo");
		algochat.agregarContactoAGrupo("Luis", "Ejemplo");
		algochat.recibirMensajeDeGrupo("Ejemplo", "Juan", "Hola");
		algochat.enviarMensajeAGrupo("Ejemplo", "Que tal?");
		algochat.recibirMensajeDeGrupo("Ejemplo", "Luis", "Como va");
		
		assertEquals(algochat.obtenerConversacionConGrupo("Ejemplo").get(1), "Luis: Como va");
		assertEquals(algochat.obtenerConversacionConGrupo("Ejemplo").get(3), "Juan: Hola");
	}
	
	@Test (expected = GrupoInexistente.class)
	public void test40ObtenerConversacionConGrupoNoCreadoLanzaGrupoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.obtenerConversacionConGrupo("LALA");
	}
	
	@Test
	public void test41ChequearCantidadTotalDeMensajesEnviados(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Juan");
		algochat.agregarContacto("Jorge");
		algochat.crearGrupo("Tarde");
		algochat.agregarContactoAGrupo("Juan", "Tarde");
		algochat.enviarMensajeA("Jorge", "Jelow");
		algochat.enviarMensajeAGrupo("Tarde", "Hola");
		algochat.enviarMensajeA("Juan", "Hola");
		
		assertTrue(algochat.cantidadTotalMensajesEnviados() == 3);
	}
	
	@Test
	public void test42ChequearCantidadTotalDeMensajesRecibidos(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Juan");
		algochat.agregarContacto("Jorge");
		algochat.crearGrupo("Tarde");
		algochat.agregarContactoAGrupo("Juan", "Tarde");
		algochat.recibirMensajeDe("Juan", "Hola");
		algochat.recibirMensajeDeGrupo("Tarde", "Juan", "Hola");
		algochat.recibirMensajeDe("Jorge", "Que haces");
		
		assertTrue(algochat.cantidadTotalMensajesRecibidos() == 3);
	}
	
	@Test
	public void test43BorrarMensajesDeUnContacto(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Jose");
		algochat.recibirMensajeDe("Jose", "Hola");
		algochat.enviarMensajeA("Jose", "HOLA");
		algochat.recibirMensajeDe("Jose", "Sup");
		algochat.borrarMensajesDelContacto("Jose");
		
		assertTrue(algochat.cantidadMensajesDe("Jose") == 0);
		assertTrue(algochat.cantidadMensajesEnviadosA("Jose") == 0);
	}
	
	@Test (expected = ContactoInexistente.class)
	public void test44BorrarMensajesDeUnContactoNoAgregadoLanzaContactoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.borrarMensajesDelContacto("Jesus");
	}
	
	@Test
	public void test45BorrarMensajesDeUnGrupo(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("Jorge");
		algochat.crearGrupo("Eje");
		algochat.agregarContactoAGrupo("Jorge", "Eje");
		algochat.enviarMensajeAGrupo("Eje", "Hola");
		algochat.recibirMensajeDeGrupo("Eje", "Jorge", "Hola");
		algochat.borrarMensajesDelGrupo("Eje");
		
		assertTrue(algochat.cantidadMensajesRecibidosDelGrupo("Eje") == 0);
		assertTrue(algochat.cantidadMensajesEnviadosAlGrupo("Eje") == 0);
	}
	
	@Test (expected = GrupoInexistente.class)
	public void test46BorrarMensajesDeUnGrupoNoCreadoLanzaGrupoInexistente(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.borrarMensajesDelGrupo("Alguno");
	}
	
	@Test
	public void test47ChequearCantidadDeGrupos(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("1");
		algochat.crearGrupo("2");
		algochat.crearGrupo("3");
		
		assertTrue(algochat.cantidadDeGrupos() == 3);
	}
	
	@Test
	public void test48ChequearCantidadDeContacos(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("1");
		algochat.agregarContacto("2");
		algochat.agregarContacto("3");
		algochat.agregarContacto("5");
		
		assertTrue(algochat.cantidadDeContactos() == 4);
	}
	
	@Test
	public void test49ChequearCantidadDeChatsGrupales(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.crearGrupo("1");
		algochat.crearGrupo("2");
		algochat.crearGrupo("3");
		
		assertTrue(algochat.cantidadDeChatsGrupales() == 3);
	}
	
	@Test
	public void test50ChequearCantidadDeChatsIndividuales(){
		AlgoChat algochat = new AlgoChat("Juan");
		algochat.agregarContacto("1");
		algochat.agregarContacto("2");
		algochat.agregarContacto("3");
		algochat.agregarContacto("5");
		
		assertTrue(algochat.cantidadDeChatsIndividuales() == 4);
	}
	
	
}
