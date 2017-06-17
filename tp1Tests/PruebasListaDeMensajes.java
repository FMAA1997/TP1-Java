package tp1Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.ListaDeMensajes;

public class PruebasListaDeMensajes {
	
	@Test
	public void test01At(){
		ListaDeMensajes lista = new ListaDeMensajes();
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		
		assertEquals(lista.get(2), "3");
		assertEquals(lista.get(3), "2");
		assertEquals(lista.get(1), "4");
	}

}
