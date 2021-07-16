package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filtros.PrecioMin;
import publicacionesYBusquedas.Publicacion;

class PrecioMinTest {
	
	private List<Publicacion> publicaciones;
	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private PrecioMin precioMin;

	@BeforeEach
	void setUp() throws Exception {

	publicaciones = new ArrayList<Publicacion>();
	publicacion1 = mock(Publicacion.class);
	publicacion2 = mock(Publicacion.class);
	precioMin = new PrecioMin(10.0);
	
	}
	
	@Test
	void test001ListaQueFiltraPorPreciosMin() {

		
		publicaciones.add(publicacion1);
		publicaciones.add(publicacion2);

		Double precio1 = 1000.0;	
		Double precio2 = 0.0;
		
		
		when(publicacion1.getPrecioPorDia()).thenReturn(precio1);
		when(publicacion2.getPrecioPorDia()).thenReturn(precio2);
		
		assertTrue(precioMin.filtrar(publicaciones).contains(publicacion1));
		assertFalse(precioMin.filtrar(publicaciones).contains(publicacion2));
 	

		
	}

}
