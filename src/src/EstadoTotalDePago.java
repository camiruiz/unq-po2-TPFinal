import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EstadoTotalDePago extends EstadoDeCancelacionIntermedia {
		
	@Override
	public float getMontoParaReserva(Reserva reserva, CancelacionIntermedia cancelacion) {

		float montoAPagar = 0; 

			if (this.getDiferenciaDeDias() >10) { 
				montoAPagar = reserva.getPrecioTotal();
			} else {
				cancelacion.tuEstadoEs(new EstadoGratuito());
				cancelacion.getMontoParaReserva(reserva);
		}
		return montoAPagar;
	}
}
