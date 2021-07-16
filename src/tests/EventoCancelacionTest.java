package tests;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.EventoCancelacion;
import src.ICancelable;
import src.Publicacion;
import src.Reserva;

class EventoCancelacionTest {

	EventoCancelacion 	eventoCancelacion;
	ICancelable			suscriptor1;
	ICancelable 		suscriptor2;
	Publicacion 		publicacion1;
	Reserva				reserva1;
	
	@BeforeEach
	void setUp() throws Exception {
		suscriptor1	 		= mock(ICancelable.class);
		suscriptor2  		= mock(ICancelable.class);
		eventoCancelacion 	= new EventoCancelacion();
		publicacion1		= mock(Publicacion.class);
		reserva1			= mock(Reserva.class);
	}

	@Test
	void test001UnEventoBajaDePrecioAttacheaYDesattacheaYElSuscriptor1SeEncuentraEnLaListaYElSuscriptor2No() {
		eventoCancelacion.attach(suscriptor1);
		eventoCancelacion.attach(suscriptor2);
		eventoCancelacion.dettach(suscriptor2);
		
		eventoCancelacion.notificarPorCancelacion(publicacion1, reserva1);
		
		verify(suscriptor1, times(1)).serNotificadoPorCancelacion(publicacion1, reserva1);
		verify(suscriptor2, times(0)).serNotificadoPorCancelacion(publicacion1, reserva1);
	}
	
	@Test
	void test002UnEventoBajaDePrecioAttacheaYDesattacheaYNoNotificaANadiePorCancelacion() {
		eventoCancelacion.attach(suscriptor1);
		eventoCancelacion.attach(suscriptor2);
		eventoCancelacion.dettach(suscriptor2);
		
		eventoCancelacion.notificarPorBajaDePrecio(publicacion1);
		
		verify(suscriptor1, times(0)).serNotificadoPorCancelacion(publicacion1, reserva1);
		verify(suscriptor2, times(0)).serNotificadoPorCancelacion(publicacion1, reserva1);
	}
	
	@Test
	void test001UnEventoBajaDePrecioAttacheaYDesattacheaYNoNotificaANadiePorReserva() {
		eventoCancelacion.attach(suscriptor1);
		eventoCancelacion.attach(suscriptor2);
		eventoCancelacion.dettach(suscriptor2);
		
		eventoCancelacion.notificarPorReserva(publicacion1, reserva1);
		
		verify(suscriptor1, times(0)).serNotificadoPorCancelacion(publicacion1, reserva1);
		verify(suscriptor2, times(0)).serNotificadoPorCancelacion(publicacion1, reserva1);
	}
}
