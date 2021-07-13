package src;

import java.time.LocalDate;

public class UsuarioInquilino extends Usuario {

	

		// Constructor
		public UsuarioInquilino(String nombreCompleto, String email, String telefono, CalculadorDeCalificaciones calculadorDeCalificaciones) {
			super(nombreCompleto, email, telefono, calculadorDeCalificaciones);
			
			
		}

	
		public void solicitarReserva(Publicacion publicacion, LocalDate fechaInicio, LocalDate fechaFin, String metodoDePago, Double precioTotal) {
			Solicitud solicitud = new Solicitud(this, fechaInicio, fechaFin, metodoDePago, publicacion, precioTotal); //rompe openclose
			publicacion.getPropietario().recibirSolicitud(solicitud); //rompe encap
		}

		public int vecesQueFueInquilino() {
			return 0;
		}

	
}
