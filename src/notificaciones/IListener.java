package notificaciones;

import publicacionesYBusquedas.Publicacion;
import publicacionesYBusquedas.Reserva;

public interface IListener {

	public void notificarPorCancelacion(Publicacion publicacion, Reserva reserva);

	public void notificarPorBajaDePrecio(Publicacion publicacion);
	
	public void notificarPorReserva(Publicacion publicacion, Reserva reserva);

}
