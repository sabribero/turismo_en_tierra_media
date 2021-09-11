package turismo_en_tierra_media;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

	List<Promocion> promocionesDeAventura = new ArrayList<Promocion>();
	List<Promocion> promocionesDeDegustacion = new ArrayList<Promocion>();
	List<Promocion> promocionesDePaisaje = new ArrayList<Promocion>();

	// Lista de listas y listas auxiliares para ordenar antes de ofrecer

	List<List<Atraccion>> listaOrdenadaParaSugerir = new ArrayList<List<Atraccion>>();
	List<List<Promocion>> listaOrdenadaParaSugerirPromociones = new ArrayList<List<Promocion>>();

	// El constructor recibe una lista de atracciones
	public Aplicacion(List<Atraccion> Atracciones) {
		// super();
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

	public void separarPromociones(List<Promocion> todasLasPromos) {

		for (int i = 0; i < todasLasPromos.size(); i++) {

			if (todasLasPromos.get(i).getAtraccionesEnPromocion().get(0).getTipo() == TipoDeAtraccion.AVENTURA) {
				promocionesDeAventura.add(todasLasPromos.get(i));

			} else if (todasLasPromos.get(i).getAtraccionesEnPromocion().get(0).getTipo() == TipoDeAtraccion.PAISAJE) {
				promocionesDePaisaje.add(todasLasPromos.get(i));

			} else if (todasLasPromos.get(i).getAtraccionesEnPromocion().get(0).getTipo() == TipoDeAtraccion.DEGUSTACION) {
				promocionesDeDegustacion.add(todasLasPromos.get(i));

			}
		}

	}

	public void ofrecerTodo(Usuario unUsuario) {

		System.out.println("Bienvenido " + unUsuario.getNombre() + ", vamos a comenzar: \n\n");

		this.listaOrdenadaParaSugerir.clear();
		this.listaOrdenadaParaSugerirPromociones.clear();

		if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.PAISAJE) {
			
			
			this.ofrecerPromociones(unUsuario, promocionesDePaisaje);
			this.ofrecerPromociones(unUsuario, promocionesDeAventura);
			this.ofrecerPromociones(unUsuario, promocionesDeDegustacion);
			
			this.ofrecerAtracciones(unUsuario, atraccionesDePaisaje);
			this.ofrecerAtracciones(unUsuario, atraccionesDeAventura);
			this.ofrecerAtracciones(unUsuario, atraccionesDeDegustacion);

		}

		if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.DEGUSTACION) {
			
			
			
			this.ofrecerPromociones(unUsuario, promocionesDeDegustacion);
			this.ofrecerPromociones(unUsuario, promocionesDePaisaje);
			this.ofrecerPromociones(unUsuario, promocionesDeAventura);
			
			this.ofrecerAtracciones(unUsuario, atraccionesDeDegustacion);
			this.ofrecerAtracciones(unUsuario, atraccionesDePaisaje);
			this.ofrecerAtracciones(unUsuario, atraccionesDeAventura);
			

		}

		if (unUsuario.getAtraccionFavorita() == TipoDeAtraccion.AVENTURA) {
			
			this.ofrecerPromociones(unUsuario, promocionesDeAventura);
			this.ofrecerPromociones(unUsuario, promocionesDeDegustacion);
			this.ofrecerPromociones(unUsuario, promocionesDePaisaje);
			
			this.ofrecerAtracciones(unUsuario, atraccionesDeAventura);
			this.ofrecerAtracciones(unUsuario, atraccionesDeDegustacion);
			this.ofrecerAtracciones(unUsuario, atraccionesDePaisaje);


		}

		/////////////////////////////////////////////////////

		crearArchivoUsuario(unUsuario);

	}
	
	
	
	public void ofrecerAtracciones(Usuario unUsuario, List<Atraccion> unasAtracciones) {
		
		
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
	
	public void ofrecerPromociones(Usuario unUsuario, List<Promocion> unasPromociones) {
		
		for (Promocion cadaPromocion : unasPromociones) {
			
			boolean puede=true;
			
			for(Atraccion cadaAtraccion : cadaPromocion.getAtraccionesEnPromocion()){
				
				
				if (!unUsuario.podesIrA(cadaPromocion.getValorPromo(), cadaPromocion.getTiempoDeUso()) || !unUsuario.todaviaNoVasA(cadaAtraccion)
						|| !(cadaAtraccion.getUsosDisponibles() > 0)) {
					
					puede=false;
					
				}
				
			}

			if (puede) {

				Scanner entrada = new Scanner(System.in);

				System.out.println(unUsuario.getNombre() + ", te gustaria comprar la promo de " + cadaPromocion.getNombre()
						+ "por "+ cadaPromocion.getValorPromo()+ " monedas? ( 1 - Si / 2 - No )");

				int seleccion = Character.getNumericValue(entrada.next().charAt(0));

				while (seleccion != 1 && seleccion != 2) {

					System.out.println("Error, debe ingresar solo un 1 o un 2");
					System.out.println(unUsuario.getNombre() + ", te gustaria comprar o no? ( 1 - Si / 2 - No )");

					seleccion = Character.getNumericValue(entrada.next().charAt(0));

				}

				if (seleccion == 1) {

					
					for(Atraccion cadaAtraccion : cadaPromocion.getAtraccionesEnPromocion()){
						
						cadaAtraccion.reservarLugar(unUsuario);
					
					}
					
					unUsuario.agregarPromocion(cadaPromocion);
					

				} else if (seleccion == 2) {

					System.out.println("No vas a ir a " + cadaPromocion.getNombre());

				}
			}
		}

		
	}
	
	
	
	
	

	public void crearArchivoUsuario(Usuario unUsuario) {

		try {
			String ruta = "archivos_de_salida/"+unUsuario.getNombre()+".txt";
			//String ruta = unUsuario.getNombre() + ".txt";
			String contenido = unUsuario.toString();
			File file = new File(ruta);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}