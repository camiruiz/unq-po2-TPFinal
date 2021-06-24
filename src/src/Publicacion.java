package src;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class Publicacion {

	private LocalTime checkInHorario;
	private LocalTime checkOutHorario;
	private Double precioPorDia;
	private List<Reserva> reservas;
	private List<LocalDate> diasDisponibles;
	private Inmueble inmueble;
	private Propietario propietario;
	private CalculadorDeCalificaciones calculadorDeCalificaciones;
	private Notificador notificador;
	private EstadoDeCancelacion politicaDeCancelacion;
	private List<TemporadaAlta> diasEnAumento;
	
	public Publicacion(	LocalDate fechaInicio, LocalDate fechaFin, 
						LocalTime horarioDeCheckIn, LocalTime horarioDeCheckOut, 
						Double precio, Inmueble miInmueble, Propietario miPropietario,
						Notificador miNotificador, EstadoDeCancelacion politicaDeCancel,
						CalculadorDeCalificaciones miCalculadorDeCalificaciones) 
	{
		super();
		reservas = new ArrayList<Reserva>();
		diasDisponibles = this.crearListaDeDiasDisponibles(fechaInicio, fechaFin);
		diasEnAumento = new ArrayList<TemporadaAlta>();
		checkInHorario = horarioDeCheckIn;
		checkOutHorario = horarioDeCheckOut;
		precioPorDia = precio;
		inmueble = miInmueble;
		propietario = miPropietario;
		notificador = miNotificador;
		politicaDeCancelacion = politicaDeCancel;
		calculadorDeCalificaciones = miCalculadorDeCalificaciones;
	}

	private List<LocalDate> crearListaDeDiasDisponibles(LocalDate fechaInicio, LocalDate fechaFin) {
		
		LocalDate fechaActual = fechaInicio;
		
		while(!fechaActual.equals(fechaFin)) {
			diasDisponibles.add(fechaActual);
			fechaActual = fechaActual.plusDays(1);
		}
	}
	
	public void aumentarPrecioEnPeriodo(LocalDate fechaDeInicio, LocalDate fechaDeFin, Double aumento) {
		diasEnAumento.add(new TemporadaAlta(fechaDeInicio, fechaDeFin, aumento));
	}
	
	public float getPuntaje() {
		return(this.calculadorDeCalificaciones.getPromedio());
	}
	
	public float setPuntaje(String, Integer) {
		return(this.calculadorDeCalificaciones.setPuntaje(String, Integer));
	}
	
	public void recibirReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void cancelarReserva(Reserva reserva) {
		//Precondicion: la reserva debe estar en mi lista de reservas
		this.reservas.remove(reserva);
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
		return diasDisponibles;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setPoliticaDeCancelacion(EstadoDeCancelacion politicaDeCancelacion) {
		this.politicaDeCancelacion = politicaDeCancelacion;
	}
	
}
