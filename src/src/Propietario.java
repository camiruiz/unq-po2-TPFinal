package tpFinal_JAVASTA;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends UsuarioInquilino {
	
	private String nombreCompleto;
	private String email;
	private String telefono;
	private CalculadorDeCalificaciones calculadorDeCalificacionesDue�o;
	private List<String> metodosDePago;

	// Constructor
	public Propietario(String nombreCompleto, String email, String telefono, CalculadorDeCalificaciones calculadorDeCalificacionesDue�o, List<String> metodosDePago) {
		super(nombreCompleto, email, telefono, calculadorDeCalificacionesDue�o);
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

	public CalculadorDeCalificaciones getCalculadorDeCalificacionesDue�o() {
		return calculadorDeCalificacionesDue�o;
	}

	public void setCalculadorDeCalificacionesDue�o(CalculadorDeCalificaciones calculadorDeCalificacionesDue�o) {
		this.calculadorDeCalificacionesDue�o = calculadorDeCalificacionesDue�o;
	}

	
	
}
