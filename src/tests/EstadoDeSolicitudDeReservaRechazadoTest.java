package tests;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.EstadoDeSolicitudDeReservaRechazado;
import src.Solicitud;

class EstadoDeSolicitudDeReservaRechazadoTest {


    private Solicitud solicitud1;
    private EstadoDeSolicitudDeReservaRechazado estadoDeSolicitudDeReservaRechazado;
	LocalDate 		fechaInicio1;
	LocalDate 		fechaFin1;



    @BeforeEach
    void setUp() throws Exception {

    	solicitud1 		= mock(Solicitud.class);
		fechaInicio1 	= LocalDate.now().plusDays(-10);
		fechaFin1 		= LocalDate.now().plusDays(-6);
	    estadoDeSolicitudDeReservaRechazado = new EstadoDeSolicitudDeReservaRechazado();
	    
    }


    @Test
    void test001MiEstadoDeSolicitudDeReservaRechazadoRecibeElMensajeAceptar(){


        estadoDeSolicitudDeReservaRechazado.aceptar(solicitud1);

        verify(solicitud1, times(1)).aceptar();



    }
    
    @Test
    void test002MiEstadoDeSolicitudDeReservaRechazadoNoRecibeElMensajeRechazar(){


        estadoDeSolicitudDeReservaRechazado.rechazar(solicitud1);

        verify(solicitud1, times(0)).rechazar();
    }

    @Test
    void test003MiEstadoDeSolicitudDeReservaRechazadoDevuelveFalseAlPreguntarSiEsPendiente(){
    	
    	assertFalse(estadoDeSolicitudDeReservaRechazado.esPendienteYEstaDisponibleEntreFechas(fechaInicio1, fechaFin1, solicitud1));
    }
}

