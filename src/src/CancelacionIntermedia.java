package src;

public class CancelacionIntermedia extends PoliticaDeCancelacionDeReserva{
	
	//Hasta 20 d�as antes es gratuita, entre el d�a 19 anterior y el
	//d�a 10 anterior paga el 50 %, despu�s del 10mo d�a paga la totalidad.
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