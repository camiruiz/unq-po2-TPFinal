package notificaciones;

import publicacionesYBusquedas.Publicacion;
import publicacionesYBusquedas.Reserva;

public interface ICancelable {
	public abstract void serNotificadoPorCancelacion(Publicacion publicacion, Reserva reserva);
}
