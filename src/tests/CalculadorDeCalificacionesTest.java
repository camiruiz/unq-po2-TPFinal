package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.CalculadorDeCalificaciones;
import src.Calificacion;
import src.Comentario;

class CalculadorDeCalificacionesTest {
	
	private  CalculadorDeCalificaciones 	calculador;
	private ArrayList<Comentario> 			comentarios;
	private ArrayList<Calificacion> 		calificaciones;
	private Calificacion					cal1;
	private Calificacion					cal2;
	private Calificacion					cal3;
	private Calificacion					cal4;
	private Comentario 						comen1;
	private Comentario 						comen2;


	@BeforeEach
	void setUp() throws Exception {
		
		comentarios 	= 	new ArrayList<Comentario>();
		calificaciones	= 	new ArrayList<Calificacion>();
		cal1 = mock(Calificacion.class);
		cal2 = mock(Calificacion.class);
		cal3 = mock(Calificacion.class);
		cal4 = mock(Calificacion.class);
		comen1 = mock(Comentario.class);
		comen2 = mock(Comentario.class);
		
		
		calculador = new CalculadorDeCalificaciones(calificaciones, comentarios);
	}
	
	@Test
	void test001ElCalculadorDeCalificacionesSabeCalcularSuPuntajeTotal() {
		
		calculador.agregarPuntaje(cal1);
		calculador.agregarPuntaje(cal2);
		calculador.agregarPuntaje(cal3);
		calculador.agregarPuntaje(cal4);
		
		
		when(cal1.getCalificacion()).thenReturn(5);
		when(cal2.getCalificacion()).thenReturn(6);
		when(cal3.getCalificacion()).thenReturn(7);
		when(cal4.getCalificacion()).thenReturn(2);
		
		
		assertEquals(calculador.puntajeTotal(), 20);
		
		verify(cal1, times(1)).getCalificacion();
		verify(cal2, times(1)).getCalificacion();
		verify(cal3, times(1)).getCalificacion();
		verify(cal4, times(1)).getCalificacion();
	}
	
	@Test
	void test002ElCalculadorDecalificacionesSabeCalcularSupromedio() {
		
		calculador.agregarPuntaje(cal1);
		calculador.agregarPuntaje(cal2);
		calculador.agregarPuntaje(cal3);
		calculador.agregarPuntaje(cal4);
		
		when(cal1.getCalificacion()).thenReturn(5);
		when(cal2.getCalificacion()).thenReturn(6);
		when(cal3.getCalificacion()).thenReturn(7);
		when(cal4.getCalificacion()).thenReturn(2);
		
		assertEquals(calculador.calcularPromedio(), 5.0);	
	}
	
	@Test
	void test003ElCalculadorDecalificacionesSabeSusCalificaciones() {
		calculador.agregarPuntaje(cal1);
		
		assertTrue(calculador.getListaDePuntajes().contains(cal1));
		assertFalse(calculador.getListaDePuntajes().contains(cal2));
		
	}
	
	
	@Test
	void test004ElCalculadorDecalificacionesSabeSusComentarios() {
		calculador.agregarComentario(comen1);
	
		
		assertTrue(calculador.getListaDeComentarios().contains(comen1));
		assertFalse(calculador.getListaDeComentarios().contains(comen2));
	}
		

}
