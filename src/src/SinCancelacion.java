package src;

public class SinCancelacion extends PoliticaDeCancelacionDeReserva {
	
		//Sin cancelaci�n: en caso de cancelar el usuario de todas formas paga
		//los d�as que hab�a reservado.
		
		@Override 
		public float getMontoParaReserva(Reserva reserva) {
			
			return reserva.getPrecioTotal(); 

		}
} 
	

       