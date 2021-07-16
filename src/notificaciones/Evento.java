package notificaciones;

import publicacionesYBusquedas.Publicacion;
import publicacionesYBusquedas.Reserva;

public abstract class Evento implements IListener {

	
	@Override
	public void notificarPorCancelacion(Publicacion publicacion, Reserva reserva) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarPorBajaDePrecio(Publicacion publicacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarPorReserva(Publicacion publicacion, Reserva reserva) {
		// TODO Auto-generated method stub
		
	}

}
