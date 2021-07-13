package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CapacidadTest {
	
	private List<Publicacion> publicaciones;
	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Capacidad capacidad;

	@BeforeEach
	void setUp() throws Exception {

	publicaciones = new ArrayList<Publicacion>();
	publicacion1 = mock(Publicacion.class);
	publicacion2 = mock(Publicacion.class);
	capacidad = new Capacidad(10);
	
	}
	
	@Test
	void test001ListaQueFiltraPorCapacidad() {

		
		publicaciones.add(publicacion1);
		publicaciones.add(publicacion2);

		int capacidad1 =  10;	
		int capacidad2 = 0;
		
		
		when(publicacion1.getCapacidad()).thenReturn(capacidad1);
		when(publicacion2.getCapacidad()).thenReturn(capacidad2);
		
		assertTrue(capacidad.filtrar(publicaciones).contains(publicacion1));
		assertFalse(capacidad.filtrar(publicaciones).contains(publicacion2));
 	

		
	}

}
