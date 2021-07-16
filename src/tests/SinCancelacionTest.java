package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Reserva;
import src.SinCancelacion;

class SinCancelacionTest {

	private Reserva reserva1;
	private SinCancelacion sinCancelacion;

	@BeforeEach
	void setUp() throws Exception {

	reserva1 = mock(Reserva.class);
	sinCancelacion = new SinCancelacion();
	
	}
	@Test
	void test001SinCancelacionSabeSuMontoParaLaReserva() {
		
		sinCancelacion.getMontoParaCancelacionDeReserva(reserva1);
		when(reserva1.getPrecioTotal()).thenReturn(10.0);
		verify(reserva1, times(1)).getPrecioTotal();
		
		assertEquals(sinCancelacion.getMontoParaCancelacionDeReserva(reserva1), 10.0);

	}

}
