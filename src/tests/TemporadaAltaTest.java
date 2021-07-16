package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.*;

class TemporadaAltaTest {

	LocalDate 		fechaInicio1;
	LocalDate 		fechaFin1;
	LocalDate 		fechaInicio2;
	LocalDate 		fechaFin2;
	LocalDate 		fechaInicio3;
	LocalDate 		fechaFin3;
	Double 			aumento;
	TemporadaAlta 	temporadaAlta;
	
	
	@BeforeEach
	void setUp() throws Exception {
		fechaInicio1 	= LocalDate.now().plusDays(-10);
		fechaFin1 		= LocalDate.now().plusDays(-6);
		fechaInicio2 	= LocalDate.now().plusDays(-5);
		fechaFin2 		= LocalDate.now().plusDays(-1);
		fechaInicio3 	= LocalDate.now().plusDays(-9);
		fechaFin3 		= LocalDate.now().plusDays(-7);
		aumento			= 20.0;
		temporadaAlta	= new TemporadaAlta(fechaInicio1, fechaFin1, aumento);
	}

	@Test
	void test001UnaTemporadaAltaDevuelveLaMismaFechaQueLaInstanciada() {
		LocalDate fechaInicioActual = temporadaAlta.getFechaInicio();
		LocalDate fechaFinalActual	= temporadaAlta.getFechaFin();
		assertEquals(fechaInicioActual, fechaInicio1);
		assertEquals(fechaFinalActual, fechaFin1);
	}
	
	@Test
	void test001UnaTemporadaAltaTieneLos3DiasEnAumentoYDevuelve60DeAumento() {
		Double aumentoActual = temporadaAlta.aumentoParaDiasEntreFechas(fechaInicio3, fechaFin2);
		
		assertEquals(aumentoActual, 60.0);
	}

}
