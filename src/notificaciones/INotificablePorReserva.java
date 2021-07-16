package notificaciones;

import publicacionesYBusquedas.Publicacion;
import publicacionesYBusquedas.Reserva;

public interface INotificablePorReserva {

	public abstract void serNotificadoPorReserva(Publicacion publicacion, Reserva reserva);

}
