package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoDeCancelacionIntermediaTest {

	private Reserva reserva1;
	private LocalDate F1;
	private EstadoGratuito estadoGratuito1;
	
	@BeforeEach
	void setUp() throws Exception {

	reserva1 = mock(Reserva.class);
	estadoGratuito1 = new EstadoGratuito();
	
	}
	
	
	@Test
	void test001MiEstadoGratuito1RecibeLaDiferenciaDeDiasDeLaReservaDada() {
	F1 = LocalDate.now().plusDays(51);
		
		when(reserva1.getFechaInicio()).thenReturn(F1);
		
		assertEquals(estadoGratuito1.getDiferenciaDeDias(reserva1), 51);
 		
		
	}

}