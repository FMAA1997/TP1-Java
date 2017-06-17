package tp1;

public class Contacto {
	
	private String nombre;
	private Chat chat;
	
	public Contacto (String nombre){
		this.nombre = nombre;
		this.chat = new Chat();
	}

	public int cantidadMensajesEnviados(){
		return chat.cantidadMensajesEnviados();
	}
	
	public int cantidadMensajesRecibidos(){
		return chat.cantidadMensajesRecibidos();
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
	
	public void enviarMensaje(String mensaje){
		this.chat.enviarMensaje(mensaje);
	}
	
	public void recibirMensaje(String mensaje){
		this.chat.recibirMensaje(this.nombre, mensaje);
	}
	
	public ListaDeMensajes obtenerConversacion(){
		return this.chat.obtenerConversacion();
	}
	
	public void borrarConversacion(){
		this.chat.borrarConversacion();
	}
}
