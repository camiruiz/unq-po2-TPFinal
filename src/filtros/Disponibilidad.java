package filtros;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import app.*;
import publicacionesYBusquedas.Publicacion;

public class Disponibilidad extends Filtro {

	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	static String tipo = "Disponibilidad";
	
	
	
	public Disponibilidad(LocalDate miFechaEntrada, LocalDate miFechaSalida) {
		this.setTipo(tipo);
		this.fechaSalida = miFechaSalida;
		this.fechaEntrada = miFechaEntrada;
	}
	
	public Disponibilidad() {
		this.setTipo(tipo);
	}
	
	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		return (publicaciones.stream().filter(p -> p.checkDisponibilidadEntre(fechaEntrada, fechaSalida))).collect(Collectors.toList());
	}

}
