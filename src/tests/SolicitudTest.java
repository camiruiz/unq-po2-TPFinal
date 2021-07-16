package tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.*;
import publicacionesYBusquedas.Publicacion;
import solicitud.Solicitud;
import usuarios.UsuarioInquilino;

class SolicitudTest {

	UsuarioInquilino 	inquilino;
	String 				metodoDePago;
	Publicacion 		publicacion;
	Double				precioTotal;
	LocalDate 			fechaInicio1;
	LocalDate 			fechaFin1;
	LocalDate 			fechaInicio2;
	LocalDate 			fechaFin2;
	LocalDate 			fechaInicio3;
	LocalDate 			fechaFin3;
	Solicitud			solicitud;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		inquilino		= mock(UsuarioInquilino.class);                 
		fechaInicio1 	= LocalDate.now().plusDays(-10);
		fechaFin1 		= LocalDate.now().plusDays(-6);
		fechaInicio2 	= LocalDate.now().plusDays(-5);
		fechaFin2 		= LocalDate.now().plusDays(-1);
		fechaInicio3 	= LocalDate.now().plusDays(-9);
		fechaFin3 		= LocalDate.now().plusDays(-7);                  
		metodoDePago	= "Tarjeta";              
		publicacion		= mock(Publicacion.class);               
		precioTotal		= 200.0;               
		solicitud		= new Solicitud(inquilino, fechaInicio1, fechaFin1, metodoDePago, publicacion, precioTotal);
	}

	@Test
	void test001ElMetodoAceptarGeneraUnaReservaYSeLaEnviaAPublicacion() {
		solicitud.aceptar();
		verify(publicacion, times(1)).recibirReserva(any());
		
	}
	
	@Test
	void test002ElMetodoRechazarCambiaElEstadoDeLaSolicitud() {
		solicitud.rechazar();	
	}
	
	@Test
	void test003ElMetodoGetInquilinoDevuelveLaMismaInstanciaQueLaPasadaPorParametroCuandoSeInstancio() {
		UsuarioInquilino usuario2 = solicitud.getInquilino();
		
		assertEquals(usuario2, inquilino);
	}
	
	@Test
	void test004ElMetodogetPublicacionDevuelveLaMismaInstanciaQueLaPasadaPorParametroCuandoSeInstancio() {
		Publicacion publicacion2 = solicitud.getPublicacion();
		
		assertEquals(publicacion2, publicacion);
	}
	
	@Test
	void test004ElMetodoDePagoDevuelveLaMismaInstanciaQueLaPasadaPorParametroCuandoSeInstancio() {
		String metodoDePago = solicitud.getMetodoDePago();
		
		assertEquals(metodoDePago, metodoDePago);
	}
	
	@Test
	void test005ElMetodoGetFechaInicioDevuelveLaMismaInstanciaQueLaPasadaPorParametroCuandoSeInstancio() {
		LocalDate fechaInicio2 = solicitud.getFechaInicio();
		
		assertEquals(fechaInicio2, fechaInicio1);
	}
	
	@Test
	void test006ElMetodoGetFechaFinDevuelveLaMismaInstanciaQueLaPasadaPorParametroCuandoSeInstancio() {
		LocalDate fechaFin2 = solicitud.getFechaFin();
		
		assertEquals(fechaFin2, fechaFin1);
	}
	
	@Test
	void test007ElMetodoEsDePublicacionDaTrueAlDarleLaMismaPublicacionQueLaPasadaPorParametroALaHoraDeInstanciar() {

		assertTrue(solicitud.esDePublicacion(publicacion));
	}
	
	@Test
	void test008LaSolicitudDeVuelveTruePorqueEstaPendienteEntreFechasYLaFechaDadaPorParametroEstaEntreLosDiasHabilesDeLaSolicitud() {
		when(publicacion.checkDisponibilidadEntre(fechaInicio1, fechaFin1)).thenReturn(true);
		assertTrue(solicitud.estaPendienteYEntreFechasPara(fechaInicio3, fechaFin3));
		verify(publicacion, times(1)).checkDisponibilidadEntre(fechaInicio1, fechaFin1);
	}
	
	@Test
	void test008LaSolicitudDeVuelveFalsePorqueEstaPendientePeroNoEntreFechasYLaFechaDadaPorParametroNoEstaEntreLosDiasHabilesDeLaSolicitud() {
		assertFalse(solicitud.estaPendienteYEntreFechasPara(fechaInicio2, fechaFin2));
		verify(publicacion, times(0)).checkDisponibilidadEntre(fechaInicio1, fechaFin1);
	}
	
	

	
	
	
}
