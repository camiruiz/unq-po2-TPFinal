package src;

import java.util.List;


public abstract class Filtro {
	private String tipo;
	
	public abstract List<Publicacion> filtrar(List<Publicacion> publicaciones);
	
	protected String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	protected void agregarSiDebo(Publicacion p, List<Publicacion> listaActual,Boolean condicion) {
		if(condicion) {
			listaActual.add(p);
		}
	}

}
