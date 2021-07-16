package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.*;
import politicasDeCancelacion.CancelacionIntermedia;
import politicasDeCancelacion.EstadoDeCancelacionIntermedia;
import publicacionesYBusquedas.Reserva;

class CancelacionIntermediaTest {


	private EstadoDeCancelacionIntermedia estado1;
	private Reserva reserva1;
	private CancelacionIntermedia cancelacionIntermedia;
	
	
	@BeforeEach
	void setUp() throws Exception {

		estado1 = mock(EstadoDeCancelacionIntermedia.class);
		reserva1 = mock(Reserva.class);
	
		cancelacionIntermedia = new CancelacionIntermedia();
	
	}
	

	@Test
	void test001ElEstadoRecibeElGetMontoParaLaReserva() {

		cancelacionIntermedia.tuEstadoEs(estado1);
		when(estado1.getMontoParaReserva(reserva1, cancelacionIntermedia)).thenReturn(50.0);
		Double monto = cancelacionIntermedia.getMontoParaCancelacionDeReserva(reserva1);
	
	
		verify(estado1, times(1)).getMontoParaReserva(reserva1, cancelacionIntermedia);
		assertEquals((Double) monto, (Double) 50.0);
	
	}

	
	
	
}
