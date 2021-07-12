package src;

public class EstadoDeSolicitudDeReservaRechazado  extends EstadosDeSolicitudDeReserva {
	
	public void aceptar(Solicitud solicitud) {
		//Deberian poder aceptarme si estoy rechazado?
		solicitud.aceptar();
		solicitud.tuEstadoEs(new EstadoDeSolicitudDeReservaAceptado());
	}
	
	
	@Override
	public void rechazar(Solicitud solicitud) {
		//no hago nada ya estoy rechazado.
	}

}
