import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EstadoMitadDePago extends EstadoDeCancelacionIntermedia{

	@Override
	public float getMontoParaReserva(Reserva reserva, CancelacionIntermedia cancelacion) {
		
		float montoAPagar = 0; 
	
			if (this.getDiferenciaDeDias() < 20 && this.getDiferenciaDeDias() >= 10) {
				montoAPagar = (reserva.getPrecioTotal() * 0.5);
			} else {
				cancelacion.tuEstadoEs(new EstadoTotalDePago());
				cancelacion.getMontoParaReserva(reserva, publicacion);
		}
		return montoAPagar;
	}
	
}
