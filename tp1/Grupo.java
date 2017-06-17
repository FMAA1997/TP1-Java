package tp1;

import java.util.HashMap;

public class Grupo {
	
	private String nombre;
	private HashMap<String, Integer> miembros;
	private Chat chat;
	
	public Grupo(String nombre){
		this.nombre = nombre;
		this.miembros = new HashMap<String, Integer>();
		this.chat = new Chat();
	}
	
	public void agregarContacto(String nombre){
		this.miembros.put(nombre, 0);
	}
	
	public boolean perteneceContacto(String nombre){
		return this.miembros.containsKey(nombre);
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
	
	public int cantidadMensajesEnviados(){
		return this.chat.cantidadMensajesEnviados();
	}
	
	public int cantidadMensajesRecibidos(){
		return this.chat.cantidadMensajesRecibidos();
	}
	
	public int cantidadMiembros(){
		return this.miembros.size() +1;
	}
	
	public int cantidadDeMensajes(String nombre){
		return this.miembros.get(nombre);
	}
	
	public void enviarMensaje(String mensaje){
		this.chat.enviarMensaje(mensaje);
	}
	
	public void recibirMensaje(String nombre, String mensaje){
		this.chat.recibirMensaje(nombre, mensaje);
		this.miembros.replace(nombre, this.miembros.get(nombre) +1);
	}
	
	public ListaDeMensajes obtenerConversacion(){
		return this.chat.obtenerConversacion();
	}
	
	public void borrarMensajes(){
		for (String miembro: this.miembros.keySet())
			this.miembros.put(miembro, 0);
		this.chat.borrarConversacion();
	}
	
	
	
}
