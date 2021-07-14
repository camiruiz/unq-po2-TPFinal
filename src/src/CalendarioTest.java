package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarioTest {

	Reserva 		reserva1;
	Reserva 		reserva2;
	Reserva 		reserva3;
	TemporadaAlta 	temporadaAlta1;
	TemporadaAlta 	temporadaAlta2;
	LocalDate 		fechaInicio1;
	LocalDate 		fechaFin1;
	LocalDate 		fechaInicio2;
	LocalDate 		fechaFin2;
	LocalDate 		fechaInicio3;
	LocalDate 		fechaFin3;
	Calendario 		calendario;
	
	@BeforeEach
	void setUp() throws Exception {
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		reserva3 = mock(Reserva.class);
		temporadaAlta1 = mock(TemporadaAlta.class);
		temporadaAlta2 = mock(TemporadaAlta.class);
		calendario = new Calendario();
		fechaInicio1 	= LocalDate.now().plusDays(-10);
		fechaFin1 		= LocalDate.now().plusDays(-6);
		fechaInicio2 	= LocalDate.now().plusDays(-5);
		fechaFin2 		= LocalDate.now().plusDays(-1);
		fechaInicio3 	= LocalDate.now().plusDays(-9);
		fechaFin3 		= LocalDate.now().plusDays(-7);
		
		
	}

	@Test
	void test001UnCalendarioNoEstaDisponibleEntreLasFechasDadas() {

		when(reserva1.getFechaInicio()).thenReturn(fechaInicio1);
		when(reserva1.getFechaFin()).thenReturn(fechaFin1);
		when(reserva2.getFechaInicio()).thenReturn(fechaInicio2);
		when(reserva2.getFechaFin()).thenReturn(fechaFin2);
		
		calendario.addReserva(reserva2);
		calendario.addReserva(reserva1);
		
		Boolean estaDisponibles = calendario.checkDisponibilidadEntre(fechaInicio3, fechaFin3);
		
		verify(reserva2, times(1)).getFechaInicio();
		verify(reserva2, times(1)).getFechaFin();
		verify(reserva1, times(1)).getFechaInicio();
		verify(reserva1, times(1)).getFechaFin();
		
		assertFalse(estaDisponibles);
		
	}

	@Test
	void test002UnCalendarioEstaDisponibleEntreLasFechasDadas() {
		
		when(reserva1.getFechaInicio()).thenReturn(fechaInicio1);
		when(reserva1.getFechaFin()).thenReturn(fechaFin1);
		when(reserva2.getFechaInicio()).thenReturn(fechaInicio2);
		when(reserva2.getFechaFin()).thenReturn(fechaFin2);
		fechaInicio3		= LocalDate.now().plusDays(-99);
		fechaFin3			= LocalDate.now().plusDays(-95);
		
		calendario.addReserva(reserva2);
		calendario.addReserva(reserva1);
		calendario.addReserva(reserva3);
		calendario.sacarReserva(reserva3);
		
		Boolean estaDisponibles = calendario.checkDisponibilidadEntre(fechaInicio3, fechaFin3);
		
		verify(reserva2, times(1)).getFechaInicio();
		verify(reserva2, times(1)).getFechaFin();
		verify(reserva1, times(1)).getFechaInicio();
		verify(reserva1, times(1)).getFechaFin();
		verify(reserva3, times(0)).getFechaFin();
		verify(reserva3, times(0)).getFechaFin();
		
		assertTrue(estaDisponibles);
		
	}
	
	@Test
	void test003UnCalendarioTieneTemporadaAltaEntreFechas() {
		
		when(temporadaAlta1.getFechaInicio()).thenReturn(fechaInicio1);
		when(temporadaAlta1.getFechaFin()).thenReturn(fechaFin1);
		when(temporadaAlta2.getFechaInicio()).thenReturn(fechaInicio2);
		when(temporadaAlta2.getFechaFin()).thenReturn(fechaFin2);
		
		
		calendario.addDiasEnAumento(temporadaAlta2);
		calendario.addDiasEnAumento(temporadaAlta1);
		
		Boolean estaEnTemporadaAlta = calendario.tieneTemporadaAltaEntre(fechaInicio3, fechaFin3);
		
		verify(temporadaAlta2, times(1)).getFechaInicio();
		verify(temporadaAlta2, times(1)).getFechaFin();
		verify(temporadaAlta1, times(1)).getFechaInicio();
		verify(temporadaAlta1, times(1)).getFechaFin();
		
		assertTrue(estaEnTemporadaAlta);
		
	}
	
	@Test
	void test004UnCalendarioCalculaSuAumentroEntreFechasYTieneComoResultado50() {
		
		when(temporadaAlta1.aumentoParaDiasEntreFechas(fechaInicio1,fechaFin1)).thenReturn(50.0);
		when(temporadaAlta2.aumentoParaDiasEntreFechas(fechaInicio1,fechaFin1)).thenReturn(0.0);
		
		calendario.addDiasEnAumento(temporadaAlta2);
		calendario.addDiasEnAumento(temporadaAlta1);
		
		Double montoExtra = calendario.calcularAumentoEntre(fechaInicio1, fechaFin1);
		
		verify(temporadaAlta2, times(1)).aumentoParaDiasEntreFechas(fechaInicio1,fechaFin1);
		verify(temporadaAlta1, times(1)).aumentoParaDiasEntreFechas(fechaInicio1,fechaFin1);
		
		assertEquals(montoExtra, 50.0);
		
	}
	
	@Test
	void test005TestGetReserva() {
		
		calendario.addReserva(reserva1);
		List<Reserva> l1 = calendario.getReservas();
		assertTrue(l1.contains(reserva1));
		
	}

}
