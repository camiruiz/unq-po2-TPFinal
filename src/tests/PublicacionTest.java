package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.*;
import calculadorDeCalificaciones.CalculadorDeCalificaciones;
import calculadorDeCalificaciones.Calificacion;
import notificaciones.IListener;
import politicasDeCancelacion.PoliticaDeCancelacionDeReserva;
import publicacionesYBusquedas.Calendario;
import publicacionesYBusquedas.Inmueble;
import publicacionesYBusquedas.Publicacion;
import publicacionesYBusquedas.Reserva;
import publicacionesYBusquedas.TemporadaAlta;
import solicitud.Solicitud;
import usuarios.Propietario;
import usuarios.UsuarioInquilino;


class PublicacionTest {

	
	LocalTime 						checkInHorario;
	LocalTime						checkOutHorario;
	Double					 		precioPorDia;
	Inmueble 						inmueble;
	Propietario 					propietario;
	UsuarioInquilino 				usuarioInquilino;
	CalculadorDeCalificaciones 		calculadorDeCalificaciones;
	PoliticaDeCancelacionDeReserva 	politicaDeCancelacion;
	Reserva							reserva;
	Calendario 						calendario;
	IListener						listener;
	IListener						listener2;

	
	Publicacion publicacion1;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		checkInHorario 				= mock(LocalTime.class);             
		checkOutHorario				= mock(LocalTime.class);            
		precioPorDia				= 12.0;                                            
		inmueble					= mock(Inmueble.class);                   
		propietario					= mock(Propietario.class);      
		calculadorDeCalificaciones 	= mock(CalculadorDeCalificaciones.class);                
		politicaDeCancelacion		= mock(PoliticaDeCancelacionDeReserva.class);      
		calendario					= mock(Calendario.class);
		reserva						= mock(Reserva.class);
		listener					= mock(IListener.class);
		listener2					= mock(IListener.class);
		usuarioInquilino			= mock(UsuarioInquilino.class);
		
		publicacion1 = new Publicacion(	checkInHorario, 
										checkOutHorario,
										precioPorDia,
										inmueble,
										propietario,
										politicaDeCancelacion, 
										calculadorDeCalificaciones,  
										calendario);
	}

	@Test
	void test001unListenerRecibeLaNotificacionSiSeSubstribeAUnaPublicacionPorCancelacion() {
		publicacion1.recibirReserva(reserva);
		publicacion1.attachListener(listener);
		publicacion1.attachListener(listener2);
		publicacion1.detachListener(listener2);
		
		publicacion1.cancelarReserva(reserva);

		verify(listener, times(1)).notificarPorCancelacion(publicacion1, reserva);
		verify(listener2, times(0)).notificarPorCancelacion(publicacion1, reserva);
		verify(calendario, times(1)).addReserva(reserva);
	}
	
	@Test
	void test002unListenerRecibeLaNotificacionSiSeSubstribeAUnaPublicacionBajaDePrecio() {
		Double montoADisminuir = 25.0;
		publicacion1.attachListener(listener);
		publicacion1.disminuirPrecio(montoADisminuir);
		
		verify(listener, times(0)).notificarPorCancelacion(publicacion1, reserva);
		verify(listener, times(1)).notificarPorBajaDePrecio(publicacion1);
	}
	
	 @Test 
	 void test003unaPublicacionConoceElPrecioParaLaCancelacionDeUnaReserva() {
		 publicacion1.calcularMontoPorCancelacionPara(reserva);

		 verify(politicaDeCancelacion, times(1)).getMontoParaCancelacionDeReserva(reserva);
	 }

	 @Test 
	 void test004unaPublicacionConsultaASuInmueblePorSuCiudad() {
		 publicacion1.getCiudad();
		 verify(inmueble, times(1)).getCiudad();
	 }
	 
	 @Test 
	 void test005unaPublicacionConsultaASuInmueblePorSuCiudad() {
		 publicacion1.getCapacidad();
		 verify(inmueble, times(1)).getCapacidad();
	 }
	 
//	 @Test 
//	 void test006unaPublicacionConsultaASuInmueblePorSuCiudad() {
//		 
//		 LocalTime checkInHorarioNuevo = LocalTime.now();
//		 publicacion1.setCheckInHorario(checkInHorarioNuevo);
//		 LocalTime horarioResultante = publicacion1.getCheckInHorario();
//		 
//		 assertEquals(horarioResultante , horarioResultante);
//	 }
	 
	 @Test 
	 void test007unaPublicacionDelegaSuResponsabilidadAlCalculadorCuandoCalculaSuPromedio() {
		 Calificacion calificacionNueva = mock(Calificacion.class);
		 publicacion1.setPuntaje(calificacionNueva);
		 publicacion1.getPuntaje();
		 verify(calculadorDeCalificaciones, times(1)).agregarPuntaje(calificacionNueva);
		 verify(calculadorDeCalificaciones, times(1)).calcularPromedio();
	 }
	 
	 @Test
	 void test008unaPublicacionDelegaLaResponsabilidadALaHoraDeMarcarUnaTemporadaAlta() {
		 TemporadaAlta tem1 = mock(TemporadaAlta.class);
		 publicacion1.aumentarPrecioEnPeriodo(tem1);
		 verify(calendario, times(1)).addDiasEnAumento(tem1);
		 
	 }
	 
	 @Test
	 void test009AlDueñoDeUnaPublicacionLeLlegaElMensajeCuandoSeConsultaPorElPromedioDeSuDueño() {
		 publicacion1.puntajeDueño();
		 verify(propietario, times(1)).getPuntaje();
	 }
	 
	 @Test
	 void test010unaPublicacionDelegaLaResponsabilidadAlCalendarioCuandoSeChekeaLaDisponibilidad() {
		 LocalDate l1 = LocalDate.now();
		 LocalDate l2 = LocalDate.now();
		 publicacion1.checkDisponibilidadEntre(l1, l2);
		 
		 verify(calendario, times(1)).checkDisponibilidadEntre(l1, l2);
	 }
	 
	 
	 @Test
	 void test011unaPublicacionLeEnviaLaSolicitudDeReservaAlDueño() {
		 Solicitud solicitudNueva = mock(Solicitud.class);
		 publicacion1.solicitarReserva(solicitudNueva);
		 verify(propietario, times(1)).recibirSolicitud(solicitudNueva);
	 }
	 
	 @Test
	 void test012UnaPublicacionCalculaElPrecioEntreDosFechasYComoHayAumentoCalculaSuPrecioAumentado() {
		 LocalDate l1 = LocalDate.now().plusDays(2);
		 LocalDate l2 = LocalDate.now().plusDays(10);
		 
		 when(calendario.tieneTemporadaAltaEntre(l1, l2)).thenReturn(true);
		 when(calendario.calcularAumentoEntre(l1, l2)).thenReturn(30.0);
		 
		 
		 
		 Double precioTotal = publicacion1.getPrecioTotalEntreFechas(l1, l2);
		 
		 verify(calendario, times(1)).tieneTemporadaAltaEntre(l1, l2);
		 verify(calendario, times(1)).calcularAumentoEntre(l1, l2);
		 
		 assertEquals(precioTotal, 126.0);
	 }
	 
	
	 @Test
	 void test013unaPublicacionCalculaElPrecioEntreDosFechasYComoNoHayAumentoCalculaSuPrecioNormalmente() {
		 LocalDate l1 = LocalDate.now().plusDays(2);
		 LocalDate l2 = LocalDate.now().plusDays(10);
		 
		 when(calendario.tieneTemporadaAltaEntre(l1, l2)).thenReturn(false);
		 
		 Double precioTotal = publicacion1.getPrecioTotalEntreFechas(l1, l2);
		 
		 verify(calendario, times(1)).tieneTemporadaAltaEntre(l1, l2);
		 verify(calendario, times(0)).calcularAumentoEntre(l1, l2);
		 
		 assertEquals(precioTotal, 96.0);
	 }
	 
	 
	 @Test
	 void test014unaPublicacionSabeSuCalendario() {
		 
		 assertEquals(publicacion1.getCalendario(), calendario);
	 }
	 
	 @Test
	 void test0015unaPublicacionSabeSusReservas() {
		 
		 ArrayList<Reserva> listaDeReservas = new ArrayList<Reserva>();
		 listaDeReservas.add(reserva);
		 publicacion1.recibirReserva(reserva);
		 when(calendario.getReservas()).thenReturn(listaDeReservas);
		 verify(calendario, times(1)).addReserva(reserva);
		 assertTrue(publicacion1.getReservas().contains(reserva));
	 }
	 
	 @Test
	 void test015unaPublicacionSabeSuHorarioDeCheckIn() {
		 publicacion1.setCheckInHorario(checkInHorario);
		 
		 assertEquals(publicacion1.getCheckInHorario(), checkInHorario);
		 
	 }
	 
	 @Test
	 void test015unaPublicacionSabeSuHorarioDeCheckOut() {
		 publicacion1.setCheckOutHorario(checkOutHorario);
		 
		 assertEquals(publicacion1.getCheckOutHorario(), checkOutHorario);
		 
	 }
	 
	 @Test
	 void test015unaPublicacionSabeSuPrecioPorDia() {
		 publicacion1.setPrecioPorDia(precioPorDia);
		 
		 assertEquals(publicacion1.getPrecioPorDia(), precioPorDia);
		 
	 }
	 
	 
	 @Test
	 void test016unaPublicacionSabeSuPoliticaDeCancelacion() {
		 
		 publicacion1.setPoliticaDeCancelacion(politicaDeCancelacion);
		 
		 assertEquals(publicacion1.getPoliticaDeCancelacion(), politicaDeCancelacion);
	 }
	 
	 @Test
	 void test017unaPublicacionConoceSuInmueble() {
		 
		 assertEquals(publicacion1.getInmueble(), inmueble); 
	 }
	 
	 @Test
	 void test018unaPublicacionSabeChequearUnaCiudad() {
		 
		 String ciudad = "CityOfAngels";
		 
		 when(inmueble.getCiudad()).thenReturn(ciudad);
		 
		 assertTrue(publicacion1.chequearCiudad(ciudad));
	 }
	 
	@Test
	 void test018unaPublicacionSabeSiElUsuarioTieneReserva() { 
		 
		 List<Reserva> listaDeReservas = new ArrayList<Reserva>();
		 listaDeReservas.add(reserva);
		
		 when(calendario.getReservas()).thenReturn(listaDeReservas);
		 when(reserva.compararInquilino(usuarioInquilino)).thenReturn(true);
		 
		 publicacion1.recibirReserva(reserva);
		 Boolean tieneReserva = publicacion1.chequearSiElUsuarioTieneReserva(usuarioInquilino);
		 
		 assertTrue(tieneReserva);
		 verify(reserva, times(1)).compararInquilino(usuarioInquilino);
	 }
	 	
	 
}



