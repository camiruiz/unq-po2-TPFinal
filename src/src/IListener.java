package src;

public interface IListener {

	public void notificarPorCancelacion(Publicacion publicacion, Reserva reserva);

	public void notificarPorBajaDePrecio(Publicacion publicacion);

}
