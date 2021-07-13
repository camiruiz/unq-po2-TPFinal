package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropietarioTest {
	
	private String nombreCompleto;
	private String email;
	private String telefono;
	private CalculadorDeCalificaciones calculadorDeCalificaciones;
	private List<String> 	metodosDePago;
	private List<Solicitud> solicitudes;
	private Solicitud solicitud1;
	private Solicitud solicitud2;
	private Solicitud solicitud3;
	
	Propietario propietario;
	
	@BeforeEach
	void setUp() throws Exception {
		
		propietario = new Propietario(nombreCompleto, email, telefono, calculadorDeCalificaciones, metodosDePago);
		
		nombreCompleto 				= "ElFlakito Spinetta";
		email 						= "elFlakkitoGOD@correocaliente.com";
		telefono 					= "0-800-LuisAlberto";
		calculadorDeCalificaciones 	= mock(CalculadorDeCalificaciones.class);
		metodosDePago				= new ArrayList<String>();
		solicitudes 				= new ArrayList<Solicitud>();
		solicitud1					= mock(Solicitud.class);
		solicitud2					= mock(Solicitud.class);
		solicitud3					= mock(Solicitud.class);
		
		
	}

	
	@Test
	void test001ElUsuarioPropietarioSabeSusMetodosDepago() {
		
		String metodoDePago = "TarjetaDeCredito";
		
		propietario.setMetodoDePago(metodoDePago);
		
		assertTrue(propietario.getMetodosDePago().contains(metodoDePago));
		
	}
	
	@Test
	void test002ElUsuarioPropietarioPuedeRecibirSolicitudes() {
		
		propietario.recibirSolicitud(solicitud1);
		
		assertTrue(propietario.getSolicitudes().contains(solicitud1));	
	}
	
	@Test
	void test003ElUsuarioPropietarioPuedeSacarSolicitudes() {
		
		propietario.recibirSolicitud(solicitud1);
		propietario.recibirSolicitud(solicitud2);
		propietario.recibirSolicitud(solicitud3);
		assertTrue(propietario.getSolicitudes().contains(solicitud1));
		assertTrue(propietario.getSolicitudes().contains(solicitud2));
		assertTrue(propietario.getSolicitudes().contains(solicitud3));
		
		propietario.sacarSolicitud(solicitud1);
		
		assertFalse(propietario.getSolicitudes().contains(solicitud1));	
		assertTrue(propietario.getSolicitudes().contains(solicitud2));
		assertTrue(propietario.getSolicitudes().contains(solicitud3));
	}
	
	

}
