package src;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoDeSolicitudDeReservaRechazadoTest {


    private Solicitud solicitud1;
    private EstadoDeSolicitudDeReservaRechazado estadoDeSolicitudDeReservaRechazado;



    @BeforeEach
    void setUp() throws Exception {

    solicitud1 = mock(Solicitud.class);
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
}

