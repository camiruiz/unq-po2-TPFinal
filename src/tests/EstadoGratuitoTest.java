package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import politicasDeCancelacion.CancelacionIntermedia;
import politicasDeCancelacion.EstadoGratuito;
import publicacionesYBusquedas.Reserva;

class EstadoGratuitoTest {
	private Reserva reserva1;
	private Reserva reserva2;
	private CancelacionIntermedia cancelacionIntermedia1;
	private EstadoGratuito estadoGratuito;
	private LocalDate F1;
	
	
	@BeforeEach
	void setUp() throws Exception {

	reserva1 = mock(Reserva.class);
	reserva2 = mock(Reserva.class);
	cancelacionIntermedia1 = mock(CancelacionIntermedia.class);
	estadoGratuito = new EstadoGratuito();
 }
	
	
	@Test
	void test001ElEstadoGratuitoSabeQueSiLaDiferenciaDeDiasEsMayorA20ElMontoEsDe0() {
			
		F1 = LocalDate.now().plusDays(40);
		
		when(reserva1.getFechaInicio()).thenReturn(F1);
		assertEquals(estadoGratuito.getMontoParaReserva(reserva1, cancelacionIntermedia1),0.0);
		
		
	}
	
	@Test
	void test002ElEstadoGratuitoSabeQueSiLaDiferenciaDeDiasEsMenorA20ElMontoEsElDeUnEstadoMitadDePago() {
		F1 = LocalDate.now().minusDays(42);
		
		
		when(reserva2.getFechaInicio()).thenReturn(F1);
		when(cancelacionIntermedia1.getMontoParaCancelacionDeReserva(reserva2)).thenReturn(5000.0);
 		
		assertEquals(5000.0, estadoGratuito.getMontoParaReserva(reserva2, cancelacionIntermedia1));
		verify(cancelacionIntermedia1, times(1)).getMontoParaCancelacionDeReserva(reserva2);

		
	}
		

}
