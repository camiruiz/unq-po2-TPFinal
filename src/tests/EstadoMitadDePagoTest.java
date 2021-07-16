package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.CancelacionIntermedia;
import src.EstadoMitadDePago;
import src.Reserva;

class EstadoMitadDePagoTest {

	private Reserva reserva1;
	private Reserva reserva2;
	private CancelacionIntermedia cancelacionIntermedia1;
	private EstadoMitadDePago estadoMitadDePago;
 	private LocalDate F1;
	
	@BeforeEach
	void setUp() throws Exception {

	reserva1 = mock(Reserva.class);
	reserva2 = mock(Reserva.class);
	cancelacionIntermedia1 = mock(CancelacionIntermedia.class);
	estadoMitadDePago = new EstadoMitadDePago();
 }
	
	@Test
	void test001ElEstadoMitadDePagoSabeQueSiLaDiferenciaDeDiasEsMenorA20YMayorA10ElMontoEs5 () {
			
		F1 = LocalDate.now().plusDays(10);
		
		when(reserva1.getFechaInicio()).thenReturn(F1);
		when(reserva1.getPrecioTotal()).thenReturn(10000.0);
		Double montoAPagar = estadoMitadDePago.getMontoParaReserva(reserva1, cancelacionIntermedia1);
		
		assertEquals(5000.0, montoAPagar);
		verify(reserva1, times(1)).getPrecioTotal();
		
		
	}
	
	@Test
	void test002ElEstadoMitadDePagoSabeQueSiLaDiferenciaDeDiasEsMayorA20OMenorA10DiasElMontoEsElDeUnEstadoTotalDePago(){
		F1 = LocalDate.now().plusDays(21);
		
		
		when(reserva2.getFechaInicio()).thenReturn(F1);
		when(cancelacionIntermedia1.getMontoParaCancelacionDeReserva(reserva2)).thenReturn(10000.0);
		
		assertEquals(10000.0, estadoMitadDePago.getMontoParaReserva(reserva2, cancelacionIntermedia1));
		verify(cancelacionIntermedia1, times(1)).getMontoParaCancelacionDeReserva(reserva2);
		
	}

}
