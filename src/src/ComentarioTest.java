package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComentarioTest  {

	private Comentario comentario;
	private String cuerpo;
	private Usuario usuario;

	@BeforeEach
	void setUp() throws Exception {
		
		comentario = new Comentario(cuerpo, usuario);
		usuario = mock(Usuario.class);
			
	}

	@Test
	void test001UnComentarioSabeSuCuerpo() {
	
		comentario.setCuerpo("Muy lindo el ambiente");
		
		assertEquals(comentario.getCuerpo(), "Muy lindo el ambiente");
	}
	
	@Test
	void test002UnComentarioSabeSuUsuario() {
	
		comentario.setUsuario(usuario);
		
		assertEquals(comentario.getUsuario(), usuario);
	}

}