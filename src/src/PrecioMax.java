package src;

import java.util.ArrayList;
import java.util.List;

public class PrecioMax extends Filtro {

	private Double precioMax;
	static String tipo = "PrecioMax";
	public PrecioMax(Double precioMax) {
		this.setTipo(tipo);
		this.precioMax = precioMax;
	}
	
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		List<Publicacion> listaActual = new ArrayList<Publicacion>(); 
		publicaciones.stream().forEach(p -> this.agregarSiDebo(p, listaActual,(p.getPrecioPorDia() <= this.precioMax)));
		return listaActual;
	}
}
