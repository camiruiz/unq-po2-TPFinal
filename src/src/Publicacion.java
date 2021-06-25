package src;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;



public class Publicacion implements iPuntuable{

	private LocalTime checkInHorario;
	private LocalTime checkOutHorario;
	private Double precioPorDia;
	private List<Reserva> reservas;
	private List<LocalDate> diasDisponibles;
	private Inmueble inmueble;
	private Propietario propietario;
	private CalculadorDeCalificaciones calculadorDeCalificaciones;
	private Notificador notificador;
	private PoliticaDeCancelacionDeReserva politicaDeCancelacion;
	private List<TemporadaAlta> diasEnAumento;
	private Calendario calendario;
	
	public Publicacion(	LocalDate fechaInicio, 
						LocalDate fechaFin, 
						LocalTime horarioDeCheckIn, 
						LocalTime horarioDeCheckOut, 
						Double precio, 
						Inmueble miInmueble, 
						Propietario miPropietario,
						Notificador miNotificador, 
						PoliticaDeCancelacionDeReserva politicaDeCancel,
						CalculadorDeCalificaciones miCalculadorDeCalificaciones,
						Calendario calendario) {
		super();
		this.checkInHorario = horarioDeCheckIn;
		this.checkOutHorario = horarioDeCheckOut;
		this.precioPorDia = precio;
		this.inmueble = miInmueble;
		this.propietario = miPropietario;
		this.notificador = miNotificador;
		this.politicaDeCancelacion = politicaDeCancel;
		this.calculadorDeCalificaciones = miCalculadorDeCalificaciones;
		this.calendario = calendario;
	}

	
	public Double getPrecioTotalEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		Double precioActual= 0.0;
		if(this.calendario.tieneTemporadaAltaEntre(fechaInicio, fechaFin)){
			precioActual += this.calendario.calcularAumentoEntre(fechaInicio,fechaFin);
		}
		precioActual += this.precioPorDia * (ChronoUnit.DAYS.between(fechaInicio, fechaFin));
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
		this.propietario.getPuntaje();
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
		return precioPorDia;
	}

	public void setPrecioPorDia(Double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public List<LocalDate> getDiasDisponibles() {
		return this.diasDisponibles;
	}

	public Inmueble getInmueble() {
		return this.inmueble;
	}

	public void setPoliticaDeCancelacion(EstadoDeCancelacion politicaDeCancelacion) {
		this.politicaDeCancelacion = politicaDeCancelacion;
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

	//probablemente va al calendario
	public Boolean checkDisponibilidadEntre(LocalDate fechaInicio, LocalDate fechaFin) {
		return calendario.checkDisponibilidadEntre(fechaInicio, fechaFin);
	}
	
	
	public void setPuntaje(String categoria, Integer calificacion) {
		calculadorDeCalificaciones.agregarPuntaje(categoria, calificacion);
	}
	
	public void solicitarReserva(Solicitud solicitud) {
		this.getPropietario().recibirSolicitud(solicitud); //rompe encap
	}

}
