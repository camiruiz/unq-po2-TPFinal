package usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import calculadorDeCalificaciones.CalculadorDeCalificaciones;
import publicacionesYBusquedas.Publicacion;
import solicitud.Solicitud;

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

	public List<Solicitud> solicitudesDePublicacion(Publicacion publicacion){
		List<Solicitud> solicitudesDePublicacion = this.solicitudes.stream().filter(solicitud -> solicitud.esDePublicacion(publicacion)).collect(Collectors.toList());
		return(solicitudesDePublicacion);
	}
	
	public void aceptarSolicitudPorCancelacionEntre_Para(LocalDate fechaInicio, LocalDate fechaFin, Publicacion publicacion) {
		List<Solicitud> solicitudesDePublicacion = this.solicitudesDePublicacion(publicacion);
		Optional<Solicitud> solicitudOptional = solicitudesDePublicacion.stream().filter(solicitud -> solicitud.estaPendienteYEntreFechasPara(fechaInicio,fechaFin)).findFirst();
		if(solicitudOptional.isPresent()) {
			solicitudOptional.get().aceptar();
		}	
	}
	
}
