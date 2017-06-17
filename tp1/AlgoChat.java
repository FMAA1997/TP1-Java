package tp1;

import java.util.HashMap;

public class AlgoChat {
	
	private String usuario;
	private HashMap<String, Contacto> contactos;
	private HashMap<String, Grupo> grupos;
	
	public AlgoChat (String usuario){
		this.usuario = usuario;
		this.contactos = new HashMap<String, Contacto>();
		this.grupos = new HashMap<String, Grupo>();
	}

	public int cantidadDeChatsIndividuales (){
		return this.contactos.size();
	}
	
	public int cantidadDeContactos(){
		return this.contactos.size();
	}
	
	public int cantidadDeChatsGrupales(){
		return this.grupos.size();
	}
	
	public int cantidadDeGrupos(){
		return this.grupos.size();
	}
	
	public int cantidadDeMensajesEnviados(){
		int total = 0;
		for(Contacto contacto: this.contactos.values())
			total = total + (contacto.cantidadMensajesEnviados());
		for(Grupo grupo: this.grupos.values())
			total = total + (grupo.cantidadMensajesEnviados());
		return total;
	}
	
	public String nombreUsuario(){
		return this.usuario;
	}
	
	public int cantidadTotalMensajesEnviados(){
		return this.cantidadDeMensajesEnviados();
	}
	
	public int cantidadTotalMensajesRecibidos(){
		int total = 0;
		for(Contacto contacto: this.contactos.values())
			total = total + (contacto.cantidadMensajesRecibidos());
		for(Grupo grupo: this.grupos.values())
			total = total + (grupo.cantidadMensajesRecibidos());
		return total;
	}
	
	public boolean existeContacto(String nombre){
		return this.contactos.containsKey(nombre);
	}
	
	public boolean existeGrupo(String nombre){
		return this.grupos.containsKey(nombre);
	}
	
	public void agregarContacto(String nombre){
		if (this.existeContacto(nombre)){
			throw new ContactoExistente();
		}
		Contacto contacto = new Contacto(nombre);
		this.contactos.put(nombre, contacto);
	}
	
	public void agregarContactoAGrupo(String contacto, String grupo){
		if (!this.existeContacto(contacto))
			throw new ContactoInexistente();
		if(!this.existeGrupo(grupo))
			throw new GrupoInexistente();
		if(((this.grupos.get(grupo)).perteneceContacto(contacto)))
			throw new ContactoExistente();
		this.grupos.get(grupo).agregarContacto(contacto);
	}
	
	public void recibirMensajeDe(String nombre, String mensaje){
		if (!this.existeContacto(nombre))
			throw new ContactoInexistente();
		(this.contactos.get(nombre)).recibirMensaje(mensaje);
	}
	
	public void enviarMensajeA(String nombre, String mensaje){
		if (!this.existeContacto(nombre))
			throw new ContactoInexistente();
		(this.contactos.get(nombre)).enviarMensaje(mensaje);
	}
	
	public int cantidadMensajesDe(String nombre){
		int total = 0;
		if (!this.existeContacto(nombre))
			throw new ContactoInexistente();
		for (Grupo grupo: this.grupos.values())
			if (grupo.perteneceContacto(nombre))
				total = total + (grupo.cantidadDeMensajes(nombre));
		return total + (this.contactos.get(nombre)).cantidadMensajesRecibidos();
	}
	
	public int cantidadMensajesEnviadosA(String nombre){
		if (!this.existeContacto(nombre))
			throw new ContactoInexistente();
		return (this.contactos.get(nombre)).cantidadMensajesEnviados();
	}
	
	public ListaDeMensajes obtenerConversacionCon(String nombre){
		if (!this.existeContacto(nombre))
			throw new ContactoInexistente();
		return (this.contactos.get(nombre)).obtenerConversacion();
	}
	
	public void crearGrupo(String nombre){
		if (this.existeGrupo(nombre))
			throw new GrupoExistente();
		Grupo grupo = new Grupo(nombre);
		this.grupos.put(nombre, grupo);
	}
	
	public int cantidadMiembrosEnGrupo(String nombre){
		if (!this.existeGrupo(nombre))
			throw new GrupoInexistente();
		return (this.grupos.get(nombre)).cantidadMiembros();
	}
	
	public void recibirMensajeDeGrupo(String grupo, String contacto, String mensaje){
		if (!this.existeContacto(contacto))
			throw new ContactoInexistente();
		if(!this.existeGrupo(grupo))
			throw new GrupoInexistente();
		if(!(this.grupos.get(grupo)).perteneceContacto(contacto))
			throw new NoPerteneceContacto();
		(this.grupos.get(grupo)).recibirMensaje(contacto, mensaje);
	}
	
	public void enviarMensajeAGrupo(String grupo, String mensaje){
		if(!this.existeGrupo(grupo))
			throw new GrupoInexistente();
		this.grupos.get(grupo).enviarMensaje(mensaje);
	}
	
	public int cantidadMensajesEnviadosAlGrupo(String grupo){
		if(!this.existeGrupo(grupo))
			throw new GrupoInexistente();
		return this.grupos.get(grupo).cantidadMensajesEnviados();
	}
	
	public int cantidadMensajesRecibidosDelGrupo(String grupo){
		if(!this.existeGrupo(grupo))
			throw new GrupoInexistente();
		return this.grupos.get(grupo).cantidadMensajesRecibidos();
	}
	
	public ListaDeMensajes obtenerConversacionConGrupo(String grupo){
		if(!this.existeGrupo(grupo))
			throw new GrupoInexistente();
		return this.grupos.get(grupo).obtenerConversacion();
	}
	
	public void borrarMensajesDelContacto(String nombre){
		if (!this.existeContacto(nombre))
			throw new ContactoInexistente();
		this.contactos.get(nombre).borrarConversacion();
	}
	
	public void borrarMensajesDelGrupo(String grupo){
		if(!this.existeGrupo(grupo))
			throw new GrupoInexistente();
		this.grupos.get(grupo).borrarMensajes();
	}
}
