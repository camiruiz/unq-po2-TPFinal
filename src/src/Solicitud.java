package src;

import java.time.LocalDate;


public class Solicitud {
	
	private UsuarioInquilino inquilino;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String metodoDePago;
	private Publicacion publicacion;
	
	public Solicitud(	UsuarioInquilino miInquilino, 
						LocalDate miFechaInicio, 
						LocalDate miFechaFin, 
						String miMetodoDePago, 
						Publicacion miPublicacion) {
		
			super();
			fechaInicio 	= miFechaInicio;
			fechaFin 		= miFechaFin;
			metodoDePago 	= miMetodoDePago;
			publicacion		= miPublicacion;
	}
	
	public void aceptar() {
		Reserva reserva = this.generarReserva();
		this.darReservaALaPublicacion(reserva);
		this.sacarSolicitudAlPropietario();
	}

	private Reserva generarReserva() {
		return (new Reserva(this.inquilino,
							this.fechaInicio, 
							this.fechaFin, 
							this.metodoDePago));
	}

	private void darReservaALaPublicacion(Reserva reserva) {
		publicacion.recibirReserva(reserva);
	}

	private void sacarSolicitudAlPropietario() {
		this.sacarSolicitudAlPropietario();
	}
	
	public void rechazar() {
		this.publicacion.getPropietario().sacarSolicitud(this);
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
	
}
