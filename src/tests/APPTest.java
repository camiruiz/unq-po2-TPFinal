package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.APP;
import src.Usuario;
import src.UsuarioInquilino;

class APPTest {
	
	 
	private List<Usuario> usuarios;
	private List<String> tiposDeInmueble;
	private List<String> servicios;
	private List<String> categoriasDeInmueble;
	private List<String> categoriasDePropietario;
	private List<String> categoriasDeInquilino;
	private UsuarioInquilino usuario1;
	private UsuarioInquilino usuario2;
	
	APP app;
	

	@BeforeEach
	void setUp() throws Exception {
		
		usuarios 					= new ArrayList<Usuario>();
		tiposDeInmueble 			= new ArrayList<String>();
		servicios 					= new ArrayList<String>();
		categoriasDeInmueble		= new ArrayList<String>();
		categoriasDePropietario		= new ArrayList<String>();
		categoriasDeInquilino 		= new ArrayList<String>();
		
		
		app = new APP(usuarios, tiposDeInmueble, servicios, categoriasDeInmueble, categoriasDePropietario, categoriasDeInquilino);
		

	}

	@Test
	void test001LaAPPSabeSusCategoriasDeInmuebles() {
		
		String categoria1 = "unaCategoria";
		String categoria2 = "otraCategoria";
			
		app.agregarCategoriaDeInmueble(categoria1);
		
		assertTrue(app.getCategoriasDeInmueble().contains(categoria1));
		assertFalse(app.getCategoriasDeInmueble().contains(categoria2));
	}
	
	@Test
	void test002LaAPPSabeSusCategoriasDePropietario() {
		
		String categoria1 = "unaCategoria";
		String categoria2 = "otraCategoria";
			
		app.agregarCategoriaDePropietario(categoria1);
		
		assertTrue(app.getCategoriasDePropietario().contains(categoria1));
		assertFalse(app.getCategoriasDePropietario().contains(categoria2));
	}
	
	
	@Test
	void test003LaAPPSabeSusCategoriasDeInquilino() {
		
		String categoria1 = "unaCategoria";
		String categoria2 = "otraCategoria";
			
		app.agregarCategoriaDeInquilino(categoria1);
		
		assertTrue(app.getCategoriasDeInquilino().contains(categoria1));
		assertFalse(app.getCategoriasDeInquilino().contains(categoria2));
	}
	

	@Test
	void test004LaAPPSabeSusServicios() {
		
		String servicio1 = "unServicio";
		String servicio2 = "otroServicio";
			
		app.agregarServicio(servicio1);
		
		assertTrue(app.getServicios().contains(servicio1));
		assertFalse(app.getServicios().contains(servicio2));
	}
	
	@Test
	void test005LaAPPSabeSusTiposDeInmuebles() {
		
		String tipoDeInmueble1 = "unTipoDeInmueble";
		String tipoDeInmueble2 = "otroTipoDeInmueble";
			
		app.agregarTipoDeInmueble(tipoDeInmueble1);
		
		assertTrue(app.getTiposDeInmueble().contains(tipoDeInmueble1));
		assertFalse(app.getTiposDeInmueble().contains(tipoDeInmueble2));
	}
	
	@Test
	void test006LaAPPSabeSusUsuarios() {
		
		usuario1 = mock(UsuarioInquilino.class);
		usuario2 = mock(UsuarioInquilino.class);
			
		app.setUsuario(usuario1);
		
		assertTrue(app.getUsuarios().contains(usuario1));
		assertFalse(app.getUsuarios().contains(usuario2));
	}
	
	

}
