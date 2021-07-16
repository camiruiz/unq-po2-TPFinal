package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filtros.Disponibilidad;
import publicacionesYBusquedas.Publicacion;

class DisponibilidadTest {
	
	private List<Publicacion> publicaciones;
	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Disponibilidad disponibilidad;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	@BeforeEach
	void setUp() throws Exception {

	publicaciones = new ArrayList<Publicacion>();
	publicacion1 = mock(Publicacion.class);
	publicacion2 = mock(Publicacion.class);
	fechaInicio =  LocalDate.now();	
	fechaFin = LocalDate.now().plusDays(1);
	disponibilidad = new Disponibilidad(fechaInicio, fechaFin);
	
	}
	
	@Test
	void test001ListaQueFiltraPorDisponibilidad() {

		
		publicaciones.add(publicacion1);
		publicaciones.add(publicacion2);
		disponibilidad.filtrar(publicaciones);
		
		when(publicacion1.checkDisponibilidadEntre(fechaInicio,fechaFin)).thenReturn(true);
		when(publicacion2.checkDisponibilidadEntre(fechaInicio,fechaFin)).thenReturn(false);
		
		verify(publicacion1, times(1)).checkDisponibilidadEntre(fechaInicio, fechaFin);
		
		assertTrue(disponibilidad.filtrar(publicaciones).contains(publicacion1));
		assertFalse(disponibilidad.filtrar(publicaciones).contains(publicacion2));
 	

		
	}


}
