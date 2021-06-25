package src;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

<<<<<<< HEAD


public class Reserva {
=======
public class Reserva implements iPeriodoDeTiempo {
>>>>>>> cc5ec2e86f79c1b1a4f5173264f7dc9fcdd13558
	
	private UsuarioInquilino 	inquilino;
	private LocalDate 			fechaInicio;
	private LocalDate 			fechaFin;
	private String 				metodoDePago;
	private Double 				precioTotal;
	
	
	public Reserva(	UsuarioInquilino 	miInquilino,
					LocalDate 			miFechaInicio,
					LocalDate 			miFechaFin,
					String 				miMetodoDePago,
					Double              precioTotal) {
		super();
		this.inquilino 		= miInquilino;
		this.fechaInicio 	= miFechaInicio;
		this.fechaFin 		= miFechaFin;
		this.metodoDePago 	= miMetodoDePago;
		this.precioTotal 	= precioTotal;
	}
	
	
	public UsuarioInquilino getInquilino() {
		return this.inquilino;
		
	}
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	public LocalDate getFechaFin() {
		return this.fechaFin;
	}
<<<<<<< HEAD
	public String getMetodoDePago() {
		return this.metodoDePago;
	}



	public Boolean compararInquilino(UsuarioInquilino usuario) {
		return this.inquilino.equals(usuario);
	}


	public Boolean chequearSiEsFutura(UsuarioInquilino usuario) {
		return this.fechaInicio.isAfter(LocalDate.now());
	}

=======
	public String getMetodoDePago() {
		return metodoDePago;
	}	
>>>>>>> cc5ec2e86f79c1b1a4f5173264f7dc9fcdd13558
	
	public Double getPrecioTotal() {
		return this.precioTotal;
	}
	
	public long getPeriodoDeDias() {
		long diasTotalesDeReserva = ChronoUnit.DAYS.between(this.fechaInicio, this.fechaFin);
		return diasTotalesDeReserva;
	}
	
	public Double getPrecioPorDia() {
		return this.precioTotal / this.getPeriodoDeDias();
	}	
}
