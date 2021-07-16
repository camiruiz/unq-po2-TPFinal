package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import notificaciones.EventoReserva;
import notificaciones.INotificablePorReserva;
import publicacionesYBusquedas.Publicacion;
import publicacionesYBusquedas.Reserva;

class EventoReservaTest {


	EventoReserva 			eventoReserva;
	INotificablePorReserva	suscriptor1;
	INotificablePorReserva 	suscriptor2;
	Publicacion 			publicacion1;
	Reserva					reserva1;
	
	@BeforeEach
	void setUp() throws Exception {
		suscriptor1	 		= mock(INotificablePorReserva.class);
		suscriptor2  		= mock(INotificablePorReserva.class);
		eventoReserva 		= new EventoReserva();
		publicacion1		= mock(Publicacion.class);
		reserva1			= mock(Reserva.class);
	}

	@Test
	void test001UnEventoBajaDePrecioAttacheaYDesattacheaYElSuscriptor1SeEncuentraEnLaListaYElSuscriptor2No() {
		eventoReserva.attach(suscriptor1);
		eventoReserva.attach(suscriptor2);
		eventoReserva.dettach(suscriptor2);
		
		eventoReserva.notificarPorReserva(publicacion1, reserva1);
		
		verify(suscriptor1, times(1)).serNotificadoPorReserva(publicacion1, reserva1);
		verify(suscriptor2, times(0)).serNotificadoPorReserva(publicacion1, reserva1);
	}
	
	@Test
	void test002UnEventoBajaDePrecioAttacheaYDesattacheaYNoNotificaANadiePorCancelacion() {
		eventoReserva.attach(suscriptor1);
		eventoReserva.attach(suscriptor2);
		eventoReserva.dettach(suscriptor2);
		
		eventoReserva.notificarPorBajaDePrecio(publicacion1);
		
		verify(suscriptor1, times(0)).serNotificadoPorReserva(publicacion1, reserva1);
		verify(suscriptor2, times(0)).serNotificadoPorReserva(publicacion1, reserva1);
	}
	
	@Test
	void test001UnEventoBajaDePrecioAttacheaYDesattacheaYNoNotificaANadiePorReserva() {
		eventoReserva.attach(suscriptor1);
		eventoReserva.attach(suscriptor2);
		eventoReserva.dettach(suscriptor2);
		
		eventoReserva.notificarPorCancelacion(publicacion1, reserva1);
		
		verify(suscriptor1, times(0)).serNotificadoPorReserva(publicacion1, reserva1);
		verify(suscriptor2, times(0)).serNotificadoPorReserva(publicacion1, reserva1);
	}
}
