package src;

public class CancelacionBasica extends PoliticaDeCancelacionDeReserva{
		
		 /* Cancelación gratuita hasta 10 días antes de la fecha de inicio de la
		ocupación y luego abona el equivalente a dos días de reserva.

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