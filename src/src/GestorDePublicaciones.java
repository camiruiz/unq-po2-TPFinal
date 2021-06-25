package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorDePublicaciones {

	private List<Publicacion> publicaciones;	
	private static GestorDePublicaciones single_instance = null;
	
	private GestorDePublicaciones(){
		super();
		this.publicaciones = new ArrayList<Publicacion> (publicaciones);
	}
	
	public static GestorDePublicaciones getInstance()
	{
	    if (single_instance == null)
	        single_instance = new GestorDePublicaciones();

	    return single_instance;
	}
	
	
	
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	
	
	public List<Reserva> getReservas(){
		List<Reserva> listaDeReservas = new ArrayList<Reserva>();
		this.publicaciones.stream().forEach(p -> listaDeReservas.addAll(p.getReservas()));
		return listaDeReservas;
	}
	
	
	public List<Reserva> getReservasDeUsuario(UsuarioInquilino usuario){
		List<Reserva> reservasDelUsuario = this.getReservas().stream().filter(r -> r.compararInquilino(usuario))
				.collect(Collectors.toList());
		return reservasDelUsuario;
	}
	
	
	public List<String> getCiudadesConReserva(UsuarioInquilino usuario){
		List<String> ciudadesConReserva = new ArrayList<String>();
				(this.publicaciones.stream()			
				.filter(p -> p.chequearSiElUsuarioTieneReserva(usuario)))
				.forEach(p -> ciudadesConReserva.add(p.getCiudad()));
		return ciudadesConReserva;
	}
	
	public List<Reserva> getReservasEnCiudad(String ciudad){
		List<Reserva> reservasEnCiudad = new ArrayList<Reserva>();
				(this.publicaciones.stream()			
				.filter(p	-> p.chequearCiudad(ciudad)))
				.forEach(p 	-> reservasEnCiudad.addAll(p.getReservas()));
		return reservasEnCiudad;
	}
	
	public List<Reserva> getReservasFuturas(UsuarioInquilino usuario){
		List<Reserva> reservasFuturas= new ArrayList<Reserva>();
				(this.getReservas().stream()			
				.filter(r	-> r.chequearSiEsFutura(usuario)))
				.forEach(r 	-> reservasFuturas.add(r));
		return reservasFuturas;
	}
	
	public List<UsuarioInquilino> getTopTenUsuarios(List<UsuarioInquilino> listaDeUsuarios){
		List<UsuarioInquilino> topDeUsuarios = new ArrayList<UsuarioInquilino>();
		topDeUsuarios.addAll(listaDeUsuarios);																						//Cargo todos los usuarios existentes en mi lista de "Top Usuarios"
				(topDeUsuarios.stream()			
				.sorted((u1, u2) -> this.getCantidadDeReservasDeUsuario(u1).compareTo(this.getCantidadDeReservasDeUsuario(u2)))		//Los ordeno de forma que el primer usuario es el que mas veces fue inquilino, de manera descendente.
				//.sorted((u1, u2) -> this.getCantidadDeReservasDeUsuario(u2).compareTo(this.getCantidadDeReservasDeUsuario(u1)))
				.limit(10))																											//Me quedo con los 10 primeros
				.collect(Collectors.toList());
		return topDeUsuarios;
	}


	public Integer getCantidadDeReservasDeUsuario(UsuarioInquilino usuario) {
		return this.getReservasDeUsuario(usuario).size();
	}
	
	public List<Inmueble> getInmueblesLibres(){
		List<Inmueble> inmueblesLibres = new ArrayList<Inmueble>();
				(this.publicaciones.stream()			
				.filter(p	-> p.estaLibre()))
				.forEach(p 	-> inmueblesLibres.add(p.getInmueble()));
		return inmueblesLibres;
	}
	
	
	public Float getTasaDeOcupacion(){
		float totalDeInmuebles = this.getInmuebles().size();
		float inmueblesLibres = this.getInmueblesLibres().size();
				
		return (inmueblesLibres * 100) / totalDeInmuebles;
	}
	
	public List<Inmueble> getInmuebles() {
		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		this.publicaciones.stream()
		.forEach(p -> inmuebles.add(p.getInmueble()));
	}
	
	
	public Integer getVecesQueAlquiloUnInmueble(Publicacion publicacion){
		Integer vecesAlquilado = 0;
		publicacion.getReservas().stream()
		.filter(r -> r.seConcretoAnteriormente())  // si se concreto anteriormente es porque fue alquilado.
		.forEach(r -> vecesAlquilado += 1);
				
		return vecesAlquilado;
	}
	
	//Que manera es mejor para resolver este ejercicio? Que la reserva sea la responsable de implementar el mensaje seConcretoAnteriormente() como esta hecho arriba en el metodo que no esta comentado
	//O hacer que el GestorDePublicaciones sea el encargado de implementar el mensaje y saber si una reserva se concreto anteriormente.
	/*
	public Integer getVecesQueAlquiloUnInmueble(Publicacion publicacion){
		Integer vecesAlquilado = 0;
		publicacion.getReservas().stream()
		.filter(r -> this.seConcretoAnteriormente(r))  // Aca es la diferencia
		.forEach(r -> vecesAlquilado += 1);
				
		return vecesAlquilado;
	}
	
	private Boolean seContreroAnteriormente(Reserva reserva){
		return reserva.getFechaInicio().isBefore(LocalDate.now());
		
	}*/
	
	
	public Integer getVecesQueAlquiloTodosSusInmuebles(Propietario propietario){
		Integer vecesQueAlquiloTotal = 0;
		this.getPublicacionesDeUsuario(propietario).stream()
		.forEach(p -> vecesQueAlquiloTotal += (this.getVecesQueAlquiloUnInmueble(p)));
				
		return vecesQueAlquiloTotal;
	}
	
	public List<Publicacion> getPublicacionesDeUsuario(Propietario propietario){
		List<Publicacion> publicacionesDelUsuario = this.publicaciones.stream().filter(p -> this.compararUsuario(propietario, p))
				.collect(Collectors.toList());
		return publicacionesDelUsuario;
	}

	private Boolean compararUsuario(Propietario propietario, Publicacion p) {
		return p.getPropietario().equals(propietario);	
	}
	
	
	
	
	
}


//Ejemplo de Singleton.
/*class Singleton
{
// static variable single_instance of type Singleton
private static Singleton single_instance = null;

// variable of type String
public String s;

// private constructor restricted to this class itself
private Singleton()
{
    s = "Hello I am a string part of Singleton class";
}

// static method to create instance of Singleton class
public static Singleton getInstance()
{
    if (single_instance == null)
        single_instance = new Singleton();

    return single_instance;
	}
}
*/