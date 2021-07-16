package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Reserva;
import src.UsuarioInquilino;

class ReservaTest {
	
	UsuarioInquilino usuario1;
	UsuarioInquilino usuario2;
	Reserva reserva;
	Reserva reserva2;
	LocalDate fechaInicio;
	LocalDate fechaFin;
	String metodoDePago;
	Double precioTotal;
	

	

	@BeforeEach
	void setUp() throws Exception {
		
		usuario1 = mock(UsuarioInquilino.class);
		usuario2 = mock(UsuarioInquilino.class);
		reserva = new Reserva(usuario1, fechaInicio, fechaFin, metodoDePago, precioTotal);
		
	}

	@Test
	void test001LasReservasSabenCompararInquilinos() {
	
		assertTrue(reserva.compararInquilino(usuario1));
		assertFalse(reserva.compararInquilino(usuario2));
	
	}

	@Test
	void test002LaReserva1ConFechaInicioFuturaSabeQueEsFutura() {	
		fechaInicio = LocalDate.now().plusDays(1);
		reserva = new Reserva(usuario1, fechaInicio, fechaFin, metodoDePago, precioTotal);
		
		assertTrue(reserva.chequearSiEsFutura());
		
	}
	
	@Test
	void test003LaReserva2ConFechaInicioAnteriorAHoySabeQueNOEsFutura() {	
		fechaInicio = LocalDate.now().minusDays(1);
		reserva2 = new Reserva(usuario1, fechaInicio, fechaFin, metodoDePago, precioTotal);
		
		assertFalse(reserva2.chequearSiEsFutura());
		
	}
	
	@Test
	void test004LaReservaSabeSuPrecioTotal() {
		precioTotal = 100.0;
		reserva = new Reserva(usuario1, fechaInicio, fechaFin, metodoDePago, precioTotal);
		
		assertEquals(reserva.getPrecioTotal(), 100);
	}
	
	@Test
	void test005LaReservaSabeCalcularSuPeriodoDeDias() {
		fechaInicio = LocalDate.now();
		fechaFin = LocalDate.now().plusDays(1);
		reserva = new Reserva(usuario1, fechaInicio, fechaFin, metodoDePago, precioTotal);
		
		assertEquals(reserva.getPeriodoDeDias(), 1);
	}
	
	@Test
	void test006LasReservasSabenCalcularSuPrecioPorDiaYElPrecioPorDiaDeUnaEstadiaDe5DiasEsDe200() {
		precioTotal = 1000.0;
		fechaInicio = LocalDate.now();
		fechaFin = LocalDate.now().plusDays(5);
		reserva = new Reserva(usuario1, fechaInicio, fechaFin, metodoDePago, precioTotal);
		
		assertEquals(reserva.getPrecioPorDia(), 200.0);
	}
	
	@Test
	void test007UnaReservaSabeSiSeConcretoAnteriormente() {
		fechaInicio = LocalDate.now().minusDays(3);
		reserva = new Reserva(usuario1, fechaInicio, fechaFin, metodoDePago, precioTotal);
		
		assertTrue(reserva.seConcretoAnteriormente());				
	}
	
	
	@Test
	void test008UnaReservaQueTodaviaNoLlegoSeFechaDeInicioNoSeConcretoAnteriormente() {
		fechaInicio = LocalDate.now().plusDays(5);
		reserva = new Reserva(usuario1, fechaInicio, fechaFin, metodoDePago, precioTotal);
		
		assertFalse(reserva.seConcretoAnteriormente());				
	}
	
	@Test
	void test009UnaReservaSabeSuUsuarioInquilino() {
		
		reserva.setInquilino(usuario1);
		
		
		assertEquals(reserva.getInquilino(), usuario1);
			
	}
	
	@Test
	void test010UnaReservaSabeSuFechaFin() {
		
		reserva.setFechaFin(fechaFin);
		
		assertEquals(reserva.getFechaFin(), fechaFin);
	}
	
	@Test
	void test011UnaReservaSabeSuMetodoDePago() {
		reserva.setMetodoDePago(metodoDePago);
		
		assertEquals(reserva.getMetodoDePago(), metodoDePago);
		
	}
		
	
	
	
}
