package src;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import src.PoliticaDeCancelacionDeReserva;

public class CancelacionBasica extends PoliticaDeCancelacionDeReserva{
		
		 /* Cancelaci�n gratuita hasta 10 d�as antes de la fecha de inicio de la
		ocupaci�n y luego abona el equivalente a dos d�as de reserva.

		 */
	
		@Override 
		public float getMontoParaReserva(Reserva reserva) {
			float montoAPagar = 0;
			long diferenciaEnDias = ChronoUnit.DAYS.between(LocalDate.now(), reserva.getFechaInicio());
			
			if(diferenciaEnDias < 10) {
				montoAPagar = (float) (reserva.getPrecioPorDia()* 2);
			}
			
		return montoAPagar;
		}
}