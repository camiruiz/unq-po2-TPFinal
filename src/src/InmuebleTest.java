package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InmuebleTest {
	
	private String tipoInmueble;
	private String superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private ArrayList<String> servicios;
	private int capacidad;
	
	Inmueble inmueble;


	@BeforeEach
	void setUp() throws Exception {
		
		tipoInmueble 	= "tipoDeInmueble";
		superficie   	= "unaSuperficie";
		pais 			= "Mongolia";
		ciudad 			= "BajoFlores";
		direccion 		= "CalleFalsa 123";
		servicios 		= new ArrayList<String>();
		capacidad		= 4;
		
		inmueble = new Inmueble(tipoInmueble, superficie, pais, ciudad, direccion, servicios, capacidad);
		
		
		
	}

	@Test
	void test001UnInmuebleSabeSuTipoDeInmueble() {
		
		inmueble.setTipoInmueble(tipoInmueble);
		
		assertEquals(inmueble.getTipoInmueble(), tipoInmueble);		
	}
	
	@Test
	void test002UnInmuebleSabeSuSuperficie() {
		
		inmueble.setSuperficie(superficie);
		
		assertEquals(inmueble.getSuperficie(), superficie);		
	}
	
	
	@Test
	void test003UnInmuebleSabeSuPais() {
		
		inmueble.setPais(pais);
		
		assertEquals(inmueble.getPais(), pais);		
	}
	
	@Test
	void test003UnInmuebleSabeSuCiudad() {
		
		inmueble.setCiudad(ciudad);
		
		assertEquals(inmueble.getCiudad(), ciudad);		
	}
	
	@Test
	void test004UnInmuebleSabeSuDireccion() {
		
		inmueble.setDireccion(direccion);
		
		assertEquals(inmueble.getDireccion(), direccion);		
	}
	
	@Test
	void test005UnInmuebleSabeSusServicios() {
		
		String servicio 	= "unServicio";
		String servicio2 	= "unServicioQueNoTieneMiInmueble";
		
		inmueble.setServicio(servicio);
		
		assertTrue(inmueble.getServicios().contains(servicio));		
		assertFalse(inmueble.getServicios().contains(servicio2));
	}
		
	@Test
	void test006UnInmuebleSabeSuCapacidad() {
		
		inmueble.setCapacidad(capacidad);
		
		assertEquals(inmueble.getCapacidad(), capacidad);		
	}

}
