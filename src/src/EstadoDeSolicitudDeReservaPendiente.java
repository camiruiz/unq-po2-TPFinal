package src;

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
	

}
