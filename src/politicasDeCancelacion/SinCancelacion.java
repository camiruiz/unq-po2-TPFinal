package politicasDeCancelacion;

import publicacionesYBusquedas.Reserva;

public class SinCancelacion extends PoliticaDeCancelacionDeReserva {
	
		//Sin cancelación: en caso de cancelar el usuario de todas formas paga
		//los días que había reservado.
		
		@Override 
		public Double getMontoParaCancelacionDeReserva(Reserva reserva) {
			
			return reserva.getPrecioTotal(); 

		}
} 
	

       