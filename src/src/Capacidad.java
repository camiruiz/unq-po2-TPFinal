package src;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Capacidad extends Filtro {
	private Integer capacidad;
	static String tipo = "Capacidad";
	public Capacidad(Integer miCapacidad) {
		this.setTipo(tipo);
		capacidad = miCapacidad;
	}
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		
		return (publicaciones.stream().filter(p -> p.getCapacidad() == this.capacidad)).collect(Collectors.toList());
	}
	
}
