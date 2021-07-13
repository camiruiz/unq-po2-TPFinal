package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoTotalDePagoTest {
	
	private Reserva reserva1;
	private Reserva reserva2;
	private CancelacionIntermedia cancelacionIntermedia1;
	private EstadoTotalDePago estadoTotalDePago;
 	private LocalDate F1;
	
	@BeforeEach
	void setUp() throws Exception {

	reserva1 = mock(Reserva.class);
	reserva2 = mock(Reserva.class);
	cancelacionIntermedia1 = mock(CancelacionIntermedia.class);
	estadoTotalDePago = new EstadoTotalDePago();
 }
	
	@Test
	void test001ElEstadoTotalDePagoSabeQueSiLaDiferenciaDeDiasEsMayorA10ElMontoEsElPrecioTotalDeLaReserva () {
			
		F1 = LocalDate.now().plusDays(11);
		
		when(reserva1.getFechaInicio()).thenReturn(F1);
		when(reserva1.getPrecioTotal()).thenReturn(10000.0);
		Double montoAPagar = estadoTotalDePago.getMontoParaReserva(reserva1, cancelacionIntermedia1);
		
		assertEquals(10000.0, montoAPagar);
		verify(reserva1, times(1)).getPrecioTotal();
		
		
	}
	
	
	@Test
	void test002ElEstadoTotalDePagoSabeQueSiLaDiferenciaDeDiasEsMenorA10ElMontoEsElDelEstadoGratuito(){
		F1 = LocalDate.now().plusDays(5);
		
		
		when(reserva2.getFechaInicio()).thenReturn(F1);
		when(cancelacionIntermedia1.getMontoParaCancelacionDeReserva(reserva2)).thenReturn(0.0);
		
		assertEquals(0.0, estadoTotalDePago.getMontoParaReserva(reserva2, cancelacionIntermedia1));
		verify(cancelacionIntermedia1, times(1)).getMontoParaCancelacionDeReserva(reserva2);


		
	}

}
