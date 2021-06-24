package tpFinal_JAVASTA;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends UsuarioInquilino {
	
	private String nombreCompleto;
	private String email;
	private String telefono;
	private CalculadorDeCalificaciones calculadorDeCalificacionesDueño;
	private List<String> metodosDePago;

	// Constructor
	public Propietario(String nombreCompleto, String email, String telefono, CalculadorDeCalificaciones calculadorDeCalificacionesDueño, List<String> metodosDePago) {
		super(nombreCompleto, email, telefono, calculadorDeCalificacionesDueño);
		this.metodosDePago = new ArrayList<String>(metodosDePago);

	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public List<String> getMetodosDePago() {
		return metodosDePago;
	}

	public void setMetodosDePago(ArrayList<String> metodosDePago) {
		this.metodosDePago = metodosDePago;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
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

	public CalculadorDeCalificaciones getCalculadorDeCalificacionesDueño() {
		return calculadorDeCalificacionesDueño;
	}

	public void setCalculadorDeCalificacionesDueño(CalculadorDeCalificaciones calculadorDeCalificacionesDueño) {
		this.calculadorDeCalificacionesDueño = calculadorDeCalificacionesDueño;
	}

	
	
}
