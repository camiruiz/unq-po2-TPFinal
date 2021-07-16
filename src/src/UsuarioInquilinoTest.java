package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioInquilinoTest {
	
	UsuarioInquilino 			usuarioInq;
	String				 		nombreCompleto;
	String 						email;
	String 						telefono;
	CalculadorDeCalificaciones  calculadorDeCalificaciones;
	Solicitud 					solicitud;
	Publicacion					publicacion;
	Propietario					propietario;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	
		
		nombreCompleto 				= "LuisAlbertoSpinettalandia";
		email						= "TuFlakitolindo@CorreoCaliente.com";
		telefono					= "0-800-ElFlaketeee";
		calculadorDeCalificaciones  = mock(CalculadorDeCalificaciones.class);
		usuarioInq 					= new UsuarioInquilino(nombreCompleto, email, telefono, calculadorDeCalificaciones);
		solicitud  					= mock(Solicitud.class);
		publicacion					= mock(Publicacion.class);
		propietario					= mock(Propietario.class);
		
	}
	

	
	
	@Test
	void test001() {
		
		when(solicitud.getPublicacion()).thenReturn(publicacion);
		when(publicacion.getPropietario()).thenReturn(propietario);
		
		usuarioInq.solicitarReserva(solicitud);
		
		verify(solicitud, times(1)).getPublicacion();
		verify(publicacion, times(1)).getPropietario();
		verify(propietario, times(1)).recibirSolicitud(solicitud);
		
		
	}

}
