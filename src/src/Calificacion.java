package src;

public class Calificacion {
	
	private String 	categoria;
	private Integer calificacion;
	
	public Calificacion(String categoria, Integer calificacion) {
		super();
		this.categoria = categoria;
		this.calificacion = calificacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	
	
}