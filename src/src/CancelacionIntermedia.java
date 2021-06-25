package src;

public class CancelacionIntermedia extends PoliticaDeCancelacionDeReserva{
	
	//Hasta 20 días antes es gratuita, entre el día 19 anterior y el
	//día 10 anterior paga el 50 %, después del 10mo día paga la totalidad.

	
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