package calculadorDeCalificaciones;

import java.util.ArrayList;
import java.util.List;

public class CalculadorDeCalificaciones {

	private List<Calificacion> listaDePuntajes;
	private List<Comentario> listaDeComentarios;

	public CalculadorDeCalificaciones(List<Calificacion> listaDePuntajes, List<Comentario> listaDeComentarios) {
		super();
		this.listaDePuntajes = new ArrayList<Calificacion>(listaDePuntajes);
		this.listaDeComentarios = new ArrayList<Comentario>(listaDeComentarios);
	}

	public List<Calificacion> getListaDePuntajes() {
		return listaDePuntajes;
	}



	public List<Comentario> getListaDeComentarios() {
		return listaDeComentarios;
	}

	

	public float calcularPromedio() {
		float total = 0;
		if (!this.listaDePuntajes.isEmpty()) {
			total = (float) this.puntajeTotal() / this.listaDePuntajes.size();
		}
		return total;
	}
		
		public Integer puntajeTotal() {
			Integer valor = this.listaDePuntajes.stream().mapToInt(Calificacion::getCalificacion).sum();
			return valor;

		}

	public void agregarPuntaje(Calificacion calificacion) {
		this.listaDePuntajes.add(calificacion);
		
	}
	
	public void agregarComentario(Comentario comentario) {
		this.listaDeComentarios.add(comentario);
		
	}
	
	
}
