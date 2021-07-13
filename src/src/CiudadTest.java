package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CiudadTest {
	
 	private List<Publicacion> publicaciones;
	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Ciudad ciudad;
	private String buenosAires;
	private String cordoba;


 
	@BeforeEach
	void setUp() throws Exception {

	publicaciones = new ArrayList<Publicacion>();
	publicacion1 = mock(Publicacion.class);
	publicacion2 = mock(Publicacion.class);
	buenosAires = "BuenosAires";
	cordoba 	= "Cordoba";
	ciudad = new Ciudad(buenosAires);
	
	
	}
	
	@Test
	void test001ListaQueFiltraPorCiudad() {

		
		publicaciones.add(publicacion1);
		publicaciones.add(publicacion2);

		when(publicacion1.getCiudad()).thenReturn(buenosAires);
		when(publicacion2.getCiudad()).thenReturn(cordoba);
		
		assertTrue(ciudad.filtrar(publicaciones).contains(publicacion1));
		assertFalse(ciudad.filtrar(publicaciones).contains(publicacion2));
  
		
	}

}