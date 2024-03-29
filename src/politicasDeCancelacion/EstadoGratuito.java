package politicasDeCancelacion;

import publicacionesYBusquedas.Reserva;

public class EstadoGratuito extends EstadoDeCancelacionIntermedia {

	@Override
	public Double getMontoParaReserva(Reserva reserva, CancelacionIntermedia cancelacion) {
 
		Double montoAPagar;
			if (this.getDiferenciaDeDias(reserva) >= 20) {
				montoAPagar = 0.0;
			} else {
				cancelacion.tuEstadoEs(new EstadoMitadDePago());
				montoAPagar = cancelacion.getMontoParaCancelacionDeReserva(reserva);
		}
			return montoAPagar;
	}
}
 