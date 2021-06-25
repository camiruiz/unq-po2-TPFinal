package src;

public class SinCancelacion extends PoliticaDeCancelacionDeReserva {
	
		//Sin cancelación: en caso de cancelar el usuario de todas formas paga
		//los días que había reservado.
		
		@Override 
		public getMontoParaReserva(Reserva reserva, Publicacion publicacion) {
			
			return reserva.getPrecioTotal(); 
			
			//hacer get precio total en reserva entre fecha inicio y fin
			//long diasTotalesDeReserva = ChronoUnit.DAYS.between(reserva.fechaInicio(), reserva.fechaFin());
			//x el precioxdia de la publicacion=total

		}
} 
	

       