package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Busqueda {
	List<Filtro> filtros;
	List<Filtro> filtrosObligatorios;
	

	
	public Busqueda() {
		filtros = new  ArrayList<Filtro>();
		filtrosObligatorios = new  ArrayList<Filtro>();
		this.setFiltroObligatorio(new Disponibilidad());
		this.setFiltroObligatorio(new Ciudad());
	}
	
	public void setFiltro(Filtro filtro) {
		this.filtros.add(filtro);
	}
	
	public void setFiltroObligatorio(Filtro filtro) {
		this.filtrosObligatorios.add(filtro);
	}
	
	public List<Filtro> getFiltros(){
		return filtros;
	}
	
	public List<Publicacion> buscar(List<Publicacion> ps) {
		
		List<Publicacion> listaDePublicaciones = ps;
	
		if (this.checkFiltrosObligatorios()) {
			listaDePublicaciones = this.concretarBusqueda(ps);
		}
		return listaDePublicaciones;
		
		 
	}

	
	public List<Publicacion> concretarBusqueda(List<Publicacion> ps) {
		List<Publicacion> publicaciones = ps;
		
		for (Filtro filtro: filtros) {
			publicaciones = filtro.filtrar(publicaciones);
		}
		return publicaciones;
	}
	
	
	public Boolean checkFiltrosObligatorios() {
		
		Boolean estanLosFiltrosObligatorios = this.filtrosObligatorios.stream().allMatch(f -> this.contains(f));
		
		return estanLosFiltrosObligatorios;
		
	}
	
	public Boolean contains(Filtro filtro) {
		
		Boolean estaEnLaLista = this.filtros.stream().anyMatch(f -> f.equals(filtro));
		
		return estaEnLaLista;
	}

}
