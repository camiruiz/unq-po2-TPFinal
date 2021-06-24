package src;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



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
	private EstadoDeCancelacion politicaDeCancelacion;
	private List<TemporadaAlta> diasEnAumento;
	
	public Publicacion(	LocalDate fechaInicio, 
						LocalDate fechaFin, 
						LocalTime horarioDeCheckIn, 
						LocalTime horarioDeCheckOut, 
						Double precio, 
						Inmueble miInmueble, 
						Propietario miPropietario,
						Notificador miNotificador, 
						EstadoDeCancelacion politicaDeCancel,
						CalculadorDeCalificaciones miCalculadorDeCalificaciones) {
		super();
		this.reservas = new ArrayList<Reserva>();
		this.diasDisponibles = crearListaDeDias(fechaInicio, fechaFin);
		this.diasEnAumento = new ArrayList<TemporadaAlta>();
		this.checkInHorario = horarioDeCheckIn;
		this.checkOutHorario = horarioDeCheckOut;
		this.precioPorDia = precio;
		this.inmueble = miInmueble;
		this.propietario = miPropietario;
		this.notificador = miNotificador;
		this.politicaDeCancelacion = politicaDeCancel;
		this.calculadorDeCalificaciones = miCalculadorDeCalificaciones;
	}

	private List<LocalDate> crearListaDeDias(LocalDate fechaInicio, LocalDate fechaFin) {
		
		LocalDate fechaActual 	= fechaInicio;
		List<LocalDate> listaDeDias= new ArrayList<LocalDate>();
		
		while(!fechaActual.equals(fechaFin)) {
			listaDeDias.add(fechaActual);
			fechaActual = fechaActual.plusDays(1);
		}
		return(listaDeDias);
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

	public Boolean checkDisponibilidadEntre(LocalDate fechaInicio, LocalDate fechaFin) {
		List<LocalDate> listaDeDias = crearListaDeDias(fechaInicio, fechaFin);
		
		return diasDisponibles.contains(listaDeDias);
	}

}
