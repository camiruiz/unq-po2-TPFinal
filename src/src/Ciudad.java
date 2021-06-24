package src;

import java.util.ArrayList;
import java.util.List;

public class Ciudad extends Filtro {
	
	private String ciudad;
	static String tipo = "Ciudad";
	public Ciudad(String ciudad) {
		this.setTipo(tipo);
		this.ciudad = ciudad;
	}
	
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		List<Publicacion> listaActual = new ArrayList<Publicacion>(); 
		publicaciones.stream().forEach(p -> this.agregarSiDebo(p, listaActual,(p.getCiudad().equals(this.ciudad))));
		return listaActual;
	}
}
