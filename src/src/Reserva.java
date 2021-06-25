package src;

import java.time.LocalDate;

public class Reserva implements iPeriodoDeTiempo {
	
	private UsuarioInquilino inquilino;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String metodoDePago;
	
	
	
	public Reserva(	UsuarioInquilino 	miInquilino,
					LocalDate 			miFechaInicio,
					LocalDate 			miFechaFin,
					String 				miMetodoDePago) {
		inquilino = miInquilino;
		fechaInicio = miFechaInicio;
		fechaFin = miFechaFin;
		metodoDePago = miMetodoDePago;
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
	
}
