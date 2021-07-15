package src;

import java.util.List;


public abstract class Filtro {
	private String tipo;
	
	public abstract List<Publicacion> filtrar(List<Publicacion> publicaciones);
	
	public String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object o){
		return o.getClass() == this.getClass();
	}

}
