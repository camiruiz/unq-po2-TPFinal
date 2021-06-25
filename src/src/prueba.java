package src;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class prueba {

	public static void main(String[] args) {
		
		LocalDate a1 = LocalDate.now();
		LocalDate a2 = LocalDate.now().plusDays(5);
		System.out.println(a2.compareTo(a1));
			
			LocalDate fechaActual 	= LocalDate.now();
			LocalDate fechaFin		= LocalDate.now().plusDays(20);
			List<LocalDate> listaDeDias= new ArrayList<LocalDate>();
			
			while(!fechaActual.equals(fechaFin)) {
				listaDeDias.add(fechaActual);
				fechaActual = fechaActual.plusDays(1);
			}
			LocalDate fechaActual1 	= LocalDate.now();
			LocalDate fechaFin2		= LocalDate.now().plusDays(10);
			List<LocalDate> listaDeDias1= new ArrayList<LocalDate>();
			
			while(!fechaActual1.equals(fechaFin2)) {
				listaDeDias1.add(fechaActual1);
				fechaActual1 = fechaActual1.plusDays(1);
			}
			
			LocalDate fechaInicial = LocalDate.now();
			
			List<Filtro> l1 = new ArrayList<Filtro>();
			
			LocalDate fechaActual12 	= LocalDate.now();
			LocalDate fechaFin12		= LocalDate.now().plusDays(20);
			
			LocalDate fechaActualPregunta	= LocalDate.now().plusDays(5);
			LocalDate fechaFinPregunta		= LocalDate.now().plusDays(10);
			Period period = Period.between(fechaActual12, fechaFin12);
			
			List<LocalDate>diasDeMiReserva = fechaActual12.datesUntil(fechaFin12.plusDays(20)).collect(Collectors.toList());
			List<LocalDate>diasAPreguntar = fechaActualPregunta.datesUntil(fechaFinPregunta).collect(Collectors.toList());
			System.out.println(diasDeMiReserva.stream().anyMatch(diasAPreguntar::contains));
			

		}
}


