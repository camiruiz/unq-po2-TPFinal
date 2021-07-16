package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.*;
import publicacionesYBusquedas.Calendario;
import publicacionesYBusquedas.Publicacion;
import solicitud.EstadoDeSolicitudDeReservaPendiente;
import solicitud.Solicitud;

class EstadoDeSolicitudDeReservaPendienteTest {


	EstadoDeSolicitudDeReservaPendiente estadoDeSolicitudDeReservaPendiente;
    Solicitud 		solicitud1;
	LocalDate 		fechaInicio1;
	LocalDate 		fechaFin1;
	LocalDate 		fechaInicio2;
	LocalDate 		fechaFin2;
	LocalDate 		fechaInicio3;
	LocalDate 		fechaFin3;
	LocalDate 		fechaInicio4;
	Calendario 		calendario;
	Publicacion		publicacion1;
	

    @BeforeEach
    void setUp() throws Exception {

	    estadoDeSolicitudDeReservaPendiente = new EstadoDeSolicitudDeReservaPendiente();
	    solicitud1 		= mock(Solicitud.class);
	    publicacion1	= mock(Publicacion.class);
		fechaInicio1 	= LocalDate.now().plusDays(-10);
		fechaFin1 		= LocalDate.now().plusDays(-6);
		fechaInicio2 	= LocalDate.now().plusDays(-5);
		fechaFin2 		= LocalDate.now().plusDays(-1);
		fechaInicio3 	= LocalDate.now().plusDays(-9);
		fechaFin3 		= LocalDate.now().plusDays(-7);
		fechaInicio4 	= LocalDate.now().plusDays(-20);
    }


    @Test
    void test001MiEstadoDeSolicitudDeReservaPendienteRecibeElMensajeAceptar(){


        estadoDeSolicitudDeReservaPendiente.aceptar(solicitud1);

        verify(solicitud1, times(1)).generarReserva();
        verify(solicitud1, times(1)).darReservaALaPublicacion(any());
    }   
    
    @Test
    void test002MiEstadoDeSolicitudDeReservaPendienteRecibeElMensajeRechazar(){
        estadoDeSolicitudDeReservaPendiente.rechazar(solicitud1);

        verify(solicitud1, times(1)).tuEstadoEs(any());
    }
    
    @Test
    void test003MiEstadoSolicitudPendienteRecibeUnaFechaInicioQueEstaEntreMisDiasYRetornaFalse() {
    	
    	when(solicitud1.getFechaInicio()).thenReturn(fechaInicio1);
    	when(solicitud1.getFechaFin()).thenReturn(fechaFin1);
    	when(solicitud1.getPublicacion()).thenReturn(publicacion1);
    	when(publicacion1.checkDisponibilidadEntre(fechaInicio3, fechaFin2)).thenReturn(false);
    	
    	Boolean estaEntreFechas = estadoDeSolicitudDeReservaPendiente.esPendienteYEstaDisponibleEntreFechas(fechaInicio3, fechaFin2, solicitud1);
    	
    	verify(solicitud1, times(1)).getFechaInicio();
    	verify(solicitud1, times(1)).getFechaFin();    	
    	verify(solicitud1, times(1)).getPublicacion();
    	verify(publicacion1, times(1)).checkDisponibilidadEntre(fechaInicio1, fechaFin1);
    	
    	assertFalse(estaEntreFechas);
    }
    
    @Test
    void test004MiEstadoSolicitudPendienteRecibeUnaFechaFinQueEstaEntreMisDiasYRetornaFalse() {
    	
    	when(solicitud1.getFechaInicio()).thenReturn(fechaInicio1);
    	when(solicitud1.getFechaFin()).thenReturn(fechaFin1);
    	when(solicitud1.getPublicacion()).thenReturn(publicacion1);
    	when(publicacion1.checkDisponibilidadEntre(fechaInicio4, fechaFin3)).thenReturn(false);
    	
    	Boolean estaEntreFechas = estadoDeSolicitudDeReservaPendiente.esPendienteYEstaDisponibleEntreFechas(fechaInicio4, fechaFin3, solicitud1);
    	
    	verify(solicitud1, times(1)).getFechaInicio();
    	verify(solicitud1, times(1)).getFechaFin();    	
    	verify(solicitud1, times(1)).getPublicacion();
    	verify(publicacion1, times(1)).checkDisponibilidadEntre(fechaInicio1, fechaFin1);
    	
    	assertFalse(estaEntreFechas);
    }
    
    @Test
    void test005MiEstadoSolicitudPendienteRecibeUnaFechaInicioQueEstaNoEntreMisDiasPeroMiPublicacionSiEstaDisponibleEnEsosDiasYRetornaFalse() {
    	
    	when(solicitud1.getFechaInicio()).thenReturn(fechaInicio1);
    	when(solicitud1.getFechaFin()).thenReturn(fechaFin1);
    	when(solicitud1.getPublicacion()).thenReturn(publicacion1);
    	when(publicacion1.checkDisponibilidadEntre(fechaInicio2, fechaFin2)).thenReturn(true);
    	
    	Boolean estaEntreFechas = estadoDeSolicitudDeReservaPendiente.esPendienteYEstaDisponibleEntreFechas(fechaInicio2, fechaFin2, solicitud1);
    	
    	verify(solicitud1, times(1)).getFechaInicio();
    	verify(solicitud1, times(1)).getFechaFin();    	
    	verify(solicitud1, times(0)).getPublicacion();
    	verify(publicacion1, times(0)).checkDisponibilidadEntre(fechaInicio2, fechaFin2);
    	
    	assertFalse(estaEntreFechas);
    }
    
    @Test
    void test006MiEstadoSolicitudPendienteRecibeUnaFechaInicioQueEstaEntreMisDiasYMiPublicacionSiEstaDisponibleEnEsosDiasYRetornaTrue() {
    	
    	when(solicitud1.getFechaInicio()).thenReturn(fechaInicio1);
    	when(solicitud1.getFechaFin()).thenReturn(fechaFin1);
    	when(solicitud1.getPublicacion()).thenReturn(publicacion1);
    	when(publicacion1.checkDisponibilidadEntre(fechaInicio1, fechaFin1)).thenReturn(true);
    	
    	Boolean estaEntreFechas = estadoDeSolicitudDeReservaPendiente.esPendienteYEstaDisponibleEntreFechas(fechaInicio3, fechaFin3, solicitud1);
    	
    	verify(solicitud1, times(1)).getFechaInicio();
    	verify(solicitud1, times(1)).getFechaFin();    	
    	verify(solicitud1, times(1)).getPublicacion();
    	verify(publicacion1, times(1)).checkDisponibilidadEntre(fechaInicio1, fechaFin1);
    	
    	assertTrue(estaEntreFechas);
    }
    
    
}

