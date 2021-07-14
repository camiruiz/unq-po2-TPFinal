package src;

import java.util.ArrayList;
import java.util.List;

public class EventoCancelacion extends Evento{
	
	private List<ICancelable> listaANotificar;
	
	public EventoCancelacion() {
		listaANotificar = new ArrayList<ICancelable>();
	}

	
	
	@Override
	public void notificarPorCancelacion(Publicacion publicacion, Reserva reserva) {
		listaANotificar.stream().forEach(cancelable -> cancelable.serNotificadoPorCancelacion(publicacion, reserva));
		
	}
	
	public void attach(ICancelable cancelable) {
		listaANotificar.add(cancelable);
	}
	
	public void dettach(ICancelable cancelable) {
		listaANotificar.remove(cancelable);
	}



}
