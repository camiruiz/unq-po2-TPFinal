package src;

public class CancelacionIntermedia extends PoliticaDeCancelacionDeReserva{
	
	//Hasta 20 d�as antes es gratuita, entre el d�a 19 anterior y el
	//d�a 10 anterior paga el 50 %, despu�s del 10mo d�a paga la totalidad.

	
	@Override 
	public getMontoParaReserva(Reserva reserva, Publicacion publicacion) {
		
		private float montoAPagar = 0; 
		
		long diferenciaEnDias = ChronoUnit.DAYS.between(LocalDate.now(), reserva.fechaInicio());

			if (this.diferenciaEnDias< 20 && this.diferenciaEnDias >10) {
				this.montoAPagar = (reserva.getPrecioTotal() * 0.5);
			} else if (this.diferenciaEnDias >10) { 
				this.montoAPagar = reserva.getPrecioTotal();
		}
			
		return this.montoAPagar;
	
	}
}