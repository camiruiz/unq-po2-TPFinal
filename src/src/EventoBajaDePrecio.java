package src;

import java.util.ArrayList;
import java.util.List;

public class EventoBajaDePrecio extends Evento {
	
	private List<IBajaDePrecio> listaANotificar;
	
	public EventoBajaDePrecio() {
		listaANotificar = new ArrayList<IBajaDePrecio>();
	}

	@Override
	public void notificarPorBajaDePrecio(Publicacion publicacion) {
		listaANotificar.stream().forEach(notificablePorBajaDePrecio -> notificablePorBajaDePrecio.serNotificadoPorBajaDePrecio(publicacion));
		
	}
	
	public void attach(IBajaDePrecio notificablePorBajaDePrecio) {
		listaANotificar.add(notificablePorBajaDePrecio);
	}
	
	public void dettach(IBajaDePrecio notificablePorBajaDePrecio) {
		listaANotificar.remove(notificablePorBajaDePrecio);
	}
	
}
