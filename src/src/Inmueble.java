package src;

import java.util.ArrayList;

public class Inmueble {
	private String tipoInmueble;
	private String superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private ArrayList<String> servicios;
	private int capacidad;
	
	public Inmueble(String tipoInmueble,
					String superficie, 
					String pais,
					String ciudad,
					String direccion, 
					ArrayList<String> servicios, 
					int capacidad) {
		
		this.tipoInmueble = tipoInmueble;
		this.superficie = superficie;
		this.pais = pais;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.servicios = new ArrayList<String>();
		this.capacidad = capacidad;
		
	}
	
	public String getTipoInmueble() {
		return tipoInmueble;
	}
	
	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	
	public String getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}	
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public ArrayList<String> getServicios() {
		return servicios;
	}
	
	public void setServicio(String servicio) {
		this.servicios.add(servicio);
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
}
