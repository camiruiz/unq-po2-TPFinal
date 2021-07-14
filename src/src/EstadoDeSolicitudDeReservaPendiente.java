package src;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EstadoDeSolicitudDeReservaPendiente extends EstadosDeSolicitudDeReserva {

	
	@Override
	public void aceptar(Solicitud solicitud) {
		solicitud.aceptar();
		solicitud.tuEstadoEs(new EstadoDeSolicitudDeReservaPendiente());
	}
	
	
	@Override
	public void rechazar(Solicitud solicitud) {
		solicitud.rechazar();
		solicitud.tuEstadoEs(new EstadoDeSolicitudDeReservaRechazado());

	}
	
	public Boolean esPendienteYEstaDisponibleEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, Solicitud solicitud) {
		List<LocalDate> diasDeMiPeriodo = solicitud.getFechaInicio().datesUntil(solicitud.getFechaFin()).collect(Collectors.toList());
		Boolean laSolicitudEstaEntreFechas = laSolicitudEstaEntreFechas(fechaInicio, fechaFin, diasDeMiPeriodo);
		
		
		return laSolicitudEstaEntreFechas && solicitud.getPublicacion().checkDisponibilidadEntre(fechaInicio, fechaFin);
	}


	private boolean laSolicitudEstaEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, List<LocalDate> diasDeMiPeriodo) {
		return diasDeMiPeriodo.contains(fechaInicio) || diasDeMiPeriodo.contains(fechaFin);
	}
	
	

}
