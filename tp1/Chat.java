package tp1;

public class Chat {
	
	private int cantMensajesEnviados;
	private int cantMensajesRecibidos;
	private ListaDeMensajes conversacion;
	
	public Chat(){
		this.conversacion = new ListaDeMensajes();
		this.cantMensajesRecibidos = 0;
		this.cantMensajesEnviados = 0;
	}
	
	public int cantidadMensajesEnviados(){
		return this.cantMensajesEnviados;
	}
	
	public int cantidadMensajesRecibidos(){
		return this.cantMensajesRecibidos;
	}
	
	public void enviarMensaje(String mensaje){
		this.conversacion.add("Yo: "+mensaje);
		this.cantMensajesEnviados++;
	}
	
	public void recibirMensaje(String nombre, String mensaje){
		this.conversacion.add(nombre+": "+mensaje);
		this.cantMensajesRecibidos++;
	}
	
	public void borrarConversacion(){
		this.conversacion = new ListaDeMensajes();
		this.cantMensajesEnviados = 0;
		this.cantMensajesRecibidos = 0;
	}
	
	public ListaDeMensajes obtenerConversacion(){
		return this.conversacion;
	}
	
}
