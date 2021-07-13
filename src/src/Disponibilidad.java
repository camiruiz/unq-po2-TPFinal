package src;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


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
		return (publicaciones.stream().filter(p -> p.checkDisponibilidadEntre(fechaInicio,fechaFin))).collect(Collectors.toList());
	}

}
