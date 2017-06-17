package tp1;

import java.util.ArrayList;

public class ListaDeMensajes {
	
	private ArrayList<String> mensajes;
	
	public ListaDeMensajes (){
		this.mensajes = new ArrayList<String>();
	}
	
	public String get (int posicion){
		return this.mensajes.get(posicion-1);
	}
	
	public void add (String mensaje){
		this.mensajes.add(0, mensaje);
	}

}
