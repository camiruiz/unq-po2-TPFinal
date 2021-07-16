package filtros;

import java.util.stream.Collectors;

import publicacionesYBusquedas.Publicacion;

import java.util.List;

public class Ciudad extends Filtro {
	
	private String ciudad;
	static String tipo = "Ciudad";
	
	public Ciudad(String ciudad) {
		this.setTipo(tipo);
		this.ciudad = ciudad;
	}
	
	public Ciudad( ) {
		this.setTipo(tipo);
	}
	
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		return (publicaciones.stream().filter(p -> p.getCiudad().equals(this.ciudad))).collect(Collectors.toList());

	}
}
