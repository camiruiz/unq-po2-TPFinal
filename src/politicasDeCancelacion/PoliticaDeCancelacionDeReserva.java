package politicasDeCancelacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import publicacionesYBusquedas.Reserva;

public abstract class PoliticaDeCancelacionDeReserva {

	abstract public Double getMontoParaCancelacionDeReserva(Reserva reserva);

}