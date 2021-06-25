import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class EstadoDeCancelacionIntermedia  {

	abstract public Double getMontoParaReserva(Reserva reserva, CancelacionIntermedia cancelacion);
	
	public long getDiferenciaDeDias(Reserva reserva) {
		return ChronoUnit.DAYS.between(LocalDate.now(), reserva.getFechaInicio());
	}
}
