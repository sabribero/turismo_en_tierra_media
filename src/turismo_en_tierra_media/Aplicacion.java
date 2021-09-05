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

		if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.PAISAJE) {

			for (Atraccion cadaAtraccion : this.atraccionesDePaisaje) {

				if (unUsuario.podriasIrA(cadaAtraccion) && unUsuario.todaviaNoVasA(cadaAtraccion)
						&& cadaAtraccion.getUsosDisponibles() > 0) {

					Scanner entrada = new Scanner(System.in);

					System.out.println(
							unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre() + "? ( S/N )");

					char seleccion = entrada.next().charAt(0);


					while (seleccion != 'S' && seleccion != 'N') {

						System.out.println("Error, debe ingresar solo una S o una N");
						System.out.println(unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre()
								+ "? ( S/N )");

						seleccion = entrada.next().charAt(0);

					}

					if (seleccion == 'S') {

						cadaAtraccion.reservarLugar(unUsuario);
					} else if (seleccion == 'N') {

						System.out.println("No vas a ir a " + cadaAtraccion.getNombre());

					}

					//entrada.close();

				}

			}

		} else if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.AVENTURA) {

			for (Atraccion cadaAtraccion : this.atraccionesDeAventura) {

				if (unUsuario.podriasIrA(cadaAtraccion) && unUsuario.todaviaNoVasA(cadaAtraccion)
						&& cadaAtraccion.getUsosDisponibles() > 0) {

					Scanner entrada = new Scanner(System.in);
					System.out.println(
							unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre() + "? ( S/N )");
					char seleccion = entrada.next().charAt(0);


					while (seleccion != 'S' && seleccion != 'N') {

						System.out.println("Error, debe ingresar solo una S o una N");
						System.out.println(unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre()
								+ "? ( S/N )");

						seleccion = entrada.next().charAt(0);

					}

					if (seleccion == 'S') {

						cadaAtraccion.reservarLugar(unUsuario);
					}

				//	entrada.close();
				}
			}
		} else if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.DEGUSTACION) {

			for (Atraccion cadaAtraccion : this.atraccionesDeDegustacion) {

				if (unUsuario.podriasIrA(cadaAtraccion) && unUsuario.todaviaNoVasA(cadaAtraccion)
						&& cadaAtraccion.getUsosDisponibles() > 0) {

					Scanner entrada = new Scanner(System.in);
					System.out.println(
							unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre() + "? ( S/N )");
					char seleccion = entrada.next().charAt(0);

					while (seleccion != 'S' && seleccion != 'N') {

						System.out.println("Error, debe ingresar solo una S o una N");
						System.out.println(unUsuario.getNombre() + ", te gustaria ir a " + cadaAtraccion.getNombre()
								+ "? ( S/N )");

						seleccion = entrada.next().charAt(0);

					}

					if (seleccion == 'S') {

						cadaAtraccion.reservarLugar(unUsuario);
					}

					//entrada.close();

				}
			}
		}

	}

}