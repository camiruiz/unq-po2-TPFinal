package solicitud;

public class EstadoDeSolicitudDeReservaAceptado extends EstadosDeSolicitudDeReserva {
	
	public void aceptar(Solicitud solicitud) {
		//Nada que hacer, ya estoy aceptado.
	}
	
	
	@Override
	public void rechazar(Solicitud solicitud) {
		//Deberia poder rechazar solicitudes que ya fueron aceptadas?
		solicitud.rechazar();
		solicitud.tuEstadoEs(new EstadoDeSolicitudDeReservaRechazado());
	}

}
