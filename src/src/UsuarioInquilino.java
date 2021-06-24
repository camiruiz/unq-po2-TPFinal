package src;

import java.time.LocalDate;

public class UsuarioInquilino implements iPuntuable {

		private String nombreCompleto;
		private String email;
		private String telefono;
		private CalculadorDeCalificaciones calculadorDeCalificaciones;

		// Constructor
		public UsuarioInquilino(String nombreCompleto, String email, String telefono, CalculadorDeCalificaciones calculadorDeCalificaciones) {
			super();
			this.nombreCompleto = nombreCompleto;
			this.email = email;
			this.telefono = telefono;
			this.calculadorDeCalificaciones = calculadorDeCalificaciones;
			
		}

		public CalculadorDeCalificaciones getCalculadorDeCalificaciones() {
			return calculadorDeCalificaciones;
		}

		public void setCalculadorDeCalificaciones(CalculadorDeCalificaciones calculadorDeCalificaciones) {
			this.calculadorDeCalificaciones = calculadorDeCalificaciones;
		}

		public String getNombreCompleto() {
			return nombreCompleto;
		}

		public void setNombreCompleto(String nombre) {
			this.nombreCompleto = nombre;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		public float getPuntaje() {
			return calculadorDeCalificaciones.calcularPromedio();
		}
		
		public void setPuntaje(String categoria, Integer calificacion) {
			calculadorDeCalificaciones.agregarPuntaje(categoria, calificacion);
		}
		
		public void solicitarReserva(Publicacion publicacion, LocalDate fechaInicio, LocalDate fechaFin, String metodoDePago) {
			Solicitud solicitud = new Solicitud(this, fechaInicio, fechaFin, metodoDePago, publicacion);
			publicacion.getPropietario().recibirSolicitud(solicitud);
		}
		
	
	
}
