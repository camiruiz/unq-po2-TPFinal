package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculadorDeCalificaciones.CalculadorDeCalificaciones;
import publicacionesYBusquedas.Publicacion;
import solicitud.Solicitud;
import usuarios.Propietario;

class PropietarioTest {
	
	String nombreCompleto;
	String email;
	String telefono;
	CalculadorDeCalificaciones calculadorDeCalificaciones;
	List<String> 	metodosDePago;
	List<Solicitud> solicitudes;
	Solicitud solicitud1;
	Solicitud solicitud2;
	Solicitud solicitud3;
	Publicacion publicacion;
	Propietario propietario;
	LocalDate 		fechaInicio1;
	LocalDate 		fechaFin1;
	LocalDate 		fechaInicio2;
	LocalDate 		fechaFin2;
	LocalDate 		fechaInicio3;
	LocalDate 		fechaFin3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		propietario = new Propietario(nombreCompleto, email, telefono, calculadorDeCalificaciones, metodosDePago);
		publicacion					= mock(Publicacion.class);
		nombreCompleto 				= "ElFlakito Spinetta";
		email 						= "elFlakkitoGOD@correocaliente.com";
		telefono 					= "0-800-LuisAlberto";
		calculadorDeCalificaciones 	= mock(CalculadorDeCalificaciones.class);
		metodosDePago				= new ArrayList<String>();
		solicitudes 				= new ArrayList<Solicitud>();
		solicitud1					= mock(Solicitud.class);
		solicitud2					= mock(Solicitud.class);
		solicitud3					= mock(Solicitud.class);
		fechaInicio1 				= LocalDate.now().plusDays(-10);
		fechaFin1 					= LocalDate.now().plusDays(-6);
		fechaInicio2 				= LocalDate.now().plusDays(-5);
		fechaFin2 					= LocalDate.now().plusDays(-1);
		fechaInicio3 				= LocalDate.now().plusDays(-9);
		fechaFin3 					= LocalDate.now().plusDays(-7);
		
		
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
	
	@Test
	void test004ElUsuarioPropietarioDevuelteSoloLaSolicitudUnoPorQueEsDePublicacion() {
		
		propietario.recibirSolicitud(solicitud1);
		propietario.recibirSolicitud(solicitud2);
		propietario.recibirSolicitud(solicitud3);
		when(solicitud1.esDePublicacion(publicacion)).thenReturn(true);
		when(solicitud2.esDePublicacion(publicacion)).thenReturn(false);
		when(solicitud3.esDePublicacion(publicacion)).thenReturn(false);
		
		List<Solicitud> solicitudesDePublicacion = propietario.solicitudesDePublicacion(publicacion);
		
		verify(solicitud1,times(1)).esDePublicacion(publicacion);
		verify(solicitud2,times(1)).esDePublicacion(publicacion);
		verify(solicitud3,times(1)).esDePublicacion(publicacion);
		
		assertTrue(solicitudesDePublicacion.contains(solicitud1));	
		assertFalse(solicitudesDePublicacion.contains(solicitud2));
		assertFalse(solicitudesDePublicacion.contains(solicitud3));
	}
	
	@Test
	void test005ElUsuarioPropietarioAceptaSoloLaSolicituddosPorQueEsLaUnicaQueCumple() {
		
		propietario.recibirSolicitud(solicitud1);
		propietario.recibirSolicitud(solicitud2);
		propietario.recibirSolicitud(solicitud3);
		when(solicitud1.esDePublicacion(publicacion)).thenReturn(true);
		when(solicitud2.esDePublicacion(publicacion)).thenReturn(true);
		when(solicitud3.esDePublicacion(publicacion)).thenReturn(false);
		
		when(solicitud1.estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1)).thenReturn(false);
		when(solicitud2.estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1)).thenReturn(true);
		
		propietario.aceptarSolicitudPorCancelacionEntre_Para(fechaInicio1, fechaFin1, publicacion);
		
		verify(solicitud1,times(1)).estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1);
		verify(solicitud2,times(1)).estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1);
		verify(solicitud3,times(0)).estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1);
		
		verify(solicitud1,times(0)).aceptar();
		verify(solicitud2,times(1)).aceptar();
		verify(solicitud3,times(0)).aceptar();
		
	}
	
	@Test
	void test006ElUsuarioPropietarioNoAceptaNingunaSolicitudPorQueNingunaMatche() {
		
		propietario.recibirSolicitud(solicitud1);
		propietario.recibirSolicitud(solicitud2);
		propietario.recibirSolicitud(solicitud3);
		when(solicitud1.esDePublicacion(publicacion)).thenReturn(true);
		when(solicitud2.esDePublicacion(publicacion)).thenReturn(true);
		when(solicitud3.esDePublicacion(publicacion)).thenReturn(true);
		
		when(solicitud1.estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1)).thenReturn(false);
		when(solicitud2.estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1)).thenReturn(false);
		when(solicitud3.estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1)).thenReturn(false);
		
		propietario.aceptarSolicitudPorCancelacionEntre_Para(fechaInicio1, fechaFin1, publicacion);
		
		verify(solicitud1,times(1)).estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1);
		verify(solicitud2,times(1)).estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1);
		verify(solicitud3,times(1)).estaPendienteYEntreFechasPara(fechaInicio1, fechaFin1);
		
		verify(solicitud1,times(0)).aceptar();
		verify(solicitud2,times(0)).aceptar();
		verify(solicitud3,times(0)).aceptar();
		
	}
	
	
	
	
	

}
