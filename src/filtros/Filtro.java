package filtros;

import java.util.List;

import publicacionesYBusquedas.Publicacion;


public abstract class Filtro {
	private String tipo;
	
	public abstract List<Publicacion> filtrar(List<Publicacion> publicaciones);
	
	public String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public boolean equals(Filtro f){
		return f.getTipo() == this.getTipo();
	}

}
