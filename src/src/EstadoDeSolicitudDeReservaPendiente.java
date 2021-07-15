package src;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EstadoDeSolicitudDeReservaPendiente extends EstadosDeSolicitudDeReserva {

	
	@Override
	public void aceptar(Solicitud solicitud) {
		Reserva reserva = solicitud.generarReserva();
		solicitud.darReservaALaPublicacion(reserva);
		solicitud.tuEstadoEs(new EstadoDeSolicitudDeReservaPendiente());
	}
	
	
	@Override
	public void rechazar(Solicitud solicitud) {
		solicitud.tuEstadoEs(new EstadoDeSolicitudDeReservaRechazado());

	}
	
	public Boolean esPendienteYEstaDisponibleEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, Solicitud solicitud) {
		LocalDate fechaInicioDeSolicitud = solicitud.getFechaInicio();
		LocalDate fechaFinDeSolicitud = solicitud.getFechaFin();
		
		
		List<LocalDate> diasDeMiPeriodo = fechaInicioDeSolicitud.datesUntil(fechaFinDeSolicitud).collect(Collectors.toList());
		Boolean laSolicitudEstaEntreFechas = laSolicitudEstaEntreFechas(fechaInicio, fechaFin, diasDeMiPeriodo);
		
		
		return laSolicitudEstaEntreFechas && solicitud.getPublicacion().checkDisponibilidadEntre(fechaInicioDeSolicitud, fechaFinDeSolicitud);
	}


	private boolean laSolicitudEstaEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, List<LocalDate> diasDeMiPeriodo) {
		List<LocalDate> diasDeMiPeriodo2 = fechaInicio.datesUntil(fechaFin).collect(Collectors.toList());
		Boolean estaEntreFechas = diasDeMiPeriodo2.stream().anyMatch(dia -> diasDeMiPeriodo.contains(dia));
		return estaEntreFechas;
		///return diasDeMiPeriodo.contains(fechaInicio) || diasDeMiPeriodo.contains(fechaFin);
	}
	
	

}
