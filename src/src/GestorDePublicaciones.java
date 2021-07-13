package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GestorDePublicaciones {

	private List<Publicacion> publicaciones;	
	
	
	public GestorDePublicaciones(){
		super();
		this.publicaciones = new ArrayList<Publicacion>();
	}
		
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
		
	}
	
	
	public List<Reserva> getReservas(){
		List<Reserva> listaDeReservas = new ArrayList<Reserva>();
		this.publicaciones.stream()
							.forEach(p -> listaDeReservas.addAll(p.getReservas()));
		
		return listaDeReservas;
	}
	
	
	public List<Reserva> getReservasDeUsuario(UsuarioInquilino usuario){
		List<Reserva> reservasDelUsuario = this.getReservas().stream()
																.filter(r -> r.compararInquilino(usuario))
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
									.filter(r	-> r.chequearSiEsFutura()))
									.forEach(r 	-> reservasFuturas.add(r));
				
		return reservasFuturas;
	}
	
	public List<UsuarioInquilino> getTopTenUsuarios(List<UsuarioInquilino> listaDeUsuarios){
		List<UsuarioInquilino> topDeUsuarios = new ArrayList<UsuarioInquilino>();
		topDeUsuarios.addAll(listaDeUsuarios);																						
				(topDeUsuarios.stream()			
								.sorted((u1, u2) -> this.getCantidadDeReservasDeUsuario(u2).compareTo(this.getCantidadDeReservasDeUsuario(u1)))
								.limit(10))																											
								.collect(Collectors.toList());
				
		return topDeUsuarios;
	}


	public Integer getCantidadDeReservasDeUsuario(UsuarioInquilino usuario) {
		return this.getReservasDeUsuario(usuario).size();
	}
	
	
	public List<Inmueble> getInmueblesLibres(){
		List<Inmueble> inmueblesLibres = new ArrayList<Inmueble>();
				(this.publicaciones.stream()			
									.filter(p	-> this.estaLibre(p)))           							
									.forEach(p 	-> inmueblesLibres.add(p.getInmueble()));
		return inmueblesLibres;
	}
	
	
	public boolean estaLibre(Publicacion publicacion) {
		
		return (publicacion.getCalendario().checkDisponibilidadEntre(LocalDate.now(), LocalDate.now()));
		
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
		
		return inmuebles;
		
	}
	
	
	public Integer getVecesQueAlquiloUnInmueble(Publicacion publicacion){
		
		return publicacion.getReservas().stream()
									.filter(r -> this.seConcretoAnteriormente(r))
									.collect(Collectors.toList()).size();
			
	}

	
	public Boolean seConcretoAnteriormente(Reserva reserva){
		return reserva.getFechaInicio().isBefore(LocalDate.now());
		
	}
	

	
	
	public Integer getVecesQueAlquiloTodosSusInmuebles(Propietario propietario){
	
		return this.getPublicacionesDeUsuario(propietario).stream()
															.mapToInt(p -> this.getVecesQueAlquiloUnInmueble(p))
															.sum();
	}


	

	public List<Publicacion> getPublicacionesDeUsuario(Propietario propietario){
		List<Publicacion> publicacionesDelUsuario = this.publicaciones.stream().filter(p -> this.compararUsuario(propietario, p))
				.collect(Collectors.toList());
		return publicacionesDelUsuario;
	}
	
	

	public Boolean compararUsuario(Propietario propietario, Publicacion publicacion) {
		return publicacion.getPropietario().equals(propietario);	
	}


	
	
	
	
	
}

