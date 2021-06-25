import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import src.Publicacion;
import src.Reserva;

public class EstadoGratuito extends EstadoDeCancelacionIntermedia {

	@Override
	public float getMontoParaReserva(Reserva reserva, CancelacionIntermedia cancelacion) {

		float montoAPagar = 0; 
 	
			if (this.getDiferenciaDeDias() >= 20) {
				montoAPagar = 0;
			} else {
				cancelacion.tuEstadoEs(new EstadoMitadDePago());
				cancelacion.getMontoParaReserva(reserva, publicacion);
		}
			return montoAPagar;
	}
}
 