package src;

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

	public void setListaDePuntajes(List<Calificacion> listaDePuntajes) {
		this.listaDePuntajes = listaDePuntajes;
	}

	public List<Comentario> getListaDeComentarios() {
		return listaDeComentarios;
	}

	public void setListaDeComentarios(List<Comentario> listaDeComentarios) {
		this.listaDeComentarios = listaDeComentarios;
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
			//Integer valor = this.listaDePuntajes.stream().mapToInt(Calificacion::getCalificacion).average(); Al momento de testear esto ver q devuelve el average xd
		}

	public void agregarPuntaje(String categoria, Integer calificacion) {
		this.listaDePuntajes.add(new Calificacion(categoria, calificacion));
		
	}
	
	public void agregarComentario(String cuerpo, UsuarioInquilino usuario) {
		this.listaDeComentarios.add(new Comentario(cuerpo, usuario));
		
	}
	
	
}
