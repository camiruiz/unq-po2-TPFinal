import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class EstadoDeCancelacionIntermedia  {

	abstract public float getMontoParaReserva(Reserva reserva, CancelacionIntermedia cancelacion);
	
	public long getDiferenciaDeDias() {
		return ChronoUnit.DAYS.between(LocalDate.now(), reserva.getFechaInicio());
	}
}
