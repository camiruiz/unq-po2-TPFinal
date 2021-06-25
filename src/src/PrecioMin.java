package src;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PrecioMin extends Filtro {
	private Double precioMin;
	static String tipo = "PrecioMin";
	public PrecioMin(Double precioMin) {
		this.setTipo(tipo);
		this.precioMin = precioMin;
	}
	
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		return (publicaciones.stream().filter(p -> p.getPrecioPorDia() >= this.precioMin)).collect(Collectors.toList());

	}

	
	public List<Publicacion> filtrar2(List<Publicacion> publicaciones) {
		List<Publicacion> listaActual = new ArrayList<Publicacion>(); 
		return publicaciones.stream().filter(p -> (p.getPrecioPorDia() >= this.precioMin));
	
}
