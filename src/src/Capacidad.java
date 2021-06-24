package src;


import java.util.ArrayList;
import java.util.List;

public class Capacidad extends Filtro {
	private Integer capacidad;
	static String tipo = "Capacidad";
	public Capacidad(Integer miCapacidad) {
		this.setTipo(tipo);
		capacidad = miCapacidad;
	}
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		List<Publicacion> listaActual = new ArrayList<Publicacion>(); 
		publicaciones.stream().forEach(p -> this.agregarSiDebo(p, listaActual,(p.getCapacidad() == this.capacidad)));
		return listaActual;
	}
	
}
