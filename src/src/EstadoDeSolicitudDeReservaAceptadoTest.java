package src;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoDeSolicitudDeReservaAceptadoTest {


    Solicitud solicitud1;
    EstadoDeSolicitudDeReservaAceptado estadoDeSolicitudDeReservaAceptado;
	LocalDate 		fechaInicio1;
	LocalDate 		fechaFin1;



    @BeforeEach
    void setUp() throws Exception {

    	solicitud1 = mock(Solicitud.class);
		fechaInicio1 	= LocalDate.now().plusDays(-10);
		fechaFin1 		= LocalDate.now().plusDays(-6);
	    estadoDeSolicitudDeReservaAceptado = new EstadoDeSolicitudDeReservaAceptado();
    }


    @Test
    void test001MiEstadoDeSolicitudDeReservaAceptadoRecibeElMensajeRechazar(){
    	estadoDeSolicitudDeReservaAceptado.rechazar(solicitud1);

        verify(solicitud1, times(1)).rechazar();

    }
    
    @Test
    void test002MiEstadoDeSolicitudDeReservaAceptadoNoRecibeElMensajeAceptar(){
        estadoDeSolicitudDeReservaAceptado.aceptar(solicitud1);

        verify(solicitud1, times(0)).aceptar();
    }
    
    @Test
    void test003MiEstadoDeSolicitudDeReservaAceptadoDevuelveFalseAlPreguntarSiEsPendiente(){
    	
    	assertFalse(estadoDeSolicitudDeReservaAceptado.esPendienteYEstaDisponibleEntreFechas(fechaInicio1, fechaFin1, solicitud1));
    }
}