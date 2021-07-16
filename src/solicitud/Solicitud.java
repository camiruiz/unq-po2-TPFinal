package solicitud;

import java.time.LocalDate;

import publicacionesYBusquedas.Publicacion;
import publicacionesYBusquedas.Reserva;
import usuarios.UsuarioInquilino;


public class Solicitud {
	
	private UsuarioInquilino 			inquilino;
	private LocalDate 					fechaInicio;
	private LocalDate 					fechaFin;
	private String 						metodoDePago;
	private Publicacion 				publicacion;
	private Double						precioTotal;
	private EstadosDeSolicitudDeReserva	estadoDeSolicitudDeReserva;
	
	public Solicitud(	UsuarioInquilino miInquilino, 
						LocalDate miFechaInicio, 
						LocalDate miFechaFin, 
						String miMetodoDePago, 
						Publicacion miPublicacion,
						Double precioTotal) {
		
			super();
			this.inquilino					= miInquilino;
			this.fechaInicio 				= miFechaInicio;
			this.fechaFin 					= miFechaFin;
			this.metodoDePago 				= miMetodoDePago;
			this.publicacion				= miPublicacion;
			this.precioTotal				= precioTotal;
			this.estadoDeSolicitudDeReserva	= new EstadoDeSolicitudDeReservaPendiente();
			
	}
	

	public Reserva generarReserva() {
		return new Reserva(this.inquilino,
							this.fechaInicio, 
							this.fechaFin, 
							this.metodoDePago,
							this.precioTotal);
	}
	
	public void aceptar() {
		this.estadoDeSolicitudDeReserva.aceptar(this);
	}

	public void darReservaALaPublicacion(Reserva reserva) {
		publicacion.recibirReserva(reserva);
	}

	public void rechazar() {
		this.estadoDeSolicitudDeReserva.rechazar(this);
	}

	public UsuarioInquilino getInquilino() {
		return inquilino;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public String getMetodoDePago() {
		return metodoDePago;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}
	
	public void tuEstadoEs(EstadosDeSolicitudDeReserva estado) {
		estadoDeSolicitudDeReserva = estado;
	}


	public Boolean estaPendienteYEntreFechasPara(LocalDate fechaInicio, LocalDate fechaFin) {
		return this.estadoDeSolicitudDeReserva.esPendienteYEstaDisponibleEntreFechas(fechaInicio, fechaFin, this);
	}


	public Boolean esDePublicacion(Publicacion publicacion) {
		return this.publicacion.equals(publicacion);
	}
	
}
