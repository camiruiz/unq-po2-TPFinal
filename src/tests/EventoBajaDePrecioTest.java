package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import notificaciones.EventoBajaDePrecio;
import notificaciones.IBajaDePrecio;
import publicacionesYBusquedas.Publicacion;
import publicacionesYBusquedas.Reserva;

class EventoBajaDePrecioTest {

	EventoBajaDePrecio 	eventoBajaDePrecio;
	IBajaDePrecio		suscriptor1;
	IBajaDePrecio 		suscriptor2;
	Publicacion 		publicacion1;
	Reserva				reserva1;
	
	@BeforeEach
	void setUp() throws Exception {
		suscriptor1	 		= mock(IBajaDePrecio.class);
		suscriptor2  		= mock(IBajaDePrecio.class);
		eventoBajaDePrecio 	= new EventoBajaDePrecio();
		publicacion1		= mock(Publicacion.class);
		reserva1			= mock(Reserva.class);
	}

	@Test
	void test001UnEventoBajaDePrecioAttacheaYDesattacheaYElSuscriptor1SeEncuentraEnLaListaYElSuscriptor2No() {
		eventoBajaDePrecio.attach(suscriptor1);
		eventoBajaDePrecio.attach(suscriptor2);
		eventoBajaDePrecio.dettach(suscriptor2);
		
		eventoBajaDePrecio.notificarPorBajaDePrecio(publicacion1);
		
		verify(suscriptor1, times(1)).serNotificadoPorBajaDePrecio(publicacion1);
		verify(suscriptor2, times(0)).serNotificadoPorBajaDePrecio(publicacion1);
	}
	
	@Test
	void test002UnEventoBajaDePrecioAttacheaYDesattacheaYNoNotificaANadiePorCancelacion() {
		eventoBajaDePrecio.attach(suscriptor1);
		eventoBajaDePrecio.attach(suscriptor2);
		eventoBajaDePrecio.dettach(suscriptor2);
		
		eventoBajaDePrecio.notificarPorCancelacion(publicacion1,reserva1);
		
		verify(suscriptor1, times(0)).serNotificadoPorBajaDePrecio(publicacion1);
		verify(suscriptor2, times(0)).serNotificadoPorBajaDePrecio(publicacion1);
	}
	
	@Test
	void test001UnEventoBajaDePrecioAttacheaYDesattacheaYNoNotificaANadiePorReserva() {
		eventoBajaDePrecio.attach(suscriptor1);
		eventoBajaDePrecio.attach(suscriptor2);
		eventoBajaDePrecio.dettach(suscriptor2);
		
		eventoBajaDePrecio.notificarPorReserva(publicacion1, reserva1);
		
		verify(suscriptor1, times(0)).serNotificadoPorBajaDePrecio(publicacion1);
		verify(suscriptor2, times(0)).serNotificadoPorBajaDePrecio(publicacion1);
	}

}
