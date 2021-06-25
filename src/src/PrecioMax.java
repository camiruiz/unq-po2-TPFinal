package src;


import java.util.List;
import java.util.stream.Collectors;


public class PrecioMax extends Filtro {

	private Double precioMax;
	static String tipo = "PrecioMax";
	public PrecioMax(Double precioMax) {
		this.setTipo(tipo);
		this.precioMax = precioMax;
	}
	
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		return (publicaciones.stream().filter(p -> p.getPrecioPorDia() <= this.precioMax)).collect(Collectors.toList());

	}
}
