package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusquedaTest {
	
	private List<Filtro> filtros;
	private Filtro filtro1;
	private Filtro filtro2;
	private Filtro filtro3;
	private Filtro filtro4;
	private List<Publicacion> listaDePublicaciones1;
	private List<Publicacion> listaDePublicaciones2;
	private Publicacion p1;
	private Publicacion p2;
	
	Busqueda busqueda;



	@BeforeEach
	void setUp() throws Exception {
		
		busqueda = new Busqueda();
		
		filtros = new ArrayList<Filtro>();
		filtro1 = mock(Filtro.class);
		filtro2 = mock(Filtro.class);
		filtro3 = mock(Filtro.class);
		filtro4 = mock(Filtro.class);
		listaDePublicaciones1 = new ArrayList<Publicacion>();
		listaDePublicaciones2 = new ArrayList<Publicacion>();
		p1 		= mock(Publicacion.class);
		p2 		= mock(Publicacion.class);
		
		
		
	}

	@Test
	void test001UnaBusquedaConoceSusFiltros() {
		
		busqueda.setFiltro(filtro1);
		
		assertTrue(busqueda.getFiltros().contains(filtro1));
		assertFalse(busqueda.getFiltros().contains(filtro2));
		
	}
	
	@Test
	void test002UnaBusquedaSabeAsignarUnaListaDePublicacionesAOtra() {
		
		listaDePublicaciones1.add(p1);
		listaDePublicaciones2.add(p2);
		assertNotEquals(listaDePublicaciones1, listaDePublicaciones2);
		
		busqueda.asignar(listaDePublicaciones1, listaDePublicaciones2);
		
		//assertEquals(listaDePublicaciones1, listaDePublicaciones2);
		//Este falta ver q quisite hacer con el asignar, yo entiendo que la listaDePub1 pasa a ser igual a la 2, igual no me corre;
	}
	

}
