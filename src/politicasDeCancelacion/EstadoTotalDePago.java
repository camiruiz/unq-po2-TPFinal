package politicasDeCancelacion;

import publicacionesYBusquedas.Reserva;

public class EstadoTotalDePago extends EstadoDeCancelacionIntermedia {
		
	@Override
	public Double getMontoParaReserva(Reserva reserva, CancelacionIntermedia cancelacion) {

		Double montoAPagar = 0.0; 

			if (this.getDiferenciaDeDias(reserva) >10) { 
				montoAPagar = reserva.getPrecioTotal();
			} else {
				cancelacion.tuEstadoEs(new EstadoGratuito());
				montoAPagar = cancelacion.getMontoParaCancelacionDeReserva(reserva);
		}
		return montoAPagar;
	}
}
