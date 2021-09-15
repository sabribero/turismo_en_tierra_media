package turismo_en_tierra_media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Sugeridor {

	protected static void sugerirPromos(Usuario unUsuario, List<Promocion> unasPromociones) {
		for (Promocion cadaPromocion : unasPromociones) {
			
			if (unUsuario.podesIrA(cadaPromocion) && cadaPromocion.tieneCupos()) { 

				Scanner entrada = new Scanner(System.in);

				System.out.println(
						unUsuario.getNombre() + ", te gustaria comprar la promo de " + cadaPromocion.getNombre()
								+ "por " + cadaPromocion.getValorPromo() + " monedas? ( 1 - Si / 2 - No )");

				int seleccion = Character.getNumericValue(entrada.next().charAt(0));

				while (seleccion != 1 && seleccion != 2) {

					System.out.println("Error, debe ingresar solo un 1 o un 2");
					System.out.println(unUsuario.getNombre() + ", te gustaria comprar o no? ( 1 - Si / 2 - No )");

					seleccion = Character.getNumericValue(entrada.next().charAt(0));

				}

				if (seleccion == 1) {

					for (Atraccion cadaAtraccion : cadaPromocion.getAtraccionesEnPromocion()) {

						cadaAtraccion.reservarLugar(unUsuario);

					}


				} else if (seleccion == 2) {

					System.out.println("No vas a ir a " + cadaPromocion.getNombre());

				}
			}
		}
	}
	
	protected static void sugerirAtracciones(Usuario unUsuario, List<Atraccion> unasAtracciones) {
		for (Atraccion cadaAtraccion : unasAtracciones) {
		
			if (unUsuario.podesIrA(cadaAtraccion) && cadaAtraccion.getUsosDisponibles() > 0) {

				Scanner entrada = new Scanner(System.in);

				System.out.println(unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre()
						+ "? ( 1 - Si / 2 - No )");

				int seleccion = Character.getNumericValue(entrada.next().charAt(0));

				while (seleccion != 1 && seleccion != 2) {

					System.out.println("Error, debe ingresar solo un 1 o un 2");
					System.out.println(unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre()
							+ "? ( 1 - Si / 2 - No )");

					seleccion = Character.getNumericValue(entrada.next().charAt(0));

				}

				if (seleccion == 1) {

					cadaAtraccion.reservarLugar(unUsuario);
					
					
				} else if (seleccion == 2) {

					System.out.println("No vas a ir a " + cadaAtraccion.getNombre());

				}

			}

		}
	}
	
	protected static void sugerirPromosNoFavoritas(Usuario unUsuario, List<Promocion> unasPromociones) {
		//creo una lista que guarda las promociones para borrarlas y luego agregarlas de nuevo,
				//ya que si solo las borro luego no se le recomiendan a lxs demas.
				List<Promocion> promocionesRechazadas= new ArrayList<Promocion>();
				//remuevo de la lista todas las promociones del tipo favorito, que ya fueron sugeridas
						Iterator<Promocion> iterador= unasPromociones.iterator();
						while(iterador.hasNext()) {
							Promocion actual= iterador.next();
							if(actual.getTipoDeAtraccion() == unUsuario.getAtraccionFavorita()) {
								promocionesRechazadas.add(actual);
								iterador.remove();
							}
						}
						Sugeridor.sugerirPromos(unUsuario, unasPromociones);
						//vuelvo a agregar las promociones eliminadas
						for(Promocion promocion: promocionesRechazadas) {
							unasPromociones.add(promocion);
						}
		//vuelvo a ordenar la lista ya que elimine y volvi a agregar elementos
		unasPromociones.sort(new ComparadorPromocion().reversed());
	}
	
	protected static void sugerirAtraccionesNoFavoritas(Usuario unUsuario, List<Atraccion> unasAtracciones) {
		//mismo caso que con promocionesNoFavoritas
				List<Atraccion> atraccionesRechazadas= new ArrayList<Atraccion>();
				//remuevo de la lista todas las atracciones del tipo favorito, que ya fueron sugeridas
				Iterator<Atraccion> iterador= unasAtracciones.iterator();
				while(iterador.hasNext()) {
					Atraccion actual= iterador.next();
					if(actual.getTipo() == unUsuario.getAtraccionFavorita()) {
						atraccionesRechazadas.add(actual);
						iterador.remove();
					}
				}
				Sugeridor.sugerirAtracciones(unUsuario, unasAtracciones);

				//vuelvo a agregar las posiciones eliminadas
				for(Atraccion atraccion: atraccionesRechazadas) {
					unasAtracciones.add(atraccion);
				}
		unasAtracciones.sort(new ComparadorAtraccion().reversed());
	}
}