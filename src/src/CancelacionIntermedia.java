package src;

public class CancelacionIntermedia extends PoliticaDeCancelacionDeReserva{
	
	//Hasta 20 días antes es gratuita, entre el día 19 anterior y el
	//día 10 anterior paga el 50 %, después del 10mo día paga la totalidad.
	private EstadoDeCancelacionIntermedia estado;
	
	public CancelacionIntermedia () {
		
		this.estado = new EstadoGratuito();
	}
	
	public Double getMontoParaCancelacionDeReserva(Reserva reserva) {
		
		return this.estado.getMontoParaReserva(reserva, this);
	
	}
	
	public void tuEstadoEs(EstadoDeCancelacionIntermedia estado) {
		this.estado = estado;
	}
	
}