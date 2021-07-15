package src;

import java.util.ArrayList;
import java.util.List;

public class EventoReserva extends Evento{
	private List<INotificablePorReserva> listaANotificar;
	
	public EventoReserva() {
		listaANotificar = new ArrayList<INotificablePorReserva>();
	}

	@Override
	public void notificarPorReserva(Publicacion publicacion, Reserva reserva) {
		listaANotificar.stream().forEach(notificablePorReserva -> notificablePorReserva.serNotificadoPorReserva(publicacion, reserva));
		
	}
	
	public void attach(INotificablePorReserva notificablePorReserva) {
		listaANotificar.add(notificablePorReserva);
	}
	
	public void dettach(INotificablePorReserva notificablePorReserva) {
		listaANotificar.remove(notificablePorReserva);
	}
}
