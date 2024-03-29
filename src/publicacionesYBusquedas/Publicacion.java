package publicacionesYBusquedas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import app.*;
import calculadorDeCalificaciones.CalculadorDeCalificaciones;
import calculadorDeCalificaciones.Calificacion;
import notificaciones.IListener;
import politicasDeCancelacion.PoliticaDeCancelacionDeReserva;
import solicitud.Solicitud;
import usuarios.Propietario;
import usuarios.UsuarioInquilino;

import java.time.temporal.ChronoUnit;



public class Publicacion {

	private LocalTime checkInHorario;
	private LocalTime checkOutHorario;
	private Double precioPorDia;
	private Inmueble inmueble;
	private Propietario propietario;
	private CalculadorDeCalificaciones calculadorDeCalificaciones;
	private PoliticaDeCancelacionDeReserva politicaDeCancelacion;
	//private List<TemporadaAlta> diasEnAumento;
	private Calendario calendario;
	private List<IListener> listeners;
	
	public Publicacion(	 
						LocalTime 						horarioDeCheckIn, 
						LocalTime 						horarioDeCheckOut, 
						Double 							precio, 
						Inmueble 						miInmueble, 
						Propietario 					miPropietario, 
						PoliticaDeCancelacionDeReserva	politicaDeCancel,
						CalculadorDeCalificaciones 		miCalculadorDeCalificaciones,
						Calendario 						calendario) {
		super();
		
		
		this.checkInHorario = horarioDeCheckIn;
		this.checkOutHorario = horarioDeCheckOut;
		this.precioPorDia = precio;
		this.inmueble = miInmueble;
		this.propietario = miPropietario;
		this.politicaDeCancelacion = politicaDeCancel;
		this.calculadorDeCalificaciones = miCalculadorDeCalificaciones;
		this.calendario = calendario;
		this.listeners	= new ArrayList<IListener>();
	}

	
	public Double getPrecioTotalEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		Double precioActual= 0.0;
		if(this.calendario.tieneTemporadaAltaEntre(fechaInicio, fechaFin)){
			precioActual += this.calendario.calcularAumentoEntre(fechaInicio,fechaFin);
		}
		precioActual += this.precioPorDia * (ChronoUnit.DAYS.between(fechaInicio, fechaFin));
		return precioActual;
	}
	
	
	
	public Calendario getCalendario() {
		return calendario;
	}
	
	public List<Reserva> getReservas() {
		return this.calendario.getReservas();
	}


	public void aumentarPrecioEnPeriodo(TemporadaAlta temporadaAlta) {
		this.calendario.addDiasEnAumento(temporadaAlta);
	}
	
	public float getPuntaje() {
		return(this.calculadorDeCalificaciones.calcularPromedio());
	}
	
	public void recibirReserva(Reserva reserva) {
		this.calendario.addReserva(reserva);
	}
	
	public float puntajeDueño() {
		return this.propietario.getPuntaje();
	}

	public LocalTime getCheckInHorario() {
		return checkInHorario;
	}

	public void setCheckInHorario(LocalTime checkInHorario) {
		this.checkInHorario = checkInHorario;
	}

	public LocalTime getCheckOutHorario() {
		return checkOutHorario;
	}

	public void setCheckOutHorario(LocalTime checkOutHorario) {
		this.checkOutHorario = checkOutHorario;
	}

	public Double getPrecioPorDia() {
		return this.precioPorDia;
	}

	public void setPrecioPorDia(Double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public Inmueble getInmueble() {
		return this.inmueble;
	}

	public void setPoliticaDeCancelacion(PoliticaDeCancelacionDeReserva politicaDeCancelacion) {
		this.politicaDeCancelacion = politicaDeCancelacion;
	}
	
	

	public PoliticaDeCancelacionDeReserva getPoliticaDeCancelacion() {
		return politicaDeCancelacion;
	}


	public Propietario getPropietario() {
		return this.propietario;
	}

	public Integer getCapacidad() {
		return this.inmueble.getCapacidad();
	}

	public String getCiudad() {
		return this.inmueble.getCiudad();
	}

	
	public Boolean checkDisponibilidadEntre(LocalDate fechaInicio, LocalDate fechaFin) {
		return calendario.checkDisponibilidadEntre(fechaInicio, fechaFin);
	}
	
	
	public void setPuntaje(Calificacion calificacion) {
		calculadorDeCalificaciones.agregarPuntaje(calificacion);
	}
	
	public void solicitarReserva(Solicitud solicitud) {
		this.getPropietario().recibirSolicitud(solicitud); 
	}

	public void cancelarReserva(Reserva reserva) {
		this.notificarPorCancelacion(reserva);
		this.calendario.sacarReserva(reserva);
		this.reservaPorCancelacionDe(reserva);
	}


	private void reservaPorCancelacionDe(Reserva reserva) {
		LocalDate fechaInicio = reserva.getFechaInicio();
		LocalDate fechaFin    = reserva.getFechaFin();
		
		this.propietario.aceptarSolicitudPorCancelacionEntre_Para(fechaInicio, fechaFin, this);
		
	}


	private void notificarPorCancelacion(Reserva reserva) {
		this.listeners.stream().forEach(listener -> listener.notificarPorCancelacion(this, reserva));
	}


	public void attachListener(IListener listener) {
		this.listeners.add(listener);
		
	}
	
	public void detachListener(IListener listener) {
		this.listeners.remove(listener);
	}


	public void disminuirPrecio(Double montoADisminuir) {
		this.precioPorDia -= montoADisminuir;
		this.listeners.stream().forEach(listener -> listener.notificarPorBajaDePrecio(this));
	}


	public Double calcularMontoPorCancelacionPara(Reserva reserva) {
		return this.politicaDeCancelacion.getMontoParaCancelacionDeReserva(reserva);	
	}
	
	public Boolean chequearSiElUsuarioTieneReserva(UsuarioInquilino usuario) {
		return ( this.getReservas().stream().anyMatch(r -> r.compararInquilino(usuario)));
	}

	public Boolean chequearCiudad(String ciudad) {
		return this.inmueble.getCiudad().equals(ciudad);
	}


	


}
