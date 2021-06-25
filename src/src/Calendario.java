package src;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Calendario {
	List<Reserva> reservas;
	List<TemporadaAlta> diasEnAumento;
	
	public Boolean checkDisponibilidadEntre(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return !(reservas.stream().anyMatch(r -> r.estaOcupadaEnFechas(fechaInicio, fechaFin)));
	}
	
	public Boolean estaOcupadaEnFechas(LocalDate fechaInicio, LocalDate fechaFin, iPeriodoDeTiempo periodo) {
		//Seteo un ArrayList<LocalDate> para el @Periodo recibido por parametro
		List<LocalDate>diasDeMiPeriodo = periodo.getFechaInicio().datesUntil(
																periodo.getFechaFin())
																.collect(Collectors.toList());
		
		//Seteo un ArrayList<LocalDate> para los dias a preguntar recibidos por parametro
		List<LocalDate>diasAPreguntar = fechaInicio.datesUntil(fechaFin).collect(Collectors.toList());
		
		return diasDeMiPeriodo.stream().anyMatch(diasAPreguntar::contains);
		
		//Se realizo con una interfaz debido a que tenemos que preguntar tanto por 
		//Reserva como por Temporada Alta(Que son los que implementan esta interfaz iPeriodoDeTiempo)
		
	}
	
}
