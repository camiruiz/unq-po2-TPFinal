package src;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

	public Double aumentoParaDiasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		List<LocalDate> diasAChekear 		= fechaInicio.datesUntil(fechaFin).collect(Collectors.toList());
		List<LocalDate> diasDeTemporadaAlta	= this.fechaInicio.datesUntil(this.fechaFin).collect(Collectors.toList());
		diasAChekear = diasAChekear.stream().filter(diasDeTemporadaAlta::contains).collect(Collectors.toList());
		
		return diasAChekear.size() * aumento;
	}
	

}
