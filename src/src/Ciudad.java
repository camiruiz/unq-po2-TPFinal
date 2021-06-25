package src;

import java.util.stream.Collectors;

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
		return (publicaciones.stream().filter(p -> p.getCiudad().equals(this.ciudad))).collect(Collectors.toList());

	}
}
