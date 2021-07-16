package usuarios;

import calculadorDeCalificaciones.CalculadorDeCalificaciones;
import calculadorDeCalificaciones.Calificacion;

public abstract class Usuario {
	

	private String nombreCompleto;
	private String email;
	private String telefono;
	private CalculadorDeCalificaciones calculadorDeCalificaciones;

	// Constructor
	public Usuario(String nombreCompleto, String email, String telefono, CalculadorDeCalificaciones calculadorDeCalificaciones) {
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
	
	public void setPuntaje(Calificacion calificacion) {
		calculadorDeCalificaciones.agregarPuntaje(calificacion);
	}
	
}

