package turismo_en_tierra_media;

import java.util.List;
import java.util.Scanner;

public class Sugeridor {

	protected static void sugerirPromo(Usuario unUsuario, List<Promocion> unasPromociones) {
		for (Promocion cadaPromocion : unasPromociones) {

			boolean puede = true;

			for (Atraccion cadaAtraccion : cadaPromocion.getAtraccionesEnPromocion()) {

				if (!unUsuario.podesIrA(cadaPromocion.getValorPromo(), cadaPromocion.getTiempoDeUso())
						|| !unUsuario.todaviaNoVasA(cadaAtraccion) || !(cadaAtraccion.getUsosDisponibles() > 0)) {

					puede = false;

				}

			}

			if (puede) {

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

					unUsuario.agregarPromocion(cadaPromocion);

				} else if (seleccion == 2) {

					System.out.println("No vas a ir a " + cadaPromocion.getNombre());

				}
			}
		}
	}
	
	public static void sugerirAtracciones(Usuario unUsuario, List<Atraccion> unasAtracciones) {
		for (Atraccion cadaAtraccion : unasAtracciones) {

			if (unUsuario.podesIrA(cadaAtraccion.getValor(), cadaAtraccion.getTiempoDeUso()) && unUsuario.todaviaNoVasA(cadaAtraccion)
					&& cadaAtraccion.getUsosDisponibles() > 0) {

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
					unUsuario.agregarAtraccion(cadaAtraccion);
					
					
				} else if (seleccion == 2) {

					System.out.println("No vas a ir a " + cadaAtraccion.getNombre());

				}

			}

		}
	}
}
