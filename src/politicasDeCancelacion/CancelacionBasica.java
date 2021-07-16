package politicasDeCancelacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import publicacionesYBusquedas.Reserva;

public class CancelacionBasica extends PoliticaDeCancelacionDeReserva{
		
		 /* Cancelación gratuita hasta 10 días antes de la fecha de inicio de la
		ocupación y luego abona el equivalente a dos días de reserva.

		 */
	
		@Override 
		public Double getMontoParaCancelacionDeReserva(Reserva reserva) {
			Double montoAPagar = 0.0;
			long diferenciaEnDias = ChronoUnit.DAYS.between(LocalDate.now(), reserva.getFechaInicio());
			
			if(diferenciaEnDias < 10) {
				montoAPagar = (Double) (reserva.getPrecioPorDia()* 2);
			}
			
		return montoAPagar;
		}
}