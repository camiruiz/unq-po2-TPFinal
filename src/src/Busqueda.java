package src;

import java.util.ArrayList;
import java.util.List;

public class Busqueda {
	List<Filtro> filtros;
	
	public Busqueda() {
		filtros = new  ArrayList<Filtro>();
	}
	
	public void setFiltro(Filtro filtro) {
		this.filtros.add(filtro);
	}
	
	public List<Publicacion> buscar(List<Publicacion> ps) {
		
		List<Publicacion> publicaciones = ps;
		filtros.stream().forEach(filtro -> asignar(publicaciones,filtro.filtrar(publicaciones)));
		return publicaciones;
	}
	
	private void asignar(List<Publicacion>p1,List<Publicacion>p2) {
		p1 = p2;
	}
}