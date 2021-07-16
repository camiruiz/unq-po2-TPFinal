package publicacionesYBusquedas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Calendario {
	List<Reserva> reservas;
	List<TemporadaAlta> diasEnAumento;
	
	public Calendario() {
		this.reservas 		= new ArrayList<Reserva>();
		this.diasEnAumento	= new ArrayList<TemporadaAlta>();
		
	}
	
	public Boolean checkDisponibilidadEntre(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return !(reservas.stream().anyMatch(r -> this.estaOcupadaEnFechas(fechaInicio, fechaFin,r)));
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

	public boolean tieneTemporadaAltaEntre(LocalDate fechaInicio, LocalDate fechaFin) {
		return diasEnAumento.stream().anyMatch(temporadaAlta -> this.estaOcupadaEnFechas(fechaInicio, fechaFin, temporadaAlta));
	}
	
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	public void addDiasEnAumento(TemporadaAlta temporadaAlta) {
		this.diasEnAumento.add(temporadaAlta);
	}

	public Double calcularAumentoEntre(LocalDate fechaInicio, LocalDate fechaFin) {
		
		Double totalAumento = 0.0;
		for (TemporadaAlta temporadaAlta : this.diasEnAumento) {
            totalAumento += temporadaAlta.aumentoParaDiasEntreFechas(fechaInicio, fechaFin);
        }
		
		return totalAumento;
		
	}

	public void sacarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}

	public List<Reserva> getReservas() {
		// TODO Auto-generated method stub
		return this.reservas;
	}
	

}
