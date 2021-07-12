package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class PublicacionTest {

	
	private LocalTime 						checkInHorario;
	private LocalTime						checkOutHorario;
	private Double					 		precioPorDia;
	private List<Reserva> 					reservas;
	private List<LocalDate> 				diasDisponibles;
	private Inmueble 						inmueble;
	private Propietario 					propietario;
	private CalculadorDeCalificaciones 		calculadorDeCalificaciones;
	private PoliticaDeCancelacionDeReserva 	politicaDeCancelacion;
	//private List<TemporadaAlta>		 		diasEnAumento;
	private Reserva							reserva;
	private Calendario 						calendario;
	private IListener						listener;
	
	Publicacion publicacion1;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		checkInHorario 				= mock(LocalTime.class);             
		checkOutHorario				= mock(LocalTime.class);            
		precioPorDia				= 12.0;               
		//reservas					= mock(List.class);                               
		inmueble					= mock(Inmueble.class);                   
		propietario					= mock(Propietario.class);      
		calculadorDeCalificaciones 	= mock(CalculadorDeCalificaciones.class);                
		politicaDeCancelacion		= mock(PoliticaDeCancelacionDeReserva.class);      
		calendario					= mock(Calendario.class);
		reserva						= mock(Reserva.class);
		listener					= mock(IListener.class);
		
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
		publicacion1.cancelarReserva(reserva);
		
		verify(listener, times(1)).notificarPorCancelacion(publicacion1, reserva);
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
	 void test009AlDue�oDeUnaPublicacionLeLlegaElMensajeCuandoSeConsultaPorElPromedioDeSuDue�o() {
		 publicacion1.puntajeDue�o();
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
	 void test011unaPublicacionLeEnviaLaSolicitudDeReservaAlDue�o() {
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
	 
	 
	 
	
	 
	 
	 
}


