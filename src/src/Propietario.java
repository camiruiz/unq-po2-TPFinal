package src;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends UsuarioInquilino {
	
	
	private List<String> metodosDePago;
	private List<Solicitud> solicitudes;

	// Constructor
	public Propietario(String nombreCompleto, String email, String telefono, CalculadorDeCalificaciones calculadorDeCalificaciones, List<String> metodosDePago) {
		super(nombreCompleto, email, telefono, calculadorDeCalificaciones);
		
		this.metodosDePago = new ArrayList<String>();
		this.solicitudes   = new ArrayList<Solicitud>();

	}
	
	
	public List<String> getMetodosDePago() {
		return metodosDePago;
	}
	
	
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}


	public void setMetodoDePago(String metodoDePago) {
		this.metodosDePago.add(metodoDePago);
	}



	public void sacarSolicitud(Solicitud solicitud) {
		this.solicitudes.remove(solicitud);
		
	}

	public void recibirSolicitud(Solicitud solicitud) {
		this.solicitudes.add(solicitud);
		
	}

	
	
}
