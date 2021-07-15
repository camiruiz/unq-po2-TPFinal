package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusquedaTest {
	
	Filtro filtro1;
	Filtro filtro2;
	Filtro filtro3;
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
		
		busqueda = new Busqueda();
		
		filtro1 = mock(Filtro.class);
		filtro2 = mock(Filtro.class);
		filtro3 = mock(Filtro.class);
		listaDePublicaciones1 = new ArrayList<Publicacion>();
		listaDePublicaciones2 = new ArrayList<Publicacion>();
		listaDePublicaciones3 = new ArrayList<Publicacion>();
		listaDePublicaciones4 = new ArrayList<Publicacion>();
		p1 		= mock(Publicacion.class);
		p2 		= mock(Publicacion.class);
		p3 		= mock(Publicacion.class);
		p4 		= mock(Publicacion.class);
		
		
		
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
		
		List<Publicacion> publicacionesResultantes = busqueda.buscar(listaDePublicaciones4);
		
		assertTrue(publicacionesResultantes.contains(p1));
		assertFalse(publicacionesResultantes.contains(p2));
		assertFalse(publicacionesResultantes.contains(p3));
		assertFalse(publicacionesResultantes.contains(p4));
		
		
	}
	
	
	
	
	
	

}
