package src;

public class CancelacionBasica extends PoliticaDeCancelacionDeReserva{
		
		 /* Cancelaci�n gratuita hasta 10 d�as antes de la fecha de inicio de la
		ocupaci�n y luego abona el equivalente a dos d�as de reserva.

		 */
	
		@Override 
		public getMontoParaReserva(Reserva reserva, Publicacion publicacion) {
			private float montoAPagar = 0;
		
			long diferenciaEnDias = ChronoUnit.DAYS.between(LocalDate.now(), reserva.getFechaInicio());
			
			if(this.diferenciaEnDias < 10) {
				this.montoAPagar = (publicacion.getPrecioPorDia()* 2);
			}
			
		return this.montoAPagar;
		}
}