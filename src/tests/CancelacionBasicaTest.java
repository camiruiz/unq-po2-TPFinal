package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.CancelacionBasica;
import src.Reserva;

class CancelacionBasicaTest {
	
		private Reserva reserva1;
		private CancelacionBasica cancelacionBasica;
		private LocalDate F1;

		
		@BeforeEach
		void setUp() throws Exception {

		reserva1 = mock(Reserva.class);
		cancelacionBasica = new CancelacionBasica();
		
		}
		
		@Test
		void test001LaCancelacionBasicaSabeSuMontoParaCancelarLaReserva() {
			
			F1 = LocalDate.now();
			
			when(reserva1.getFechaInicio()).thenReturn(F1);
			when(reserva1.getPrecioPorDia()).thenReturn(5.0);
			Double montoDeCancelacion = cancelacionBasica.getMontoParaCancelacionDeReserva(reserva1);
			verify(reserva1, times(1)).getPrecioPorDia();
			
			assertEquals(10.0, montoDeCancelacion);
			
		}

	}

