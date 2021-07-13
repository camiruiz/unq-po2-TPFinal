package src;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends UsuarioInquilino {
	
	
	private List<String> metodosDePago;
	private List<Solicitud> solicitudes;

	// Constructor
	public Propietario(String nombreCompleto, String email, String telefono, CalculadorDeCalificaciones calculadorDeCalificaciones, List<String> metodosDePago) {
		super(nombreCompleto, email, telefono, calculadorDeCalificaciones);
		this.metodosDePago = new ArrayList<String>(metodosDePago);

	}
	
	
	public List<String> getMetodosDePago() {
		return metodosDePago;
	}



	public void setMetodosDePago(List<String> metodosDePago) {
		this.metodosDePago = metodosDePago;
	}



	public void sacarSolicitud(Solicitud solicitud) {
		this.solicitudes.remove(solicitud);
		
	}

	public void recibirSolicitud(Solicitud solicitud) {
		this.solicitudes.add(solicitud);
		
	}

	
	
}
