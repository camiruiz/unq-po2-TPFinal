package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculadorDeCalificaciones.CalculadorDeCalificaciones;
import calculadorDeCalificaciones.Calificacion;
import calculadorDeCalificaciones.Comentario;
import usuarios.Usuario;
import usuarios.UsuarioInquilino;

class UsuarioTest {
	
	
	private String nombreCompleto;
	private String email;
	private String telefono;
	private CalculadorDeCalificaciones calculadorDeCalificaciones1;
	private List<Calificacion> listaPuntajes1;
	private List<Comentario> listaComentarios1;
	
	Usuario usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		

		nombreCompleto    = "Lio Messi";
		email 			  = "messi2021@gmail.com";
		telefono		  = "43214321" ;
		listaPuntajes1    = new ArrayList<Calificacion>();		
		listaComentarios1 = new ArrayList<Comentario>();
		calculadorDeCalificaciones1 = mock(CalculadorDeCalificaciones.class);
 
		usuario = new UsuarioInquilino(nombreCompleto, email, telefono, calculadorDeCalificaciones1);
	}
	

	
	@Test
	void test001ElUsuarioSabeSusCalificaciones() {
		
		usuario.setCalculadorDeCalificaciones(calculadorDeCalificaciones1);
		
		assertEquals(usuario.getCalculadorDeCalificaciones(), calculadorDeCalificaciones1);
			
 	}
	
	@Test
	void test002ElUsuarioSabeSuNombre() {
		
		usuario.setNombreCompleto(nombreCompleto);
		
		assertEquals(usuario.getNombreCompleto(), nombreCompleto);
			
 	}
	
	@Test
	void test003ElUsuarioSabeSuEmail() {
		
		usuario.setEmail(email);
		
		assertEquals(usuario.getEmail(), email);
			
 	}
	
	
	@Test
	void test004ElUsuarioSabeSuTelefono() {
		
		usuario.setTelefono(telefono);
		
		assertEquals(usuario.getTelefono(), telefono);
			
 	}
	
	@Test
	void test005ElUsuarioLePideASuCalculadorDeCalificacionesQueLeCalculeSuPuntaje() {
		
		usuario.getPuntaje();
		
		verify(calculadorDeCalificaciones1, times(1)).calcularPromedio();
			
 	}
	
	@Test
	void test006ElUsuarioLePideASuCalculadorDeCalificacionesQueAgregueUnPuntaje() {
		
		Calificacion calificacion1 = mock(Calificacion.class);
		usuario.setPuntaje(calificacion1);
		
		verify(calculadorDeCalificaciones1, times(1)).agregarPuntaje(calificacion1);
			
 	}
	
	


}
