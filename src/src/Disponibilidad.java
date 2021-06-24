package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Disponibilidad extends Filtro {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	static String tipo = "Disponibilidad";
	public Disponibilidad(LocalDate fechaInicio, LocalDate fechaFin) {
		this.setTipo(tipo);
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
	}
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		List<Publicacion> listaActual = new ArrayList<Publicacion>(); 
		publicaciones.stream().forEach(p -> this.agregarSiDebo(p, listaActual,(p.checkDisponibilidadEntre(fechaInicio,fechaFin))));
		return listaActual;
	}

}
