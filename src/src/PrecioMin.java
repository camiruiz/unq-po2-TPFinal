package src;


import java.util.ArrayList;
import java.util.List;

public class PrecioMin extends Filtro {
	private Double precioMin;
	static String tipo = "PrecioMin";
	public PrecioMin(Double precioMin) {
		this.setTipo(tipo);
		this.precioMin = precioMin;
	}
	
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		List<Publicacion> listaActual = new ArrayList<Publicacion>(); 
		publicaciones.stream().forEach(p -> this.agregarSiDebo(p, listaActual,(p.getPrecioPorDia() >= this.precioMin)));
		return listaActual;
	}

	
	public List<Publicacion> filtrar2(List<Publicacion> publicaciones) {
		List<Publicacion> listaActual = new ArrayList<Publicacion>(); 
		return publicaciones.stream().filter(p -> (p.getPrecioPorDia() >= this.precioMin));
	
}
