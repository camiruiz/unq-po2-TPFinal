package src;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoDeSolicitudDeReservaPendienteTest {


    private Solicitud solicitud1;
    private EstadoDeSolicitudDeReservaPendiente estadoDeSolicitudDeReservaPendiente;

    @BeforeEach
    void setUp() throws Exception {

    solicitud1 = mock(Solicitud.class);
	    estadoDeSolicitudDeReservaPendiente = new EstadoDeSolicitudDeReservaPendiente();
	    }


    @Test
    void test001MiEstadoDeSolicitudDeReservaPendienteRecibeElMensajeAceptar(){


        estadoDeSolicitudDeReservaPendiente.aceptar(solicitud1);

        verify(solicitud1, times(1)).aceptar();



    }   
    
    @Test
    void test002MiEstadoDeSolicitudDeReservaPendienteRecibeElMensajeRechazar(){


        estadoDeSolicitudDeReservaPendiente.rechazar(solicitud1);

        verify(solicitud1, times(1)).rechazar();



    }
}

