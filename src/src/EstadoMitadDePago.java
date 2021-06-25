import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EstadoMitadDePago extends EstadoDeCancelacionIntermedia{

	@Override
	public Double getMontoParaReserva(Reserva reserva, CancelacionIntermedia cancelacion) {
		
		Double montoAPagar = 0.0; 
	
			if (this.getDiferenciaDeDias(reserva) < 20 && this.getDiferenciaDeDias(reserva) >= 10) {
				montoAPagar = (reserva.getPrecioTotal() * 0.5);
			} else {
				cancelacion.tuEstadoEs(new EstadoTotalDePago());
				montoAPagar = cancelacion.getMontoParaReserva(reserva);
		}
		return montoAPagar;
	}
	
}
