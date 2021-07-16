package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Calificacion;

class CalificacionTest  {

	private Calificacion calificacion;
	private String categoria;
	private Integer puntaje;

	@BeforeEach
	void setUp() throws Exception {
		
		calificacion = new Calificacion(categoria, puntaje);
		
		
	}

	@Test
	void test001LaCalificacionSabeSuCategoria() {
	
		calificacion.setCategoria("Higiene");
		
		assertEquals(calificacion.getCategoria(), "Higiene");
	}
	
	@Test
	void test002LaCalificacionSabeSuCalificacion() {
	
		calificacion.setCalificacion(6);
		
		assertEquals(calificacion.getCalificacion(), 6);
	}

}
