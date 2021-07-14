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
	
	public List<Filtro> getFiltros(){
		return filtros;
	}
	
	public List<Publicacion> buscar(List<Publicacion> ps) {
		
		List<Publicacion> publicaciones = ps;
		for (Filtro filtro: filtros) {
			publicaciones = filtro.filtrar(publicaciones);
		}
		return publicaciones;
	}
	
	public void asignar(List<Publicacion>p1,	List<Publicacion>p2) {
		p1 = p2;
	}
}
