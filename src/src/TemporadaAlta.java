package src;

import java.time.LocalDate;

public class TemporadaAlta implements iPeriodoDeTiempo {
	
	LocalDate 	fechaInicio;
	LocalDate 	fechaFin;
	Double 		aumento;
	
	public TemporadaAlta(LocalDate fechaInicio, LocalDate fechaFin, Double aumento) {
		this.fechaInicio 	= fechaInicio;
		this.fechaFin 		= fechaFin;
		this.aumento		= aumento;
	}

	@Override
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	@Override
	public LocalDate getFechaFin() {
		return this.fechaFin;
	}
	

}
