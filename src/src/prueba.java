package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
			
			System.out.println(listaDeDias.containsAll(listaDeDias1));
			
		}
}


