package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusquedaTest {
	
	PrecioMin filtro1;
	PrecioMax filtro2;
	Capacidad filtro3;
	Disponibilidad filtro4;
	Ciudad filtro5;
	List<Publicacion> listaDePublicaciones1;
	List<Publicacion> listaDePublicaciones2;
	List<Publicacion> listaDePublicaciones3;
	List<Publicacion> listaDePublicaciones4;
	Publicacion p1;
	Publicacion p2;
	Publicacion p3;
	Publicacion p4;
	
	Busqueda busqueda;



	@BeforeEach
	void setUp() throws Exception {
		
		busqueda 				= new Busqueda();
		filtro1 				= mock(PrecioMin.class);
		filtro2					= mock(PrecioMax.class);
		filtro3 				= mock(Capacidad.class);
		filtro4					= mock(Disponibilidad.class);
		filtro5					= mock(Ciudad.class);
		listaDePublicaciones1 	= new ArrayList<Publicacion>();
		listaDePublicaciones2	= new ArrayList<Publicacion>();
		listaDePublicaciones3 	= new ArrayList<Publicacion>();
		listaDePublicaciones4 	= new ArrayList<Publicacion>();
		p1 						= mock(Publicacion.class);
		p2 						= mock(Publicacion.class);
		p3 						= mock(Publicacion.class);
		p4 						= mock(Publicacion.class);
		
		
		
	}

	@Test
	void test001UnaBusquedaConoceSusFiltros() {
		
		busqueda.setFiltro(filtro1);
		
		assertTrue(busqueda.getFiltros().contains(filtro1));
		assertFalse(busqueda.getFiltros().contains(filtro2));
		
	}
	
	@Test
	void test002FiltraPorTodosSusFiltrosYSeQuedaConLaPublicacion1() {
		listaDePublicaciones1.add(p1);
		
		listaDePublicaciones2.add(p1);
		listaDePublicaciones2.add(p2);
		
		listaDePublicaciones3.add(p1);
		listaDePublicaciones3.add(p2);
		listaDePublicaciones3.add(p3);
		
		listaDePublicaciones4.add(p1);
		listaDePublicaciones4.add(p2);
		listaDePublicaciones4.add(p3);
		listaDePublicaciones4.add(p4);
		                    
		busqueda.setFiltro(filtro1);
		busqueda.setFiltro(filtro2);
		busqueda.setFiltro(filtro3);
		
		
		when(filtro1.filtrar(listaDePublicaciones4)).thenReturn(listaDePublicaciones3);
		when(filtro2.filtrar(listaDePublicaciones3)).thenReturn(listaDePublicaciones2);
		when(filtro3.filtrar(listaDePublicaciones2)).thenReturn(listaDePublicaciones1);
		
		List<Publicacion> publicacionesResultantes = busqueda.concretarBusqueda(listaDePublicaciones4);
		
		assertTrue(publicacionesResultantes.contains(p1));
		assertFalse(publicacionesResultantes.contains(p2));
		assertFalse(publicacionesResultantes.contains(p3));
		assertFalse(publicacionesResultantes.contains(p4));
		
		
	}
	

	@Test
	void test003SeIntentaRealizarUnaBusquedaSiNlosFIltrosObligatoriosEstandoPresentesPorLoTantoSeDevuelveLaListaDeTodasLasPublicacionesSinFiltrar() {
		listaDePublicaciones1.add(p1);
		
		listaDePublicaciones2.add(p1);
		listaDePublicaciones2.add(p2);
		
		listaDePublicaciones3.add(p1);
		listaDePublicaciones3.add(p2);
		listaDePublicaciones3.add(p3);
		
		listaDePublicaciones4.add(p1);
		listaDePublicaciones4.add(p2);
		listaDePublicaciones4.add(p3);
		listaDePublicaciones4.add(p4);
		
		busqueda.setFiltro(filtro1);
		busqueda.setFiltro(filtro2);
		busqueda.setFiltro(filtro3);
		busqueda.setFiltro(filtro4);
		busqueda.setFiltro(filtro5);
		
		when(filtro1.equals(any())).thenReturn(false);
		when(filtro2.equals(any())).thenReturn(false);
		when(filtro3.equals(any())).thenReturn(false);
		when(filtro4.equals(any())).thenReturn(false);
		when(filtro5.equals(any())).thenReturn(true, false);
	
		
		when(filtro1.filtrar(listaDePublicaciones4)).thenReturn(listaDePublicaciones3);
		when(filtro2.filtrar(listaDePublicaciones3)).thenReturn(listaDePublicaciones2);
		when(filtro3.filtrar(listaDePublicaciones2)).thenReturn(listaDePublicaciones1);
		when(filtro4.filtrar(listaDePublicaciones1)).thenReturn(listaDePublicaciones1);
		when(filtro5.filtrar(listaDePublicaciones1)).thenReturn(listaDePublicaciones1);
		
		List<Publicacion> publicacionesResultantes = busqueda.buscar(listaDePublicaciones4);
		
		
		
		assertEquals(publicacionesResultantes, listaDePublicaciones4);
		
		
		verify(filtro1, times(2)).equals(any());
		verify(filtro2, times(2)).equals(any());
		verify(filtro3, times(2)).equals(any());
		verify(filtro4, times(2)).equals(any());
		verify(filtro5, times(2)).equals(any());
		
		verify(filtro1, times(0)).filtrar(listaDePublicaciones4);
		verify(filtro2, times(0)).filtrar(listaDePublicaciones4);
		verify(filtro3, times(0)).filtrar(listaDePublicaciones4);
		verify(filtro4, times(0)).filtrar(listaDePublicaciones4);
		verify(filtro5, times(0)).filtrar(listaDePublicaciones4);
		
		assertTrue(publicacionesResultantes.contains(p1));
		assertTrue(publicacionesResultantes.contains(p2));
		assertTrue(publicacionesResultantes.contains(p3));
		assertTrue(publicacionesResultantes.contains(p4));

		
		
	}
	
	@Test
	void test004SeIntentaRealizarUnaBusquedaConlosFIltrosObligatoriosEstandoPresentesPorLoTantoSeDevuelveLaListaDeTodasLasPublicacionesFiltrada() {
		listaDePublicaciones1.add(p1);
		
		listaDePublicaciones2.add(p1);
		listaDePublicaciones2.add(p2);
		
		listaDePublicaciones3.add(p1);
		listaDePublicaciones3.add(p2);
		listaDePublicaciones3.add(p3);
		
		listaDePublicaciones4.add(p1);
		listaDePublicaciones4.add(p2);
		listaDePublicaciones4.add(p3);
		listaDePublicaciones4.add(p4);
		
		busqueda.setFiltro(filtro1);
		busqueda.setFiltro(filtro2);
		busqueda.setFiltro(filtro3);
		busqueda.setFiltro(filtro4);
		busqueda.setFiltro(filtro5);
		
		when(filtro1.equals(any())).thenReturn(false);
		when(filtro2.equals(any())).thenReturn(false);
		when(filtro3.equals(any())).thenReturn(false);
		when(filtro4.equals(any())).thenReturn(false, true);
		when(filtro5.equals(any())).thenReturn(true, false);
		
		
		when(filtro1.filtrar(listaDePublicaciones4)).thenReturn(listaDePublicaciones3);
		when(filtro2.filtrar(listaDePublicaciones3)).thenReturn(listaDePublicaciones2);
		when(filtro3.filtrar(listaDePublicaciones2)).thenReturn(listaDePublicaciones1);
		when(filtro4.filtrar(listaDePublicaciones1)).thenReturn(listaDePublicaciones1);
		when(filtro5.filtrar(listaDePublicaciones1)).thenReturn(listaDePublicaciones1);

		List<Publicacion> publicacionesResultantes = busqueda.buscar(listaDePublicaciones4);
		
		
		verify(filtro1, times(1)).filtrar(listaDePublicaciones4);
		verify(filtro2, times(1)).filtrar(listaDePublicaciones3);
		verify(filtro3, times(1)).filtrar(listaDePublicaciones2);
		verify(filtro4, times(1)).filtrar(listaDePublicaciones1);
		verify(filtro5, times(1)).filtrar(listaDePublicaciones1);
		
		
		assertEquals(publicacionesResultantes, listaDePublicaciones1);
		
		
		verify(filtro1, times(2)).equals(any());
		verify(filtro2, times(2)).equals(any());
		verify(filtro3, times(2)).equals(any());
		verify(filtro4, times(2)).equals(any());
		verify(filtro5, times(1)).equals(any());
		
		
		assertTrue(publicacionesResultantes.contains(p1));
		assertFalse(publicacionesResultantes.contains(p2));
		assertFalse(publicacionesResultantes.contains(p3));
		assertFalse(publicacionesResultantes.contains(p4));
		
		
		
	}
	

}
