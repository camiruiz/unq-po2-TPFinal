package src;

import java.time.LocalDate;

public class UsuarioInquilino extends Usuario {
	
	

	

		// Constructor
		public UsuarioInquilino(String nombreCompleto, String email, String telefono, CalculadorDeCalificaciones calculadorDeCalificaciones) {
			super(nombreCompleto, email, telefono, calculadorDeCalificaciones);
			
			
		}

	
		public void solicitarReserva(Solicitud solicitud) {
			solicitud.getPublicacion().getPropietario().recibirSolicitud(solicitud); 
		}

	
}
