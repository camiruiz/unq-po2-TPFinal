package solicitud;

import java.time.LocalDate;

public abstract class EstadosDeSolicitudDeReserva {
	
	public abstract void aceptar(Solicitud solicitud);
	
	
	public abstract void rechazar(Solicitud solicitud);


	public Boolean esPendienteYEstaDisponibleEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, Solicitud solicitud) {
		return false;
	}
		
}
