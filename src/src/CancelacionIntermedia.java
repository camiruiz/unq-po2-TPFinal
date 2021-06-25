package src;

public class CancelacionIntermedia extends PoliticaDeCancelacionDeReserva{
	
	//Hasta 20 d�as antes es gratuita, entre el d�a 19 anterior y el
	//d�a 10 anterior paga el 50 %, despu�s del 10mo d�a paga la totalidad.
	private EstadoDeCancelacionIntermedia estado;
	
	public CancelacionIntermedia () {
		
		this.estado = new EstadoGratuito();
	}
	
	public float getMontoParaReserva(Reserva reserva) {
		
		this.estado.getMontoParaReserva(reserva, this);
	
	}
	
	void tuEstadoEs(EstadoDeCancelacionIntermedia estado) {
		this.estado = estado;
	}
	
}