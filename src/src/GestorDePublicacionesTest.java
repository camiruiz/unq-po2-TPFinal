package src;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestorDePublicacionesTest {
	
	private GestorDePublicaciones GP;
	private UsuarioInquilino usuario1;
	private UsuarioInquilino usuario2;
	private Publicacion p1;
	private Publicacion p2;
	private Publicacion p3;
	private Publicacion p4;
	private Reserva r1;
	private Reserva r2;
	private Reserva r3;
	private Reserva r4;
	private ArrayList<Reserva> listaDeReservas;
	private ArrayList<Reserva> listaDeReservas2;
	private Calendario calendario;
	private Calendario calendario2;
	private LocalDate f1;
	private LocalDate f2;
	private LocalDate f3;
	private LocalDate f4;
	private ArrayList<Inmueble> listaDeInmuebles;
	private ArrayList<Inmueble> listaDeInmuebles2;
	private Inmueble inmueble1;
	private Inmueble inmueble2;
	private Inmueble inmueble3;
	private Inmueble inmueble4;
	private Propietario propietario1;
	private Propietario propietario2;
	


	@BeforeEach
	void setUp() throws Exception {
	
		usuario1 = mock(UsuarioInquilino.class);
		usuario2 = mock(UsuarioInquilino.class);
		propietario1 = mock(Propietario.class);
		propietario2 = mock(Propietario.class);
		p1 = mock(Publicacion.class);
		p2 = mock(Publicacion.class);
		p3 = mock(Publicacion.class);
		p4 = mock(Publicacion.class);
		GP = new GestorDePublicaciones();
		r1 = mock(Reserva.class);
		r2 = mock(Reserva.class);
		r3 = mock(Reserva.class);
		r4 = mock(Reserva.class);
		listaDeReservas = new ArrayList<Reserva>();
		listaDeReservas2 = new ArrayList<Reserva>();
		calendario = mock(Calendario.class);
		calendario2 = mock(Calendario.class);
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		inmueble3 = mock(Inmueble.class);
		inmueble4 = mock(Inmueble.class);
	}

	
	@Test
	void test001ElGestorDePublicacionesSabeCuantasReservasExisten() {
		
		
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
		GP.setPublicacion(p3);
		GP.getReservas();
		verify(p1, times(1)).getReservas();
		verify(p2, times(1)).getReservas();
		verify(p3, times(1)).getReservas();
	}
	
	@Test
	void test002ElGestorDePublicacionesSabeLasReservasDeUnUsuario() {
		
		
		
		
		
		listaDeReservas.add(r2);
		
		
		p1.recibirReserva(r1);
		p2.recibirReserva(r2);
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
		
		when(r1.compararInquilino(usuario2)).thenReturn(false);
		when(r2.compararInquilino(usuario1)).thenReturn(true);
		
		when(p1.getReservas()).thenReturn(listaDeReservas);
		
		assertTrue(GP.getReservasDeUsuario(usuario1).contains(r2));
		
		
	}
	
	@Test
	void test0003ElGestorDePublicacionesSabeLasCiudadesConReservas() {
	
		String ciudad = "BsAs";
		String ciudadLoca = "ciudadLoca";
		
		when(p1.chequearSiElUsuarioTieneReserva(usuario1)).thenReturn(true);
		when(p1.getCiudad()).thenReturn(ciudad);
		when(p2.chequearSiElUsuarioTieneReserva(usuario1)).thenReturn(false);
		when(p2.getCiudad()).thenReturn(ciudadLoca);
		
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
		
		
		assertTrue(GP.getCiudadesConReserva(usuario1).contains(ciudad));
		assertFalse(GP.getCiudadesConReserva(usuario1).contains(ciudadLoca));
	}
	
	@Test
	void test003ElGestorDePublicacionesSabeLasReservasEnLaCiudadCiudad() {
		
		ArrayList<Reserva> listaDeReservasDeCiudad = new ArrayList<Reserva>();
		ArrayList<Reserva> listaDeReservasDeCiudad2 = new ArrayList<Reserva>();
		
		listaDeReservasDeCiudad.add(r1);
		listaDeReservasDeCiudad.add(r2);
		
		listaDeReservasDeCiudad2.add(r3);
		
		
		
		when(p1.getCiudad()).thenReturn("CiudadLoca");	
		when(p2.getCiudad()).thenReturn("CiudadLocaQueNoEntraXD");	
		
		when(p1.chequearCiudad("CiudadLoca")).thenReturn(true);	
		when(p2.chequearCiudad("CiudadLoca")).thenReturn(false);	
	
		
		when(p1.getReservas()).thenReturn(listaDeReservasDeCiudad);
		when(p2.getReservas()).thenReturn(listaDeReservasDeCiudad2);
		
		
		
	
		GP.setPublicacion(p1); 
		GP.setPublicacion(p2); 
		
		List<Reserva> lista = GP.getReservasEnCiudad("CiudadLoca");
		
		
		verify(p1, times(1)).getReservas();
		verify(p2, times(0)).getReservas();
		verify(p1, times(1)).chequearCiudad("CiudadLoca");
		verify(p2, times(1)).chequearCiudad("CiudadLoca");
		
		assertEquals(lista, listaDeReservasDeCiudad);	
	
	}
	
	@Test
	void test004ElGestorDePublicacionesSabeLasReservasQueSonFuturas() {
		
		when(r1.chequearSiEsFutura()).thenReturn(true);
		when(r2.chequearSiEsFutura()).thenReturn(false);
		listaDeReservas.add(r1);
		listaDeReservas.add(r2);
		
		
		
		when(p1.getReservas()).thenReturn(listaDeReservas);
		GP.setPublicacion(p1);

		List<Reserva> reservasFuturasDeUser = GP.getReservasFuturas(usuario1);
		
		
		verify(p1, times(1)).getReservas();
		verify(r1, times(1)).chequearSiEsFutura();
		verify(r2, times(1)).chequearSiEsFutura();
		assertTrue(reservasFuturasDeUser.contains(r1));
		assertFalse(reservasFuturasDeUser.contains(r2));
		
	}
	

	@Test
	void test006ElGestorDePublicacionesSabeSiUnaPublicacionEstaLibre() {
		
		f1 = LocalDate.now();
		f2 = LocalDate.now();
		f3 = LocalDate.now().plusDays(3);
		f4 = LocalDate.now().plusDays(3);
		
		when(p1.getCalendario()).thenReturn(calendario);
		when(p2.getCalendario()).thenReturn(calendario2);
		
		when(calendario.checkDisponibilidadEntre(f1, f2)).thenReturn(true);
		when(calendario2.checkDisponibilidadEntre(f3, f4)).thenReturn(false);
		
		assertTrue(GP.estaLibre(p1));
		assertFalse(GP.estaLibre(p2));
		
	}
	
	
	@Test
	void test007ElGestorDePublicacionesSabeTodosLosInmueblesQueSeEncuentranLibres() {
		
	
		listaDeInmuebles = new ArrayList<Inmueble>();
		listaDeInmuebles2 = new ArrayList<Inmueble>();

		
		f1 = LocalDate.now();
		f2 = LocalDate.now();

		listaDeInmuebles.add(inmueble1);
		listaDeInmuebles.add(inmueble2);
		listaDeInmuebles.add(inmueble3);
		listaDeInmuebles2.add(inmueble4);
	
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
		GP.setPublicacion(p3);
		
		when(p1.getInmueble()).thenReturn(inmueble1);
		when(p2.getInmueble()).thenReturn(inmueble2);
		when(p3.getInmueble()).thenReturn(inmueble3);
		when(p4.getInmueble()).thenReturn(inmueble4);
		when(calendario.checkDisponibilidadEntre(f1, f2)).thenReturn(true);
		
		when(p1.getCalendario()).thenReturn(calendario);
		when(p2.getCalendario()).thenReturn(calendario);
		when(p3.getCalendario()).thenReturn(calendario);
		
		assertEquals(GP.getInmueblesLibres(), listaDeInmuebles);
		assertNotEquals(GP.getInmueblesLibres(), listaDeInmuebles2);
		
	}
		
		
		
		

	
	@Test
	void test008ElGestorDePublicacionesSabeSusInmuebles() {
		
		listaDeInmuebles = new ArrayList<Inmueble>();
		
		listaDeInmuebles.add(inmueble1);
		listaDeInmuebles.add(inmueble2);
		listaDeInmuebles.add(inmueble3);
		
		when(p1.getInmueble()).thenReturn(inmueble1);
		when(p2.getInmueble()).thenReturn(inmueble2);
		when(p3.getInmueble()).thenReturn(inmueble3);
		
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
		GP.setPublicacion(p3);
		
		assertEquals(GP.getInmuebles(), listaDeInmuebles);		
		
	}
	
	@Test
	void test009ElGestorDePublicacionesSabeCalcularSuTasaDeOcupacion() {
		

		f1 = LocalDate.now();
		f2 = LocalDate.now();
				
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
		GP.setPublicacion(p3);
		
		when(p1.getInmueble()).thenReturn(inmueble1);
		when(p2.getInmueble()).thenReturn(inmueble2);
		when(p3.getInmueble()).thenReturn(inmueble3);
		when(p1.getCalendario()).thenReturn(calendario2);
		when(p2.getCalendario()).thenReturn(calendario);
		when(p3.getCalendario()).thenReturn(calendario);
		when(calendario.checkDisponibilidadEntre(f1, f2)).thenReturn(true);
		when(calendario2.checkDisponibilidadEntre(f1, f2)).thenReturn(false);
		
		
		
	
		
		assertEquals((double) GP.getTasaDeOcupacion(), (double) 66.66666412353516);
		
		verify(p1, times(1)).getInmueble();
		verify(p2, times(2)).getInmueble();
		verify(p3, times(2)).getInmueble();
		verify(p1, times(1)).getCalendario();
		verify(p2, times(1)).getCalendario();
		verify(p3, times(1)).getCalendario();
		verify(calendario, times(2)).checkDisponibilidadEntre(f1, f2);
		verify(calendario2, times(1)).checkDisponibilidadEntre(f1, f2);
		
		
	
	}
	
	
	@Test
	void test010ElGestorDePublicacionesSabeSiUnaReservaSeConcretoAnteriormenteYCuandoNo() {
		
		when(r1.getFechaInicio()).thenReturn(LocalDate.now().minusDays(3));
		when(r2.getFechaInicio()).thenReturn(LocalDate.now().plusDays(3));
		
		
		assertTrue(GP.seConcretoAnteriormente(r1));
		assertFalse(GP.seConcretoAnteriormente(r2));
			
	}
	
	
	@Test
	void test011ElGestorDePublicacionesSabeCuantasVecesSeAlquiloUnInmueble() {
		
		
		listaDeReservas.add(r1);
		listaDeReservas.add(r2);
		listaDeReservas.add(r3);
		
		listaDeReservas2.add(r1);
		listaDeReservas2.add(r4);
		
		when(r1.getFechaInicio()).thenReturn(LocalDate.now().minusDays(3));
		when(r2.getFechaInicio()).thenReturn(LocalDate.now().minusDays(3));
		when(r3.getFechaInicio()).thenReturn(LocalDate.now().plusDays(3));
		when(r4.getFechaInicio()).thenReturn(LocalDate.now().minusDays(3));
		
		when(p1.getReservas()).thenReturn(listaDeReservas);
		
	
		assertEquals(GP.getVecesQueAlquiloUnInmueble(p1), listaDeReservas2.size());
		assertNotEquals(GP.getVecesQueAlquiloUnInmueble(p1), listaDeReservas.size());
		
		
	}
	
	@Test
	void test012ElGestorDePublicacionesSabeLaCantidadDeReservasDeUnUsuario() {
		
		listaDeReservas.add(r1);
		listaDeReservas.add(r2);
		listaDeReservas.add(r3);
			
		p1.recibirReserva(r1);
		p1.recibirReserva(r2);
		p1.recibirReserva(r3);
			
		when(r1.compararInquilino(usuario1)).thenReturn(true);
		when(r2.compararInquilino(usuario1)).thenReturn(true);
		when(r3.compararInquilino(usuario1)).thenReturn(true);
		when(p1.getReservas()).thenReturn(listaDeReservas);
		
		GP.setPublicacion(p1);
		
		assertEquals(GP.getCantidadDeReservasDeUsuario(usuario1), listaDeReservas.size());
		
	}
	
	@Test
	void test013ElGestorDePublicacionesSabeSusPublicaciones() {
		
		ArrayList<Publicacion> listaDePublicaciones = new ArrayList<Publicacion>();
		
		listaDePublicaciones.add(p1);
		listaDePublicaciones.add(p2);
		
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
				
		assertEquals(GP.getPublicaciones(), listaDePublicaciones);
		
	}
	
	
	@Test	
	void test014ElGestorDePublicacionesSabeCompararUsuarios() {

		when(p1.getPropietario()).thenReturn(propietario1);
		when(p2.getPropietario()).thenReturn(propietario2);
		
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
		
		
		assertTrue(GP.compararUsuario(propietario1, p1));
		assertFalse(GP.compararUsuario(propietario1, p2));
	}
	
	
	@Test	
	void test015ElGestorDePublicacionesConoceTodasLasPublicacionesDeUnUsuarioPropietario() {
		
		ArrayList<Publicacion> listaDePublicaciones = new ArrayList<Publicacion>();
		
		listaDePublicaciones.add(p1);
		listaDePublicaciones.add(p2);
		
		when(p1.getPropietario()).thenReturn(propietario1);
		when(p2.getPropietario()).thenReturn(propietario1);
		
		GP.setPublicacion(p1);
		GP.setPublicacion(p2);
				
		assertEquals(GP.getPublicacionesDeUsuario(propietario1), listaDePublicaciones);		
	}
	
	
	
	@Test	
	void test016ElGestorDePublicacionesSabeTodasLasVecesQueAlquiloUnInmuebleUnPropieteario() {
		
			
		listaDeReservas.add(r1);
		listaDeReservas.add(r2);
		listaDeReservas.add(r3);
		listaDeReservas.add(r4);
		
		
		when(p1.getPropietario()).thenReturn(propietario1);
		when(r1.getFechaInicio()).thenReturn(LocalDate.now().minusDays(3));
		when(r2.getFechaInicio()).thenReturn(LocalDate.now().minusDays(3));
		when(r3.getFechaInicio()).thenReturn(LocalDate.now().minusDays(3));
		when(r4.getFechaInicio()).thenReturn(LocalDate.now().minusDays(3));
		when(p1.getPropietario()).thenReturn(propietario1);
		when(p1.getReservas()).thenReturn(listaDeReservas);
		
		p1.recibirReserva(r1);
		p1.recibirReserva(r2);
		p1.recibirReserva(r3);
		p1.recibirReserva(r4);
		
		GP.setPublicacion(p1);
		GP.getPublicacionesDeUsuario(propietario1);
		
		assertEquals(GP.getVecesQueAlquiloTodosSusInmuebles(propietario1), 4);
		
	}		
	
}
