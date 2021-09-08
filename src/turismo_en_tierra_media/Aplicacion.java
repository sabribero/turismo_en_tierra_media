package turismo_en_tierra_media;

import java.util.ArrayList;

import java.util.Scanner;

import java.util.Comparator;
import java.util.List;

/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * 
 * Copie y pegue la clase aplicacion en este nuevo repo, todavia no funciona nada pero quiero que quede cargada
 * 
 * 
 * 3/9/2021
 * 
 * 
 * 
 * 
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * 
 */

//La aplicacion se encarga del manejo y organizacion de todas las atracciones y promociones disponibles.

public class Aplicacion {

	// Todas las listas necesarias para organizar
	List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDeAventura = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDeDegustacion = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDePaisaje = new ArrayList<Atraccion>();

	// Lista de listas y listas auxiliares para ordenar antes de ofrecer

	List<List<Atraccion>> listaOrdenadaParaSugerir = new ArrayList<List<Atraccion>>();


	// El constructor recibe una lista de atracciones
	public Aplicacion(List<Atraccion> Atracciones) {
		super();
		this.todasLasAtracciones = Atracciones;

	}

	public void separarAtracciones() {

		for (int i = 0; i < this.todasLasAtracciones.size(); i++) {

			if (this.todasLasAtracciones.get(i).getTipo() == TipoDeAtraccion.AVENTURA) {
				atraccionesDeAventura.add(todasLasAtracciones.get(i));

			} else if (this.todasLasAtracciones.get(i).getTipo() == TipoDeAtraccion.PAISAJE) {
				atraccionesDePaisaje.add(todasLasAtracciones.get(i));

			} else if (this.todasLasAtracciones.get(i).getTipo() == TipoDeAtraccion.DEGUSTACION) {
				atraccionesDeDegustacion.add(todasLasAtracciones.get(i));

			}
		}

		atraccionesDeAventura.sort(Comparator.comparing(Atraccion::getValor).reversed());
		atraccionesDePaisaje.sort(Comparator.comparing(Atraccion::getValor).reversed());
		atraccionesDeDegustacion.sort(Comparator.comparing(Atraccion::getValor).reversed());

	}

	public void ofrecerAtracciones(Usuario unUsuario) {

		this.listaOrdenadaParaSugerir.clear();

		switch (unUsuario.getAtraccionFavorita()) {

		case PAISAJE: {

			this.listaOrdenadaParaSugerir.add(atraccionesDePaisaje);
			this.listaOrdenadaParaSugerir.add(atraccionesDeAventura);
			this.listaOrdenadaParaSugerir.add(atraccionesDeDegustacion);

		}

		case AVENTURA: {

			this.listaOrdenadaParaSugerir.add(atraccionesDeAventura);
			this.listaOrdenadaParaSugerir.add(atraccionesDeDegustacion);
			this.listaOrdenadaParaSugerir.add(atraccionesDePaisaje);

		}

		case DEGUSTACION: {

			this.listaOrdenadaParaSugerir.add(atraccionesDeDegustacion);
			this.listaOrdenadaParaSugerir.add(atraccionesDePaisaje);
			this.listaOrdenadaParaSugerir.add(atraccionesDeAventura);

		}

		case DEFAULT: {

			// TIRAR UN ERROR

		}

		}

		for (List<Atraccion> cadaListaDeTipo : this.listaOrdenadaParaSugerir)

			for (Atraccion cadaAtraccion : cadaListaDeTipo) {

				if (unUsuario.podriasIrA(cadaAtraccion) && unUsuario.todaviaNoVasA(cadaAtraccion)
						&& cadaAtraccion.getUsosDisponibles() > 0) {

					Scanner entrada = new Scanner(System.in);

					System.out.println(
							unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre() + "? ( 1 - Si / 2 - No )");

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

					// entrada.close();

				}

			}

		/////////////////////////////////////////////////////

	}

}