package src;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoDeSolicitudDeReservaAceptadoTest {


    private Solicitud solicitud1;
	    private EstadoDeSolicitudDeReservaAceptado estadoDeSolicitudDeReservaAceptado;



    @BeforeEach
    void setUp() throws Exception {

    solicitud1 = mock(Solicitud.class);
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
}