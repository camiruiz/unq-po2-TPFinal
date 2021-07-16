package politicasDeCancelacion;

import publicacionesYBusquedas.Reserva;

public class SinCancelacion extends PoliticaDeCancelacionDeReserva {
	
		//Sin cancelaci�n: en caso de cancelar el usuario de todas formas paga
		//los d�as que hab�a reservado.
		
		@Override 
		public Double getMontoParaCancelacionDeReserva(Reserva reserva) {
			
			return reserva.getPrecioTotal(); 

		}
} 
	

       